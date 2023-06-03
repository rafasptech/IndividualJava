/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
/**
 *
 * @author rafae
 */
public class MaquinaRowMapper implements RowMapper<Maquina> {
    
    @Override
    public Maquina mapRow(ResultSet rs, int rowNum) throws SQLException {
        Maquina maquina= new Maquina();
        maquina.setIdMaquina(rs.getInt("idMaquina"));
        maquina.setNomeUsuario(rs.getString("nomeDoUsuario"));
        maquina.setPatrimonio(rs.getString("patrimonio"));
        maquina.setSenha(rs.getString("senha"));
        maquina.setFkEmpresa(rs.getInt("fkEmpresa"));
        return maquina;
    
}
        
    
}
