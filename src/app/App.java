package app;

import model.GerarMatrizInversa;
import util.PrintMatriz;

public class App {

	public static void main(String[] args) {
		
		
		double[][] matriz = {
		{2, 4, 5, 6},
		{3, 0, 7, 0},
		{2, 1, 0, 0},
		{0, 1, 6, 5}
};
		PrintMatriz.printMatriz(matriz);
		System.out.println("----------");
		
		
		GerarMatrizInversa.gerarMatrizInversa(matriz);
		PrintMatriz.printMatriz(matriz);
		System.out.println("----------");
		PrintMatriz.printMatriz(GerarMatrizInversa.matrizIdentidade);
		
		
//		if (matriz[0].length != matriz.length)
//			System.out.println("Não é quadrada");
		
//		PrintMatriz.printMatriz(MatrizIdentidade.gerarMatrizIdentidade(matriz));
		
		
		
//		System.out.println(VerificadorDeterminante.isInversa(matriz));
		

		
		
//		PrintMatriz.printMatriz(MatrizIdentidade.gerarMatrizIdentidade(matriz2));
	
		
//		System.out.println(VerificadorDeterminante.isInversa(matriz2));
		
		
	}

}
