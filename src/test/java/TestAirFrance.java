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
    public void test3() {
        PageAccueil accueil= new PageAccueil(driver);
        String dateDepart= "20180816";
        String villeDepart="ORY";
        String villeArrivee="NCE";

        accueil.ChoisirAllerSimple();
        accueil.ChoisirDateDepart(dateDepart );

        accueil.SaisirDepart(villeDepart);
        accueil.SaisirArrivee(villeArrivee);

        PageHorairesTarifs tarifPage=  accueil.rechercher();
        System.out.println("apres rechercher");
        tarifPage.ChoisirMeilleurTarifAller(5);
        System.out.println("apres tarifPage");
        PageDetailsVoyage detailsPage= tarifPage.continuer();
        System.out.println("apres details page");
        PageDonneesPersonnelles persoPage=detailsPage.continuer();
        //-------------------------------
        persoPage.fermerPopup();
        String nom="toto";
        String prenom="toto";
        String email="toto@toto.com";
        String telephone="611223344";
        persoPage.choisirMonsieur();
        System.out.println("Apres cocherPasDassurance");
        persoPage.cocherPasDassurance();
        persoPage.saisirNom(nom);
        persoPage.saisirPrenom(prenom);
        persoPage.saisirEmail(email);
        persoPage.saisirEmailConfirm(email);
        persoPage.saisirTelephone(telephone);
        System.out.println("Apres telephone");

        persoPage.cocherCGU();
        System.out.println("Apres cocherCGU");
        persoPage.cocherCGU();
        System.out.println("Apres cocherCGU");
        persoPage.payer();
        System.out.println("Apres Payer");
    }

    @Test
    public void test1() {
        PageAccueil accueil= new PageAccueil(driver);
        String dateDepart= "20180716";
        String dateArrivee= "20180721";
        String villeDepart="ORY";
        String villeArrivee="NCE";

        accueil.nousContacterFooter();
        accueil.choisirEnregistrement();



    }
}
