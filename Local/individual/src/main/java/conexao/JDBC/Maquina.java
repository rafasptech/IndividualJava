/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

// Tabela Maquina
public class Maquina {

    private Integer idMaquina;
    private String nomeUsuario;
    private String patrimonio;
    private String senha;
    private Integer fkEmpresa;
    private Integer idEmpresa;
    private String razaoSocial;
    private String CNPJ;
    private String email;
    private String tel;

//    fazer um construtor para seguir com as boas práticas
    public Maquina(Integer idMaquina, String nomeUsuario, String patrimonio, String senha, Integer fkEmpresa) {
        this.idMaquina = idMaquina;
        this.nomeUsuario = nomeUsuario;
        this.patrimonio = patrimonio;
        this.senha = senha;
        this.fkEmpresa = fkEmpresa;
    }
//Construtor alternativo para execução de testes

    public Maquina(String patrimonio, String senha) {
        this.patrimonio = patrimonio;
        this.senha = senha;
    }

    public Maquina() {
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
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
        return String.format("Maquina | idMáquina: %d | Nome Usuário: %s | Patrimonio: %s | Senha : %s|fkEmpresa: %d"
                + "\n Empresa | idEmpresa : %d |razaoSocial: %s| CNPJ %s | Email %s | tel %S", idMaquina, nomeUsuario, patrimonio, senha,
                fkEmpresa, idEmpresa, razaoSocial, CNPJ,email,tel);
    }

    
    
    
    
}
