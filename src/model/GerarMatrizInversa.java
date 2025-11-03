package model;

//1.    O primeiro elemento não nulo em cada linha (o pivô) deve ser 1,
//   verifique em qual coluna deve começar o pivô e permute para a linha1.
//
//2. Zeros Abaixo do Pivô: Todos os elementos abaixo dos pivôs sejam zero.
//
//3. Avance para linha de baixo e Repita 1º e 2º até que todos os elementos 
//   abaixo dos pivôs sejam zeros.
//
//4. Zeros Acima do Pivô: Todos os elementos acima de cada pivô também devem ser zero,
//   use a última linha com método MultAdd.
//
//5. Avance para a linha de cima e repita o 4º até chegar na Matriz Identidade.

public class GerarMatrizInversa {

	public static double[][] matrizIdentidade;
	
	public static boolean gerarMatrizInversa(double[][] matriz) {

		matrizIdentidade = MatrizIdentidade.gerarMatrizIdentidade(matriz);
		if (!VerificadorDeterminante.isInversivel(matriz))
			return false;
		operacaoInversaoDeMatriz(matriz, 0);
		return true;

	}

	// PRINCIPAL FUNÇÃO
	private static double[][] operacaoInversaoDeMatriz(double[][] matriz, int passo){

		// while faz a limpeza de baixo
		while (passo != matrizIdentidade.length) {
			System.out.println("passo está valendo "+passo);
			// verifica o começo da linha na coluna
			if (matriz[passo][passo] != 1) {
				// se n for valida, então verifica se precisa permutar,
				//  caso ñ permute então geramos pivo
				if (!verificarColunaAbaixoValida(matriz, passo)) {
					if (matriz[passo][passo] == 0) {
						trocaLinhaNumDiferenteDe0(matriz, passo);
					}
					gerarPivo(matriz, passo);
				}
				// se for valida então resta apenas ajeitar o pivo
				else {
					gerarPivo(matriz, passo);
				}
			}
			// Zera todos os elementos abaixo do pivô
			zerarColunaAbaixoDoPivo(matriz, passo);

			// contador de linhas
			passo += 1;
		}
		System.out.println("--------------------------");
		System.out.println("começando processo de baixo pra cima");
		System.out.println("--------------------------");
		passo -=1;

		// while faz a limpeza de cima	
		while (passo != 0) {
			System.out.println("passo está valendo "+passo);
			// Zera todos os elementos acima do pivô
			zerarColunaAcimaDoPivo(matriz, passo);
			// contador de linhas, agora é o inverso,
			passo -= 1;
		}

		// saiu dos whiles, devidamente filtrado
		return matriz;
	}

	private static boolean gerarPivo (double[][] matriz, int indice) {
		OperacoesElementares.multiplicar(matriz, indice, 1/matriz[indice][indice]);
		return true;
	}


	private static boolean trocaLinhaNumDiferenteDe0(double[][] matriz, int passo) {

		for (int i = passo + 1; i < matriz.length; i++) {
			if (matriz[i] == null)
				return true;
			if (matriz[i][passo] != 0) {
				OperacoesElementares.permutar(matriz, i, passo);
				return true;
			}
		}
		return false;
	}
	private static boolean zerarColunaAbaixoDoPivo(double[][] matriz, int passo) {
		for (int i = passo + 1; i < matriz.length; i++) {
			if (matriz[i][passo] != 0) {
				double multiplicador = -matriz[i][passo];
				OperacoesElementares.multAdd(matriz, passo, multiplicador, i); 
			}
		}
		return true; // A limpeza foi tentada (agora o loop percorre a coluna inteira)
	}
	private static boolean zerarColunaAcimaDoPivo(double[][] matriz, int passo) {

		while (!verificarColunaAcimaValida(matriz, passo)) {
			for (int i = passo-1; i >= 0; i--) {
				if (matriz[i][passo] != 0) {
					OperacoesElementares.multAdd(matriz, passo, -(matriz[i][passo]), i);
				}
			}
		}
		return true;
	}

	private static boolean verificarColunaAbaixoValida(double[][] matriz, int passo) {
		for (int i = passo + 1; i < matriz.length; i++) {
			if (matriz[i][passo] != 0)
				return false;

		}
		return true;
	}

	private static boolean verificarColunaAcimaValida(double[][] matriz, int passo) {
		for (int i = passo-1; i >= 0; i--) {
			if (matriz[i][passo] != 0)
				return false;

		}
		return true;
	} 

}