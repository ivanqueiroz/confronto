package br.com.confronto.dao;

import br.com.confronto.util.LogControl;
import br.com.confronto.model.vo.TipoCliente;
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
public class TipoDao extends AbstractDao{

    private Connection connection;
    private final ResourceBundle SQL_PROP = ResourceBundle.getBundle("sql");
    private final String SQL_INSERIR = SQL_PROP.getString("TBTIPO_INSERT");
    private final String SQL_APAGAR = SQL_PROP.getString("TBTIPO_DELETE");
    private final String SQL_ATUALIZAR = SQL_PROP.getString("TBTIPO_UPDATE");
    private final String SQL_LISTAR = SQL_PROP.getString("TBTIPO_SELECT");
  
    public TipoDao(Connection connection) {
        this.connection = connection;
    }

    public List<TipoCliente> getTipos() {
        List<TipoCliente> tipos = null;
        TipoCliente aux = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_LISTAR);
            rs = ps.executeQuery();
            tipos = new Vector<TipoCliente>();
            tipos.add(new TipoCliente());
            while (rs.next()) {
                aux = new TipoCliente();
                aux.setId(rs.getLong(1));
                aux.setTipo(rs.getString(2));
                tipos.add(aux);
            }
        } catch (SQLException ex) {
            LogControl.getInstancia().toLog(this.getClass(), "Erro ao executar listagem de tipos: " + ex.getMessage(), Level.SEVERE);
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
        return tipos;
    }
}
