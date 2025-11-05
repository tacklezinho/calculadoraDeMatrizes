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

		// Gera a matriz identidade com mesmo tamanho da matriz original
		matrizIdentidade = MatrizIdentidade.gerarMatrizIdentidade(matriz);

		// Verifica se a matriz é inversível (determinante ≠ 0)
		if (!VerificadorDeterminante.isInversivel(matriz))
			return false;

		// Executa o processo de inversão (eliminação de Gauss-Jordan)
		operacaoInversaoDeMatriz(matriz, 0);
		return true;
	}

	// Função principal que realiza as operações de inversão da matriz
	private static double[][] operacaoInversaoDeMatriz(double[][] matriz, int passo){

		// Loop para eliminar os elementos abaixo dos pivôs (parte inferior da matriz)
		while (passo != matrizIdentidade.length) {
			System.out.println("passo está valendo "+passo);

			// Verifica se o elemento na diagonal principal (pivô) é 1
			if (matriz[passo][passo] != 1) {

				// Caso não seja 1, verifica se precisa permutar linhas
				if (!verificarColunaAbaixoValida(matriz, passo)) {
					// Se o elemento for zero, procura outra linha para trocar
					if (matriz[passo][passo] == 0) {
						trocaLinhaNumDiferenteDe0(matriz, passo);
					}
					// Após possível troca, gera o pivô
					gerarPivo(matriz, passo);
				}
				// Caso a coluna abaixo esteja válida, apenas gera o pivô
				else {
					gerarPivo(matriz, passo);
				}
			}

			// Zera todos os elementos abaixo do pivô
			zerarColunaAbaixoDoPivo(matriz, passo);

			// Avança para a próxima linha
			passo += 1;
		}

		System.out.println("--------------------------");
		System.out.println("começando processo de baixo pra cima");
		System.out.println("--------------------------");

		// Volta uma linha (último índice da matriz)
		passo -=1;

		// Loop para eliminar os elementos acima dos pivôs (parte superior da matriz)
		while (passo != 0) {
			System.out.println("passo está valendo "+passo);
			// Zera todos os elementos acima do pivô
			zerarColunaAcimaDoPivo(matriz, passo);
			// Retrocede uma linha
			passo -= 1;
		}

		// Retorna a matriz transformada (inversa)
		return matriz;
	}

	// Gera o pivô dividindo a linha pelo valor do pivô atual
	private static boolean gerarPivo (double[][] matriz, int indice) {
		OperacoesElementares.multiplicar(matriz, indice, 1/matriz[indice][indice]);
		return true;
	}

	// Troca a linha atual por outra que possua elemento diferente de zero na coluna do pivô
	private static boolean trocaLinhaNumDiferenteDe0(double[][] matriz, int passo) {

		for (int i = passo + 1; i < matriz.length; i++) {
			if (matriz[i] == null)
				return true;
			if (matriz[i][passo] != 0) {
				// Permuta as linhas (i ↔ passo)
				OperacoesElementares.permutar(matriz, i, passo);
				return true;
			}
		}
		return false;
	}

	// Zera todos os elementos abaixo do pivô (eliminação direta)
	private static boolean zerarColunaAbaixoDoPivo(double[][] matriz, int passo) {
		for (int i = passo + 1; i < matriz.length; i++) {
			if (matriz[i][passo] != 0) {
				// Calcula o multiplicador necessário para zerar o elemento
				double multiplicador = -matriz[i][passo];
				// Aplica operação: linha_i = linha_i + multiplicador * linha_passo
				OperacoesElementares.multAdd(matriz, passo, multiplicador, i); 
			}
		}
		// Retorna verdadeiro, indicando que a coluna foi processada
		return true;
	}

	// Zera todos os elementos acima do pivô (eliminação reversa)
	private static boolean zerarColunaAcimaDoPivo(double[][] matriz, int passo) {

		// Continua enquanto existirem elementos não nulos acima do pivô
		while (!verificarColunaAcimaValida(matriz, passo)) {
			for (int i = passo-1; i >= 0; i--) {
				if (matriz[i][passo] != 0) {
					// Elimina o valor aplicando operação inversa
					OperacoesElementares.multAdd(matriz, passo, -(matriz[i][passo]), i);
				}
			}
		}
		return true;
	}

	// Verifica se todos os elementos abaixo do pivô são zero
	private static boolean verificarColunaAbaixoValida(double[][] matriz, int passo) {
		for (int i = passo + 1; i < matriz.length; i++) {
			if (matriz[i][passo] != 0)
				return false;
		}
		return true;
	}

	// Verifica se todos os elementos acima do pivô são zero
	private static boolean verificarColunaAcimaValida(double[][] matriz, int passo) {
		for (int i = passo-1; i >= 0; i--) {
			if (matriz[i][passo] != 0)
				return false;
		}
		return true;
	} 

}