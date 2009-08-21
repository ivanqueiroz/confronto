package br.com.confronto.security;

import br.com.confronto.util.*;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Criptografia {

    private final static String chave = "C0nfr0nt0@G1Ls0n@Ab4c4x1@4Ndr309";
    private static SecretKey chaveSecreta;
    private static Cipher cipher = null;
    private static Criptografia cript = new Criptografia();


    /**
     * Cria objeto Criptografia. Inicializa objeto para criptografia com
     * padrão DESede/ECB/PKCS5Padding e gera chave secreta.
     *
     */
    private Criptografia() {
        
        System.out.println("Criptografia()");
        System.out.println("Construindo objeto para criptografia: " + cript);
        try {
            cipher = Cipher.getInstance("DESede");
            DESedeKeySpec keyspec = new DESedeKeySpec(chave.getBytes());
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
            chaveSecreta = keyfactory.generateSecret(keyspec);
        } catch (InvalidKeyException e) {
            System.out.println("Não foi possível iniciar a criptografia. Chave inválida.");
            System.out.println("Mensagem: " + e);
        } catch (InvalidKeySpecException e) {
            System.out.println("Não foi possível iniciar a criptografia. Especificação de chave inválida.");
            System.out.println("Mensagem: " + e);
        } catch (NoSuchPaddingException e) {
            System.out.println("Não foi possível iniciar a criptografia. Padding inexistente.");
            System.out.println("Mensagem: " + e);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Não foi possível iniciar a criptografia. Algoritmo inexistente.");
            System.out.println("Mensagem: " + e);
        }
        System.out.println("Objeto para criptografia construído.");
    }

    /**
     * Criptografa a String recebida e retorna o valor em String
     * @param objeto
     * @return
     */
    public static String encripta(final String objeto) {
        //System.out.println("encripta()");
        try {
            cipher.init(Cipher.ENCRYPT_MODE, chaveSecreta);

        } catch (InvalidKeyException e) {
            System.out.println("Não foi possível iniciar a criptografia. Chave inválida.");
            System.out.println("Mensagem: " + e);
            return null;
        }
        try {
            BASE64Encoder encoder = new BASE64Encoder();
            System.out.println(ConfigControl.toHexString(cipher.doFinal(objeto.getBytes())));
            //System.out.println("Objeto encriptado: " + tmp);
            return encoder.encode(cipher.doFinal(objeto.getBytes()));
        } catch (BadPaddingException e) {
            System.out.println("Erro ao encriptar dados. Padding inválido.");
            System.out.println("Mensagem: " + e);
            return null;
        } catch (IllegalBlockSizeException e) {
            System.out.println("Erro ao encriptar dados. Tamanho de bloco inválido.");
            System.out.println("Mensagem: " + e);
            return null;
        }
    }

    /**
     * Decripta a String recebida e retorna o objeto como String
     * @param objeto
     * @return
     */
    public static String decripta(final String objeto) {
        //System.out.println("decripta()");
        try {
            cipher.init(Cipher.DECRYPT_MODE, chaveSecreta);
        } catch (InvalidKeyException e) {
            System.out.println("Não foi possível iniciar a criptografia. Chave inválida.");
            System.out.println("Mensagem: " + e);
            return null;
        }
        try {
            BASE64Decoder dec = new BASE64Decoder();
            byte[] texto = cipher.doFinal(dec.decodeBuffer(objeto));
            return new String(texto);
        } catch (IOException e) {
            System.out.println("Erro ao decriptar dados. Exceção de I/O.");
            System.out.println("Mensagem: " + e);
            return null;
        } catch (BadPaddingException e) {
            System.out.println("Erro ao decriptar dados. Padding inválido.");
            System.out.println("Mensagem: " + e);
            return null;
        } catch (IllegalBlockSizeException e) {
            System.out.println("Erro ao decriptar dados. Tamanho de bloco inválido.");
            System.out.println("Mensagem: " + e);
            return null;
        }
    }
  
}
