package util;

public class PrintMatriz {
	
	
	public static void printMatriz(double[][] matrizTemp) {
		for (int i = 0; i < matrizTemp.length; i++) {
			for (int j = 0; j < matrizTemp[0].length; j++) {
				System.out.print(DecimalParaFracao.transformarEmFracao(matrizTemp[i][j]) + " ");
				
			}
			System.out.println();
		}
	}
}
