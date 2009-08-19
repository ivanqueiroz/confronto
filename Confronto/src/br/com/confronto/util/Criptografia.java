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

    private final static String chave = "C0nfr0nt0@G1Ls0n@Ab4c4x1@4Ndr309";
    private static SecretKey chaveSecreta;
    private static Cipher cipher = null;
    private static Criptografia cript = new Criptografia();
    private static char[] hexChar = {
        '0', '1', '2', '3',
        '4', '5', '6', '7',
        '8', '9', 'a', 'b',
        'c', 'd', 'e', 'f'};

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
        System.out.println("encripta()");
        try {
            cipher.init(Cipher.ENCRYPT_MODE, chaveSecreta);
        } catch (InvalidKeyException e) {
            System.out.println("Não foi possível iniciar a criptografia. Chave inválida.");
            System.out.println("Mensagem: " + e);
            return null;
        }
        try {
            final String tmp = new String(cipher.doFinal(objeto.getBytes()));
            System.out.println(toHexString(objeto.getBytes()));
            System.out.println("Objeto encriptado: " + tmp);
            return new String(cipher.doFinal(objeto.getBytes()));
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
        System.out.println("decripta()");
        try {
            cipher.init(Cipher.DECRYPT_MODE, chaveSecreta);
        } catch (InvalidKeyException e) {
            System.out.println("Não foi possível iniciar a criptografia. Chave inválida.");
            System.out.println("Mensagem: " + e);
            return null;
        }
        try {
            System.out.println(toHexString(objeto.getBytes()));
            return new String(cipher.doFinal(objeto.getBytes()));
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

    public static String toHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(hexChar[(b[i] & 0xf0) >>> 4]);
            sb.append(hexChar[b[i] & 0x0f]);
        }
        return sb.toString();
    }
}
