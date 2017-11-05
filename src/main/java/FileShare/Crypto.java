package FileShare;

import static FileShare.Selection.FileName;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author lala
 */

public class Crypto {
    static File encryptedFile = new File("test.encrypted");
    private static String key = "";
    
    static void fileProcessor(int cipherMode,String key,File inputFile,File outputFile){
	try {
	    Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
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
        }
    }

    public static void Encrypt(String key) {	
        try {
            fileProcessor(Cipher.ENCRYPT_MODE,key,Selection.sourceFile,encryptedFile);
        } 
        catch (Exception ex) {
                System.out.println(ex.getMessage());
        }
    }

    public static void Decrypt() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter password to decrypt file:");
        JPasswordField pword = new JPasswordField(8);
        panel.add(label, pword);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "The title", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
        if(option == 0) {
            char[] password = pword.getPassword();
            String pass = String.copyValueOf(password);
            if (pass == null ? key == null : pass.equals(key)) {
                try {
                    String dest = FilenameUtils.getName(Selection.FileName);
                    File decryptedFile = new File("/Users/Miguel/Desktop/" +dest);
                    fileProcessor(Cipher.DECRYPT_MODE,key,encryptedFile,decryptedFile);
                } 
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }    
            }
            else {
                JOptionPane.showMessageDialog(panel, "Wrong Password");  
            }
        }   	
        
    }

}