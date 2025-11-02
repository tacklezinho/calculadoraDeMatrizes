package model;

import java.util.Iterator;

public class MatrizIdentidade {


	public static double[][] gerarMatrizIdentidade(double[][] matriz){

		double[][] matrizIdentidade =  geradorMatriz_1(geradorMatriz_0(matriz));
		return matrizIdentidade;

	}


	private static double[][] geradorMatriz_0(double[][] matriz){
		
		double[][] matrizTemp = new double[matriz.length][matriz[0].length];

		for (int i = 0; i < matriz.length; i++) {

			for (int i2 = 0; i2 < matriz.length; i2++) {

				matrizTemp[i][i2] = 0;

			}

		}
		
		return matrizTemp;

	}
	
	
	private static double[][] geradorMatriz_1(double[][] matrizTemp){
		
		for (int i = 0; i < matrizTemp.length; i++) {

			matrizTemp[i][i] = 1;

		}
		
		return matrizTemp;
		
	}

}
