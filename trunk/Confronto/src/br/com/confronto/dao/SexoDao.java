package br.com.confronto.dao;

import br.com.confronto.util.LogControl;
import br.com.confronto.model.vo.Sexo;
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
public class SexoDao {

    private Connection connection;
    private final ResourceBundle SQL_PROP = ResourceBundle.getBundle("sql");
    private final String SQL_SELECT = SQL_PROP.getString("TBSEXO_SELECT");

    public SexoDao(Connection connection) {
        this.connection = connection;
    }

    public List<Sexo> getLista() {
        List<Sexo> lista = null;
        Sexo vo = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            lista = new Vector<Sexo>();
            lista.add(new Sexo());
            while (rs.next()) {
                vo = new Sexo();
                vo.setId(rs.getLong(1));
                vo.setSexo(rs.getString(2));
                lista.add(vo);
            }
        } catch (SQLException ex) {
            LogControl.getInstancia().toLog(this.getClass(),"Erro ao obter lista de sexo: "+ ex.getMessage(), Level.SEVERE);
        } finally{
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException ex) {
                    LogControl.getInstancia().toLog(this.getClass(),"Erro ao obter fechar Prepared Statement: "+ex.getMessage(), Level.SEVERE);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    LogControl.getInstancia().toLog(this.getClass(), "Erro ao fechar result set: "+ex.getMessage(), Level.SEVERE);
                }
            }
        }
        return lista;
    }
}
