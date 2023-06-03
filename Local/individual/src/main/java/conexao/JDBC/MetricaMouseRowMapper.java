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
public class MetricaMouseRowMapper implements RowMapper<MetricaMouse> {
    
    
    @Override
    public MetricaMouse mapRow(ResultSet rs, int rowNum) throws SQLException {
        MetricaMouse coordenada= new MetricaMouse();
        coordenada.setIdMetricaMouse(rs.getInt("idMetricaMouse"));
        coordenada.setCordenadaX(rs.getInt("cordenadaX"));
        coordenada.setCordenaday(rs.getInt("cordenadaY"));
        coordenada.setDataHora(rs.getString("dataHora"));
        coordenada.setFkMaquina(rs.getInt("fkMaquina"));
        coordenada.setFkEmpresa(rs.getString("fkEmpresa"));
        return coordenada;
        
    
    
    }
}
