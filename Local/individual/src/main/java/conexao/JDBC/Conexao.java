/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;



// Classe Conexão com o Mysql baseado em aula de LP
public class Conexao {

    private JdbcTemplate connectionmysql;
    private JdbcTemplate connectionazure;

    public Conexao() {
        BasicDataSource dataSourcemysql = new BasicDataSource();
        dataSourcemysql.setDriverClassName("com.mysql.cj.jdbc.Driver");
// exemplo para MySql: "com.mysql.cj.jdbc.Driver"
        dataSourcemysql.setUrl("jdbc:mysql://localhost:3310/NexusCenter");
// exemplo para MySql: "jdbc:mysql://localhost:3306/meubanco"
        dataSourcemysql.setUsername("root");
        dataSourcemysql.setPassword("#Gfgrupo6");
        this.connectionmysql = new JdbcTemplate(dataSourcemysql);
        
        BasicDataSource dataSourceMSSQL = new BasicDataSource();
//      classe de driver fornecida no site da Microsoft        
        dataSourceMSSQL.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//      url fornecida no BD Azure, que teve parte de seus parâmetros repassados para setUsername e setPassword
        dataSourceMSSQL.setUrl("jdbc:sqlserver://nexus-center.database.windows.net:1433;database=nexus-center;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
//      usuario admin do BD Azure        
        dataSourceMSSQL.setUsername("admin-nexus-center");
//      senha de usuário do BD        
        dataSourceMSSQL.setPassword("#Gfgrupo6");
        this.connectionazure = new JdbcTemplate(dataSourceMSSQL);
        
    }

    public JdbcTemplate getConnection() {
        return connectionmysql;
    }
    
    public JdbcTemplate getConnectionAzu(){
        return connectionazure;
    }

   // Processo de autenticação baseado em videoaula 
    
    public Connection conectaBDAzure() {
        Connection con = null;

        try {

            String url = "jdbc:sqlserver://nexus-center.database.windows.net:1433;database=nexus-center;user=admin-nexus-center;password={#Gfgrupo6};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            con = DriverManager.getConnection(url);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ConexaoDAO" + erro.getMessage());
        }
        return con;
    }
;

}