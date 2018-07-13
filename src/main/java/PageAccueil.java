import org.openqa.selenium.By;
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

public class PageAccueil extends AF_Full {

    public PageAccueil(WebDriver driver )
    {
        super(driver);

    }


    @FindBy(id="minibe__od--out")
    WebElement depart;
    public void SaisirDepart(String  aeroport)
    {

        depart.sendKeys(aeroport);
    }


    @FindBy(id="minibe__od--in")
    WebElement arrivee;
    public void SaisirArrivee(String  aeroport)
    {

        arrivee.sendKeys(aeroport);
    }

    @FindBy(id="minibe__roundTrip--label")
    WebElement ButtonRetour;
    public void ChoisirRetour(  )
    {

        ButtonRetour.click();
    }



    @FindBy(id="minibe__oneWay--label")
    WebElement ButtonAllerSimple;
    public void ChoisirAllerSimple(  )
    {

        ButtonAllerSimple.click();
    }

    WebElement calendrier;

    @FindBy(xpath="//*[@id=\"calendar\"]/header/div[2]/button[2]")
    WebElement btnMoisProchain;


    @FindBy(id="minibe__button--calendar_out")
    WebElement dateDepart;
    public void ChoisirDateDepart( String  dateD ) //
    {
        //dateD = 20180816
        LocalDateTime now = LocalDateTime.now();
        dateDepart.click();
        //calendar20188
        System.out.println("dateD :"+ dateD);
        String year =dateD.substring(0,4);
        int yearInt = Integer.parseInt(year);
        System.out.println("year :"+ year);
        System.out.println("dateD :"+ dateD);
        String month= dateD.substring(4,6);
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
            /*
            int differenceMois = monthInt - actualMonth;
            for(int i=0;i<differenceMois;i++)
            {
                btnMoisProchain.click();
            }
            */
        }

        String idCal = year +month;
        System.out.println("idCal :"+ idCal);
        String idCalendrier ="calendar"+idCal;
        WebDriverWait wait = new WebDriverWait(driver, 5);
        System.out.println("avant Find Element "+idCalendrier);
        calendrier = driver.findElement(By.id(idCalendrier));
        System.out.println("avant wait.until "+idCalendrier);
        wait.until(ExpectedConditions.visibilityOf(calendrier));
        //calendar--20180713
        System.out.println("apres wait.until "+idCalendrier);
        String idDate ="calendar--"+dateD ;
        calendrier.findElement(By.id(idDate)).click();
    }

    @FindBy(id="minibe__button--calendar_in")
    WebElement dateArrivee;
    public void ChoisirDateArrivee( String  dateA )
    {
        System.out.println("-----------------------");
        System.out.println("Entree Date Arrivee");
        //dateD = 20180816
        LocalDateTime now = LocalDateTime.now();
        dateArrivee.click();
        //calendar20188
        System.out.println("dateD :"+ dateA);
        String year =dateA.substring(0,4);
        int yearInt = Integer.parseInt(year);
        System.out.println("year :"+ year);
        System.out.println("dateD :"+ dateA);
        String month= dateA.substring(4,6);
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
            /*
            int differenceMois = monthInt - actualMonth;
            for(int i=0;i<differenceMois;i++)
            {
                btnMoisProchain.click();
            }
            */
        }

        String idCal = year +month;
        System.out.println("idCal :"+ idCal);
        String idCalendrier ="calendar"+idCal;
        System.out.println("idCalendrier :"+ idCalendrier);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        System.out.println("apres wait :"+ idCalendrier);
        calendrier = driver.findElement(By.id(idCalendrier));
        System.out.println("apres calendrier :"+ idCalendrier);
        wait.until(ExpectedConditions.visibilityOf(calendrier));
        System.out.println("apres wait :"+ idCalendrier);
        //calendar--20180713
        String idDate ="calendar--"+dateA ;
        calendrier.findElement(By.id(idDate)).click();
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

        //tnr__itp__3
        WebElement btnNbrPassager = menuPassager.findElement(By.id(inputBtnNbAdulte));
        actions.moveToElement(btnNbrPassager);
        System.out.println(" apres move:"+ inputBtnNbAdulte);
        actions.build().perform();
        System.out.println(" perform move:"+ inputBtnNbAdulte);
        actions.click();
        System.out.println(" click:"+ inputBtnNbAdulte);
        actions.build().perform();
        System.out.println(" End:"+ inputBtnNbAdulte);
        //wait.until(ExpectedConditions.elementToBeClickable(btnNbrPassager));
        //btnNbrPassager.click();
        ////*[@id="tnr__itp__3"]
        //
    }

    @FindBy(id="minibe__button--search")
    WebElement btnRechercher;
    public void rechercher(  )
    {

        btnRechercher.click();
    }

}
