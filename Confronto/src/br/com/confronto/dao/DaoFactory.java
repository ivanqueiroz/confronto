package br.com.confronto.dao;

import br.com.confronto.security.Encriptador;
import br.com.confronto.util.ConfigControl;
import br.com.confronto.util.Criptografia;
import br.com.confronto.util.LogControl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class DaoFactory {

    private final String driver = "org.h2.Driver";
    private final String url = "jdbc:h2:tcp://" + ConfigControl.getInstancia().carregaPropriedade("IP") + "/~/confronto";
    private final String usuario = "confronto";
    private final String senha = "admin123";
    private static final DaoFactory instancia = new DaoFactory();
    private Connection connection;

    private DaoFactory() {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            LogControl.getInstancia().toLog(this.getClass(), "Erro ao carregar driver: " + ex.getMessage(), Level.SEVERE);
        }
    }

    public static DaoFactory getInstancia() {
        return instancia;
    }

    private boolean conecta() {
        boolean conectou = false;
        try {
            connection = DriverManager.getConnection(url, usuario, senha);
            conectou = true;
        } catch (SQLException ex) {
            LogControl.getInstancia().toLog(this.getClass(), "Erro ao obter connection : " + ex.getMessage(), Level.SEVERE);
        }
        return conectou;
    }

    public PessoaFisicaDao getPessoaDao() {
        PessoaFisicaDao pessoaDao = null;
        if (conecta()) {
            pessoaDao = new PessoaFisicaDao(connection);
        }
        return pessoaDao;
    }

    public SexoDao getSexoDao() {
        SexoDao sexoDao = null;
        if (conecta()) {
            sexoDao = new SexoDao(connection);
        }
        return sexoDao;
    }

    public TipoDao getTipoDao() {
        TipoDao tipoDao = null;
        if (conecta()) {
            tipoDao = new TipoDao(connection);
        }
        return tipoDao;
    }

    public EstadoCivilDao getEstadoCivilDao() {
        EstadoCivilDao estadoCivilDao = null;
        if (conecta()) {
            estadoCivilDao = new EstadoCivilDao(connection);
        }
        return estadoCivilDao;
    }

    public ProfissaoDao getProfissaoDao() {
        ProfissaoDao profissaoDao = null;
        if (conecta()) {
            profissaoDao = new ProfissaoDao(connection);
        }
        return profissaoDao;
    }

    public EstadoDao getEstadoDao() {
        EstadoDao estadoDao = null;
        if (conecta()) {
            estadoDao = new EstadoDao(connection);
        }
        return estadoDao;
    }

    public CidadeDao getCidadeDao() {
        CidadeDao cidadeDao = null;
        if (conecta()) {
            cidadeDao = new CidadeDao(connection);
        }
        return cidadeDao;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        ConfigControl.getInstancia().salvarPropriedade("user", "confronto");
        ConfigControl.getInstancia().salvarPropriedade("ip", "192.168.0.108");
            //ConfigControl.getInstancia().salvarPropriedade("password", Encriptador.newInstance().encripita("admin123"));
            //ConfigControl.getInstancia().salvarPropriedade("password", Criptografia.encripta("admin123"));
            //System.out.println(Encriptador.newInstance().desencripta(ConfigControl.getInstancia().carregaPropriedade("password")));
            System.out.println(Criptografia.decripta(ConfigControl.getInstancia().carregaPropriedade("password")));
            //System.out.println(Criptografia.decripta("e����=��%�C�".getBytes()));
        /*} catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
            Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex) {
            Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();*/
        //System.out.println(Criptografia.decripta(ConfigControl.getInstancia().carregaPropriedade("password")));
        //System.out.println(Criptografia.decripta("e����=��%�C�".getBytes()));

    }
}
