package model;

public class VerificadorDeterminante {
	
	// Calcula o determinante de uma matriz de forma recursiva
	private static double calcDeterminante(double[][] matriz) {
		
		double det = 0;
		
		// Caso base: matriz 2x2
		if (matriz.length == 2) {
			// Fórmula do determinante 2x2: ad - bc
			det = matriz[0][0]*matriz[1][1] - matriz[1][0]*matriz[0][1];
			if (det != 0)
				return det;
		}
		
		// Caso geral: matriz NxN (usa expansão de Laplace na primeira linha)
		for (int i = 0; i < matriz.length; i++) {
			// Cria uma submatriz removendo a primeira linha e a coluna i
	        double[][] submatriz = criarSubmatriz(matriz, 0, i);
			// Calcula o cofator e soma ao determinante
	        det += Math.pow(-1, i) * matriz[0][i] * calcDeterminante(submatriz);
	    }

		// Retorna o determinante calculado
		return det;
	}

	// Cria uma submatriz removendo a linha e a coluna especificadas
	private static double[][] criarSubmatriz(double[][] matriz, int linhaRemovida, int colunaRemovida) {
	    int n = matriz.length;
	    double[][] submatriz = new double[n - 1][n - 1];
	    int r = 0;

	    // Percorre as linhas da matriz original
	    for (int i = 0; i < n; i++) {
	        // Ignora a linha que deve ser removida
	        if (i == linhaRemovida) continue;
	        int c = 0;

	        // Percorre as colunas da matriz original
	        for (int j = 0; j < n; j++) {
	            // Ignora a coluna que deve ser removida
	            if (j == colunaRemovida) continue;
				// Copia o elemento para a submatriz
	            submatriz[r][c++] = matriz[i][j];
	        }
			// Avança a linha da submatriz
	        r++;
	    }

	    // Retorna a submatriz gerada
	    return submatriz;
	}

	// Verifica se uma matriz é inversível (determinante ≠ 0)
	public static boolean isInversivel(double[][] matriz) {
		if (calcDeterminante(matriz) != 0)
			return true;
		return false;
	}
	

}
