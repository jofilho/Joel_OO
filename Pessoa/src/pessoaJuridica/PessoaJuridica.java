package pessoaJuridica;

public class PessoaJuridica {
	
	private String cnpj;
	private String razaoSocial;
	
	public PessoaJuridica(String cnpj){
		this.cnpj = cnpj;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

}
