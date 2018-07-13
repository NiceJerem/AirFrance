import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AF_Full extends AF_Footer{
    public WebElement getHeader() {
        return header;
    }

    public AF_Full(WebDriver driver )
    {
        super(driver);
    }

    @FindBy(tagName="header")
    private WebElement header;

    @FindBy(tagName="idNavIciLink")
    private WebElement btnEnregistrement;

    public void clickerBtnEnregistrement()
    {
        btnEnregistrement.click();
    }

}
