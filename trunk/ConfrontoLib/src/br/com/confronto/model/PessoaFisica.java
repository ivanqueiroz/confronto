package br.com.confronto.model;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class PessoaFisica extends Pessoa {

    private String cpf;
    private String rg;
    private String pis;
    private String ctps;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
