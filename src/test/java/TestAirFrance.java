import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAirFrance {
    WebDriver driver;

    @Before
    public void beforeTest()
    {
        driver = new ChromeDriver();
        driver.get("http://www.airfrance.fr");
    }

    @Test
    public void t1() {
        PageAccueil accueil= new PageAccueil(driver);
        String dateDepart= "20180719";
        String dateArrivee= "20180721";
        String villeDepart="NCE";
        String villeArrivee="CDG";

        int nbAdultes =3;
     //   accueil.ChoisirAllerSimple();


    //
        //accueil.SaisirArrivee(villeArrivee);
        //accueil.ChoisirDateArrivee(dateArrivee);
        //accueil.ChoisirDateDepart(dateDepart );
        //accueil.SaisirDepart(villeDepart);


        accueil.ChoisirNombreAdulte(nbAdultes);
      //  accueil.rechercher();

    }
}
