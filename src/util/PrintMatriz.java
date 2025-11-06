package util;

import model.GerarMatrizInversa;

public class PrintMatriz {
	
	
	public static void printMatriz(double[][] matrizTemp) {
//		System.out.println("| ======== |\n|  Matriz  |\nV ======== V ");
//		System.out.println("______________________\n");
		String matrizTexto = "";
		for (int i = 0; i < matrizTemp.length; i++) {
			matrizTexto += "";
			for (int j = 0; j < matrizTemp[0].length; j++) {
				matrizTexto += DecimalParaFracao.transformarEmFracao(matrizTemp[i][j]);
				if (j == matrizTemp.length-1) {
					matrizTexto += "";
				}
				else {
					matrizTexto += "\t";
				}

			}
			if (!(i == matrizTemp.length-1)) {
				matrizTexto += "\n";
			}
			
		}
		System.out.println(matrizTexto);
		System.out.println();
	}

	public static void passoApassoMult(double[][] matriz, int numLinha1, double numMultiplicador) {
		PrintMatriz.printMatriz(matriz);
		PrintMatriz.printMatriz(GerarMatrizInversa.matrizIdentidade);
		numLinha1 += 1;
		System.out.println("-> Linha "+ numLinha1 +" será Multiplicada por "+DecimalParaFracao.transformarEmFracao(numMultiplicador));
		numLinha1 -= 1;
		System.out.println();
	}

	public static void passoApassoMultAdd(double[][] matriz, int numLinha1, double numMultiplicador, int numLinha2) {
		PrintMatriz.printMatriz(matriz);
		PrintMatriz.printMatriz(GerarMatrizInversa.matrizIdentidade);
		numLinha1 += 1;
		numLinha2 += 1;
		System.out.println("-> Linha "+ numLinha1 +" será Multiplicada por "+ DecimalParaFracao.transformarEmFracao(numMultiplicador)+
				" e somada à linha: "+ numLinha2 +"");
		numLinha1 -= 1;
		numLinha2 -= 1;
		System.out.println();


	}
	public static void passoApassoPermuta(double[][]matriz, int linha1, int linha2) {
		PrintMatriz.printMatriz(matriz);
		PrintMatriz.printMatriz(GerarMatrizInversa.matrizIdentidade);
		linha1 += 1;
		linha2 += 1;
		System.out.println("Linha: "+ linha1 +" -> será Trocada pela linha: "+ linha2 +"");
		linha1 -= 1;
		linha2 -= 1;
		System.out.println();


	}
}
