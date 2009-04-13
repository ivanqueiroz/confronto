package br.com.confronto.dao;

import br.com.confronto.model.vo.EstadoCivil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class EstadoCivilDao {

    private Connection connection;
    private final ResourceBundle SQL_PROP = ResourceBundle.getBundle("sql");
    private final String SQL_INSERT = SQL_PROP.getString("TBESTADOCIVIL_INSERT");
    private final String SQL_SELECT = SQL_PROP.getString("TBESTADOCIVIL_SELECT");
    private final String SQL_DELETE = SQL_PROP.getString("TBESTADOCIVIL_DELETE");
    private final String SQL_UPDATE = SQL_PROP.getString("TBESTADOCIVIL_UPDATE");
    private final ResourceBundle LOG_PROP = ResourceBundle.getBundle("log");

    private void log(String msg, Level level) {
        Logger log = Logger.getLogger(EstadoCivilDao.class.getName());
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

    public EstadoCivilDao(Connection connection) {
        this.connection = connection;
    }

    public Vector<EstadoCivil> getLista() {
        Vector<EstadoCivil> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            if (rs != null) {
                lista = new Vector<EstadoCivil>();
                while (rs.next()) {
                    EstadoCivil vo = new EstadoCivil();
                    vo.setId(rs.getLong(1));
                    vo.setEstadoCivil(rs.getString(2));
                    lista.add(vo);
                }
            }
        } catch (SQLException ex) {
            log("Erro ao obter lista de estados civis: " + ex, Level.SEVERE);
        }
        return lista;
    }
}
