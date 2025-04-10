/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba3;

import javax.swing.JOptionPane;

/**
 *
 * @author porto
 */
public class Prueba3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Crear matriz de Habitaciones
        Room matrizRooms[][] = new Room[5][5];
        //Quemar datos en la matriz creada
        matrizRooms = Room.dataWriter(matrizRooms);
        //Iniciar menu
        boolean menu = true;
        while (menu) {
            
            int menuSelector = Integer.parseInt(JOptionPane.showInputDialog(//Menu
                    "Bienvenido al sistema de Habitaciones del Hotel Fidelitas\nSeleccione su opcion"
                    + "\n1-Ver Habitaciones"
                    + "\n2-Modificar Habitaciones"
                    + "\n3-Resumen de ventas"
                    + "\n4-Salir"));
            switch (menuSelector) {
                case 1:
                    //Ver Habitaciones
                    Room.showRooms(matrizRooms);
                    break;
                case 2:
                    if (Room.searchRoom(matrizRooms) == false) {
                        JOptionPane.showMessageDialog(null, "Vuelva intentar nuevamente");
                    }
                    break;
                case 3:
                    Room.resumeHotel(matrizRooms);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Gracias por utilizarnos");
                    menu = false;
                    break;
                default:
                    break;
            }
        }
    }

}
