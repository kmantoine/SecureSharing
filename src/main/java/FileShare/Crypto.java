package FileShare;

import UserFileInterface.FileManager;
import java.io.*;
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author LalaAicha Coulibaly
 */

public class Crypto {
    public static File encryptedFile;
    public static File decryptedFile;
    private static byte[] hashKey;
    private final static String SALT = "wreghytjuyikuhjgf7yuthresfoeikjtdngsfviaekrjtperfoqerbw";
    
    static void fileProcessor(int cipherMode, byte[] key, File inputFile, File outputFile){
	try {
	    Key secretKey = new SecretKeySpec(key, "AES");
	    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	    cipher.init(cipherMode, secretKey);//, new IvParameterSpec(new byte[16]));
           
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
        catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | IOException ex) {
            Logger.getLogger(Crypto.class.getName()).log(Level.SEVERE, "Error with encryption", ex);
        }
    }

    public static void Encrypt(File sourceFile, String key) {
        createHash (key);
        encryptedFile = new File(sourceFile.getName () + ".encrypted");
        fileProcessor(Cipher.ENCRYPT_MODE, hashKey, sourceFile, encryptedFile); //ENCRYPT
        for (int i=0; i<Share.jList1.getSelectedValuesList ().size (); i++) {
            String name = Share.jList1.getSelectedValuesList ().get (i);
            DBConnection.insertIntoDB (name, encryptedFile.getName (), key);
        }
    }

    public static void Decrypt(File sourceFile, String key) {
        createHash(key);
        decryptedFile = new File(sourceFile.getAbsolutePath ().replace (".encrypted", ""));
        fileProcessor(Cipher.DECRYPT_MODE, hashKey, sourceFile, decryptedFile); //DECRYPT
        FileManager.currentFile = decryptedFile;
        DBConnection.deleteFromDB(sourceFile.getName (), key);
        sourceFile.delete ();
    }
    
    public static void createHash (String key) {
        try {
            byte[] newKey = (SALT.substring(13, 35) + key).getBytes("UTF-8");
            MessageDigest hash = MessageDigest.getInstance("SHA-256");
            hashKey = hash.digest(newKey);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Crypto.class.getName()).log(Level.SEVERE, "Error creating hash", ex);
        }
    }

}