/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.confronto.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
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

    private ConfigControl(){
        try {
            config.load(new FileInputStream(arquivoIni));
        } catch (IOException ex) {
            Logger.getLogger(ConfigControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ConfigControl getInstancia(){
        return instancia;
    }

    public Boolean salvarPropriedade(String chave, String valor){
        Boolean resultado = Boolean.FALSE;
        config.setProperty(chave, valor);
        try {
            config.store(new PrintWriter(arquivoIni), null);
            resultado = Boolean.TRUE;
        } catch (IOException ex) {
            Logger.getLogger(ConfigControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public String carregaPropriedade(String chave){
        return config.getProperty(chave);
    }



}
