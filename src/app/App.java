package app;

import model.GerarMatrizInversa;
import util.PrintMatriz;

public class App {

	public static void main(String[] args) {


		double[][] matriz = {
//				{2, 4, 5, 0},
//				{3, 0, 7,10},
//				{2, 1, 0,8},
//				{1,0,6,4}
				{8, 30, 850, 20},
				{15, 0, 1, 2.5},
				{0, 0, 1, 0},
				{2, 3, 6, 420}
		};


		GerarMatrizInversa.gerarMatrizInversa(matriz);
		System.out.println("~~~~~~~~");
		PrintMatriz.printMatriz(GerarMatrizInversa.matrizIdentidade);
		System.out.println("~~~~~~~~");
		PrintMatriz.printMatriz(matriz);


	}

}
