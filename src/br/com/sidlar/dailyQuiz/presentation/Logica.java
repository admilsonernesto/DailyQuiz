package br.com.sidlar.dailyQuiz.presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ADMILSON on 22/04/14.
 */
public interface Logica {
    String executa(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
