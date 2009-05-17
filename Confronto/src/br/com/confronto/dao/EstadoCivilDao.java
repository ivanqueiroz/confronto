package br.com.confronto.dao;

import br.com.confronto.util.LogControl;
import br.com.confronto.model.vo.EstadoCivil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;

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
    
    public EstadoCivilDao(Connection connection) {
        this.connection = connection;
    }

    public List<EstadoCivil> getEstadosCivis() {
        List<EstadoCivil> lista = null;
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
            LogControl.getInstancia().toLog(this.getClass(),"Erro ao obter lista de estados civis: " + ex, Level.SEVERE);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    LogControl.getInstancia().toLog(this.getClass(), "Erro ao fechar connection: " + ex.getMessage(), Level.SEVERE);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    LogControl.getInstancia().toLog(this.getClass(), "Erro ao fechar Prepared Statement: " + ex.getMessage(), Level.SEVERE);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    LogControl.getInstancia().toLog(this.getClass(), "Erro ao fechar result set: " + ex.getMessage(), Level.SEVERE);
                }
            }
        }
        return lista;
    }
}
