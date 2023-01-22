package br.com.alura.tdd;

import org.junit.Assert;
import org.junit.jupiter.api.Test;





public class CalculadoraTest {

    @Test
    public void DeveriaSomarDoisNumerosPositivos() {
        Calculadora calc = new Calculadora();
        int soma = calc.somar(3, 7);
        System.out.println("Resultado da soma : " + soma);
        Assert.assertEquals(10, soma);
        System.out.println("Resultado ");
    }
}
