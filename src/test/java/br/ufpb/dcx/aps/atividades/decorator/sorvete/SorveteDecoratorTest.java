package br.ufpb.dcx.aps.atividades.decorator.sorvete;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SorveteDecoratorTest {


    @Test
    void testSorveteBasico() {

        ElementoSorvete sorvete = new Casquinha();

        assertEquals(0.5, sorvete.getPreco());

        ElementoSorvete sorveteComBola = new BolaSorvete("chocolate", new Casquinha());

        assertEquals(1.0,sorveteComBola.getPreco());
        assertEquals("chocolate, casquinha",sorveteComBola.getSabor());

        ElementoSorvete sorveteDuplo = new BolaSorvete("chocolate", new BolaSorvete("creme", new Casquinha()));

        assertEquals(1.5, sorveteDuplo.getPreco());
        assertEquals("chocolate, creme, casquinha", sorveteDuplo.getSabor());

        ElementoSorvete sorveteCopinho = new BolaSorvete("chocolate", new Copinho());
        assertEquals(1.0, sorveteCopinho.getPreco());
        assertEquals("chocolate, ",sorveteCopinho.getSabor());

        ElementoSorvete sorveteCalda = new Calda("chocolate", new BolaSorvete("morango", new Casquinha()));

        assertEquals(1.1, sorveteCalda.getPreco());
        assertEquals("calda(chocolate), morango, casquinha",sorveteCalda.getSabor());
    }

    @Test
    void testBananaSplit() {

        ElementoSorvete bananaSplit = new Calda("baunilha", new BolaSorvete("chocolate", new BolaSorvete("morango",new Banana(new Vasilha()))));
        double precoResult = bananaSplit.getPreco();

        //Verifiquem se o assert a seguir vai dar erro. Se sim, arredondem o double.
        assertEquals(1.40,precoResult);
        assertEquals("calda(baunilha), chocolate, morango, banana, ",bananaSplit.getSabor());
    }
}
