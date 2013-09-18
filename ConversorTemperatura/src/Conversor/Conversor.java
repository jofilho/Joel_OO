package Conversor;

public class Conversor {
	
	int celsiusParaFahrenheit(){
		return 9 * 40 / 5 + 32;
	}
	int celsiusParaFahrenheit(int valorCelsius){
		return 9 * valorCelsius / 5 + 32;
	}
	double celsiusParaFahrenheit(double valorCelsius){
		return 9.0 * valorCelsius / 5.0 + 32.0;
	}
	double fahrenheitParaCelsius(double valorFahrenheit){
		return 5.0 * ( valorFahrenheit - 32.0 ) / 9.0;
	}
	double celsiusParaKelvin(double valorCelsius){
		return valorCelsius + 273.0;
	}
	double kelvinParaCelsius(double valorKelvin){
		return valorKelvin - 273.0;
	}
	double fahrenheitParaKelvin(double valorFahrenheit){
		return 5.0 * valorFahrenheit + 2297.0 / 9.0;
	}
	double kelvinParaFahrenheit(double valorKelvin){
		return 9.0 * valorKelvin - 2297.0 / 5.0;
	}

}
