package br.com.confronto.dao;

import br.com.confronto.model.vo.Tipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class TipoDao {

    private Connection connection;
    private final ResourceBundle SQL_PROP = ResourceBundle.getBundle("sql");
    private final String SQL_INSERIR = SQL_PROP.getString("TBTIPO_INSERT");
    private final String SQL_APAGAR = SQL_PROP.getString("TBTIPO_DELETE");
    private final String SQL_ATUALIZAR = SQL_PROP.getString("TBTIPO_UPDATE");
    private final String SQL_LISTAR = SQL_PROP.getString("TBTIPO_SELECT");
    private final ResourceBundle LOG_PROP = ResourceBundle.getBundle("log");

    public TipoDao(Connection connection) {
        this.connection = connection;
    }

    public List<Tipo> getTipos() {
        List<Tipo> tipos = new Vector<Tipo>();
        Tipo aux = null;
        ResultSet rs = null;
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_LISTAR);
            rs = ps.executeQuery();
            while(rs.next()){
                aux = new Tipo();
                aux.setId(rs.getLong(1));
                aux.setTipo(rs.getString(2));
                tipos.add(aux);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipos;
    }
}
