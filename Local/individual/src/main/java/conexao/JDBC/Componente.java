/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

/**
 *
 * @author vitor
 */
public class Componente {
    private Integer idComponente;
    private String tipoCompenente;

    public Componente() {
    }

    
    
    
    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public String getTipoCompenente() {
        return tipoCompenente;
    }

    public void setTipoCompenente(String tipoCompenente) {
        this.tipoCompenente = tipoCompenente;
    }

    @Override
    public String toString() {
        return "Componente{" + "idComponente=" + idComponente + ", tipoCompenente=" + tipoCompenente + '}';
    }

 

  
    
}
