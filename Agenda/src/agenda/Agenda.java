
package agenda;
import java.util.Vector;
/**
 *
 * @author alunos
 */
public class Agenda {

    private Vector listaContatos; 
    
     public Agenda() {
         listaContatos = new Vector();
     }
     
     public String adicionarContato(Contato novoContato){
         listaContatos.add(novoContato);
         return "Contato Cadastrado com Sucesso";
     }
     }
    
        
    

