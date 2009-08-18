package br.com.confronto.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class Encriptador {

    private Cipher cipher;
    private byte[] encryptKey;
    private KeySpec keySpec;
    private SecretKeyFactory secretKeyFactory;
    private SecretKey secretKey;

    private Encriptador() throws UnsupportedEncodingException, NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {

        String key = "http://www.rodrigolazoti.com.briygihijuhikuhikjuhikuhikuhiuhik";

        encryptKey = key.getBytes("UTF-8");
        cipher = Cipher.getInstance("DESede");
        keySpec = new DESedeKeySpec(encryptKey);
        secretKeyFactory = SecretKeyFactory.getInstance("DESede");
        secretKey = secretKeyFactory.generateSecret(keySpec);
    }

    public static Encriptador newInstance() throws InvalidKeyException, UnsupportedEncodingException,
            NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException {

        return new Encriptador();
    }

    public String encripita(String value) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
            UnsupportedEncodingException {

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] cipherText = cipher.doFinal(value.getBytes("UTF-8"));
        BASE64Encoder encoder = new BASE64Encoder();

        return encoder.encode(cipherText);
    }

    public String desencripta(String value) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
            IOException {

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        BASE64Decoder dec = new BASE64Decoder();
        byte[] decipherText = cipher.doFinal(dec.decodeBuffer(value));

        return new String(decipherText);
    }
}
