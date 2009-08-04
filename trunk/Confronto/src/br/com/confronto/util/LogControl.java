package br.com.confronto.util;

import java.io.File;
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
    private final static LogControl instancia = new LogControl();
    private File logFile;

    private LogControl() {
    }

    public static LogControl getInstancia() {

        return instancia;
    }

    public void toLog(Class classe, String msg, Level level) {
        Logger log = Logger.getLogger(classe.getName());
        FileHandler fh = null;
        logFile = new File(LOG_PROP.getString("LOG_DIR"));

        try {
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            fh = new FileHandler(LOG_PROP.getString("LOG_DIR"), true);

            fh.setFormatter(new SimpleFormatter());
            log.addHandler(fh);
            log.log(level, msg);
        } catch (SecurityException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            fh.close();
            log = null;
        }
    }
}
