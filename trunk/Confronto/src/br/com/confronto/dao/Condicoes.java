package br.com.confronto.dao;

import java.util.HashMap;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class Condicoes {

    private HashMap<String, Condicao> condMap;

    public Condicoes() {
        condMap = new HashMap<String, Condicao>();
    }

    public void addCondicao(String chave, String valor){
        condMap.put(chave, new Condicao(valor));
    }

    public void addCondicao(String chave, Condicao valor){
        condMap.put(chave, valor);
    }

    public Condicao getCondicao(String chave){
        return condMap.get(chave);
    }
}
