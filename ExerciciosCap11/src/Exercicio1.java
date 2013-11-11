
public class Exercicio1 {

	private double saldo;
	
	public Exercicio1(){
		this.saldo = 0.0;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void deposita(double valor) {
		 if (valor < 0) {
		    throw new IllegalArgumentException();
		 }else {
		    this.saldo += valor;    
		 }    
	}

}
