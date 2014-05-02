package br.com.sidlar.dailyQuiz.presentation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ADMILSON on 29/04/14.
 */
@WebFilter("/Quiz")
public class Filtro implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Map<String,List<String>> ipsPorData= new HashMap<String, List<String>>();
        filterConfig.getServletContext().setAttribute("mapaIps", ipsPorData);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        List<String> ips = getIpsQueResponderam(request);
        request.setAttribute("usuarioJaRespondeu", ips.contains(request.getRemoteAddr()));

        chain.doFilter(request, response);

        if(request.getParameter("logica").equals("Resposta")){
            adicionaIpQueRespondeu(request, ips);
        }
    }

    private List<String> getIpsQueResponderam(ServletRequest request){
        return getMapaIps(request).get(getDataDivulgacao())==null? new ArrayList<String>(): getMapaIps(request).get(getDataDivulgacao());
    }

    private void adicionaIpQueRespondeu(ServletRequest request, List<String> ips){
        ips.add(request.getRemoteAddr());
        getMapaIps(request).put(getDataDivulgacao(), ips);
        request.getServletContext().setAttribute("mapaIps", getMapaIps(request));
    }

    private Map<String, List<String>> getMapaIps(ServletRequest request) {
        return (Map<String, List<String>>) request.getServletContext().getAttribute("mapaIps");
    }

    private String getDataDivulgacao() {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date(Calendar.getInstance().getTimeInMillis()));
    }

    @Override
    public void destroy() {
    }
}
