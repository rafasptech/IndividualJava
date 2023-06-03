/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

import com.slack.api.methods.SlackApiException;
import conexao.JDBC.Conexao;
import conexao.JDBC.Empresa;
import conexao.JDBC.EnviaDados;
import conexao.JDBC.InfoMaquina;
import conexao.JDBC.Maquina;
import conexao.JDBC.RegistroAtividade;
import java.io.IOException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author rafae
 */
public class EnviaDados {

    Conexao conexao = new Conexao();
    JdbcTemplate conMysql = conexao.getConnection();
    JdbcTemplate conAzure = conexao.getConnectionAzu();
    MetricaMouse testeenvio;
    ColetaHDInfo testeenvio2;
    ColetaMemoria testeenvio3;
    ColetaProcessador testeenvio4;
    PorcentagemUso testeenvio5;

    public void iniciarEnvio(Integer fkMaquina,Integer fkEmpresa) throws SlackApiException, IOException {
        testeenvio = new MetricaMouse(fkMaquina,fkEmpresa);
        testeenvio2= new ColetaHDInfo();
        testeenvio3= new ColetaMemoria();
        testeenvio4= new ColetaProcessador();
        testeenvio5=new PorcentagemUso();
        while (true) {
            try {
                testeenvio5.enviaDadosPorcentagem(fkMaquina, fkEmpresa);
                testeenvio4.enviaDadosProcessador(fkMaquina, fkEmpresa);
                testeenvio3.enviaDadosMem(fkMaquina, fkEmpresa);
                testeenvio2.enviaDadosTotalhd(fkMaquina, fkEmpresa);
                testeenvio.enviaDadosMouse(fkMaquina, fkEmpresa);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
