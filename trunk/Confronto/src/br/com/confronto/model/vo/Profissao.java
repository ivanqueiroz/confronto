package br.com.confronto.model.vo;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class Profissao extends AbstractVo {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String profissao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        if (profissao == null) {
            profissao = "";
        }
        return profissao.toUpperCase();
    }
}
