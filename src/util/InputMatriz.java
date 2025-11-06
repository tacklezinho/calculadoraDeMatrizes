package util;

import java.util.Scanner;

public class InputMatriz {
    public static double[][] inputMatriz() {

        //  linhas (i)
        // colunas (j)

        System.out.println("Digite o valor de N: ");
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        double[][] matriz = new double[n][n];


        System.out.println("digite os valores da matriz: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Elemento [" + i + "][" + j + "]:");
                matriz[i][j] = scanner.nextDouble();
           
            }
        }
        
        System.out.println("Matriz quadrada de lado " + n + ":");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        scanner.close();
        System.out.println("Matriz gerada com sucesso!");
        return matriz;




    }
}
