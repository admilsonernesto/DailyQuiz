package br.com.sidlar.dailyQuiz.presentation;

import br.com.sidlar.dailyQuiz.domain.Alternativa;
import br.com.sidlar.dailyQuiz.domain.Questao;
import br.com.sidlar.dailyQuiz.domain.QuestaoDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.Calendar;

/**
 * Created by ADMILSON on 28/04/14.
 */
public class RespostaLogic implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Date dataDivulgacao = new Date(Calendar.getInstance().getTimeInMillis());
        Questao questao = new QuestaoDao().buscaQuestaoDivulgadaEm(dataDivulgacao);
        int numeroAlternativaSelecionada = Integer.valueOf(request.getParameter("alternativa"));

        for (Alternativa alternativa : questao.getAlternativas()) {
            if (alternativa.getNumero() == numeroAlternativaSelecionada){
                alternativa.setQuantidadeRespostas(alternativa.getQuantidadeRespostas() + 1L);
                new QuestaoDao().salvaAlternativa(alternativa);
            }
        }

        Resposta resposta= new Resposta(questao, numeroAlternativaSelecionada, questao.certaResposta(numeroAlternativaSelecionada));
        request.setAttribute("resposta",resposta);
        return "/WEB-INF/pages/resposta.jsp";
    }

}
