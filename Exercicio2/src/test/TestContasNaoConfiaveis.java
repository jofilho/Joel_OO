package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exercicio2.Exercicio2ContasNaoConfiaveis;

public class TestContasNaoConfiaveis {
	Exercicio2ContasNaoConfiaveis contasNaoConfiavies;
	@Before
	public void setUp() throws Exception{
		contasNaoConfiavies = new Exercicio2ContasNaoConfiaveis();
	}

	@Test
	public void testCalculaQuadradoZero() {
		assertEquals(0.0,contasNaoConfiavies.calculaQuadrado(0.0));
		
	}
	@Test
	public void testCalculaCuboZero(){
		assertEquals(0.0,contasNaoConfiavies.calculaCubo(0.0));
	}
	@Test
	public void testCalculaQuadradoNumeroPequeno(){
		assertEquals(4.0,contasNaoConfiavies.calculaQuadrado(2.0));
	}
	@Test
	public void testCalculaCuboNumeroPequeno(){
		assertEquals(8.0,contasNaoConfiavies.calculaCubo(2.0));
	}
	@Test
	public void testCalculaQuadradoNumeroGrande(){
		assertEquals(1000000.0,contasNaoConfiavies.calculaQuadrado(1000.0));
	}
	@Test
	public void testCalculaCuboNumeroGrande(){
		assertEquals(1000000000.0,contasNaoConfiavies.calculaCubo(1000.0));
	}

}
