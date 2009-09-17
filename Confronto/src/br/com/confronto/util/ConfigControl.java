package br.com.confronto.util;

import br.com.confronto.security.Criptografia;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class ConfigControl {

    private static Properties config = new Properties();
    private static ConfigControl instancia = new ConfigControl();
    private final String arquivoIni = "../Config/confronto.ini";
    private static char[] hexChar = {
        '0', '1', '2', '3',
        '4', '5', '6', '7',
        '8', '9', 'a', 'b',
        'c', 'd', 'e', 'f'};

    private ConfigControl() {
        try {
            config.load(new FileInputStream(arquivoIni));
        } catch (IOException ex) {
            Logger.getLogger(ConfigControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ConfigControl getInstancia() {
        return instancia;
    }

    public Boolean salvarPropriedade(String chave, String valor) {
        Boolean resultado = Boolean.FALSE;
        config.setProperty(chave, valor);
        try {
            config.store(new FileOutputStream(arquivoIni), null);
            resultado = Boolean.TRUE;
        } catch (IOException ex) {
            Logger.getLogger(ConfigControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public Boolean salvarPropriedadeEncriptada(String chave, String valor) {
        Boolean resultado = Boolean.FALSE;
        if(valor !=null) {
            valor = Criptografia.encripta(valor);
        }
        config.setProperty(chave, valor);
        try {
            config.store(new FileOutputStream(arquivoIni), null);
            resultado = Boolean.TRUE;
        } catch (IOException ex) {
            Logger.getLogger(ConfigControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public String carregaPropriedade(String chave) {
        String p = config.getProperty(chave);
        return p;
    }
    public String carregaPropriedadeEncriptada(String chave) {
        String p = config.getProperty(chave);
        if (p != null) {
            p = Criptografia.decripta(p);
        }
        return p;
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
