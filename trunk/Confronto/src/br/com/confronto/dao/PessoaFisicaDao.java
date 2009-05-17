package br.com.confronto.dao;

import br.com.confronto.model.vo.PessoaFisica;
import br.com.confronto.model.vo.Sexo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class PessoaFisicaDao extends AbstractDao {

    private Connection connection;
    private final String SQL_INSERT_PF = "INSERT INTO PUBLIC.TBPESSOA (NOME, RUA, ESTADO, CIDADE, CEP, RG, CPF, PIS, CTPS, PROFISSAO, NACIONALIDADE, SEXO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_SELECT = "SELECT P.ID, P.NOME, P.ENDERECO, P.ESTADO, P.CIDADE, P.CEP, P.RG, P.CPF, P.PIS, P.CTPS, P.PROFISSAO, P.NACIONALIDADE, P.SEXO, P.TIPO, T.TIPO, P.BAIRRO, P.ESTADOCIVIL, EC.ESTADOCIVIL, P.PAI, P.MAE, P.EMAIL, P.TELEFONEFIXO, P.CELULAR, P.FAX, P.COMERCIAL FROM TBPESSOA P LEFT JOIN TBESTADOCIVIL EC ON P.ESTADOCIVIL = EC.ID LEFT JOIN TBTIPO T ON P.TIPO = T.ID WHERE TIPOPESSOA = 0";

    public PessoaFisicaDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void apagar(Object o) throws DaoException {
        super.apagar(o);
    }

    @Override
    public void atualizar(Object o) throws DaoException {
        super.atualizar(o);
    }

    @Override
    public void inserir(Object o) throws DaoException {
        super.inserir(o);
        PreparedStatement ps = null;
        if (o != null && o instanceof PessoaFisica) {
            PessoaFisica pf = (PessoaFisica) o;
            try {
                ps = connection.prepareStatement(SQL_INSERT_PF);

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

            } catch (SQLException ex) {
                throw new DaoException("Erro ao inserir pessoa: ", ex);
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        throw new DaoException("Erro ao fechar connection em inserir pessoa: ", ex);
                    }
                }
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        throw new DaoException("Erro ao fechar PreparedStatement em inserir pessoa: ", ex);
                    }
                }
            }
        }
    }

    @Override
    public Object obterPorId(Object o) throws DaoException {
        StringBuilder sql = new StringBuilder("SELECT P.ID, P.NOME, P.ENDERECO, P.ESTADO, P.CIDADE, P.CEP, P.RG, P.CPF, P.PIS, P.CTPS, P.PROFISSAO, P.NACIONALIDADE, P.SEXO, P.TIPO, T.TIPO, P.BAIRRO, P.ESTADOCIVIL, EC.ESTADOCIVIL, P.PAI, P.MAE, P.EMAIL, P.TELEFONEFIXO, P.CELULAR, P.FAX, P.COMERCIAL ");
        sql.append("FROM TBPESSOA P LEFT JOIN TBESTADOCIVIL EC ON P.ESTADOCIVIL = EC.ID LEFT JOIN TBTIPO T ON P.TIPO = T.ID ");
        sql.append("WHERE P.TIPOPESSOA = 0 AND P.ID = ?");
        
        if (o != null && o instanceof Long) {
            Long id = (Long) o;
            PessoaFisica aux = new PessoaFisica();
            ResultSet rs = null;
            PreparedStatement ps = null;

            try {
                ps = connection.prepareStatement(sql.toString());
                ps.setLong(1, id);
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
                throw new DaoException("Erro ao obter PessoaFisica: ", ex);
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                        rs = null;
                    } catch (SQLException ex) {
                        throw new DaoException("Erro ao obter fechar ResultSet em obterPorId: ", ex);
                    }
                }
                if (ps != null) {
                    try {
                        ps.close();
                        ps = null;
                    } catch (SQLException ex) {
                        throw new DaoException("Erro ao fechar PreparedStatement obterPorId: ", ex);
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                        connection = null;
                    } catch (SQLException ex) {
                        throw new DaoException("Erro ao fechar connection obterPorId: ", ex);
                    }
                }
            }

            return aux;
        }
        return super.obterPorId(o);
    }

    @Override
    public List obterTodos() throws DaoException {
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
            throw new DaoException("Erro ao obter lista de PessoaFisica: ", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException ex) {
                    throw new DaoException("Erro ao fechar ResultSet em obterTodos: ", ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                    ps = null;
                } catch (SQLException ex) {
                    throw new DaoException("Erro ao fechar PreparedeStatement em obterTodos: ", ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    connection = null;
                } catch (SQLException ex) {
                    throw new DaoException("Erro ao fechar Connection em obterTodos: ", ex);
                }
            }
        }
        return lista;
    }


}
