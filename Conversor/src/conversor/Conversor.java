package conversor;

public class Conversor {

	public double celsiusParaFahrenheit(double valorCelsius){
		return 9.0 * valorCelsius / 5.0 + 32.0;
	}
	public double fahrenheitParaCelsius(double valorFahrenheit){
		return 5.0 * ( valorFahrenheit - 32.0 ) / 9.0;
	}
	public double celsiusParaKelvin(double valorCelsius){
		return valorCelsius + 273.0;
	}
	public double kelvinParaCelsius(double valorKelvin){
		return valorKelvin - 273.0;
	}
	public double fahrenheitParaKelvin(double valorFahrenheit){
		return 5.0 * valorFahrenheit + 2297.0 / 9.0;
	}
	public double kelvinParaFahrenheit(double valorKelvin){
		return 9.0 * valorKelvin - 2297.0 / 5.0;
	}

}
