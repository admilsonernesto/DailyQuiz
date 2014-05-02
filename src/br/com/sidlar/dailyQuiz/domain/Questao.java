package br.com.sidlar.dailyQuiz.domain;

import java.sql.Date;
import java.util.List;

/**
 * Created by ADMILSON on 22/04/14.
 */
public class Questao {
    private Long id;
    private Date dataDivulgacao;
    private String enunciado;
    private List<Alternativa> alternativas;

    public Questao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDivulgacao() {
        return dataDivulgacao;
    }

    public void setDataDivulgacao(Date dataDivulgacao) {
        this.dataDivulgacao = dataDivulgacao;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public boolean certaResposta(int numeroAlternativa) {
        for (Alternativa alternativa : getAlternativas()) {
            if (alternativa.getNumero() == numeroAlternativa){
                return alternativa.isCorreta();
            }
        }
        return false;
    }
}
