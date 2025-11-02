package model;

public class VerificadorDeterminante {
	
	private static double calcDeterminante(double[][] matriz) {
		
		
		
		
		double det = 0;
		// Matriz 2x2
		if (matriz.length == 2) {
			det = matriz[0][0]*matriz[1][1] - matriz[1][0]*matriz[0][1];
			if (det != 0)
				return det;	
		}
		
		
		//Matriz NxN
		for (int i = 0; i < matriz.length; i++) {
            double[][] submatriz = criarSubmatriz(matriz, 0, i);
            det += Math.pow(-1, i) * matriz[0][i] * calcDeterminante(submatriz);
        }
		return det;	
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
	

	public static boolean isInversivel(double[][] matriz) {
		if (calcDeterminante(matriz) != 0)
			return true;
		return false;
	}
	

}
