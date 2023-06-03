/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

/**
 *
 * @author vitor
 */
public class Metrica {
    private Integer idMetrica;
    private Double valorUtlizado;
    private String unidadeMedida;
    private Integer dataHora;
    private Integer fkMaquina;
    private Integer fkEmpresa;

    public Integer getIdMetrica() {
        return idMetrica;
    }

    public void setIdMetrica(Integer idMetrica) {
        this.idMetrica = idMetrica;
    }

    public Double getValorUtlizado() {
        return valorUtlizado;
    }

    public void setValorUtlizado(Double valorUtlizado) {
        this.valorUtlizado = valorUtlizado;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Integer getDataHora() {
        return dataHora;
    }

    public void setDataHora(Integer dataHora) {
        this.dataHora = dataHora;
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
        return "Metrica{" + "idMetrica=" + idMetrica + ", valorUtlizado=" + valorUtlizado + ", unidadeMedida=" + unidadeMedida + ", dataHora=" + dataHora + ", fkMaquina=" + fkMaquina + ", fkEmpresa=" + fkEmpresa + '}';
    }
    
    
    
}
