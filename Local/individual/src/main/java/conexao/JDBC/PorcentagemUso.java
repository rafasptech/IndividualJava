/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author rafae
 */
public class PorcentagemUso {
    // Objetos essenciais à classe
    
    private ColetaHDInfo coletahd;
    private ColetaMemoria coletamem;
    private ColetaProcessador coletaproc;
    private DateTimeFormatter formatter;
    
    // Objetos da Classe em si
    
    private Integer idPorcentagemUso;
    private Double porcentagemHD;
    private Double porcentagemMem;
    private Double porcentagemProc;
    private String dataHora;
    private Integer fkMaquina;
    private String fkEmpresa;

    public PorcentagemUso() {
        // Instancia de objetos para tratamento
        formatter = DateTimeFormatter.
                ofPattern("yyyy-MM-dd HH:mm:ss");
        coletahd = new ColetaHDInfo();
        coletamem = new ColetaMemoria();
        coletaproc = new ColetaProcessador();
        
        // Objetos tratados para envio ao banco      
        this.idPorcentagemUso=null;
        this.porcentagemHD=(coletahd.getValorUtilizado()
                /coletahd.getCapacidade())*100.0;
        this.porcentagemMem=(coletamem.getValorUtilizado()
                /coletamem.getCapacidade())*100.0;
        this.porcentagemProc=(coletaproc.getValorUtilizado()
                /coletaproc.getCapacidade())*100.0;
        this.dataHora = LocalDateTime.now().format(formatter);
        this.fkMaquina = null;
        this.fkEmpresa = null;
    }
    
    public JdbcTemplate conectloc() {
        JdbcTemplate conection = new Conexao().getConnection();
        return conection;
    }

    public JdbcTemplate conectnuv() {
        JdbcTemplate conection = new Conexao().getConnectionAzu();
        return conection;
    }
    public void enviaDadosPorcentagem(Integer fkMaquina, Integer fkEmpresa) {
        PorcentagemUso coleta = new PorcentagemUso();

        this.conectloc().update("insert into PorcentagemUso values(null,?,?,?,?,?,?)",
                
                
                coleta.porcentagemHD,
                coleta.porcentagemMem,
                coleta.porcentagemProc,
                coleta.dataHora,
                fkMaquina,
                fkEmpresa
                );
        this.conectnuv().update("insert into PorcentagemUso("
                + "porcentagemHD"
                + ",porcentagemMem"
                + ",porcentagemProc"
                + ",dataHora"
                + ",fkMaquina"
                + ",fkEmpresa) "
                
                + "values(?,?,?,?,?,?)",
                
                coleta.porcentagemHD,
                coleta.porcentagemMem,
                coleta.porcentagemProc,
                coleta.dataHora,
                fkMaquina,
                fkEmpresa.toString()
                );
    }

    public Double getPorcentagemHD() {
        return porcentagemHD;
    }

    public void setPorcentagemHD(Double porcentagemHD) {
        this.porcentagemHD = porcentagemHD;
    }

    public Double getPorcentagemMem() {
        return porcentagemMem;
    }

    public void setPorcentagemMem(Double porcentagemMem) {
        this.porcentagemMem = porcentagemMem;
    }

    public Double getPorcentagemProc() {
        return porcentagemProc;
    }

    public void setPorcentagemProc(Double porcentagemProc) {
        this.porcentagemProc = porcentagemProc;
    }
    
    
    
}
