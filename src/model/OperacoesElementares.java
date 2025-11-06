package model;

import util.DecimalParaFracao;
import util.PrintMatriz;

public class OperacoesElementares {

	// Cria uma cópia temporária da matriz para evitar modificar a original diretamente
	private static double[][] createMatrizTemp(double[][] matriz) {
		
		// Criando uma nova matriz temporária com o mesmo tamanho
		double[][] matrizTemp = new double[matriz.length][];
		for (int i = 0; i < matriz.length; i++) {
			// Clona cada linha da matriz original
			matrizTemp[i] = matriz[i].clone(); 
		}
		return matrizTemp;
	}

	// Troca (permuta) as posições de duas linhas da matriz
	public static void permutar(double[][] matriz, int linha1, int linha2) {
		// Exibe no console quais linhas estão sendo trocadas (com contagem iniciando em 1 para exibição)
		PrintMatriz.passoApassoPermuta(matriz, linha1, linha2);
		
		// Cria cópias temporárias da matriz principal e da matriz identidade
		double[][] matrizTemp = createMatrizTemp(matriz);
		double[][] matrizTempID = createMatrizTemp(GerarMatrizInversa.matrizIdentidade);
		
		// Troca as linhas selecionadas na matriz principal
		matriz[linha1] = matrizTemp[linha2];
		matriz[linha2] = matrizTemp[linha1];
		
		// Troca também as linhas equivalentes na matriz identidade
		GerarMatrizInversa.matrizIdentidade[linha1] = matrizTempID[linha2];
		GerarMatrizInversa.matrizIdentidade[linha2] = matrizTempID[linha1];
	}

	// Multiplica todos os elementos de uma linha por um número real
	public static void multiplicar(double[][] matriz, int numLinha, double NumMultiplicador) {
		// Mostra no console a operação realizada
		PrintMatriz.passoApassoMult(matriz, numLinha, NumMultiplicador);

		// Multiplica todos os elementos da linha na matriz principal
		for (int i = 0; i < matriz[numLinha].length; i++) {
			matriz[numLinha][i] = matriz[numLinha][i] * NumMultiplicador;
		}

		// Multiplica também os elementos equivalentes na matriz identidade
		for (int i = 0; i < matriz[numLinha].length; i++) {
			GerarMatrizInversa.matrizIdentidade[numLinha][i] =
					GerarMatrizInversa.matrizIdentidade[numLinha][i] * NumMultiplicador;
		}
	}

	// Multiplica uma linha por um número real e adiciona o resultado a outra linha (numLinha2)
	public static void multAdd(double[][] matriz, int numLinha1, double numMultiplicador, int numLinha2) {
		// Exibe no console o processo de multiplicação e soma
		PrintMatriz.passoApassoMultAdd(matriz, numLinha1, numMultiplicador, numLinha2);
		
		// Cria cópias temporárias da matriz principal e da identidade
		double [][] matrizTemp = createMatrizTemp(matriz);
		double[][] matrizTempID = createMatrizTemp(GerarMatrizInversa.matrizIdentidade);
		
		// Multiplica a linha1 pelo número multiplicador
		for (int i = 0; i < matrizTemp.length; i++) {
			matrizTemp[numLinha1][i] *= numMultiplicador;
		}

		// Soma os valores resultantes à linha2 da matriz principal
		for (int i = 0; i < matrizTemp.length; i++) {
			double valorLinhaElemento = matrizTemp[numLinha1][i];
			matriz[numLinha2][i] += valorLinhaElemento;
		}
		
		// Repete o mesmo processo na matriz identidade
		for (int i = 0; i < matrizTempID.length; i++) {
			matrizTempID[numLinha1][i] *= numMultiplicador;
		}

		for (int i = 0; i < matrizTempID.length; i++) {
			double valorLinhaElemento = matrizTempID[numLinha1][i];
			GerarMatrizInversa.matrizIdentidade[numLinha2][i] += valorLinhaElemento;
		}
	}

}