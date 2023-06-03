/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

/**
 *
 * @author rafae
 */
public class ColetarProcTeste {
    public static void main(String[] args) {
        ColetaProcessador coleta= new ColetaProcessador();
        System.out.println(coleta);
        ColetaMemoria coletamem = new ColetaMemoria();
        System.out.println(coletamem);
        ColetaHDInfo coletahd=new ColetaHDInfo();
        System.out.println(coletahd);
    }
}
