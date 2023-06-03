/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

import java.time.Instant;

/**
 *
 * @author vitor
 */

// Tabela RegistroAtividade
public class RegistroAtividade {

    private Integer idRegistroUsuario;
    private Integer fkEmpresa;
    private Integer fkMaquina;
    private String inicializado;
    private String tempoDeAtividade;

    public RegistroAtividade() {
    }

    public Integer getIdRegistroUsuario() {
        return idRegistroUsuario;
    }

    public void setIdRegistroUsuario(Integer idRegistroUsuario) {
        this.idRegistroUsuario = idRegistroUsuario;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    public String getInicializado() {
        return inicializado;
    }

    public void setInicializado(String inicializado) {
        this.inicializado = inicializado;
    }

    public String getTempoDeAtividade() {
        return tempoDeAtividade;
    }

    public void setTempoDeAtividade(String tempoDeAtividade) {
        this.tempoDeAtividade = tempoDeAtividade;
    }

   

    @Override
    public String toString() {
        return String.format(" idRegistroUsuario: %d |"
                + " fkEmpresa : %d| fkMaquina: %d |"
                + " inicializado: %s |  inicialtempoDeAtividadeizado: %s ",
                idRegistroUsuario, fkEmpresa,
                fkMaquina, inicializado, tempoDeAtividade);
    }

}
