package br.com.sidlar.dailyQuiz.presentation;

import br.com.sidlar.dailyQuiz.domain.Questao;
import br.com.sidlar.dailyQuiz.domain.QuestaoDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.Calendar;

/**
 * Created by ADMILSON on 22/04/14.
 */
public class QuestaoLogic implements Logica{
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Date dataDivulgacao = new Date(Calendar.getInstance().getTimeInMillis());
        Questao questao = new QuestaoDao().buscaQuestaoDivulgadaEm(dataDivulgacao);

        request.setAttribute("questao", questao);
        return "/WEB-INF/pages/questao.jsp";
    }
}
