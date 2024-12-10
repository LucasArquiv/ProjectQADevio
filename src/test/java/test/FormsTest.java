package test;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.FormsPages;
import pages.InicioPage;
import support.Utils;

public class FormsTest extends BaseTest {

    InicioPage inicioPage = new InicioPage();
    FormsPages forms = new FormsPages();

    String nome = Utils.getNomeAleatorio();
    String sobreNome = Utils.getSobreNomeAleatorio();

    @Test
    public void testSemPreencher() {

        inicioPage.entrar();
        forms.cadastrar();

        inicioPage.acessoTelaAdministrador();

        //verificando campo na tabela de clientes vazio:
        Assert.assertEquals(0, inicioPage.verificarCampoVazio());

    }

    @Test
    public void testFormularioPereechido() {

        inicioPage.entrar();

        //prestador ativo por padrão

        forms.setNome(nome + sobreNome);
        forms.setEmail();
        forms.setCPF();
        forms.setTelefone("(11) 94802-9822");
        forms.setCEP();
        forms.setRua("Rua Nogueira");
        forms.setNumero();
        forms.setComplemento("estádio Allianz Parque");
        forms.setBairro("Santa agustina");
        forms.setCidade("São Paulo");
        forms.setEstado("Acre");

        forms.cadastrar();

        Assert.assertEquals(nome + sobreNome, inicioPage.verificarClienteXpath(nome + sobreNome));

    }

    @Test
    public void testFormularioPereechidoInativo() {

        inicioPage.entrar();

        //prestador ativo por padrão
        forms.prestadorInativo();

        forms.setNome(nome + sobreNome);
        forms.setEmail();
        forms.setCPF();
        forms.setTelefone("(11) 92578-4525");
        forms.setCEP();
        forms.setRua("Rua Nogueira");
        forms.setNumero();
        forms.setComplemento("estádio Allianz Parque");
        forms.setBairro("Santa agustina");
        forms.setCidade("São Paulo");
        forms.setEstado("Acre");

        forms.cadastrar();

        Assert.assertEquals(nome + sobreNome, inicioPage.verificarClienteXpath(nome + sobreNome));

    }

    @Test
    public void testClienteMesmoDados() {
        inicioPage.entrar();

        // Cadastrar primeiro cliente
        forms.setNome("Lucas Araujo");
        forms.setEmailManual("lucas@hotmail.com");
        forms.setCPFManual("445.938.745-63");
        forms.setTelefone("(11) 92578-4525");
        forms.setCEPManual("07855-250");
        forms.setRua("Rua Nogueira");
        forms.setNumero();
        forms.setComplemento("estádio Allianz Parque");
        forms.setBairro("Santa agustina");
        forms.setCidade("São Paulo");
        forms.setEstado("Acre");
        forms.cadastrar();

        // Tentar cadastrar segundo cliente com dados repetidos
        inicioPage.entrar();
        forms.setNome("Lucas Araujo");
        forms.setEmailManual("lucas@hotmail.com");
        forms.setCPFManual("445.938.745-63");
        forms.setTelefone("(11) 92578-4525");
        forms.setCEPManual("07855-250");
        forms.setRua("Rua Nogueira");
        forms.setNumero();
        forms.setComplemento("estádio Allianz Parque");
        forms.setBairro("Santa agustina");
        forms.setCidade("São Paulo");
        forms.setEstado("Acre");
        forms.cadastrar();

        // Verificar se o cliente "Lucas Araujo" está na tabela
        Assert.assertEquals("Lucas Araujo",inicioPage.verificarCliente("Lucas Araujo"));

    }


}
