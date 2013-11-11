
public class Exercicio2e3 {

	public static void main(String[] args){
		Exercicio1 poupanca = new Exercicio1();
		try{
			poupanca.deposita(-100);
		}catch (IllegalArgumentException e) {
		    System.out.println("Você tentou depositar um valor inválido");
		}
	}
}
