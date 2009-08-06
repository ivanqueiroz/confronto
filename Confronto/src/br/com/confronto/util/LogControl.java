package br.com.confronto.util;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class LogControl {

    private final static LogControl instancia = new LogControl();
    private final File curDir = new File("..");
    private final File logFile = new File("/Logs/Confronto.log");

    private LogControl() {
        try {
            if (new File(curDir.getCanonicalPath() + "\\Logs").mkdir()) {
                System.out.println("Diretório criado.");
                if (!new File(curDir.getCanonicalPath() + logFile.getPath()).createNewFile()) {
                    System.out.println("Arquivo criado.");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(LogControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static LogControl getInstancia() {

        return instancia;
    }

    public void toLog(Class classe, String msg, Level level) {
        Logger log = Logger.getLogger(classe.getName());
        FileHandler fh = null;



        try {
            fh = new FileHandler(curDir.getCanonicalPath() + logFile.getPath(), true);

            fh.setFormatter(new SimpleFormatter());
            log.addHandler(fh);
            log.log(level, msg);
        } catch (SecurityException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            fh.close();
            log = null;
        }
    }
}
