package br.com.confronto.util;

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

    public String carregaPropriedade(String chave) {
        String p = config.getProperty(chave);
        if (p != null) {
            System.out.println(p.indexOf("\r\n"));
            p = p.replace("\r", "");
        }
        return p;
    }
}
