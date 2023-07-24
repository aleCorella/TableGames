package tarea_4_alec;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Tarea_4_ale {

    static int ingreso1 = -1;
    static int num1 = 0, num2 = 0; //Son Variables
    static int pCantidad;

    public static void main(String[] args) {
        Ejercicios_2 ob1 = new Ejercicios_2();

        while (ingreso1 != 0) {
            //evita que el programa termine si hay un error
            try {
                ingreso1 = Integer.parseInt(JOptionPane.showInputDialog("Elige opción:\n1- Dados"
                        + "\n2- VeintiUno\n"
                        + "3- OrdenarSecuencia\n"
                        + "0- Salir"));

                switch (ingreso1) {
                    case 1:

                        ob1.Dados();
                        break;
                    case 2:

                        ob1.VeintiUno();
                        break;
                    case 3:
                        pCantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de números"));
                        ob1.OrdenarSecuencia(pCantidad);
                        break;
                    case 0:
                        System.out.println("Adios!");
                        break;
                    default:
                        System.out.println("Número no reconocido");
                        break;
                }

                System.out.println("\n"); //Mostrar un salto de línea 

            } catch (Exception e) {
                System.out.println("Uoop! Error!");
            }
        }
    }

}
