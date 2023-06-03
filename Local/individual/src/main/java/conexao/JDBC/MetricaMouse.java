/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.POINT;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author vitor
 */
// Tabela MetricaMouse
public class MetricaMouse {

    private POINT posicaoAtual;
    private DateTimeFormatter formatter;
    private Integer idMetricaMouse;
    private Integer cordenadaX;
    private Integer cordenaday;
    private Integer acaoClick;
    private String dataHora;
    private String status;
    private Integer fkMaquina;
    private String fkEmpresa;
    private Integer currentx;
    private Integer currenty;
    private Integer lastx;
    private Integer lasty;
    private String movimento;
    private MetricaMouse coordenadas;

    public MetricaMouse(Integer fkMaquina, Integer fkEmpresa) {
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        posicaoAtual = getMousePosition();
        this.idMetricaMouse = null;
        this.cordenadaX = posicaoAtual.x;
        this.cordenaday = posicaoAtual.y;
        this.dataHora = LocalDateTime.now().format(formatter);
        this.status = "Desativado";
        this.fkMaquina = fkMaquina;
        this.fkEmpresa = fkEmpresa.toString();

    }

    public MetricaMouse() {
    }

    public WinDef.POINT getMousePosition() {
        WinDef.POINT point = new WinDef.POINT();
        User32.INSTANCE.GetCursorPos(point);

        return point;
    }

    public JdbcTemplate conectMouse() {
        JdbcTemplate conection = new Conexao().getConnection();
        return conection;
    }
        public JdbcTemplate conectMouseazu() {
        JdbcTemplate conection2 = new Conexao().getConnectionAzu();
        return conection2;
    }

    public List<MetricaMouse> listarTodos() {
        List<MetricaMouse> todascoordenadas
                = this.conectMouse().query("select * from MetricaMouse;",
                        new MetricaMouseRowMapper());
        return todascoordenadas;
    }

    public void enviaDadosMouse(Integer fkMaquina, Integer fkEmpresa) {
        coordenadas = new MetricaMouse(fkMaquina, fkEmpresa);
        posicaoAtual = getMousePosition();
        currentx = posicaoAtual.x;
        currenty = posicaoAtual.y;
        if (currentx.equals(lastx) && currenty.equals(lasty)) {
            movimento = "Inativo";
            
        } else {
            movimento = "Ativo";
        }
        this.conectMouse().update("insert into MetricaMouse(idMetricaMouse,cordenadaX,cordenadaY,dataHora,statusMouse,fkMaquina,fkEmpresa) values(?,?,?,?,?,?,?)",
                coordenadas.idMetricaMouse,
                coordenadas.cordenadaX,
                coordenadas.cordenaday,
                coordenadas.dataHora,
                movimento,
                fkMaquina,
                fkEmpresa.toString());
        this.conectMouseazu().update("insert into MetricaMouse(cordenadaX,cordenadaY,dataHora,statusMouse,fkMaquina,fkEmpresa) values(?,?,?,?,?,?)",

                coordenadas.cordenadaX,
                coordenadas.cordenaday,
                coordenadas.dataHora,
                movimento,
                fkMaquina,
                fkEmpresa.toString());
        lastx = currentx;
        lasty = currenty;
//        this.conectMouseazu().update("insert into MetricaMouse values(?,?,?,?,?,?,?)",
//                coordenadas.idMetricaMouse,
//                coordenadas.cordenadaX,
//                coordenadas.cordenaday,
//                coordenadas.dataHora,
//                movimento,
//                fkMaquina,
//                fkEmpresa);
//        lastx = currentx;
//        lasty = currenty;
    }

    public WinDef.POINT getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(WinDef.POINT posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public Integer getIdMetricaMouse() {
        return idMetricaMouse;
    }

    public void setIdMetricaMouse(Integer idMetricaMouse) {
        this.idMetricaMouse = idMetricaMouse;
    }

    public Integer getCordenadaX() {
        return cordenadaX;
    }

    public void setCordenadaX(Integer cordenadaX) {
        this.cordenadaX = cordenadaX;
    }

    public Integer getCordenaday() {
        return cordenaday;
    }

    public void setCordenaday(Integer cordenaday) {
        this.cordenaday = cordenaday;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    public Integer getCurrentx() {
        return currentx;
    }

    public void setCurrentx(Integer currentx) {
        this.currentx = currentx;
    }

    public Integer getCurrenty() {
        return currenty;
    }

    public void setCurrenty(Integer currenty) {
        this.currenty = currenty;
    }

    public Integer getLastx() {
        return lastx;
    }

    public void setLastx(Integer lastx) {
        this.lastx = lastx;
    }

    public Integer getLasty() {
        return lasty;
    }

    public void setLasty(Integer lasty) {
        this.lasty = lasty;
    }

    public String getMovimento() {
        return movimento;
    }

    public void setMovimento(String movimento) {
        this.movimento = movimento;
    }

    public MetricaMouse getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(MetricaMouse coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(String fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

//     @Override
//    public String toString() {
//        return String.format(" idMetricaMouse: %d |"
//                + " cordenadaX: %d | cordenaday : %d| acaoClick: %d |"
//                + " dataHora: %s | status: %s | fkMaquina: %d | fkEmpresa: %ds",
//                 idMetricaMouse, cordenadaX, cordenaday,
//                acaoClick, dataHora, status, fkMaquina, fkEmpresa);
//    }
//    @Override
//    public String toString() {
//        return String.format(" idMetricaMouse: %d |"
//                + " cordenadaX: %d | cordenaday : %d| "
//                + " dataHora: %s | status: %s | fkMaquina: %d | fkEmpresa: %ds",
//                idMetricaMouse, cordenadaX, cordenaday, dataHora, status, fkCasa);
//    }
    @Override
    public String toString() {
        return "MetricaMouse{" + "posicaoAtual=" + posicaoAtual + ", formatter=" + formatter + ", idMetricaMouse=" + idMetricaMouse + ", cordenadaX=" + cordenadaX + ", cordenaday=" + cordenaday + ", dataHora=" + dataHora + ", status=" + status + ", fkMetrica=" + fkMaquina + ", currentx=" + currentx + ", currenty=" + currenty + ", lastx=" + lastx + ", lasty=" + lasty + ", movimento=" + movimento + ", coordenadas=" + coordenadas + '}';
    }

}
