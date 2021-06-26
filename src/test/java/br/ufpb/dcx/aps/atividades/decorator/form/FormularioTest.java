package br.ufpb.dcx.aps.atividades.decorator.form;

import br.ufpb.dcx.aps.atividades.decorator.form.validador.ValidadorEmail;
import br.ufpb.dcx.aps.atividades.decorator.form.validador.ValidadorTextoSimples;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormularioTest {

    @Test
    void testCampoNome() {
        Formulario form = new Formulario("Exemplo Decorator");

        Campo nome = new Campo("nome", "Digite seu Nome:");
        nome.setValidador(new ValidadorTextoSimples(3,100));
        form.addItemFormulario(nome);
        nome.setValor("joao");

        //teste caso simples
        Resultado resNome = nome.validar();
        assertFalse(resNome.isErro());
        assertTrue(resNome.getMensagens().isEmpty());

        //teste limite, sem erro 100 caracteres
        nome.setValor("0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
        resNome = nome.validar();
        assertFalse(resNome.isErro());
        assertTrue(resNome.getMensagens().isEmpty());

        //teste limite, com erro 101 caracteres
        nome.setValor("01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        resNome = nome.validar();
        assertTrue(resNome.isErro());
        assertEquals(1,resNome.getMensagens().size());
        assertEquals("ERRO: tamanho do valor > 100: '01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890'",resNome.getMensagens().get(0));
    }

    @Test
    void testCampoEmail() {

        Formulario form = new Formulario("Exemplo Decorator");

        Campo campoEmail = new Campo("email","Digite seu email:");

        //primeiro vou colocar apenas o validadorEmail no campo, e validar:
        ValidadorEmail vEmail = new ValidadorEmail();

        campoEmail.setValidador(vEmail);  // <-------- Preste atenção

        campoEmail.setValor("algumEmail@comArroba.com");
        Resultado resultado = campoEmail.validar();
        System.out.println(resultado.getMensagens());
        assertFalse(resultado.isErro()); // como o string do valor é um email, não deve dar erro.

        // (TESTE X) agora vou colocar um valor de email com tamanho de 51 caracteres:
        campoEmail.setValor("01234567890@01234567890012345678900123456789001234567890.com");
        resultado = campoEmail.validar();
        assertFalse(resultado.isErro()); // como não temos nenhuma regra que limite o tamanho do campo, o resultado não deve dar erro

        //agora, vamos acrescentar o validador de texto, no validador de email:
        //Imaginando um email com estrutura mínima, por exemplo: "a@b.c", vou definir o menor
        // tamanho de um email com 5 caracteres, e, para o teste, o maior como 50 caracteres:
        ValidadorTextoSimples vTexto = new ValidadorTextoSimples(5,50);

        // coloquei o validador do email "dentro" do validador de texto
        // Observe que o validador de Texto está "decorando" o validador de email
        // agora o validador primeiro vai validar o texto e em seguida o email:
        vTexto.setDecorated(vEmail);

        campoEmail.setValidador(vTexto); // <-------- Preste atenção: -> [vTexto -> [vEmail]]

        campoEmail.setValor("a@b.c");
        resultado = campoEmail.validar();
        assertFalse(resultado.isErro());

        campoEmail.setValor("a@b."); // tamanho: 4, deve dar erro
        resultado = campoEmail.validar();
        assertTrue(resultado.isErro());
        assertEquals("ERRO: tamanho do valor < 5: 'a@b.'",resultado.getMensagens().get(0));

        // agora vamos repetir o mesmo teste que fizemos lá na linha 58 (TESTE X)
        // Naquele momento, o validador era composto apenas pela validação do email.
        // agora o validador do campo é composto pela validação do email E pela validação do texto.
        // A validação a seguir deve dar um resultado com erro.
        campoEmail.setValor("01234567890@01234567890123456789012345678901234567890.com");
        resultado = campoEmail.validar();
        assertTrue(resultado.isErro());
        assertEquals("ERRO: tamanho do valor > 50: '01234567890@01234567890123456789012345678901234567890.com'",resultado.getMensagens().get(0));


    }
}
