package controleatleta;

public class Premiacao {

    private String titulosColetivos;// campionatos, copas ...
    private String titulosIndividuais;// chuteira de ouro, bola de ouro ...
    private int ano;

    public Premiacao(String titulo, int ano) {
        this.titulosColetivos = titulo;
        this.ano = ano;
    }

    public String getTitulosColetivos() {
        return titulosColetivos;
    }

    public void setTitulosColetivos(String titulosColetivos) {
        this.titulosColetivos = titulosColetivos;
    }
    
    public String getTitulosIndividuais(){
        return titulosIndividuais;
    }
    
    public void setTitulosIndividuais(String titulosIndividuais){
        this.titulosIndividuais = titulosIndividuais;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    @Override
    public String toString() {
        return this.ano + " - " + this.titulosColetivos;
    }
}
