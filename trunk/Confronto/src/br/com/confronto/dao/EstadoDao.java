package br.com.confronto.dao;

import br.com.confronto.util.LogControl;
import br.com.confronto.model.vo.Estado;
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
public class EstadoDao extends AbstractDao<Estado,Long>{

    private Connection connection;
    private final ResourceBundle SQL_PROP = ResourceBundle.getBundle("sql");
    private final String SQL_INSERIR = SQL_PROP.getString("TBESTADO_INSERT");
    private final String SQL_APAGAR = SQL_PROP.getString("TBESTADO_DELETE");
    private final String SQL_ATUALIZAR = SQL_PROP.getString("TBESTADO_UPDATE");
    private final String SQL_LISTAR = SQL_PROP.getString("TBESTADO_SELECT");

    public EstadoDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void apagar(Long id) throws DaoException {
        super.apagar(id);
    }

    @Override
    public void atualizar(Estado o) throws DaoException {
        super.atualizar(o);
    }

    @Override
    public void inserir(Estado o) throws DaoException {
        super.inserir(o);
    }

    @Override
    public Estado obterPorId(Long id) throws DaoException {
        return super.obterPorId(id);
    }

    @Override
    public List<Estado> obterTodos() throws DaoException {
        return super.obterTodos();
    }



    public List<Estado> getEstados() {
        List<Estado> estados = null;
        Estado aux = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_LISTAR);
            rs = ps.executeQuery();
            estados = new Vector<Estado>();
            estados.add(new Estado());
            while (rs.next()) {
                aux = new Estado();
                aux.setId(rs.getLong(1));
                aux.setEstado(rs.getString(2));
                aux.setSiglaUf(rs.getString(3));
                aux.setRegiaoBrasil(rs.getString(4));
                estados.add(aux);
            }
        } catch (SQLException ex) {
            LogControl.getInstancia().toLog(this.getClass(), "Erro ao executar listagem de estados: " + ex.getMessage(), Level.SEVERE);
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
        
        return estados;
    }
}
