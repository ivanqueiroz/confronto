package br.com.confronto.dao;

import java.util.List;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public abstract class AbstractDao {

    public void apagar(Object o) throws DaoException {
    }

    public void atualizar(Object o) throws DaoException {
    }

    public void inserir(Object o) throws DaoException {
    }

    public Object obterPorId(Object id) throws DaoException {
        return null;
    }

    public List obterTodos() throws DaoException {
        return null;
    }
}
