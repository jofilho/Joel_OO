package conversor;

public class Conversor {
	
	public double celsiusParaFahreinheit(double valorCelsius){
		return 9.0 *valorCelsius/(5.0 + 32.0);
	}
	public double fahreinheitParaCelsius(double valorFahreinheit){
		return 5.0 * (valorFahreinheit - 32.0)/ 9.0;
	}
	

		
	int teste(double valorCelsius , double valorFahrenheit){
		Conversor c4 = new Conversor();
			
		if(c4.celsiusParaFahreinheit(valorCelsius) != valorFahrenheit)
			System.out.println("Não funciona para o valore: "+valorCelsius);
		if(c4.fahreinheitParaCelsius(valorFahrenheit) != valorCelsius)
			System.out.println("Não funciona para o valor: "+valorFahrenheit);
		return 0;
	}
	int testaTudo(){
		double valorCelsius = 10.0;
		double valorFahrenheit = 50.0;
		teste(valorCelsius , valorFahrenheit);
		valorCelsius = 20.0;
		valorFahrenheit = 68.0;
		teste(valorCelsius , valorFahrenheit);
		valorCelsius = 101.0;
		valorFahrenheit = 213.8;
		teste(valorCelsius , valorFahrenheit);
		System.out.println("Testes finalizados");
		return 0;
	}

}

