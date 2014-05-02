package br.com.sidlar.dailyQuiz.presentation;

import br.com.sidlar.dailyQuiz.domain.Questao;

/**
 * Created by ADMILSON on 02/05/14.
 */
public class Resposta {
    private Questao questao;
    private int numeroAlternativaSelecionada;
    private boolean acertou;

    public Resposta(Questao questao, int numeroAlternativaSelecionada, boolean acertou) {
        this.questao = questao;
        this.numeroAlternativaSelecionada = numeroAlternativaSelecionada;
        this.acertou = acertou;
    }

    public Questao getQuestao() {
        return questao;
    }

    public int getNumeroAlternativaSelecionada() {
        return numeroAlternativaSelecionada;
    }

    public boolean isAcertou() {
        return acertou;
    }
}
