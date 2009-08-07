/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.confronto.util;

import java.io.FileInputStream;
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

    private ConfigControl(){
        try {
            config.load(new FileInputStream("confronto.properties"));
        } catch (IOException ex) {
            Logger.getLogger(ConfigControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Properties getConfig(){
        return config;
    }

}
