/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
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
import oshi.software.os.OSFileStore;

/**
 *
 * @author rafae
 */
public class ColetaHDInfo {
    private SlackeandoMetodos mensagem;
    private DateTimeFormatter formatter;
    private Integer idMetrica;
    private Double capacidade;
    private Double valorUtilizado;
    private String unidadeMedida;
    private String tipoComponente;
    private String modeloComponente;
    private String dataHora;
    private Integer fkMaquina;
    private Integer fkEmpresa;
    private Integer fkComponente;
    private Looca looca;
    private DiscoGrupo grupoDeDiscos;
    private Double bytesEscritos;
    private Double capacidadeocupada;
    private String idAlerta;
    private String statusAlerta;
    private Double porcentagem;

    public ColetaHDInfo() {
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        looca = new Looca();
        grupoDeDiscos = looca.getGrupoDeDiscos();
        bytesEscritos = 0.0;
        capacidadeocupada = 0.0;
//      Foi nescessário criar duas listas para prosseguir com a coleta de dados.       
        List<Disco> listadisco = grupoDeDiscos.getDiscos();
        for (Disco disco : listadisco) {
            bytesEscritos += disco.getBytesDeEscritas();

        }
        List<Volume> listavolumed = grupoDeDiscos.getVolumes();
        for (Volume volume : listavolumed) {
            capacidadeocupada += volume.getDisponivel();

        }
        //        this.capacidade = memoria.getNumeroCpusFisicas().doubleValue()+memoria.getNumeroCpusLogicas().doubleValue();
        this.idMetrica = null;
        this.capacidade = grupoDeDiscos.getTamanhoTotal().doubleValue() / (1024 * 1024 * 1024);
        this.valorUtilizado = this.capacidade - (capacidadeocupada / (1024 * 1024 * 1024));
        this.unidadeMedida = "GB";
        this.dataHora = LocalDateTime.now().format(formatter);
        this.tipoComponente = "HDTotal";
        this.modeloComponente = "Unknow";

    }

    public ColetaHDInfo(Integer idMetrica, Double capacidade, Double valorUtilizado, String unidadeMedida, String tipoComponente, String modeloComponente) {
        this.idMetrica = idMetrica;
        this.capacidade = capacidade;
        this.valorUtilizado = valorUtilizado;
        this.unidadeMedida = unidadeMedida;
        this.tipoComponente = tipoComponente;
        this.modeloComponente = modeloComponente;
    }

    public JdbcTemplate conectHd() {
        JdbcTemplate conection = new Conexao().getConnection();
        return conection;
    }

    public JdbcTemplate conectHdazu() {
        JdbcTemplate conection = new Conexao().getConnectionAzu();
        return conection;
    }

    public void enviaDadosTotalhd(Integer fkMaquina, Integer fkEmpresa) throws SlackApiException, IOException {
        ColetaHDInfo coleta = new ColetaHDInfo();
        mensagem= new SlackeandoMetodos();

        this.conectHd().update("insert into Metrica values(?,?,?,?,?,?,?)",
                coleta.idMetrica = null,
                coleta.valorUtilizado,
                coleta.unidadeMedida,
                coleta.dataHora,
                fkMaquina,
                fkEmpresa,
                1);
        this.conectHdazu().update("insert into Metrica(valorUtilizado,unidadeMedida,dataHora,fkMaquina,fkEmpresa,fkComponente) values(?,?,?,?,?,?)",
                coleta.valorUtilizado,
                coleta.unidadeMedida,
                coleta.dataHora,
                fkMaquina,
                fkEmpresa.toString(),
                1);
        porcentagem=((coleta.valorUtilizado / coleta.capacidade) * 100);
        if (porcentagem < 80) {
            statusAlerta = "Ideal";
        } else if (porcentagem >= 80 && porcentagem < 90) {
            statusAlerta = "Atencao";
        } else if (porcentagem >= 90 && porcentagem < 100) {
            statusAlerta = "Alerta";
            mensagem.notificarErroHd(porcentagem);
        }
        this.conectHd().update("insert into AlertaDashboard values(?,?,?,?)",
                idAlerta = null,
                coleta.dataHora,
                statusAlerta,
                1);
        this.conectHdazu().update("insert into AlertaDashboard values(?,?,?)",
                coleta.dataHora,
                statusAlerta,
                1);

    }
//        template.update("insert into configuracaoComponente(capacidade, unidadeMedida, fkMaquina, fkEmpresa, fkComponente) values (?,?,?,?,?)",
//                        this.capacidade,                        
//                        this.unidadeMedida,
//                        fkmaquina,
//                        fkempresa,
//                        fkcomponente);
//        template.update("insert into configuracaoComponente(valorUtilizado, unidadeMedida, dataHora, fkMaquina, fkEmpresa, fkComponente) values (?,?,?,?,?)",
//                        this.valorUtilizado,
//                        this.unidadeMedida,
//                        this.dataHora,
//                        fkmaquina,
//                        fkempresa,
//                        fkcomponente);
//        

    public void enviaDadosTotalhdazu(Integer fkMaquina, Integer fkEmpresa) {
        ColetaHDInfo coleta = new ColetaHDInfo();

    }

    public void enviadadosporHD() {

        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        looca = new Looca();
        grupoDeDiscos = looca.getGrupoDeDiscos();
        bytesEscritos = 0.0;
        capacidadeocupada = 0.0;
        dataHora = LocalDateTime.now().format(formatter);
//      Foi nescessário criar duas listas para prosseguir com a coleta de dados.       
        List<Disco> listadisco = grupoDeDiscos.getDiscos();
        for (Disco disco : listadisco) {
            bytesEscritos += disco.getBytesDeEscritas();

        }
        List<Volume> listavolumed = grupoDeDiscos.getVolumes();
        for (Volume volume : listavolumed) {
            capacidadeocupada += volume.getDisponivel();

        }
    }

    public Double getCapacidade() {
        return capacidade;
    }

    public Double getValorUtilizado() {
        return valorUtilizado;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public String getTipoComponente() {
        return tipoComponente;
    }

    public String getModeloComponente() {
        return modeloComponente;
    }

    @Override
    public String toString() {
        return "ColetaHD{" + "capacidade=" + capacidade + ", valorUtilizado=" + valorUtilizado + ", unidadeMedida=" + unidadeMedida + ", tipoComponente=" + tipoComponente + ", modeloComponente=" + modeloComponente + '}';
    }

}
