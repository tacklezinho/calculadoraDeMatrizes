package app;



import model.GerarMatrizInversa;
import util.InputMatriz;
import util.PrintMatriz;




public class App {







	public static void main(String[] args) {




		//		double[][] matriz = {
		//				{1, 2, 4},
		//				{6, 9, 0},
		//				{0, 2, 4}
		//		123
		//		345
		//		678
		//		};

		double[][] matriz = InputMatriz.inputMatriz();


		//		GerarMatrizInversa.gerarMatrizInversa(matriz);
		if (GerarMatrizInversa.gerarMatrizInversa(matriz)) {
			PrintMatriz.printMatriz(matriz);
			PrintMatriz.printMatriz(GerarMatrizInversa.matrizIdentidade);
		} 
		else {
			System.out.println("\n O determinante desta matriz será zero, então a matriz é não invertível");
		}


	}

}
