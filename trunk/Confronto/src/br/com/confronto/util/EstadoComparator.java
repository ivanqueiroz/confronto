package br.com.confronto.util;

import br.com.confronto.model.vo.Estado;
import java.util.Comparator;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class EstadoComparator implements Comparator<Estado> {

    public int compare(Estado o1, Estado o2) {
        int result = 0;
        if (o1.getEstado() != null && o2.getEstado() != null) {
            result = o1.getEstado().compareTo(o2.getEstado());
        }else if(o1.getEstado() == null){
            result = -1;
        }else if (o2.getEstado() == null){
            result = 1;
        }
        return result;
    }
}
