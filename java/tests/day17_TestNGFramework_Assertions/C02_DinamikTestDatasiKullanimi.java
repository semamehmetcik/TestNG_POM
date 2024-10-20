package tests.day17_TestNGFramework_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DinamikTestDatasiKullanimi {

    @Test
    public void aramaTesti(){

        // testotomasyonu sayfasina dinamik url kullanarak gidin

        Driver.getDriver().get(  ConfigReader.getProperty("toUrl")   ); // C P' den alinacak
        // meydanci bize toUrl'i getir

        // arama kutusuna belirlenen aranacakKelime'yi yazip aratin
        TestotomasyonPage testotomasyonPage = new TestotomasyonPage();

        testotomasyonPage.aramaKutusu
                .sendKeys(  ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER   ); // C P' den alinacak
        // meydanci bize toAranacakKelime'yi getir

        // arama sonucunda urun bulunabildigini test edin

        Assert.assertTrue( testotomasyonPage.bulunanUrunElementleriList.size() > 0   );


        // ilk urunu tiklayin

        testotomasyonPage.bulunanUrunElementleriList
                .get(0)
                .click();

        // acilan sayfadaki urun isminde
        // case sensitive olmadan belirlenmis aranacakKelime gectigini test edin

        String aranacakKelime = ConfigReader.getProperty("toAranacakKelime");  // C P' den alinacak
        // meydanci bize toAranacakKelime'yi getir

        String actualUrunIsmi = testotomasyonPage.ilkUrunIsimElementi
                .getText()
                .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(aranacakKelime));


        Driver.quitDriver();

    }
}