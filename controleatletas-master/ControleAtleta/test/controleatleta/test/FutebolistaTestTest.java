
package controleatleta.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import controleatleta.ControleFutebolista;
import controleatleta.Futebolista;


public class FutebolistaTestTest {
    
    private ControleFutebolista controle;
    private Futebolista jogador;
    
    public FutebolistaTestTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        this.controle = new ControleFutebolista();
        this.jogador = new Futebolista("Joel");
        controle.adicionar(jogador);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddFutebolista() {
        for(Futebolista nome : controle.getListaFutebolista()){
            assertEquals(jogador, nome);
        }
    }
    
    @Test
    public void testRemoveFutebolista(){
        controle.remover(jogador);
        for(Futebolista nome : controle.getListaFutebolista()){
            assertEquals(null, nome);
        }
    }
    
    @Test
    public void pesquisaFutebolistaEspecifico(){
        assertEquals(jogador, controle.pesquisar("Joel"));
    }
    
    @Test
    public void pesquisarFutebolistaInexistente(){
        assertEquals(null, controle.pesquisar("Alguem"));
    }
}
