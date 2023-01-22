package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		
		assertThrows(IllegalArgumentException.class, 
		() -> service.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("10001"))));
		//System.out.println("Resultado do bonus " + bonus);
		
		//assertEquals(BigDecimal.ZERO, bonus);
		
		try {
			service.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("10001")));
			fail("Não deu a exception");
		} catch (Exception e) {
			assertEquals("Funcionario com salario acima de 10.000 não pode ganhar bonificação", e.getMessage());
			//assertEquals("Fauncionario com salario acima de 10.000 não pode ganhar bonificação", e.getMessage());
		}
	}
	
	@Test
	void bonusDeveSerMaiorQueZeroParaFuncionarioComSalarioAte1000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("10000")));
		System.out.println("Resultado do bonus " + bonus);
		assertEquals(new BigDecimal("1000.0"), bonus);
	}

}
