package br.com.confronto.dao;

import br.com.confronto.util.ConfigControl;
import br.com.confronto.util.LogControl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class DaoFactory extends AbstractFactory {

    private final String driver = "org.h2.Driver";
    private final String url = "jdbc:h2:tcp://" + ConfigControl.getInstancia().carregaPropriedade("IP") + "/~/confronto";
    private final String usuario = "confronto";
    private final String senha = ConfigControl.getInstancia().carregaPropriedadeEncriptada("password");
    private static final DaoFactory instancia = new DaoFactory();
    private Connection connection;

    private DaoFactory() {

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException ex) {
            LogControl.getInstancia().toLog(this.getClass(), "Erro ao carregar driver: " + ex.getMessage(), Level.SEVERE);
        } catch (SQLException ex) {
            LogControl.getInstancia().toLog(this.getClass(), "Erro ao obter connection : " + ex.getMessage(), Level.SEVERE);
        }
    }

    public static DaoFactory getInstancia() {
        return instancia;
    }


    public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        ConfigControl.getInstancia().salvarPropriedade("login", "confronto");
        ConfigControl.getInstancia().salvarPropriedadeEncriptada("password", "admin123");
        System.out.println(ConfigControl.getInstancia().carregaPropriedadeEncriptada("password"));
    }

    @Override
    public AbstractDao getDao(String typeDao) {
        if (connection != null && typeDao != null && typeDao.length() > 0) {
            if (typeDao.equalsIgnoreCase("pessoa")) {
                return new PessoaFisicaDao(connection);
            } else if (typeDao.equalsIgnoreCase("sexo")) {
                return new SexoDao(connection);
            } else if (typeDao.equalsIgnoreCase("tipoCliente")) {
                return new TipoDao(connection);
            } else if (typeDao.equalsIgnoreCase("estadoCivil")) {
                return new EstadoCivilDao(connection);
            } else if (typeDao.equalsIgnoreCase("profissao")) {
                return new ProfissaoDao(connection);
            } else if (typeDao.equalsIgnoreCase("estado")) {
                return new EstadoDao(connection);
            } else if (typeDao.equalsIgnoreCase("cidade")) {
                return new CidadeDao(connection);
            }
        }


        throw new UnsupportedOperationException("Not supported yet.");
    }
}
