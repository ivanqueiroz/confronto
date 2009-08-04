package br.com.confronto.dao;

import br.com.confronto.util.LogControl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class DaoFactory {

    private final String driver = "org.h2.Driver";
    private final String url = "jdbc:h2:file:../ConfrontoDB/confronto";
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

}
