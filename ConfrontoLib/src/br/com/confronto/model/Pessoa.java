package br.com.confronto.model;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class Pessoa {

    public final int FEMININO = 0;
    public final int MASCULINO = 1;
    private String nome;
    private String estado;
    private String cidade;
    private String endereco;
    private int tipo;
    private int sexo;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
