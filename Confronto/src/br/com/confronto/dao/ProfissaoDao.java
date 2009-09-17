package br.com.confronto.dao;

import br.com.confronto.util.LogControl;
import br.com.confronto.model.vo.Profissao;
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
public class ProfissaoDao extends AbstractDao{

    private Connection connection;
    private final ResourceBundle SQL_PROP = ResourceBundle.getBundle("sql");
    private final String SQL_INSERIR = SQL_PROP.getString("TBPROFISSAO_INSERT");
    private final String SQL_APAGAR = SQL_PROP.getString("TBPROFISSAO_DELETE");
    private final String SQL_ATUALIZAR = SQL_PROP.getString("TBPROFISSAO_UPDATE");
    private final String SQL_LISTAR = SQL_PROP.getString("TBPROFISSAO_SELECT");
    
    public ProfissaoDao(Connection connection) {
        this.connection = connection;
    }

    public List<Profissao> getProfissoes() {
        List<Profissao> profissoes = null;
        Profissao aux = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_LISTAR);
            rs = ps.executeQuery();
            profissoes = new Vector<Profissao>();
            profissoes.add(new Profissao());
            while (rs.next()) {
                aux = new Profissao();
                aux.setId(rs.getLong(1));
                aux.setProfissao(rs.getString(2));
                profissoes.add(aux);
            }
        } catch (SQLException ex) {
            LogControl.getInstancia().toLog(this.getClass(), "Erro ao executar listagem de profissoes: " + ex.getMessage(), Level.SEVERE);
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
        return profissoes;
    }
}
