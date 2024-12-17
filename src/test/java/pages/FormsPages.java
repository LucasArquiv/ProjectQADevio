package pages;

import core.BasePage;
import org.openqa.selenium.By;
import support.Utils;

import static core.DriverFactory.getDriver;

public class FormsPages extends BasePage {

    //variáveis abstraídas
    private By Prinome = new By.ByXPath("//input[@placeholder='Nome do prestador']");
    private By email = new By.ByXPath("//input[@placeholder='exemplo@email.com']");
    private By doc = new By.ByXPath("//input[@placeholder='111.111.111-22']");
    private By cep = new By.ByXPath("//input[@placeholder='00000-000']");
    private By numbCasa = new By.ByXPath("//input[@placeholder='000']");

    public void cadastrar() {
        clickDeBotaoPorTexto("Cadastrar");
    }

    public void setNome(String nome) {
        escreve(Prinome, (nome));
    }

    public void setEmail() {
        getDriver().findElement(email).sendKeys(Utils.getRamdomEmail());
    }

    public void setEmailManual(String emailManual) {
        getDriver().findElement(email).sendKeys(emailManual);
    }

    public void setCPF() {
        getDriver().findElement(doc).sendKeys(Utils.NumerosCPFAleatorio());
    }

    public void setCPFManual(String cpfManual) {
        getDriver().findElement(doc).sendKeys(cpfManual);
    }

    public void setTelefone(String telefone) {
        escreve(By.xpath("//input[@placeholder='(00) 00000-0000']"), telefone);
    }

    public void setCEP(String cepManual) {
        getDriver().findElement(cep).sendKeys(cepManual);
    }

    public void setRua(String rua) {
        escreve(By.xpath("//input[@placeholder='Nome da rua']"), rua);
    }

    public void setNumero(String numb) {
        getDriver().findElement(numbCasa).sendKeys(numb);
    }

    public void setComplemento(String complemento) {
        escreve(By.xpath("//input[@placeholder='Complemento']"), complemento);
    }

    public void setBairro(String bairro) {
        escreve(By.xpath("//input[@placeholder='Nome do Bairro']"), bairro);

    }

    public void setCidade(String cidade) {
        escreve(By.xpath("//input[@placeholder='Nome da cidade']"), cidade);

    }

    public void setEstado(String estado) {
        clicarBotao(new By.ByXPath("//*[contains(@stroke,'currentColor')]"));
        selecionaCombo("option-0", estado);
    }

    public void prestadorInativo() {
        clicarRadio(By.xpath("//div[contains(@class,'w-5 h-5 bg-white rounded-full with-transition')]"));
    }

}
