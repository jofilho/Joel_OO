public class Pessoa {
	private String nome;
	private String sobrenome;
	private String telefone;
	private String email;
	private String instantMsg;
	private String empresa;
	private String cargo;
	private String aniversario;
	private String site;
	private String grupo;
	private Object foto;
	
	public Pessoa() {
		this.nome = "-";
	}

	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public Pessoa(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstantMsg() {
		return instantMsg;
	}

	public void setInstantMsg(String instantMsg) {
		this.instantMsg = instantMsg;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getAniversario() {
		return aniversario;
	}

	public void setAniversario(String aniversario) {
		this.aniversario = aniversario;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Object getFoto() {
		return foto;
	}

	public void setFoto(Object foto) {
		this.foto = foto;
	}

}
