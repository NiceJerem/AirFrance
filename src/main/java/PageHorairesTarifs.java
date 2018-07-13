import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageHorairesTarifs extends AF_Footer {
    public PageHorairesTarifs(WebDriver driver )
    {
        super(driver);
    }
    @FindBy(id="idFlightsWrapper")
    WebElement divVols;

    @FindBy(id="idValidateFormButtonFlight")
    WebElement btnContinuer;

    WebElement volsAller;
    public void ChoisirMeilleurTarifAller(int indexItem)
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement titre = driver.findElement(By.cssSelector ("#idFlightsWrapper > section > header > div > h3 > span.title"));
        wait.until(ExpectedConditions.visibilityOf(titre));
        volsAller = divVols.findElements(By.tagName("section")).get(0);
        System.out.println("titre "+titre.getText());
         WebElement tableVolAller = volsAller.findElement(By.xpath("/html/body/div[6]/div[2]/div/main/form/div[1]/section[1]/div/table"));
        System.out.println("apres table");
        List<WebElement> listVolMeilleurTarif =tableVolAller.findElements(By.cssSelector("button[data-lowest=\"true\"]"));
        System.out.println("nb liste vol"+listVolMeilleurTarif.size());

        WebElement meilleurTarif = listVolMeilleurTarif.get(indexItem-1);
        meilleurTarif.click();
    }

    WebElement volsRetour;
    public void ChoisirMeilleurTarifRetour(int indexItem)
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement titre = driver.findElement(By.xpath("//*[@id=\"idFlightsWrapper\"]/section[1]/header/div/h3/span[1]"));
        wait.until(ExpectedConditions.visibilityOf(titre));
        volsRetour = divVols.findElements(By.tagName("section")).get(1);
        System.out.println("titre "+titre.getText());
        WebElement tableVolRetour = volsRetour.findElement(By.xpath("//*[@id=\"idFlightsWrapper\"]/section[2]/div/table"));
        System.out.println("apres table");
        List<WebElement> listVolMeilleurTarif =tableVolRetour.findElements(By.cssSelector("button[data-lowest=\"true\"]"));
        System.out.println("nb liste vol"+listVolMeilleurTarif.size());

        WebElement meilleurTarif = listVolMeilleurTarif.get(indexItem-1);
        meilleurTarif.click();
    }

    public PageDetailsVoyage continuer()
    {
/*
        Actions action = new Actions(driver);
        System.out.println("continuer Page Tarif");
        WebElement formulaire = driver.findElement(By.id("standardCustomForm"));
        action.moveToElement(formulaire);
        action.build().perform();
        action.moveToElement(btnContinuer);
        action.build().perform();
        action.click();
        action.build().perform();
            */
        btnContinuer.click();
        return new PageDetailsVoyage(driver);
    }
}
