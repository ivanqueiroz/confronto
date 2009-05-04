package br.com.confronto.util;

import br.com.confronto.model.vo.Cidade;
import java.util.Comparator;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class CidadeComparator implements Comparator<Cidade> {

    public int compare(Cidade o1, Cidade o2) {
        int result = 0;
        if (o1.getCidade() != null && o2.getCidade() != null) {
            result = o1.getCidade().compareTo(o2.getCidade());
        }else if(o1.getCidade() == null){
            result = -1;
        }else if (o2.getCidade() == null){
            result = 1;
        }
        return result;
    }
}
