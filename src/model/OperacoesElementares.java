package model;

public class OperacoesElementares {

	private static double[][] createMatrizTemp(double[][] matriz) {
		
		// Criando uma matriz temporária para não alterar a original
		double[][] matrizTemp = new double[matriz.length][];
		for (int i = 0; i < matriz.length; i++) {
			// Cria uma nova instância de array para cada linha
			matrizTemp[i] = matriz[i].clone(); 
		}
		return matrizTemp;
	}

	// Troca de posições
	//    
	public static void permutar(double[][] matriz, int linha1, int linha2) {
		linha1 += 1;
		linha2 += 1;
		System.out.println("Linha: "+ linha1 +" -> Trocada pela linha: "+ linha2 +"");
		linha1 -= 1;
		linha2 -= 1;
		
		double[][] matrizTemp = createMatrizTemp(matriz);
		
		// Matriz identidade
		double[][] matrizTempID = createMatrizTemp(GerarMatrizInversa.matrizIdentidade);
		
		matriz[linha1] = matrizTemp[linha2];
		matriz[linha2] = matrizTemp[linha1];
		
		// Matriz identidade
		GerarMatrizInversa.matrizIdentidade[linha1] = matrizTempID[linha2];
		GerarMatrizInversa.matrizIdentidade[linha2] = matrizTempID[linha1];
		
	}

	//Multiplicar todos os elementos de uma linha por um número real
	public static void multiplicar(double[][] matriz, int numLinha, double NumMultiplicador) {
		numLinha += 1;
		System.out.println("Linha: "+ numLinha +" -> Multiplicada por "+NumMultiplicador);
		numLinha -= 1;
		for (int i = 0; i < matriz[numLinha].length; i++) {
			matriz[numLinha][i] = matriz[numLinha][i]*NumMultiplicador;
		}
		// Matriz identidade
		for (int i = 0; i < matriz[numLinha].length; i++) {
			GerarMatrizInversa.matrizIdentidade[numLinha][i] = GerarMatrizInversa.matrizIdentidade[numLinha][i]*NumMultiplicador;
		}

	}

	// Multiplicar uma linha por um número real e adicioná-los em outra linha de sua escolha
	//    
	public static void multAdd(double[][] matriz, int numLinha1, double numMultiplicador, int numLinha2) {
		numLinha1 += 1;
		numLinha2 += 1;
		System.out.println("Linha: "+ numLinha1 +" -> Multiplicada por "+numMultiplicador+
				" e somada à linha: "+ numLinha2 +"");
		numLinha1 -= 1;
		numLinha2 -= 1;
		
		double [][] matrizTemp = createMatrizTemp(matriz);
		double[][] matrizTempID = createMatrizTemp(GerarMatrizInversa.matrizIdentidade);
		
		for (int i = 0; i < matrizTemp.length; i++) {
			matrizTemp[numLinha1][i] *= numMultiplicador;
		}

		for (int i = 0; i < matrizTemp.length; i++) {
			double valorLinhaElemento = matrizTemp[numLinha1][i];
			matriz[numLinha2][i] += valorLinhaElemento;
		}
		
		// Matriz identidade
		for (int i = 0; i < matrizTempID.length; i++) {
			matrizTempID[numLinha1][i] *= numMultiplicador;
		}

		for (int i = 0; i < matrizTempID.length; i++) {
			double valorLinhaElemento = matrizTempID[numLinha1][i];
			GerarMatrizInversa.matrizIdentidade[numLinha2][i] += valorLinhaElemento;
		}

	}

}
