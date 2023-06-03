/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 *
 * @author rafae
 */
public class Parametro {

    private Integer idParametroAlerta;
    private Integer fkComponente;
    private Integer ideal;
    private Integer atencao;
    private Integer alerta;

    public Parametro(Integer idParametroAlerta, Integer fkComponente, Integer ideal, Integer atencao, Integer alerta) {
        this.idParametroAlerta = idParametroAlerta;
        this.fkComponente = fkComponente;
        this.ideal = ideal;
        this.atencao = atencao;
        this.alerta = alerta;
    }
    
    public Parametro() {
    }

    public JdbcTemplate conectloc() {
        JdbcTemplate conectloc = new Conexao().getConnection();

        return conectloc;
    }

    public JdbcTemplate conectnuv() {
        JdbcTemplate conectnuv = new Conexao().getConnectionAzu();

        return conectnuv;
    }
    public List<Parametro> listarTodos() {
        List<Parametro> todosParam = this.conectloc().query("select * from ParametroAlerta;",
                new ParametroRowMapper());
        return todosParam;
    }
    public Map<String, Object> recuperarpornumero(Integer fkMaquina) {
        try {
            Map<String, Object> registro = this.conectnuv().queryForMap(
                    "select * from ParametroAlerta where idParametroAlerta = ?", fkMaquina);
            return registro;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    public Integer tamanhoTotalParam(){
        Integer tamanho=this.listarTodos().size();
        return tamanho;
    }
    public Parametro parametroDaUltimafk(Integer fkComponente){
        Parametro ultimo= this.conectnuv().queryForObject("select * from ParametroAlerta where fkComponente=?", 
                new ParametroRowMapper(),fkComponente);
        return ultimo;
    }
//    Pais registro = jdbcTemplate.queryForObject("select * from tbl_pais where id_pais = ?", new
//PaisRowMapper(), id);

    public Integer getIdParametroAlerta() {
        return idParametroAlerta;
    }

    public void setIdParametroAlerta(Integer idParametroAlerta) {
        this.idParametroAlerta = idParametroAlerta;
    }

    public Integer getFkComponente() {
        return fkComponente;
    }

    public void setFkComponente(Integer fkComponente) {
        this.fkComponente = fkComponente;
    }

    public Integer getIdeal() {
        return ideal;
    }

    public void setIdeal(Integer ideal) {
        this.ideal = ideal;
    }

    public Integer getAtencao() {
        return atencao;
    }

    public void setAtencao(Integer atencao) {
        this.atencao = atencao;
    }

    public Integer getAlerta() {
        return alerta;
    }

    public void setAlerta(Integer alerta) {
        this.alerta = alerta;
    }



}
