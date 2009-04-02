package br.com.confronto.model.vo;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class PessoaJuridica {

    private String cnpj;
    private String inscricaoEstadual;
    private String ramoAtividade;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(String ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }
}
