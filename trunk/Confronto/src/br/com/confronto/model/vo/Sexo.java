package br.com.confronto.model.vo;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class Sexo {

    private Long id;
    private String sexo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return sexo;
    }


}
