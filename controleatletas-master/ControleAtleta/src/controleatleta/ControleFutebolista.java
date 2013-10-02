package controleatleta;

import java.util.ArrayList;

public class ControleFutebolista {

    private ArrayList<Futebolista> listaFutebolista;

    public ControleFutebolista() {
        this.listaFutebolista = new ArrayList<Futebolista>();
    }
    
    public ArrayList<Futebolista> getListaFutebolista() {
        return listaFutebolista;
    }
    
    public void adicionar(Futebolista umFutebolista) {
        listaFutebolista.add(umFutebolista);
    }
    
    public void remover(Futebolista umFutebolista) {
        listaFutebolista.remove(umFutebolista);
    }
    
    public Futebolista pesquisar(String nome) {
        for (Futebolista umNome: listaFutebolista) {
            if (umNome.getNome().equalsIgnoreCase(nome)) return umNome;
        }
        return null;
    }
}
