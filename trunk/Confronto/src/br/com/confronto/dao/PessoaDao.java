package br.com.confronto.dao;

import br.com.confronto.control.util.LogControl;
import br.com.confronto.model.vo.Pessoa;
import br.com.confronto.model.vo.PessoaFisica;
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
public class PessoaDao {

    private Connection connection;
    private final ResourceBundle SQL_PROP = ResourceBundle.getBundle("sql");
    private final String SQL_INSERT = SQL_PROP.getString("TBPESSOA_INSERT");
    private final String SQL_SELECT = SQL_PROP.getString("TBPESSOA_SELECT");
    private final String SQL_SELECT_ID = SQL_PROP.getString("TBPESSOA_SELECT_ID");
    private final LogControl log = new LogControl();

    public PessoaDao(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Pessoa pessoa) {
        boolean resultado = false;
        PreparedStatement ps = null;
        if (pessoa != null && pessoa instanceof PessoaFisica) {
            PessoaFisica pf = (PessoaFisica) pessoa;
            try {
                ps = connection.prepareStatement(SQL_INSERT);

                ps.setString(1, pf.getNome());
                ps.setString(2, pf.getRua());
                ps.setString(3, pf.getEstado());
                ps.setString(4, pf.getCidade());
                ps.setString(5, pf.getCep());
                ps.setString(6, pf.getRg());
                ps.setString(7, pf.getCpf());
                ps.setString(8, pf.getPis());
                ps.setString(9, pf.getCtps());
                ps.setString(10, pf.getProfissao());
                ps.setString(11, pf.getNacionalidade());
                ps.setLong(12, pf.getSexo().getId());

                if (ps.executeUpdate() > 0) {
                    resultado = true;
                }
            } catch (SQLException ex) {
                log.toLog(this.getClass(), "Erro ao inserir: " + ex.getMessage(), Level.SEVERE);
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        log.toLog(this.getClass(), "Erro ao fechar connection: " + ex.getMessage(), Level.SEVERE);
                    }
                }
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        log.toLog(this.getClass(), "Erro ao fechar Prepared Statement: " + ex.getMessage(), Level.SEVERE);
                    }
                }
            }
        }
        return resultado;
    }

    public PessoaFisica getPessoaFisicaById(Long id){
        PessoaFisica aux = new PessoaFisica();
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(SQL_SELECT_ID);
            rs = ps.executeQuery();
            if (rs.next()) {
                aux = new PessoaFisica();
                aux.setId(rs.getLong(1));
                aux.setNome(rs.getString(2));
                aux.setRua(rs.getString(3));
                aux.setEstado(rs.getString(4));
                aux.setCidade(rs.getString(5));
                aux.setCep(rs.getString(6));
                aux.setRg(rs.getString(7));
                aux.setCpf(rs.getString(8));
                aux.setPis(rs.getString(9));
                aux.setCtps(rs.getString(10));
                aux.setProfissao(rs.getString(11));
                aux.setNacionalidade(rs.getString(12));
                Integer sexo = rs.getInt(13);
                if (sexo == 0) {
                    aux.setSexo(Sexo.getFeminino());
                } else if (sexo == 1) {
                    aux.setSexo(Sexo.getMasculino());
                }
                aux.getTipoCliente().setId(rs.getLong(14));
                aux.getTipoCliente().setTipo(rs.getString(15));
                aux.setBairro(rs.getString(16));
                aux.getEstadoCivil().setId(rs.getLong(17));
                aux.getEstadoCivil().setEstadoCivil(rs.getString(18));
                aux.setPai(rs.getString(19));
                aux.setMae(rs.getString(20));
                aux.setEmail(rs.getString(21));
                aux.setTelefoneResidencial(rs.getString(22));
                aux.setCelular(rs.getString(23));
                aux.setFax(rs.getString(24));
                aux.setTelefoneComercial(rs.getString(25));
            }
        } catch (SQLException ex) {
            log.toLog(this.getClass(), "Erro ao obter pessoa fisica: " + ex.getMessage(), Level.SEVERE);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException ex) {
                     log.toLog(this.getClass(), "Erro ao fechar result set: " + ex.getMessage(), Level.SEVERE);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                    ps = null;
                } catch (SQLException ex) {
                     log.toLog(this.getClass(), "Erro ao fechar prepared: " + ex.getMessage(), Level.SEVERE);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    connection = null;
                } catch (SQLException ex) {
                     log.toLog(this.getClass(), "Erro ao fechar a connection: " + ex.getMessage(), Level.SEVERE);
                }
            }
        }

        return aux;
    }

    public List<PessoaFisica> getPessoasFisicas() {
        List<PessoaFisica> lista = null;
        PessoaFisica aux = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            lista = new Vector<PessoaFisica>();
            while (rs.next()) {

                aux = new PessoaFisica();
                aux.setId(rs.getLong(1));
                aux.setNome(rs.getString(2));
                aux.setRua(rs.getString(3));
                aux.setEstado(rs.getString(4));
                aux.setCidade(rs.getString(5));
                aux.setCep(rs.getString(6));
                aux.setRg(rs.getString(7));
                aux.setCpf(rs.getString(8));
                aux.setPis(rs.getString(9));
                aux.setCtps(rs.getString(10));
                aux.setProfissao(rs.getString(11));
                aux.setNacionalidade(rs.getString(12));
                Integer sexo = rs.getInt(13);
                if (sexo == 0) {
                    aux.setSexo(Sexo.getFeminino());
                } else if (sexo == 1) {
                    aux.setSexo(Sexo.getMasculino());
                }
                aux.getTipoCliente().setId(rs.getLong(14));
                aux.getTipoCliente().setTipo(rs.getString(15));
                aux.setBairro(rs.getString(16));
                aux.getEstadoCivil().setId(rs.getLong(17));
                aux.getEstadoCivil().setEstadoCivil(rs.getString(18));
                aux.setPai(rs.getString(19));
                aux.setMae(rs.getString(20));
                aux.setEmail(rs.getString(21));
                aux.setTelefoneResidencial(rs.getString(22));
                aux.setCelular(rs.getString(23));
                aux.setFax(rs.getString(24));
                aux.setTelefoneComercial(rs.getString(25));

                lista.add(aux);
            }
        } catch (SQLException ex) {
            log.toLog(this.getClass(), "Erro ao obter pessoas fisicas: " + ex.getMessage(), Level.SEVERE);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException ex) {
                     log.toLog(this.getClass(), "Erro ao fechar result set: " + ex.getMessage(), Level.SEVERE);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                    ps = null;
                } catch (SQLException ex) {
                     log.toLog(this.getClass(), "Erro ao fechar prepared: " + ex.getMessage(), Level.SEVERE);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    connection = null;
                } catch (SQLException ex) {
                     log.toLog(this.getClass(), "Erro ao fechar a connection: " + ex.getMessage(), Level.SEVERE);
                }
            }
        }
        return lista;
    }

}
