package br.com.confronto.dao;

import br.com.confronto.model.vo.Sexo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class SexoDao {

    private Connection connection;
    private final ResourceBundle SQL_PROP = ResourceBundle.getBundle("sql");
    private final String SQL_SELECT = SQL_PROP.getString("TBSEXO_SELECT");
    private final ResourceBundle LOG_PROP = ResourceBundle.getBundle("log");

    public SexoDao(Connection connection) {
        this.connection = connection;
    }

    private void log(String msg, Level level) {
        Logger log = Logger.getLogger(SexoDao.class.getName());
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

    public List<Sexo> getLista() {
        List<Sexo> lista = null;
        Sexo vo = null;
        try {
            lista = new Vector<Sexo>();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vo = new Sexo();
                vo.setId(rs.getLong(1));
                vo.setSexo(rs.getString(2));
                lista.add(vo);
            }
        } catch (SQLException ex) {
            log("Erro ao obter lista de sexo: ", Level.SEVERE);
        }
        return lista;
    }
}
