package model;

import util.PrintMatriz;

public class GerarMatrizInversa {
	
	
	public static double[][] matrizIdentidade;


	//1. Pivôs Iguais a 1: O primeiro elemento não nulo em cada linha (o pivô) deve ser 1.

	//2. Zeros Abaixo do Pivô: Todos os elementos abaixo de cada pivô devem ser zero.

	//3. Zeros Acima do Pivô: Todos os elementos acima de cada pivô também devem ser zero. (Isto é o que diferencia a forma escalonada reduzida da forma escalonada simples).

	//4. Linhas Nulas por Último: Se houverem linhas compostas inteiramente de zeros, elas devem estar localizadas na parte inferior da matriz.

	public static boolean gerarMatrizInversa(double[][] matriz) {
		
		matrizIdentidade = MatrizIdentidade.gerarMatrizIdentidade(matriz);

		if (!VerificadorDeterminante.isInversivel(matriz))
			return false;
		
		
		// TEORICAMENTE TUDO DENTRO DE UM WHILE TRUE
		
		// verifica se o 1 elemento geral é 1 se n for:
			// verificar se tem n!=0 na primeira pos da coluna se tiver:
				// permuta com a primeira linha
					// se 1 elemento n for 1:
						//operaçao de transformar em pivo (tranforma em 1)
		
		
					
					//LOOP até estar valida
						// verificar se a coluna está valida se n estiver:
							// operaçao para limpar
								// Multiplica o negativo da posicao do item errado e soma a linha do item errado.
						// colunaValida == True:
							// k += 1
					
		
		
		// Ir para proxima COLUNA (j atual)
			// verificar se tem n!=0 na primeira pos da coluna se tiver e linha 0 + k (k sendo o contador de operaçoes completas):
					// se elemento n for 1:
						//operaçao de transformar em pivo (tranforma em 1)
		
		
					
					//LOOP até estar valida
						// verificar se a coluna está valida se n estiver:
							// operaçao para limpar
								// Multiplica o negativo da posicao do item errado e soma a linha do item errado.
						// colunaValida == True:
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		trocaLinhaN1ParaPos1(matriz);
		zerarColunaAbaixoDoPivo(matriz);
		return true;

	}

	private static boolean gerarPivo (double[][] matriz) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] != 0 || matriz[i][j] == 1) {
					OperacoesElementares.multiplicar(matrizIdentidade, i, 1/matriz[i][j]);
					OperacoesElementares.multiplicar(matriz, i, 1/matriz[i][j]);
					return true;
				}
			}
		}
		return false;
	}
	
	
	private static boolean trocaLinhaN1ParaPos1(double[][] matriz) {
		
		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i][0] == 1) {
				OperacoesElementares.permutar(matrizIdentidade, i, 0);
				OperacoesElementares.permutar(matriz, i, 0);
				return true;
			}
		}
		return false;
	}
	
	private static boolean zerarColunaAbaixoDoPivo(double[][] matriz) {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[j][i] != 1) {
					OperacoesElementares.multAdd(matrizIdentidade, j, -matriz[j+1][i+1], j+1);
					OperacoesElementares.multAdd(matriz, j, -matriz[j+1][i+1], j+1);
					return true;
				}
			}
		}
		return false;	
	}
	
	private static boolean verificarColunaValida(double[][] matriz, int i, int j) {
		
		for (int k = 0; k < matriz.length; k++) {
			if (matriz[i+k][j] != 1 && matriz[i+k][j] != 0)
				return false;
		}
		return true;
	}

}
