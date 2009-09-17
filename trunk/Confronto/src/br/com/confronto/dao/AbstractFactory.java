package br.com.confronto.dao;

/**
 *
 * @author ivanqueiroz
 */
abstract class AbstractFactory {

    public abstract AbstractDao getDao(String typeDao);

}
