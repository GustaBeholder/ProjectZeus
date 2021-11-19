package projectzeus.entities;

public class Opcao {

    private String descricao;
    private Integer dinheiro;
    private Integer energia;
    private Integer opiniaoPublica;
    private Integer impactoAmbiental;

    public Opcao(String descricao, Integer dinheiro, Integer energia, Integer opiniaoPublica, Integer impactoAmbiental) {
        this.descricao = descricao;
        this.dinheiro = dinheiro;
        this.energia = energia;
        this.opiniaoPublica = opiniaoPublica;
        this.impactoAmbiental = impactoAmbiental;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Integer dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Integer getEnergia() {
        return energia;
    }
    
    public void alteraStats(String descricao, Integer dinheiro, Integer energia, Integer opiniaoPublica, Integer impactoAmbiental){
        this.descricao = descricao;
        this.dinheiro = dinheiro;
        this.energia = energia;
        this.opiniaoPublica = opiniaoPublica;
        this.impactoAmbiental = impactoAmbiental;
    };

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public Integer getOpiniaoPublica() {
        return opiniaoPublica;
    }

    public void setOpiniaoPublica(Integer opiniaoPublica) {
        this.opiniaoPublica = opiniaoPublica;
    }

    public Integer getImpactoAmbiental() {
        return impactoAmbiental;
    }

    public void setImpactoAmbiental(Integer impactoAmbiental) {
        this.impactoAmbiental = impactoAmbiental;
    }
}
