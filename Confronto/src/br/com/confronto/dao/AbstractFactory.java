package br.com.confronto.dao;

/**
 *
 * @author ivanqueiroz
 */
abstract class AbstractFactory<T> {

    public abstract <T extends AbstractDao> T getDao(Class<T> type);

}
