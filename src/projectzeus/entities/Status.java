package projectzeus.entities;

public class Status {

    private String nome;
    private Integer value = 50;
    private boolean falha = false;

    public Status(String nome, Integer value) {
        this.nome = nome;
        this.value = value;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean isFalha() {
        return falha;
    }

    public void setFalha(boolean falha) {
        this.falha = falha;
    }

    private void check_over(){
        this.falha = this.value <= 0 || this.value >= 100;
    }
}
