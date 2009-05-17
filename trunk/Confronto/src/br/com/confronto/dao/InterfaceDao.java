package br.com.confronto.dao;

import java.util.List;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public interface InterfaceDao {

    public void inserir(Object o) throws DaoException;
    public void apagar(Object o) throws DaoException;
    public Object obterPorId(Object id) throws DaoException;
    public List obterTodos() throws DaoException;
    public void atualizar(Object o) throws DaoException;

}
