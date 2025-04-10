/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba3;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author porto
 */
public class Room {

    private int roomNumber;
    private String typeRoom;
    private int priceRoom;
    private String statusRoom;

    public Room(int roomNumber, String typeRoom, int priceRoom, String statusRoom) {
        this.roomNumber = roomNumber;
        this.typeRoom = typeRoom;
        this.priceRoom = priceRoom;
        this.statusRoom = statusRoom;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getStatusRoom() {
        return statusRoom;
    }

    public void setStatusRoom(String statusRoom) {
        this.statusRoom = statusRoom;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public int getPriceRoom() {
        return priceRoom;
    }

    public void setPriceRoom(int priceRoom) {
        this.priceRoom = priceRoom;
    }

    @Override
    public String toString() {
        return "Habitacion = " + roomNumber + "\nTipo de Habitacion = " + typeRoom + "\nPrecio = " + priceRoom + "\nEstatus = " + statusRoom;
    }

    /**
     * Funcion para generar automaticamente las habitaciones precargadas del
     * hotel 5*5
     *
     * @param room Este es para indicar a cual tabla se le cargara todo
     * @return
     */
    public static Room[][] dataWriter(Room[][] room) {
        int numRoom = 501;
        String[] typeRoom = {"Simple", "Doble"};
        String[] statusRoom = {"Libre", "Ocupada", "Sucia"};
        int[] priceRoom = {30, 40, 50, 70};

        Random ranType = new Random();
        Random ranStatus = new Random();
        Random ranPrices = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int numType = ranType.nextInt(typeRoom.length);
                int numStatus = ranStatus.nextInt(statusRoom.length);
                int numPrices = ranPrices.nextInt(priceRoom.length);
                Room roomI = new Room(numRoom, typeRoom[numType], priceRoom[numPrices], statusRoom[numStatus]);
                room[i][j] = roomI;
                numRoom += 1;
            }
            numRoom -= 105;
        }
        return room;
    }

    /**
     * Funcion para poder buscar la habitacion
     *
     * @param roomTa Tabla la cual se evaluar
     * @return este retorna ver si la habitacion se encuenta
     */
    public static boolean searchRoom(Room[][] roomTa) {
        int Room = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de habitacion que quiera modificar"));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (roomTa[i][j].getRoomNumber() == Room) {
                    int menu = Integer.parseInt(JOptionPane.showInputDialog(roomTa[i][j] + "\n Indique que aspecto quiere modificar: \n1-Estado   2-Tipo  3-Precio "));
                    if (menu == 1) {
                        roomTa[i][j].setStatusRoom(JOptionPane.showInputDialog("Que estado quiere para la habitacion " + roomTa[i][j].getRoomNumber() + " sea:\n Libre - Ocupada - Sucia:"));
                        return true;
                    } else if (menu == 2) {
                        roomTa[i][j].setTypeRoom(JOptionPane.showInputDialog("Que tipo quiere para la habitacion " + roomTa[i][j].getRoomNumber() + " sea:\n Simple - Doble"));
                        return true;
                    } else if (menu == 3) {
                        roomTa[i][j].setPriceRoom(Integer.parseInt(JOptionPane.showInputDialog("Que precio quiere para la habitacion " + roomTa[i][j].getRoomNumber() + " :")));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Metodo para poder ver las Habitaciones
     *
     * @param room Tabla la cual se evaluar
     */
    public static void showRooms(Room[][] room) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                JOptionPane.showMessageDialog(null, room[i][j]);
            }
        }
    }

    /**
     * Metodo para poder calcular cuantas habitaciones hay y cuanto es la
     * ganancia
     *
     * @param room Tabla la cual se evaluara
     */
    public static void resumeHotel(Room[][] room) {
        int roomAvailable = 0;
        int roomBusy = 0;
        int roomDirty = 0;
        int earns = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (room[i][j].getStatusRoom() == "Libre") {
                    roomAvailable += 1;
                    earns += room[i][j].getPriceRoom();
                } else if (room[i][j].getStatusRoom() == "Ocupada") {
                    roomBusy += 1;
                } else if (room[i][j].getStatusRoom() == "Sucia") {
                    roomDirty += 1;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Resumen del Hotel"
                + "\nHabitaciones libres" + roomAvailable
                + "\nHabitaciones ocupadas" + roomBusy
                + "\nHabitaciones sucias" + roomDirty
                + "\n\nGanancias:" + earns);
    }
}
