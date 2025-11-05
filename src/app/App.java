package app;

import model.GerarMatrizInversa;
import util.DecimalParaFracao;
import util.PrintMatriz;

public class App {

	public static void main(String[] args) {
		
		
		double[][] matriz = {
		{0, 10, 0},
		{1, 8, 6},
		{2, 1, 0}
};
		
		
	
		
		PrintMatriz.printMatriz(matriz);
		System.out.println("----------");
		
		
		System.out.println(GerarMatrizInversa.gerarMatrizInversa(matriz));
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
