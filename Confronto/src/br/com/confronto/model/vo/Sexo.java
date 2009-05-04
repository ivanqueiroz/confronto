package br.com.confronto.model.vo;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class Sexo {

    private Long id;
    private String sexo;
    private static final Sexo feminino = new Sexo(new Long(0), "FEMININO");
    private static final Sexo masculino = new Sexo(new Long(1), "MASCULINO");

    public Sexo() {
    }

    private Sexo(Long id, String sexo) {
        this.id = id;
        this.sexo = sexo;
    }

    public static Sexo getFeminino() {
        return feminino;
    }

    public static Sexo getMasculino() {
        return masculino;
    }

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
        if (sexo == null) {
            sexo = "";
        }
        return sexo.toUpperCase();
    }
}
