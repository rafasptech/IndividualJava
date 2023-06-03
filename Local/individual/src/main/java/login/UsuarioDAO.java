/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import comunicacao.slack.NotifSlack;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import conexao.JDBC.Conexao;
import conexao.JDBC.Maquina;

/**
 *
 * @author vitor
 */
// classe (DAO) Data Access Object - Acesso ao banco de dados
public class UsuarioDAO {

    Connection con;

    // Autenticação do Usuário
    public ResultSet autenticsacaoUsuario(Maquina maquina) {

        con = new Conexao().conectaBDAzure();

        try {

            String sql = "select * from Maquina join Empresa on fkempresa=idempresa WHERE patrimonio = ? AND senha = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, maquina.getPatrimonio());
            pstm.setString(2, maquina.getSenha());

            ResultSet rs = pstm.executeQuery();

            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO:" + erro);
            return null;
        }
       }
    

    // Retorna Código Slack
    public String coletarCodigoSlack() {
        con = new Conexao().conectaBDAzure();
        NotifSlack slack = new NotifSlack();
        
        String sql = "select*from Slack";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {

                slack.setCodigo(rs.getString("codigo"));

                // Preencha as outras propriedades de Maquina aqui
                return rs.getString("codigo");
            } else {
                return null; // Não encontrou a máquina com o ID fornecido
            }
        } catch (SQLException e) {
            return null;
        }
    }
   }