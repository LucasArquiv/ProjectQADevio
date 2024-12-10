package pages;

import core.BasePage;
import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static core.DriverFactory.getDriver;

public class InicioPage extends BasePage {

    public void acessoTelaAdministrador() {
        getDriver().get("https://teste-qa-devio.vercel.app/");
    }

    public void entrar() {
        clickDeBotaoPorTexto("Cadastrar Cliente");
    }

    public Object verificarCampoVazio() {
        List<WebElement> elements =
                getDriver().findElements(By.xpath("/table[@class='min-w-full']"));
        return elements.size();
    }

    public String verificarClienteXpath(String Cliente) {
        getDriver().findElement(By.xpath("//table[@class='min-w-full']")).getText();
        return  Cliente;
    }

    public String verificarCliente(String valor) {

        // Verificar se o cliente "Lucas Araujo" está na tabela
        WebElement tabela = DriverFactory.getDriver().findElement(By.xpath("//table[@class='min-w-full']//tbody"));
        List<WebElement> linhas = tabela.findElements(By.xpath(".//tr"));

        int contadorDuplicados = 0;
        for (WebElement linha : linhas) {
            WebElement colunaNome = linha.findElement(By.xpath(".//td"));
            if (colunaNome.getText().trim().equalsIgnoreCase(valor)) {
                contadorDuplicados++;
            }
        }
        // Imprimir o resultado no console
        System.out.println("O nome 'Lucas Araujo' aparece " + contadorDuplicados + " vezes na tabela.");

        return valor;
    }
}
