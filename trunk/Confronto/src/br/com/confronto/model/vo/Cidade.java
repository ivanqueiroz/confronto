package br.com.confronto.model.vo;

import java.io.Serializable;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String cidade;
    private String siglaUf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    @Override
    public String toString() {
        if (cidade == null) {
            cidade = "";
        }
        return cidade.toUpperCase();
    }
}
