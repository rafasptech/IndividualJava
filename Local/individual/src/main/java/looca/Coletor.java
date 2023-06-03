/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package looca;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.dispositivos.DispositivosUsbGrupo;
import com.github.britooo.looca.api.group.dispositivos.DispositivoUsb;
import java.util.List;

public class Coletor {

    public static void main(String[] args) {
        
    
        Looca looca = new Looca();
        Sistema sistema = looca.getSistema();

        sistema.getPermissao();
        sistema.getFabricante();
        sistema.getArquitetura();
        sistema.getInicializado();
        sistema.getSistemaOperacional();

        System.out.println(sistema);
//
////      Querry da memória
//System.out.println("#########Memória#########");
//        Memoria memoria = looca.getMemoria();
//
//        memoria.getDisponivel();
//        memoria.getEmUso();
//        memoria.getTotal();
//
//        System.out.println(memoria);

//        Querry Processador:
System.out.println("##########Processador#############");
        Processador processador = looca.getProcessador();

        processador.getFabricante();
        processador.getFrequencia();
        processador.getId();
        processador.getIdentificador();
        processador.getMicroarquitetura();
        processador.getNumeroCpusFisicas();
        processador.getNumeroCpusLogicas();
        processador.getNumeroPacotesFisicos();
        processador.getUso();
        

        System.out.println(processador);
        System.out.println("usooo");
        System.out.println(processador.getClass());

////      Querry relativo a coleta de dados do Disco:
//        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
//        grupoDeDiscos.getTamanhoTotal();
//        List<Disco> discos = grupoDeDiscos.getDiscos();
//
//        for (Disco disco : discos) {
//           Long discoLeitura = disco.getBytesDeLeitura();
//                   System.out.println(discoLeitura);
//
//        }
//        // Querry dados de Processos:
//        ProcessoGrupo grupoDeProcessos = looca.getGrupoDeProcessos();
//
//        List<Processo> processos = grupoDeProcessos.getProcessos();
//
//        for (Processo processo : processos) {
//            System.out.println(processo);
//        }
//
//        // Query de coleta de Periféricos
//        DispositivosUsbGrupo dispositivos = looca.getDispositivosUsbGrupo();
//
//        List<DispositivoUsb> dispositivosConectados = dispositivos.getDispositivosUsbConectados();
//        for (DispositivoUsb dispositivo : dispositivosConectados) {
//            System.out.println(dispositivo);
//        }

       
    }
}

