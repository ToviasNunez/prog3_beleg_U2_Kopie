package logc;

import mediaDB.Items;
import mediaDB.Tag;
import observerPattern.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class G_logikTest  {
    G_logik g_logik;
    String exceptionMessage = "";

    Darstellung_logic verwaltung;
    UploaderImpl uploader, uploader1;
    InteractiveVideoImpl interactiveVideo5;
    Beobachter beobachterKapazitaet;
    Beobachter beobachterTags;
    ConcreteSubjectCapasity concreteSubjectCapasity;
    ConcreteSubjectTags concreteSubjectTags;
    @BeforeEach
    void setUp() throws Exception {

        g_logik = new G_logik();

        uploader = new UploaderImpl("Tovias Nunez");
        uploader1 = new UploaderImpl("Ameli Nunez");
        g_logik.createProduzenten(uploader);
        interactiveVideo5 = new InteractiveVideoImpl();
        interactiveVideo5.setUploader(uploader);
        interactiveVideo5.setTags(Collections.singleton(Tag.Animal));
        verwaltung = new Darstellung_logic();
        verwaltung.addItems(interactiveVideo5);


    }

    @Test
    void cretaeProduzenten() throws Exception {
        g_logik.createProduzenten(uploader);


    }

    /**
     * list the creator with the amount a product
     *
     * @throws Exception
     */
    @Test
    void getListProduzenten() throws Exception {

        InteractiveVideoImpl interactiveVideo = new InteractiveVideoImpl();
        InteractiveVideoImpl interactiveVideo1 = new InteractiveVideoImpl();
        InteractiveVideoImpl interactiveVideo2 = new InteractiveVideoImpl();
        InteractiveVideoImpl interactiveVideo3 = new InteractiveVideoImpl();

        LicensedAudioImpl licensedAudio1 = (LicensedAudioImpl) verwaltung.createItem(new LicensedAudioImpl());
        LicensedAudioImpl licensedAudio2 = new LicensedAudioImpl();

        LicensedAudioVideoImpl licensedAudioVideo = new LicensedAudioVideoImpl();
        LicensedAudioVideoImpl licensedAudioVideo2 = new LicensedAudioVideoImpl();


        interactiveVideo.setUploader(new UploaderImpl("Mathias"));
        interactiveVideo1.setUploader(uploader);
        interactiveVideo3.setUploader(uploader);
        interactiveVideo.setUploader(uploader);
        interactiveVideo2.setUploader(uploader);
        licensedAudio1.setUploader(uploader);
        licensedAudio2.setUploader(uploader);


        licensedAudioVideo.setUploader(uploader1);
        licensedAudioVideo2.setUploader(uploader1);

        assertTrue(verwaltung.addItems(interactiveVideo));
        assertTrue(verwaltung.addItems(interactiveVideo2));
        assertTrue(verwaltung.addItems(interactiveVideo3));
        assertTrue(verwaltung.addItems(interactiveVideo1));
        assertTrue(verwaltung.addItems(licensedAudio1));
        assertTrue(verwaltung.addItems(licensedAudio2));

        assertTrue(verwaltung.addItems(licensedAudioVideo));
        assertTrue(verwaltung.addItems(licensedAudioVideo2));
        assertTrue(verwaltung.addItems(licensedAudio2));


      System.out.println(verwaltung.getItemsList().size());
      System.out.println(g_logik.getListProduzenten(verwaltung.getItemsList()));

    }

    @Test
    void testPreufenObProduzenterExitiert() {
        assertFalse(g_logik.preufenObProduzenterExitiert(uploader1));
    }

    @Test
    void testPrueftGesamtkapazitaet() {
        try {
            g_logik.prueftGesamtkapazitaet(BigDecimal.valueOf(101));
        } catch (IllegalArgumentException exception) {
            exceptionMessage = exception.getMessage();
        }
        assertEquals("Kapazitat wurde ueberschritten", exceptionMessage);

    }

    @Test
    void testPrueftGesamtkapazitaet2() {

            g_logik.prueftGesamtkapazitaet(BigDecimal.valueOf(90.000001));

    }


    @Test
    void loeschenProduzenten() {

        assertFalse(g_logik.loeschenProduzenten(uploader1));
        assertTrue(g_logik.loeschenProduzenten(uploader));
        g_logik.getListProduzenten(verwaltung.getItemsList());
    }

    @Test
    void removeItems() throws Exception {
        LicensedAudioImpl licensedAudio = (LicensedAudioImpl) verwaltung.createItem(new LicensedAudioImpl());
        assertTrue(verwaltung.addItems(licensedAudio));
        verwaltung.getItemsList();

        assertTrue(verwaltung.removeItems(licensedAudio));


    }

    @Test
    void testgetList() throws Exception {


        InteractiveVideoImpl interactiveVideo = new InteractiveVideoImpl();
        LicensedAudioImpl licensedAudio = new LicensedAudioImpl();

        interactiveVideo.setUploader(uploader1);
        verwaltung.addItems(interactiveVideo);


        verwaltung.addItems(new LicensedAudioImpl());
        licensedAudio.setAddress("test address");
        verwaltung.addItems(licensedAudio);

        System.out.println(g_logik.getList(Items.LICENSEDAUDIO , verwaltung.getItemsList()));
        //  System.out.println(g_logik.getItemsAndIDList());


    }


    @Test
    void preufenObProduzenterExitiert() {
        assertTrue(g_logik.preufenObProduzenterExitiert(uploader));
    }



    @Test
    void hochladen() throws Exception {

        interactiveVideo5.setUploader(new UploaderImpl("Karl"));
        interactiveVideo5.setSize(BigDecimal.valueOf(4242));
        interactiveVideo5.setAddress("google.com");
        interactiveVideo5.setAccessCount(12345);
        assertFalse(g_logik.hochladen(interactiveVideo5));
        interactiveVideo5.setUploader(uploader);
     //   assertTrue(g_logik.hochladen(interactiveVideo5));
    }


    @Test
    void getItemsList() {

        verwaltung.getItemsList().stream().forEach(v -> System.out.println(v));


    }

    @Test
    void getList() {
        System.out.println( g_logik.getList(Items.INTERACTIVEVIDEO , verwaltung.getItemsList())) ;
    }

    @Test
    void getAccount() {
        interactiveVideo5.setAccessCount(12345);
      assertEquals( 12345,g_logik.getAccount(interactiveVideo5.getAccessCount()));

    }


    @Test
    void testGetNichtvergebenenTags(){
     g_logik.getNichtvergebenenTags(verwaltung.getItemsList()).stream().forEach(x -> System.out.println(x));

    }


    @Test
    void observerFuction() throws Exception {

        ConcreteSubjectCapasity concreteSubjectCapasity = new ConcreteSubjectCapasity();
        beobachterKapazitaet = new BeobachterKapazitaet(concreteSubjectCapasity);

        G_logik dataMedia = new G_logik();


      //  ConcreteSubjectCapasity concreteSubjectCapasity = new ConcreteSubjectCapasity();
        //concreteSubjectCapasity.meldeAn(beobachterTags);

       InteractiveVideoImpl interactiveVideo = new InteractiveVideoImpl();

       interactiveVideo.setSize(BigDecimal.valueOf(90.0001));
       // interactiveVideo.setSize(BigDecimal.valueOf(89.0001));
     // interactiveVideo.setSize(BigDecimal.valueOf(92.0001));
       // interactiveVideo.setSize(BigDecimal.valueOf(90.0001));

        concreteSubjectCapasity.setSize(interactiveVideo.getSize());





      //

    //    client.addItems(interactiveVideo);

    }

}