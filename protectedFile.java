import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
public class protectedFile {
    
public String newfile(){
    try {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        File file = new File("priviteAstronaut.txt");
        FileOutputStream fos = new FileOutputStream(file);
        CipherOutputStream cos = new CipherOutputStream(fos, cipher);
        cos.write("This is a protected file.".getBytes());
        cos.flush();
        cos.close();
        fos.close();

        return "File created and encrypted successfully.";
    } catch (Exception e) {
        e.printStackTrace();
        return "Error occurred while creating the file.";
    }

}














}
