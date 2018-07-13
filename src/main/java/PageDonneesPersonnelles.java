import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageDonneesPersonnelles extends AF_Footer {
    //idValidateFormButtonCustom
    public PageDonneesPersonnelles(WebDriver driver )
    {
        super(driver);
        ///html/body/div[14]/section/h1
        ///html/body/div[13]/section/h1
        //body > div.overlay__popin__data > section > h1
    }


    @FindBy(id="idValidateFormButtonIDPA")
    WebElement btnPayer;
    public void payer()
    {
        Actions action = new Actions(driver);
        action.moveToElement(formulaire);
        action.build().perform();
        action.moveToElement(btnPayer);
        action.click();
        action.build().perform();
    }
    @FindBy(id="idReservationForm")
    WebElement formulaire;//

    @FindBy(id="idButtonCloseDefault")
    WebElement btnClosePopup;
    public void fermerPopup()
    {
        WebElement titrePopup= driver.findElement(By.cssSelector("body > div.overlay__popin__data > section > h1"));
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(titrePopup));
        btnClosePopup.click();
        wait.until(ExpectedConditions.invisibilityOf (titrePopup));

    }

    //class overlay__popin__data popup

    @FindBy(id="idCivility--0--0")
    WebElement radioMonsieur;
    public void choisirMonsieur()
    {
        Actions action = new Actions(driver);
        action.moveToElement(formulaire);
        action.build().perform();
        action.moveToElement(radioMonsieur);
        action.click();
        action.build().perform();
        //WebDriverWait wait = new WebDriverWait(driver,5);
        //wait.until(ExpectedConditions.visibilityOf(radioMonsieur));
        //radioMonsieur.click();
    }

    //
    @FindBy(id="idSelectionnableInsuranceTypeNoInsurance")
    WebElement radioNoAssurance;
    public void cocherPasDassurance()
    {
        WebElement tableAssurance = driver.findElement(By.id("insuranceContainerID"));
        Actions action = new Actions(driver);
        action.moveToElement(tableAssurance);
        action.build().perform();
        action.moveToElement(radioNoAssurance);
        action.build().perform();
        action.click();
        action.build().perform();
    }

    @FindBy(id="idLastName0")
    WebElement txtNom;
    public void saisirNom(String nom)
    {
        txtNom.sendKeys(nom+Keys.ENTER);
    }
    //
    @FindBy(id="idFirstName0")
    WebElement txtPrenom;
    public void saisirPrenom(String prenom)
    {
        txtPrenom.sendKeys(prenom+Keys.ENTER);
    }
    //
    @FindBy(id="idCountryCallingPhone")
    WebElement txtTelephone;
    public void saisirTelephone(String telephone)//611223344
    {
        txtTelephone.sendKeys(telephone+Keys.ENTER);
    }

    //
    @FindBy(id="idEmail")
    WebElement txtEmail;
    public void saisirEmail(String email)//611223344
    {
        txtEmail.sendKeys(email+Keys.ENTER);
    }
    //
    @FindBy(id="idEmailConfirm")
    WebElement txtEmailConfirm;
    public void saisirEmailConfirm(String emailConfirm)//611223344
    {
        txtEmailConfirm.sendKeys(emailConfirm+Keys.ENTER);
    }
    //
    @FindBy(id="idCheckboxCGU")
    WebElement checkboxCGU;
    public void cocherCGU()//611223344
    {
        WebElement formCGU = driver.findElement(By.cssSelector("//*[@id=\"idReservationForm\"]/fieldset[5]/div/div[1]"));

        Actions action = new Actions(driver);
        action.moveToElement(formCGU);
        action.build().perform();
        action.moveToElement(checkboxCGU);
        action.build().perform();
        action.click();
        action.build().perform();

        //checkboxCGU.click();
    }
    //

}

