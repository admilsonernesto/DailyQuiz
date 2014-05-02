package br.com.sidlar.dailyQuiz.domain;

/**
 * Created by ADMILSON on 22/04/14.
 */
public class Alternativa {
    private Long id;
    private int numero;
    private String descricao;
    private Long quantidadeRespostas;
    private boolean correta;

    public Alternativa() {
    }

    public Alternativa(int numero, String descricao) {
        this.numero = numero;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getQuantidadeRespostas() {
        return quantidadeRespostas;
    }

    public void setQuantidadeRespostas(Long quantidadeRespostas) {
        this.quantidadeRespostas = quantidadeRespostas;
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }
}
