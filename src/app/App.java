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
//		};
		
		double[][] matriz = InputMatriz.inputMatriz();
		
		
    
        if (GerarMatrizInversa.gerarMatrizInversa(matriz)) {
	        System.out.println("| =================== |\n|  Matriz Identidade  |\nV =================== V ");
	        System.out.println();
	        PrintMatriz.printMatriz(matriz);
	        System.out.println();
	        System.out.println("| ================== |\n|   Matriz Inversa   |\nV ================== V ");
	        System.out.println();
	        PrintMatriz.printMatriz(GerarMatrizInversa.matrizIdentidade);
	        } else {
	        	System.out.println("\n O determinante desta matriz será zero, então a matriz é não invertível");
	        }
	        
		
	}

}
