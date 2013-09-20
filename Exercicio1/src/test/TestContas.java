package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exercicio1.Exercicio1Contas;

public class TestContas {
	private Exercicio1Contas contas;
	
	@Before
	public void setUp() throws Exception{
		contas = new Exercicio1Contas();
	}
	

	@Test
	public void testCalculaQuadradoZero() {
		assertEquals(0.0,contas.calculaQuadrado(0.0));
		
	}
	@Test
	public void testCalculaCuboZero(){
		assertEquals(0.0,contas.calculaCubo(0.0));
	}
	@Test
	public void testCalculaQuadradoPositivoPequeno(){
		assertEquals(4.0,contas.calculaQuadrado(2.0));
	}
	@Test
	public void testCalculaCuboPositivoPequeno(){
		assertEquals(8.0,contas.calculaCubo(2.0));
	}
	@Test
	public void testCalculaQuadradoNegativoPequeno(){
		assertEquals(9.0,contas.calculaQuadrado(-3.0));
	}
	@Test
	public void testCalculaCuboNegativoPequeno(){
		assertEquals(-27.0,contas.calculaCubo(-3.0));
	}
	@Test
	public void testCalculaQuadradoPositivoGrande(){
		assertEquals(1000000.0,contas.calculaQuadrado(1000.0));
	}
	@Test
	public void testCalculaCuboPositivoGrande(){
		assertEquals(1000000000.0,contas.calculaCubo(1000.0));
	}
	@Test
	public void testCalculaQuadradoNegativoGrande(){
		assertEquals(4000000.0,contas.calculaQuadrado(-2000.0));
	}
	@Test
	public void testCalculaCuboNegativoGrande(){
		assertEquals(-8000000000.0,contas.calculaCubo(-2000.0));
	}
}
