package FileShare;

import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author LalaAicha Coulibaly
 */

public class Crypto {
    public static File encryptedFile;
    protected static File decryptedFile;
    private static String hashKey; 
    
    public Crypto () {
        Crypto.hashKey="";     
    }
    
    public Crypto (String newkey) {
        Crypto.hashKey=newkey;     
    }
    
    static void fileProcessor(int cipherMode,String hashKey,File inputFile,File outputFile){
	try {
	    Key secretKey = new SecretKeySpec(hashKey.getBytes(), "AES");
	    Cipher cipher = Cipher.getInstance("AES");
	    cipher.init(cipherMode, secretKey);
            FileOutputStream outputStream;
            try (FileInputStream inputStream = new FileInputStream(inputFile)) {
                byte[] inputBytes = new byte[(int) inputFile.length()];
                inputStream.read(inputBytes);
                byte[] outputBytes = cipher.doFinal(inputBytes);
                outputStream = new FileOutputStream(outputFile);
                outputStream.write(outputBytes);
            }
	    outputStream.close();
	} 
        catch (NoSuchPaddingException | NoSuchAlgorithmException 
                | InvalidKeyException | BadPaddingException
	        | IllegalBlockSizeException | IOException e) {
            JOptionPane.showMessageDialog(SecureShareGUI.jDesktopPane1, "Error in encryption");
            System.out.println(e);
        }
    }

    public static void Encrypt(String key) {	
        try {
            String source = FilenameUtils.getBaseName(SelectAndShare.FileName);
            encryptedFile = new File("Encryption/" + source + ".encrypted");
            createHash(key);
            fileProcessor(Cipher.ENCRYPT_MODE,hashKey,SelectAndShare.sourceFile,encryptedFile);
        } 
        catch (Exception ex) {
                Logger.getLogger(Crypto.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(SecureShareGUI.jDesktopPane1, "No File Found");
        }
    }

    public static void Decrypt() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JLabel label = new JLabel("Password: ");
        JPasswordField pword = new JPasswordField(16);
        panel.add(label);
        panel.add(pword);
        String[] options = new String[]{"Decrypt", "Cancel"};
        int option = JOptionPane.showOptionDialog(SecureShareGUI.jDesktopPane1, panel, "Enter Decryption Password", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
        if (option == 0){
            char[] password = pword.getPassword();
            String key = String.copyValueOf(password);         
            if (hashKey.equals(createhashD(key))) {
                try {
                    String dest = FilenameUtils.getBaseName(SelectAndShare.FileName);
                    decryptedFile = new File("Encryption/" +dest + ".txt");
                    fileProcessor(Cipher.DECRYPT_MODE,hashKey,encryptedFile,decryptedFile);
                } 
                catch (Exception ex) {
                    Logger.getLogger(Crypto.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(SecureShareGUI.jDesktopPane1, "No File Found");
                }    
            }
            else {
                JOptionPane.showMessageDialog(panel, "Wrong Password"); 
                Decrypt();
            }
        }
        else if (option == 1){
            panel.setVisible(false);
        } 
    }
    
    public static void createHash (String key) {   
        try {                 
            MessageDigest digest = MessageDigest.getInstance("MD5"); //Create MessageDigest object for MD5           
            digest.update(key.getBytes(), 0, key.length()); //Update input string in message digest            
            hashKey = new BigInteger(1, digest.digest()).toString(16);  //Converts message digest value in base 16 (hex) 
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Crypto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String createhashD(String key) {
        String hashKeyD=null;
        try {                 
            MessageDigest digest = MessageDigest.getInstance("MD5"); //Create MessageDigest object for MD5           
            digest.update(key.getBytes(), 0, key.length()); //Update input string in message digest            
            hashKeyD = new BigInteger(1, digest.digest()).toString(16);  //Converts message digest value in base 16 (hex) 
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Crypto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashKeyD;
    }

}