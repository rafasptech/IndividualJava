/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.dispositivos.DispositivosUsbGrupo;
import com.github.britooo.looca.api.group.dispositivos.DispositivoUsb;
import com.slack.api.methods.SlackApiException;
import comunicacao.slack.SlackeandoMetodos;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author rafae
 */
public class ColetaProcessador {
    private SlackeandoMetodos mensagem;
    private DateTimeFormatter formatter;
    private Integer idMetrica;
    private Double capacidade;
    private Double valorUtilizado;
    private String unidadeMedida;
    private String dataHora;
    private String tipoComponente;
    private String modeloComponente;
    private Processador processador;
    private String idAlerta;
    private String statusAlerta;
    private Double porcentagem;

    public ColetaProcessador() {
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        processador = new Processador();
//        this.capacidade = processador.getNumeroCpusFisicas().doubleValue()+processador.getNumeroCpusLogicas().doubleValue();
        this.idMetrica = null;
        this.capacidade = ((processador.getFrequencia().doubleValue()) / 1000000000) * (processador.getNumeroCpusFisicas() + processador.getNumeroCpusLogicas());
        this.valorUtilizado = processador.getUso();
        this.unidadeMedida = "GHz";
        this.dataHora = LocalDateTime.now().format(formatter);
        this.tipoComponente = "Processador";
        this.modeloComponente = processador.getNome();

    }

//  Para enviar à entidade Configuração Componente:
    public JdbcTemplate conectHd() {
        JdbcTemplate conection = new Conexao().getConnection();
        return conection;
    }

    public JdbcTemplate conectHdAzu() {
        JdbcTemplate conection = new Conexao().getConnectionAzu();
        return conection;
    }

    public void enviaDadosProcessador(Integer fkMaquina, Integer fkEmpresa) throws SlackApiException, IOException {
        ColetaProcessador coleta = new ColetaProcessador();
        mensagem= new SlackeandoMetodos();
        
        // Alertas aqui


        // Envio de dados aqui         
        this.conectHd().update("insert into Metrica values(?,?,?,?,?,?,?)",
                coleta.idMetrica = null,
                coleta.valorUtilizado,
                coleta.unidadeMedida,
                coleta.dataHora,
                fkMaquina,
                fkEmpresa,
                2);
        this.conectHdAzu().update("insert into Metrica(valorUtilizado,unidadeMedida,dataHora,fkMaquina,fkEmpresa,fkComponente) values(?,?,?,?,?,?)",
                coleta.valorUtilizado,
                coleta.unidadeMedida,
                coleta.dataHora,
                fkMaquina,
                fkEmpresa,
                2);

        porcentagem=((coleta.valorUtilizado / coleta.capacidade) * 100);
        if (porcentagem < 80) {
            statusAlerta = "Ideal";
        } else if (porcentagem >= 80 && porcentagem < 90) {
            statusAlerta = "Atencao";
        } else if (porcentagem >= 90 && porcentagem < 100) {
            statusAlerta = "Alerta";
            mensagem.notificarErroProcessador(porcentagem);
        }
        this.conectHd().update("insert into AlertaDashboard values(?,?,?,?)",
                idAlerta = null,
                coleta.dataHora,
                statusAlerta,
                2);
        this.conectHdAzu().update("insert into AlertaDashboard values(?,?,?)",
                coleta.dataHora,
                statusAlerta,
                2);

    }

    public void enviaDadosProcessadorazu(Integer fkMaquina, Integer fkEmpresa) {
        ColetaProcessador coleta = new ColetaProcessador();

        this.conectHdAzu().update("insert into Metrica(valorUtilizado,unidadeMedida,dataHora,fkMaquina,fkEmpresa,fkComponente) values(?,?,?,?,?,?)",
                coleta.valorUtilizado,
                coleta.unidadeMedida,
                coleta.dataHora,
                fkMaquina,
                fkEmpresa,
                2);
    }

    public Double getCapacidade() {
        return capacidade;
    }

//  Para enviar à entidade Metrica:
    public Double getValorUtilizado() {
        return valorUtilizado;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

//  Para enviar à entidade Componente:
    public String getTipoComponente() {
        return tipoComponente;
    }

    public String getModeloComponente() {
        return modeloComponente;
    }

    @Override
    public String toString() {
        return "ColetaProcessador{" + ", capacidade=" + capacidade + ", valorUtilizado=" + valorUtilizado + ", unidadeMedida=" + unidadeMedida + ", tipoComponente=" + tipoComponente + ", modeloComponente=" + modeloComponente + '}';
    }

}
