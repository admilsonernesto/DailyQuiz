package br.com.sidlar.dailyQuiz.presentation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ADMILSON on 22/04/14.
 */
@WebServlet("/Quiz")
public class ControllerServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response)throws ServletException, IOException {

        executaPrecondicoes(request, response);

        String acao = request.getParameter("logica");
        String nomeDaClasse = "br.com.sidlar.dailyQuiz.presentation." + acao + "Logic";
        try {
            Class classe = Class.forName(nomeDaClasse);

            Logica logica = (Logica) classe.newInstance();
            String pagina = logica.executa(request, response);

            request.getRequestDispatcher(pagina).forward(request, response);

        } catch (Exception e) {
            String mensagemErro ="Não existe a lógica de negócios informada!";
            mostraMensagemErrro(request, response, mensagemErro);
        }
    }

    private void executaPrecondicoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("logica");
        if (acao == null){
            String mensagemErro ="Não existe a ação informada!";
            mostraMensagemErrro(request, response, mensagemErro);
        }

        Boolean usuarioJaRespondeu = (Boolean) request.getAttribute("usuarioJaRespondeu");
        if(usuarioJaRespondeu){
            String dataDivulgacao = new SimpleDateFormat("dd/MM/yyyy").format(new Date(Calendar.getInstance().getTimeInMillis()));
            String mensagemErro = "Usuário já respondeu a pergunta divulgada em "+ dataDivulgacao + "! (IP:" + request.getRemoteAddr() + ")";
            mostraMensagemErrro(request, response, mensagemErro);
        }
    }

    private void mostraMensagemErrro(HttpServletRequest request, HttpServletResponse response, String mensagemErro) throws ServletException, IOException {
        request.setAttribute("mensagemErro",mensagemErro);
        request.getRequestDispatcher("/WEB-INF/pages/respondido.jsp").forward(request, response);
    }
}
