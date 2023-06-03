/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

/**
 *
 * @author rafae
 */
public class Empresa {
    private String idEmpresa;
    private String razaoSocial;
    private String CNPJ;
    private String email;
    private String tel;

    public Empresa(String idEmpresa, String razaoSocial, String CNPJ, String email, String tel) {
        this.idEmpresa = idEmpresa;
        this.razaoSocial = razaoSocial;
        this.CNPJ = CNPJ;
        this.email = email;
        this.tel = tel;
    }
// Classe criada especificamente para o Bean Property, pois sem ela é impossível inicializar a lista de acumulação de Objetos para consulta na classe LoginJframe
    public Empresa() {
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Empresa{" + "idEmpresa=" + idEmpresa + ", razaoSocial=" + razaoSocial + ", CNPJ=" + CNPJ + ", email=" + email + ", tel=" + tel + '}';
    }
    
    
}
