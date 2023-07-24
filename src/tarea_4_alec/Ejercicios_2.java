package tarea_4_alec;

import java.util.Random;
import javax.swing.JOptionPane;

public class Ejercicios_2 {

    int numMayor = 0;
    int numMenor = 0;
    int caraMayor = 0;
    int caraMenor = 0;
    int CantidadIntentos;
    int lanzarDado = 0;
    int contador = 0;
    int num1 = 0;
    int num2 = 0;
    int num3 = 0;
    int num4 = 0;
    int num5 = 0;
    int num6 = 0;

    public void SacarMayorMenor(int num, int cara) {
        if (num > numMayor && numMenor == 0) {
            numMayor = num;
            numMenor = num;
            caraMayor = cara;
            caraMenor = cara;

        } else if (num > numMayor) {

            numMayor = num;
            caraMayor = cara;

        } else if (num < numMayor && num < numMenor) {
            numMenor = num;
            caraMenor = cara;
        }
    }

    public void Dados() {

        while (lanzarDado < 200 || lanzarDado > 1000) {
            lanzarDado = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantas veces desea lanzar el dado? "));

            if (lanzarDado < 200 || lanzarDado > 1000) {
                JOptionPane.showMessageDialog(null, "Digite un numero valido");
            } else {
                while (contador != lanzarDado) {
                    int Rand = (int) (Math.random() * 6 + 1);

                    switch (Rand) {

                        case 1:
                            num1 = num1 + 1;
                            contador = contador + 1;

                            break;

                        case 2:
                            num2 = num2 + 1;
                            contador = contador + 1;

                            break;

                        case 3:
                            num3 = num3 + 1;
                            contador = contador + 1;

                            break;

                        case 4:
                            num4 = num4 + 1;
                            contador = contador + 1;

                            break;

                        case 5:
                            num5 = num5 + 1;
                            contador = contador + 1;

                            break;

                        case 6:
                            num6 = num6 + 1;
                            contador = contador + 1;

                            break;
                    }

                }

            }
        }
        SacarMayorMenor(num1, 1);
        SacarMayorMenor(num2, 2);
        SacarMayorMenor(num3, 3);
        SacarMayorMenor(num4, 4);
        SacarMayorMenor(num5, 5);
        SacarMayorMenor(num6, 6);

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(num5);
        System.out.println(num6);
        JOptionPane.showMessageDialog(null, "el numero que salio mas veces es: " + caraMayor + "\n"
                + " el numero que salio menos veces es: " + caraMenor);

    }

    public void VeintiUno() {
        int decision;
        int duda = JOptionPane.YES_NO_OPTION;
        Random rnd = new Random();
        int carta1 = rnd.nextInt(10) + 2;
        JOptionPane.showMessageDialog(null, "Su primer carta es " + carta1);
        int carta2 = rnd.nextInt(10) + 2;
        JOptionPane.showMessageDialog(null, "Su segunda carta es " + carta2);

        int suma = carta1 + carta2;
        System.out.println("la sumatoria de sus cartas es " + suma);

        decision = JOptionPane.showConfirmDialog(null, "Digite s si desea mas cartas y n si no", "Ingreso", duda);

        do {
            rnd = new Random();
            int cartan = rnd.nextInt(10) + 2;
            JOptionPane.showMessageDialog(null, "Su carta es " + cartan);
            suma = suma + cartan;
            JOptionPane.showMessageDialog(null, "La sumatoria de sus cartas es " + suma);

            if (suma > 21) {
                JOptionPane.showMessageDialog(null, "Usted perdio el juego");
                break;
            }

            decision = JOptionPane.showConfirmDialog(null, "Desea mas cartas? ", "Ingreso", duda);

        } while (decision == 0);

        if (19 <= suma && suma <= 21) {
            JOptionPane.showMessageDialog(null, "Usted gano el juego");
        } else if (suma > 21) {
            JOptionPane.showMessageDialog(null, "Usted perdio el juego");
        } else if (suma < 19) {
            JOptionPane.showMessageDialog(null, "Usted empato el juego");
        }
    }

    public void OrdenarSecuencia(int pCantidad) {

        String resultado = "";
        // Crear string con "*" separados por "|"
        for (int i = 0; i < pCantidad; i++) {
            resultado += "*|";
        }
        // Crear numeros aleatorios
        int[] numerosAleatorios = new int[pCantidad];
        int contadorNumerosRepetidos = 0;
        for (int i = 0; i < pCantidad; i++) {
            // Generar numero aleatorio
            int numeroMenor = 1;
            int numeroAleatorio = (int) Math.floor(Math.random() * ((pCantidad) - numeroMenor + 1) + numeroMenor);
            // Si esta repetido se aumenta el contador
            for (int j = 0; j < i; j++) {
                if (numerosAleatorios[j] == numeroAleatorio) {
                    contadorNumerosRepetidos++;
                    break;
                }
            }
            // Guardar numero aleatorio
            numerosAleatorios[i] = numeroAleatorio;
        }

        // Reemplazar "*" en el string
        int contadorAsterisco = -1;
        for (int i = 0; i < resultado.length(); i++) {
            if (resultado.charAt(i) == '*') {
                contadorAsterisco++;
                for (int j = 0; j < numerosAleatorios.length; j++) {
                    if (numerosAleatorios[j] == contadorAsterisco + 1) {
                        if (i + 1 == resultado.length()) {
                            resultado = resultado.substring(0, i) + numerosAleatorios[j];
                        } else {
                            resultado = resultado.substring(0, i) + numerosAleatorios[j] + resultado.substring(i + 1);
                        }
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Numeros al azar: ");
        for (int i = 0; i < numerosAleatorios.length; i++) {
            JOptionPane.showMessageDialog(null, numerosAleatorios[i]);
        }

        JOptionPane.showMessageDialog(null, "Resultado final: " + resultado);
        JOptionPane.showMessageDialog(null, "Repetidos: " + contadorNumerosRepetidos);
    }
}
