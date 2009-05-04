package br.com.confronto.control.util;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class LogControl {
    
    private final ResourceBundle LOG_PROP = ResourceBundle.getBundle("log");

    public void toLog(Class classe,String msg, Level level) {
        Logger log = Logger.getLogger(classe.getName());
        FileHandler fh = null;
        try {
            fh = new FileHandler(LOG_PROP.getString("LOG_DIR"), true);
            fh.setFormatter(new SimpleFormatter());
            log.addHandler(fh);
            log.log(level, msg);
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally{
            fh.close();
            log = null;
        }
    }

}
