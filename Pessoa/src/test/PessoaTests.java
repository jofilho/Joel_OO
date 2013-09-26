package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pessoa.Pessoa;

public class PessoaTests {
	
	private Pessoa pessoa;
	
	@Before
	public void setUp() throws Exception{
		pessoa = new Pessoa();
	}

	@Test
	public void testNome(String Ana) {
		assertEquals(Ana,pessoa.setNome(Ana));
	}

}
