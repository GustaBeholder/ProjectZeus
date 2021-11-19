package projectzeus.entities;

public class Card {

    private String titulo;
    private String imagem;
    private String descricaoEvento;
    private String tipo;
    private Opcao opcaoA;
    private Opcao opcaoB;

    public Card(String titulo, String descricaoEvento,String tipo, Opcao opcaoA, Opcao opcaoB, String imagem) {
        this.titulo = titulo;
        this.descricaoEvento = descricaoEvento;
        this.tipo = tipo;
        this.opcaoA = opcaoA;
        this.opcaoB = opcaoB;
        this.imagem = imagem;
    }

    public Card() {
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public Opcao getOpcaoA() {
        return opcaoA;
    }

    public void setOpcaoA(Opcao opcaoA) {
        this.opcaoA = opcaoA;
    }

    public Opcao getOpcaoB() {
        return opcaoB;
    }

    public void setOpcaoB(Opcao opcaoB) {
        this.opcaoB = opcaoB;
    }
}
