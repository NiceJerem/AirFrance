import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageAccueil extends AF_Full {

    public PageAccueil(WebDriver driver )
    {
        super(driver);
    }


    @FindBy(id="minibe__od--out")
    WebElement depart;
    public void SaisirDepart(String  aeroport)
    {
        depart.sendKeys(aeroport + Keys.ENTER);
    }


    @FindBy(id="minibe__od--in")
    WebElement arrivee;
    public void SaisirArrivee(String  aeroport)
    {
        arrivee.sendKeys(aeroport+ Keys.ENTER);
    }

    @FindBy(id="minibe__roundTrip--label")
    WebElement ButtonRetour;
    public void ChoisirRetour(  )
    {
        ButtonRetour.click();
    }
    //
    @FindBy(xpath="//*[@id=\"calendar\"]/header/button")
    WebElement btnCloseCalendar;



    @FindBy(id="minibe__oneWay--label")
    WebElement ButtonAllerSimple;
    public void ChoisirAllerSimple(  )
    {

        ButtonAllerSimple.click();
    }

    WebElement calendrier;

    @FindBy(xpath="//*[@id=\"calendar\"]/header/div[2]/button[2]")
    WebElement btnMoisProchain;

    public void dateOperation(String date)
    {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("dateD :"+ date);
        String year =date.substring(0,4);

        int yearInt = Integer.parseInt(year);
        System.out.println("year :"+ year);
        System.out.println("dateD :"+ date);
        String month= date.substring(4,6);
        //-------------
        System.out.println("month :"+ month);
        int monthInt = Integer.parseInt(month);
        int actualMonth = now.getMonthValue();
        int actualYear = now.getYear();
        if(monthInt< 10)
        {
            System.out.println("getInteger :"+ month);
            month= String.valueOf(monthInt);
            System.out.println("getInteger apres:"+ month);
        }
        if(actualMonth> monthInt)
        {

        }

        String idCal = year +month;
        System.out.println("idCal :"+ idCal);
        String idCalendrier ="calendar"+idCal;



        Actions actions = new Actions(driver);
        System.out.println("avant Find Element "+idCalendrier);
        calendrier = driver.findElement(By.id(idCalendrier));

        System.out.println("avant wait.until "+idCalendrier);
        actions.moveToElement(calendrier);
        actions.build().perform();
        actions.click();
        actions.build().perform();
        //
        //calendar--20180713
        System.out.println("apres wait.until "+idCalendrier);
        WebDriverWait wait = new WebDriverWait(driver,5);

        String idDate ="calendar--"+date ;
        WebElement tddate =  calendrier.findElement(By.id( idDate));
        wait.until(ExpectedConditions.visibilityOf(tddate));
        actions.moveToElement(tddate);
        actions.build().perform();
        actions.click();
        actions.build().perform();
    }

    @FindBy(id="minibe__button--calendar_out")
    WebElement dateDepart;
    public void ChoisirDateDepart( String  dateD ) //
    {
        //dateD = 20180816
        LocalDateTime now = LocalDateTime.now();
        dateDepart.click();
        //calendar20188
        dateOperation(dateD);
        //-----------
        /*
        Actions actions = new Actions(driver);
        String idDate ="calendar--"+dateD ;
        WebElement date =  calendrier.findElement(By.id( idDate));
        actions.moveToElement(date);
        actions.build().perform();
        actions.click();
        actions.build().perform();
        */
        //btnCloseCalendar.click();
    }

    @FindBy(id="minibe__button--calendar_in")
    WebElement dateArrivee;
    public void ChoisirDateArrivee( String  dateA )
    {
        System.out.println("-----------------------");
        System.out.println("Entree Date Arrivee");
        dateArrivee.click();
        //dateD = 20180816
        dateOperation(dateA);
        String idDate ="calendar--"+dateA ;
        calendrier.findElement(By.id(idDate)).click();
        btnCloseCalendar.click();
    }


    @FindBy(id="minibe__button--passenger")
    WebElement btnNombreAdulte;

    @FindBy(id="typology")
    WebElement menuPassager;



    public void ChoisirNombreAdulte( int nbAdultes )
    {
        btnNombreAdulte.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(menuPassager));
        Actions actions = new Actions(driver);

        String inputBtnNbAdulte="tnr__itp__"+nbAdultes;
        System.out.println(" id:"+ inputBtnNbAdulte);
        actions.moveToElement(menuPassager);
        WebElement btnArea = driver.findElement(By.xpath("//*[@id=\"typology__paxNum\"]/div"));
        actions.moveToElement(btnArea);
        WebElement btnNbrPassager = btnArea.findElement(By.id(inputBtnNbAdulte));
        actions.moveToElement(btnNbrPassager);
        System.out.println(" apres move:"+ inputBtnNbAdulte);
        actions.build().perform();
        System.out.println(" perform move:"+ inputBtnNbAdulte);
        actions.click();
        System.out.println(" click:"+ inputBtnNbAdulte);
        actions.build().perform();
        System.out.println(" End:"+ inputBtnNbAdulte);

        ////*[@id="tnr__itp__3"]
        //
    }

    @FindBy(id="minibe__button--search")
    WebElement btnRechercher;
    public PageHorairesTarifs rechercher(  )
    {

        btnRechercher.click();
        return new PageHorairesTarifs(driver);
    }

    public void nousContacterFooter()
    {
        super.ClickerNousContacter();
    }
    public void choisirEnregistrement()
    {
        super.clickerBtnEnregistrement();
    }

}
