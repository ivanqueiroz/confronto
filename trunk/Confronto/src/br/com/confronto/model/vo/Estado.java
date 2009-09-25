package br.com.confronto.model.vo;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class Estado extends AbstractVo {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String estado;
    private String siglaUf;
    private String regiaoBrasil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRegiaoBrasil() {
        return regiaoBrasil;
    }

    public void setRegiaoBrasil(String regiaoBrasil) {
        this.regiaoBrasil = regiaoBrasil;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    @Override
    public String toString() {
        if (estado == null) {
            estado = "";
        }
        return estado.toUpperCase();
    }
}
