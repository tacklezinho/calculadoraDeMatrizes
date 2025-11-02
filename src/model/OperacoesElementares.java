package model;

public class OperacoesElementares {

	// Troca de posições
	//    
	public static void permutar(double[][] matriz, int linha1, int linha2) {
		// Criando uma matriz temporária para não alterar a original
		double[][] matrizTemp = new double[matriz.length][];
		for (int i = 0; i < matriz.length; i++) {
			// Cria uma nova instância de array para cada linha
			matrizTemp[i] = matriz[i].clone();
		}
		matriz[linha1] = matrizTemp[linha2];
		matriz[linha2] = matrizTemp[linha1];
	}

	//Multiplicar todos os elementos de uma linha por um número real
	//    
	public static void multiplicar(double[][] matriz, int numLinha, double NumMultiplicador) {
		for (int i = 0; i < matriz[numLinha].length; i++) {
			matriz[numLinha][i] = matriz[numLinha][i]*NumMultiplicador;
		}
	}

	// Multiplicar uma linha por um número real e adicioná-los em outra linha de sua escolha
	//    
	public static void multAdd(double[][] matriz, int numLinha1, double numMultiplicador, int numLinha2) {
		double[][] matrizTemp = new double[matriz.length][];
		for (int i = 0; i < matriz.length; i++) {
			matrizTemp[i] = matriz[i].clone(); 
		}

		for (int i = 0; i < matrizTemp[numLinha1].length; i++) {
			matrizTemp[numLinha1][i] *= numMultiplicador;
		}

		for (int i = 0; i < matrizTemp[numLinha2].length; i++) {
			double valorLinhaElemento = matrizTemp[numLinha1][i];
			matriz[numLinha2][i] += valorLinhaElemento;
		}

	}

}
