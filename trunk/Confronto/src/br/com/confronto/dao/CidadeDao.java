package br.com.confronto.dao;

import br.com.confronto.util.LogControl;
import br.com.confronto.model.vo.Cidade;
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
public class CidadeDao extends AbstractDao{

    private Connection connection;
    private final ResourceBundle SQL_PROP = ResourceBundle.getBundle("sql");
    private final String SQL_INSERIR = SQL_PROP.getString("TBCIDADE_INSERT");
    private final String SQL_APAGAR = SQL_PROP.getString("TBCIDADE_DELETE");
    private final String SQL_ATUALIZAR = SQL_PROP.getString("TBCIDADE_UPDATE");
    private final String SQL_LISTAR = SQL_PROP.getString("TBCIDADE_SELECT");
    private final String SQL_LISTAR_SIGLAUF = SQL_PROP.getString("TBCIDADE_SELECT_SIGLAUF");

    public CidadeDao(Connection connection) {
        this.connection = connection;
    }

    public List<Cidade> getCidades() {
        List<Cidade> cidades = null;
        Cidade aux = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_LISTAR);
            rs = ps.executeQuery();
            cidades = new Vector<Cidade>();
            cidades.add(new Cidade());
            while (rs.next()) {
                aux = new Cidade();
                aux.setId(rs.getLong(1));
                aux.setCidade(rs.getString(2));
                aux.setSiglaUf(rs.getString(3));
                cidades.add(aux);
            }
        } catch (SQLException ex) {
            LogControl.getInstancia().toLog(this.getClass(), "Erro ao executar listagem de cidades: " + ex.getMessage(), Level.SEVERE);
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

        return cidades;
    }

    public List<Cidade> getCidadesPorEstado(String siglaUf) {
        List<Cidade> cidades = null;
        Cidade aux = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_LISTAR_SIGLAUF);
            ps.setString(1, siglaUf);
            rs = ps.executeQuery();
            cidades = new Vector<Cidade>();
            cidades.add(new Cidade());
            while (rs.next()) {
                aux = new Cidade();
                aux.setId(rs.getLong(1));
                aux.setCidade(rs.getString(2));
                aux.setSiglaUf(rs.getString(3));
                cidades.add(aux);
            }
        } catch (SQLException ex) {
            LogControl.getInstancia().toLog(this.getClass(), "Erro ao executar listagem de cidades: " + ex.getMessage(), Level.SEVERE);
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

        return cidades;
    }
}
