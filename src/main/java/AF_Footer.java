import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AF_Footer {
    WebDriver driver;

    public AF_Footer(  WebDriver driver )
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getFooter() {
        return footer;
    }

    @FindBy(tagName="footer")
    private WebElement footer;

    @FindBy(id="idLink_footer_tab1_0")
    private WebElement btnNousContacter;

    public void ClickerNousContacter()
    {
        btnNousContacter.click();
    }

}
