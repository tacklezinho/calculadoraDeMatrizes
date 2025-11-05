package model;


public class MatrizIdentidade {


	// Método principal que gera a matriz identidade com base na matriz recebida
	public static double[][] gerarMatrizIdentidade(double[][] matriz){

		// Cria uma matriz de zeros e depois transforma-a em matriz identidade
		double[][] matrizIdentidade =  geradorMatriz_1(geradorMatriz_0(matriz));
		return matrizIdentidade;

	}

	// Gera uma matriz de zeros com o mesmo tamanho da matriz original
	private static double[][] geradorMatriz_0(double[][] matriz){
		
		// Cria uma nova matriz temporária com as mesmas dimensões
		double[][] matrizTemp = new double[matriz.length][matriz[0].length];

		// Percorre todas as posições e atribui zero
		for (int i = 0; i < matriz.length; i++) {

			for (int i2 = 0; i2 < matriz.length; i2++) {

				matrizTemp[i][i2] = 0;

			}

		}
		
		// Retorna a matriz preenchida com zeros
		return matrizTemp;

	}

	// Gera a matriz identidade, definindo 1 na diagonal principal
	private static double[][] geradorMatriz_1(double[][] matrizTemp){
		
		// Percorre as linhas e coloca 1 onde i == j (diagonal principal)
		for (int i = 0; i < matrizTemp.length; i++) {

			matrizTemp[i][i] = 1;

		}
		
		// Retorna a matriz identidade finalizada
		return matrizTemp;
		
	}

}
