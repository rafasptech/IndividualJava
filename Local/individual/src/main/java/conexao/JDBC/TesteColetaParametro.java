/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafae
 */
public class TesteColetaParametro {
    
    public static void main(String[] args) {
        Integer teste = new Parametro().parametroDaUltimafk(3).getAlerta();

        System.out.println(teste);
    }
}
