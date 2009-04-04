package br.com.confronto.dao;

import br.com.confronto.model.vo.Pessoa;
import br.com.confronto.model.vo.PessoaFisica;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class PessoaDao {

    private Connection connection;
    private final ResourceBundle SQL_PROP = ResourceBundle.getBundle("sql");
    private final String SQL_INSERIR = SQL_PROP.getString("TBPESSOA_INSERT");
    private final ResourceBundle LOG_PROP = ResourceBundle.getBundle("log");

    public PessoaDao(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Pessoa pessoa) {
        boolean resultado = false;
        if (pessoa != null && pessoa instanceof PessoaFisica) {
            PessoaFisica pf = (PessoaFisica) pessoa;
            try {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERIR);
                ps.setString(1, pf.getNome());
                ps.setString(2, pf.getEndereco());
                ps.setString(3, pf.getEstado());
                ps.setString(4, pf.getCidade());
                ps.setString(5, pf.getCep());
                ps.setString(6, pf.getRg());
                ps.setString(7, pf.getCpf());
                ps.setString(8, pf.getPis());
                ps.setString(9, pf.getCtps());
                ps.setString(10, pf.getProfissao());
                ps.setString(11, pf.getNacionalidade());
                ps.setByte(12, pf.getSexo());

                if(ps.executeUpdate()>0){
                    resultado = true;
                }
            } catch (SQLException ex) {
                log("Erro ao inserir: "+ex.getMessage(),Level.SEVERE);
            }

        }
        return resultado;
    }

    private void log(String msg, Level level) {
        Logger log = Logger.getLogger(PessoaDao.class.getName());
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

}
