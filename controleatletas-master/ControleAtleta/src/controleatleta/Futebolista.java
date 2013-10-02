package controleatleta;

import java.util.ArrayList;


public class Futebolista extends Atleta {

    private char categorias; // A = amador P = profissional
    private char pernaBoa; // D = destro C = canhoto
    private ArrayList<Premiacao> premiacoes;
    private String posicao; 
    private String timeAtual;
    private String timesAnteriores;
    private String qualidades;//habilidoso, rápido, marcador, artilheiro ...
    private int golsPro;
    private int golsContra;
    private int numeroCamisa;// camisa 10, 1, 8 ...

    public Futebolista(String nome) {
        super(nome);
    }

    public char getCategorias() {
        return categorias;
    }

    public void setCategorias(char categorias) {
        this.categorias = categorias;
    }

    public int getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(int golsContra) {
        this.golsContra = golsContra;
    }

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public int getGolsPro() {
        return golsPro;
    }

    public void setGolsPro(int golsPro) {
        this.golsPro = golsPro;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public char getPernaBoa() {
        return pernaBoa;
    }

    public void setPernaBoa(char pernaBoa) {
        this.pernaBoa = pernaBoa;
    }

    public String getTimeAtual() {
        return timeAtual;
    }

    public void setTimeAtual(String timeAtual) {
        this.timeAtual = timeAtual;
    }

    public ArrayList<Premiacao> getPremiacoes() {
        return premiacoes;
    }

    public void setPremiacoes(ArrayList<Premiacao> premiacoes) {
        this.premiacoes = premiacoes;
    }

    public String getTimesAnteriores() {
        return timesAnteriores;
    }

    public void setTimesAnteriores(String timesAnteriores) {
        this.timesAnteriores = timesAnteriores;
    }

    public String getQualidades() {
        return qualidades;
    }

    public void setQualidades(String qualidades) {
        this.qualidades = qualidades;
    }

    public String obterCategoriasIdade() {
        return obterCategoriasIdade(this.getCategorias(), this.getIdade());
    }
    public static String obterCategoriasIdade(char categorias, int idade) {
        if (categorias == 'A'){
            return obterCategoriasIdadeAmador(idade);
        }
        else if(categorias == 'P'){
            return obterCategoriasIdadeProfissional(idade);
        }else{
            return "";
        }
    }
    private static String obterCategoriasIdadeAmador(int idade) {
        if(idade < 16){
            return "Escolinha";
        }
        else{
            return "Peladeiro";
        }
    }
    private static String obterCategoriasIdadeProfissional(int idade){
        if(idade <= 9) {
            return "Fraldinha";
        }
        else if (idade <= 11) {
            return "Dente de Leite";
        }
        else if (idade <= 12) {
            return "Pré-Mirim";
        }
        else if (idade <= 13) {
            return "Mirim";
        }
        else if (idade <= 15) {
            return "Infantil";
        }
        else if (idade <= 16) {
            return "Infanto-Juvenil";
        }
        else if (idade <= 18) {
            return "Juvenil";
        }
        else if (idade <= 20) {
            return "Júnior";
        }
        else{
            return "Profissional";
        }
    }
    
}