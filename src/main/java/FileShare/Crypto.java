package FileShare;

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

/**
 *
 * @author lala
 */

public class Crypto {
    static File encryptedFile = new File("test.encrypted");
    static File decryptedFile= new File("test.txt");
    
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

public void Encrypt() {
    String key = "This is a secret";	
    try {
	fileProcessor(Cipher.ENCRYPT_MODE,key,Selection.sourceFile,encryptedFile);
	} 
        catch (Exception ex) {
	    System.out.println(ex.getMessage());
	}
}

public void Decrypt() {
    String key = "This is a secret";	
    try {
	fileProcessor(Cipher.DECRYPT_MODE,key,encryptedFile,decryptedFile);
	} 
        catch (Exception ex) {
	    System.out.println(ex.getMessage());
	}
}

}