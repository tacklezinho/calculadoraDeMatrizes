package app;

import model.GerarMatrizInversa;
import util.PrintMatriz;

public class App {

	public static void main(String[] args) {
		
		
		double[][] matriz = {
		{0, 1, 3},
		{1, 2, 2},
		{6, 2, 10}
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
