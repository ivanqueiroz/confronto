package br.com.confronto.model.vo;

import java.io.Serializable;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class Tipo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }


}
