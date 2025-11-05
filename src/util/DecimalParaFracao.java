package util;

public class DecimalParaFracao {



	//	 recebe um numero decimal e retorna uma fração
	public static String transformarEmFracao(double numeroDecimal) {
		boolean negativo = numeroDecimal < 0; // verifica se o numero é negativo
		double valor = Math.abs(numeroDecimal); // pega o valor absoluto do numero, lida com o sinal depois

		
		//		o quão proximo do valor original vai ser, nesse caso: 0.000001
		double precisao = 1e-6; 
		//	    define o denominador maximo que vai ser testado
		long limite = 1000;     

		//	    armazenam a melhor fração encontrada no momento
		double melhorErro = Double.MAX_VALUE;
		long melhorNumerador = 0;
		long melhorDenominador = 1;

		//	    percorre os denominadores de 1 ate 1000
		for (long d = 1; d <= limite; d++) {
			long n = Math.round(valor * d); // calcula o numerador aproximado para o denominador 
			double erro = Math.abs(valor - (double) n / d);
			//	        mede a diferença entre o número decimal original e a fração, Se o erro for menor que o erro atual,
			//	        atualiza as variaveis melhorNumerador e melhorDenominador
			if (erro < melhorErro) {
				melhorErro = erro;
				melhorNumerador = n;
				melhorDenominador = d;
				if (erro < precisao) break; // se o erro ficar menor que a precisão, o laço é interrompido
			}
		}

		// se o sinal original era negativo, aplica o sinal negativo ao numerador
		if (negativo) melhorNumerador = -melhorNumerador; 

		//	    depois de encontrar a melhor fração, chama outro método para simplificá-la
		return simplificarFracao(melhorNumerador, melhorDenominador);
	}

	private static String simplificarFracao(long numerador, long denominador) {
		//   	verifica se o denominador é zero
		if (denominador == 0) {
			System.out.println("Erro: Denominador zero");
			return "";
		}

		//   	calcula o MDC (máximo divisor comum) entre numerador e denominador
		long mdc = calcularMDC(Math.abs(numerador), Math.abs(denominador));
		//   	divide ambos pelo MDC para simplificar a fração
		numerador /= mdc;
		denominador /= mdc;

		//   	ajusta o sinal se o denominador for negativo
		if (denominador < 0) {
			numerador = -numerador;
			denominador = -denominador;
		}

		//   	se o denominador for 1, retorna apenas o numerador (número inteiro)
		if (denominador == 1) {
			return String.valueOf(numerador);
		}

		//   	caso contrário, retorna a fração no formato "numerador/denominador"
		return numerador + "/" + denominador;
	}

	//  	calcula o Máximo Divisor Comum usando o algoritmo de Euclides (é usado para simplificar frações)
	private static long calcularMDC(long a, long b) {
		while (b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}


