package br.com.confronto.dao.factory;

import br.com.confronto.dao.PessoaDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class DaoFactory {

    private static final DaoFactory daoFactory = new DaoFactory();
    private final ResourceBundle LOG_PROP = ResourceBundle.getBundle("log");
    private final ResourceBundle BD_PROP = ResourceBundle.getBundle("config");
    private final String driver = BD_PROP.getString("DRIVER_BD");
    private final String nome = BD_PROP.getString("NOME_BD");
    private final String url = BD_PROP.getString("URL_BD");
    private final String host = BD_PROP.getString("HOST_BD");
    private final String porta = BD_PROP.getString("PORTA_BD");
    private final String usuario = BD_PROP.getString("LOGIN_BD");
    private final String senha = BD_PROP.getString("SENHA_BD");
    private final String strCon = url + "://" + host + ":" + porta + "/" + nome;
    private Connection connection;

    private void log(String msg, Level level) {
        Logger log = Logger.getLogger(DaoFactory.class.getName());
        try {
            FileHandler fh = new FileHandler(LOG_PROP.getString("LOG_DIR"), true);
            fh.setFormatter(new SimpleFormatter());
            log.addHandler(fh);
            log.log(level, msg);
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private DaoFactory() {

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(strCon,usuario,senha);
        } catch (SQLException ex) {
            log("Erro ao obter conexão: " + ex.toString(), Level.SEVERE);
        } catch (ClassNotFoundException ex) {
            log("Erro ao carregar o driver: " + ex.toString(), Level.SEVERE);
        }
    }

    public static DaoFactory getInstancia() {
        return daoFactory;
    }

    public PessoaDao getPessoaDao(){
        return new PessoaDao(connection);
    }
}
