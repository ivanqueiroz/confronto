package br.com.confronto.dao.factory;

import br.com.confronto.control.util.LogControl;
import br.com.confronto.dao.PessoaDao;
import br.com.confronto.dao.SexoDao;
import br.com.confronto.dao.TipoDao;
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
    private LogControl log = new LogControl();
    private Connection connection;

    public DaoFactory() {

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(strCon, usuario, senha);
        } catch (SQLException ex) {
            log.toLog(this.getClass(), "Erro ao obter conexão: " + ex.getMessage(), Level.SEVERE);
        } catch (ClassNotFoundException ex) {
            log.toLog(this.getClass(), "Erro ao carregar driver: " + ex.getMessage(), Level.SEVERE);
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            log.toLog(this.getClass(), "Erro ao fechar conexão: " + ex.getMessage(), Level.SEVERE);
        }
    }

    public PessoaDao getPessoaDao() {
        return new PessoaDao(connection);
    }

    public SexoDao getSexoDao() {
        return new SexoDao(connection);
    }

    public TipoDao getTipoDao() {
        return new TipoDao(connection);
    }
}
