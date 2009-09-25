package br.com.confronto.dao;

import java.util.List;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public abstract class AbstractDao<T,K> {

    public void apagar(K id) throws DaoException {
    }

    public void atualizar(T o) throws DaoException {
    }

    public void inserir(T o) throws DaoException {
    }

    public T obterPorId(K id) throws DaoException {
        return null;
    }

    public T buscar(K id) throws DaoException {
        return null;
    }

    public List<T> obterTodos() throws DaoException {
        return null;
    }
}
