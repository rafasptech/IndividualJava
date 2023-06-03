/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class teste {

    public static void main(String[] args) {
        // Obter a instância de MemoryMXBean
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        // Obter a quantidade total de memória RAM em bytes
        long totalMemory = memoryBean.getHeapMemoryUsage().getMax();
        int totalMemoryGB = (int) Math.round((double) totalMemory / (1024 * 1024 * 1024));

        // Exibir a quantidade total de memória RAM
        System.out.println("Total Memory: " + totalMemoryGB + " gb");
    }
}
