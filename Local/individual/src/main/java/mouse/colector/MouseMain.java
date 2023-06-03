/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mouse.colector;

/**
 *
 * @author rafae
 */
public class MouseMain {
    public static void main(String[] args) {
        MouseColector detector = new MouseColector(500); // 5 seconds timeout
        while (true) {
            detector.showMouseposition();
            
            System.out.println("O Mouse encontra-se: " + detector.isPositionStoped());
            
            try {
                Thread.sleep(500); // wait for 1 second
            } catch (InterruptedException exception) {
            }
        }
    }
}
