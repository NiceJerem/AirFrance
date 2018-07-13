import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageDetailsVoyage extends AF_Footer {
    //idValidateFormButtonCustom
    public PageDetailsVoyage(WebDriver driver )
    {
        super(driver);
    }

    @FindBy(id="idValidateFormButtonCustom")
    WebElement btnContinuer;
    public PageDonneesPersonnelles continuer()
    {
        btnContinuer.click();
        return new PageDonneesPersonnelles(driver);
    }
}
