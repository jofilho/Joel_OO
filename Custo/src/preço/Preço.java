package preço;
import java.util.Scanner;
public class Preço {
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		float preco;
		System.out.println("Quanto custa algo em uma loja de 1.99?");
		preco = entrada.nextFloat();
		System.out.printf("Hã: "+preco+" reais ?\n");
	}
	

}
