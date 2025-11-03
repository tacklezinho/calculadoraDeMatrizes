package model;

import util.PrintMatriz;

public class GerarMatrizInversa {


	public static double[][] matrizIdentidade;
	public static double[][] matrizPrincipal;


	//1. Pivôs Iguais a 1: O primeiro elemento não nulo em cada linha (o pivô) deve ser 1.

	//2. Zeros Abaixo do Pivô: Todos os elementos abaixo de cada pivô devem ser zero.

	//3. Zeros Acima do Pivô: Todos os elementos acima de cada pivô também devem ser zero. (Isto é o que diferencia a forma escalonada reduzida da forma escalonada simples).

	//4. Linhas Nulas por Último: Se houverem linhas compostas inteiramente de zeros, elas devem estar localizadas na parte inferior da matriz.

	public static boolean gerarMatrizInversa(double[][] matriz) {

		matrizIdentidade = MatrizIdentidade.gerarMatrizIdentidade(matriz);
		matrizPrincipal = matriz;

		if (!VerificadorDeterminante.isInversivel(matriz))
			return false;



		operacaoInversaoDeMatriz(matriz, 0);







		// verifica se o 1 elemento geral é 1 se n for:
		// verificar se tem n!=0 na primeira pos da coluna se tiver:
		// permuta com a primeira linha
		// se o primeiro elemento n for 1:
		//operaçao de transformar em pivo (tranforma em 1)



		//LOOP até estar valida
		// verificar se a coluna está valida se n estiver:
		// operaçao para limpar
		// Multiplicar a 1° linha pelo inverso do primeiro elemento errado e somar na linha do elemento errado.
		// colunaValida == True:
		// Verifica se contador == matriz.length

		return true;

	}


	private static double[][] operacaoInversaoDeMatriz(double[][] matriz, int passo){

		if(passo != matrizIdentidade.length) {
			if (matriz[0][0] != 1) {
				if (!verificarColunaValida(matriz) || matriz.length == 1) {
					trocaLinhaNumDiferenteDe0ParaPos1(matriz);
					if (matriz[0][0] != 1) {
						gerarPivo(matriz);
					}
				}
			}


			while (!verificarColunaValida(matriz)) {
				for (int i = 1; i < matriz.length; i++) {
					if (matriz[i][0] != 0) {
						OperacoesElementares.multAdd(matrizIdentidade, 0, -matriz[i][0], i);
						OperacoesElementares.multAdd(matriz, 0, -matriz[i][0], i);
					}
				}
			}


			double[][] matrizTemp = operacaoInversaoDeMatriz(criarSubmatriz(matriz, 0, 0), passo + 1);

			if (matrizTemp.length != 1 && matrizTemp.length != 0) {
				int k = matrizTemp.length;
				for (int i = (matriz.length); i >= matrizTemp.length; i--) {
					int x = matrizTemp.length;

					for (int j = (matriz.length); j >= matrizTemp.length; j--) {	

						matrizPrincipal[i-1][j-1] = matrizTemp[k-1][x-1];
						x--;
					}
					k--;

				}
			}
		}
		return matriz;
	}



	private static double[][] criarSubmatriz(double[][] matriz, int linhaRemovida, int colunaRemovida) {

		int n = matriz.length;
		double[][] submatriz = new double[n - 1][n - 1];
		int r = 0;

		for (int i = 0; i < n; i++) {
			if (i == linhaRemovida) continue;
			int c = 0;
			for (int j = 0; j < n; j++) {
				if (j == colunaRemovida) continue;
				submatriz[r][c++] = matriz[i][j];
			}
			r++;
		}
		return submatriz;
	}


	private static boolean gerarPivo (double[][] matriz) {
		OperacoesElementares.multiplicar(matrizIdentidade, 0, 1/matriz[0][0]);
		OperacoesElementares.multiplicar(matriz, 0, 1/matriz[0][0]);
		return true;
	}


	private static boolean trocaLinhaNumDiferenteDe0ParaPos1(double[][] matriz) {

		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i][0] != 0) {
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

	private static boolean verificarColunaValida(double[][] matriz) {

		for (int i = 1; i < matriz.length; i++) {
			if (matriz[i][0] != 0)
				return false;
		}
		return true;
	} 

}
