package pessoaFisica;

public class PessoaFisica {

	private String sobrenome;
	private String cpf;
	private String cargo;
	
	public PessoaFisica(String cpf){
		this.cpf = cpf;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
