/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

/**
 *
 * @author vitor
 */

// Tabela InfoMaquina
public class InfoMaquina {

    private String sistemaOperacional;
    private String fabricante;
    private String arquitetura;
    private String nomeProcessador;
    private String capacidadeRam;
    private String capacidadeDisco;
    private Integer fkMaquina;
    private Integer fkEmpresa;

    public InfoMaquina() {
    }

   

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(String arquitetura) {
        this.arquitetura = arquitetura;
    }

    public String getNomeProcessador() {
        return nomeProcessador;
    }

    public void setNomeProcessador(String nomeProcessador) {
        this.nomeProcessador = nomeProcessador;
    }

    public String getCapacidadeRam() {
        return capacidadeRam;
    }

    public void setCapacidadeRam(String capacidadeRam) {
        this.capacidadeRam = capacidadeRam;
    }

    public String getCapacidadeDisco() {
        return capacidadeDisco;
    }

    public void setCapacidadeDisco(String capacidadeDisco) {
        this.capacidadeDisco = capacidadeDisco;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    @Override
    public String toString() {
        return String.format(" sistemaOperacional: %s |"
                + " fabricante: %s | arquitetura : %s| nomeProcessador: %s |"
                + " capacidadeRam: %s | capacidadeDisco: %s | fkEmpresa: %d | fkMaquina: %ds",
                sistemaOperacional, fabricante, arquitetura,
                nomeProcessador, capacidadeRam, capacidadeDisco, fkEmpresa, fkMaquina);
    }

}
