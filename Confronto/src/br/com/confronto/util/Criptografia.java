package br.com.confronto.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class Criptografia {

    private final static String chave = "c0nfr0nt0@4b4c4x1D0G1ls0n";
    private static SecretKey chaveSecreta;
    private static Cipher cipher = null;
    private static Criptografia cript = new Criptografia();

    private Criptografia() {
        try {
            cipher = Cipher.getInstance("DESede");
            DESedeKeySpec keyspec = new DESedeKeySpec(chave.getBytes());
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
            chaveSecreta = keyfactory.generateSecret(keyspec);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String encripta(final String objeto) {

        try {
            cipher.init(Cipher.ENCRYPT_MODE, chaveSecreta);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        }
        try {
            return new String(cipher.doFinal(objeto.getBytes()));
        } catch (BadPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String decripta(final String objeto) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, chaveSecreta);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        }
        try {
            return new String(cipher.doFinal(objeto.getBytes()));
        } catch (BadPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            return null;
        }
    }
}
