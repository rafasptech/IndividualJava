/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

/**
 *
 * @author vitor
 */
// Tabela RegistroAtividade
public class Usb {

    private Integer idUsb;
    private String nome;
    private String fornecedor;
    private Integer fkMaquina;
    private Integer fkEmpresa;
    
    public Integer getIdUsb() {
        return idUsb;
    }

    public void setIdUsb(Integer idUsb) {
        this.idUsb = idUsb;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    

    @Override
    public String toString() {
        return String.format(" idUsb: %d |"
                + " nome : %s| fornecedor : %s | fkMaquina: %d |"
                + " fkEmpresa: %d",
                idUsb, nome, fornecedor,
                fkMaquina, fkEmpresa);
    }

}
