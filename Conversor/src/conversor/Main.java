package conversor;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		InputStreamReader leitorEntrada = new InputStreamReader(System.in);
		BufferedReader leitor = new BufferedReader(leitorEntrada);
		
		System.out.println("Digite qual conversão deseja:");
		System.out.println("1-Celsius para Fahrenheit");
		System.out.println("2-Fahrenheit para Celsius");
		System.out.println("3-Celsius para Kelvin");
		System.out.println("4-Kelvin para Celsius");
		System.out.println("5-Fahrenheit para Kelvin");
		System.out.println("6-Kelvin para Fahrenheit");
		
		int opcaoLida = Integer.parseInt(leitor.readLine());
		System.out.println("Digite o valor que deseja converter:");
		double valorDigitado = Integer.parseInt(leitor.readLine());
		
		Conversor meuConversor = new Conversor();
		double resultadoConversao = 0;
		
		if(opcaoLida == 1){
			resultadoConversao = meuConversor.celsiusParaFahrenheit(valorDigitado);
		}
		else if(opcaoLida == 2){
			resultadoConversao = meuConversor.fahrenheitParaCelsius(valorDigitado);			
		}
		else if(opcaoLida == 3){
			resultadoConversao = meuConversor.celsiusParaKelvin(valorDigitado);
		}
		else if(opcaoLida == 4){
			resultadoConversao = meuConversor.kelvinParaCelsius(valorDigitado);
		}
		else if(opcaoLida == 5){
			resultadoConversao = meuConversor.fahrenheitParaKelvin(valorDigitado);
		}
		else if(opcaoLida == 6){
			resultadoConversao = meuConversor.kelvinParaFahrenheit(valorDigitado);
		}
		else{
			System.out.println("Opção digitada errada! Por favor, digite novamente");
		}
	   
		System.out.println("Resultado da conversão = "+resultadoConversao);
	}
}

