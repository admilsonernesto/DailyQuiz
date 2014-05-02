package br.com.sidlar.dailyQuiz.domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Dao de mentirinha por enquanto
 */
public class QuestaoDao {

    private Connection connection;

    public QuestaoDao() {
        this.connection = new ConnectionFactory().getConnectionMySql();
    }

    public Questao buscaQuestaoDivulgadaEm(Date dataDivulgacao) throws SQLException {
        String sql = "select * from questao as q join alternativa as a on q.id = a.idQuestao where dataDivulgacao=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, dataDivulgacao);
            ResultSet rs = stmt.executeQuery();

            Questao questao = new Questao();
            List<Alternativa> alternativas = new ArrayList<Alternativa>();
            while(rs.next()){
                Alternativa alternativa = new Alternativa();
                alternativa.setId(rs.getLong("a.id"));
                alternativa.setNumero(rs.getInt("a.numero"));
                alternativa.setDescricao(rs.getString("a.descricao"));
                alternativa.setQuantidadeRespostas(rs.getLong("a.quantidadeRespostas"));
                alternativa.setCorreta(rs.getBoolean("a.correta"));
                alternativas.add(alternativa);
                if(rs.isLast()){
                    questao.setId(rs.getLong("q.id"));
                    questao.setDataDivulgacao(rs.getDate("q.dataDivulgacao"));
                    questao.setEnunciado(rs.getString("q.enunciado"));
                }
            }
            questao.setAlternativas(alternativas);
            rs.close();
            stmt.close();
            return questao;
        }finally {
            connection.close();
        }
    }



    public void salvaAlternativa(Alternativa alternativa) throws SQLException {
        String sql = "update alternativa set quantidadeRespostas=? where id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1,alternativa.getQuantidadeRespostas());
            stmt.setLong(2,alternativa.getId());
            stmt.execute();
            stmt.close();
        } finally {
            connection.close();
        }
    }

}

