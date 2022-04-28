package mediaDB;

import defaultObject.DefaultObjectCreator;
import logc.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private InteractiveVideoImpl iv1;
    private InteractiveVideoImpl iv4;
    private LicensedVideoImpl l1;
    private LicensedAudioVideoImpl l2;
    private LicensedAudioImpl l3;
    private LicensedAudioImpl l4;
    private LicensedAudioImpl l35;
    private Darstellung_logic darstellung_logic;
    private DefaultObjectCreator defaultObjectCreator;

    @BeforeEach
    void setUp() throws Exception {

        darstellung_logic = new Darstellung_logic();
 defaultObjectCreator = new DefaultObjectCreator();
        iv1 = (InteractiveVideoImpl) defaultObjectCreator.createDefaultItem(new InteractiveVideoImpl());
        InteractiveVideoImpl iv3 = (InteractiveVideoImpl) defaultObjectCreator.createDefaultItem(new InteractiveVideoImpl());
        InteractiveVideoImpl iv2 = (InteractiveVideoImpl) defaultObjectCreator.createDefaultItem(new InteractiveVideoImpl());

        iv4 = (InteractiveVideoImpl) defaultObjectCreator.createDefaultItem(new InteractiveVideoImpl());

        iv4.setUploader(new UploaderImpl("I am a update iv4"));

        l1 = (LicensedVideoImpl) defaultObjectCreator.createDefaultItem(new LicensedVideoImpl());
        l2 = (LicensedAudioVideoImpl) defaultObjectCreator.createDefaultItem(new LicensedAudioVideoImpl());
        l3 = (LicensedAudioImpl) defaultObjectCreator.createDefaultItem(new LicensedAudioImpl());
        LicensedAudioImpl l31 = (LicensedAudioImpl) defaultObjectCreator.createDefaultItem(new LicensedAudioImpl());
        LicensedAudioImpl l32 = (LicensedAudioImpl) defaultObjectCreator.createDefaultItem(new LicensedAudioImpl());
        LicensedAudioImpl l33 = (LicensedAudioImpl) defaultObjectCreator.createDefaultItem(new LicensedAudioImpl());
        LicensedAudioImpl l34 = (LicensedAudioImpl) defaultObjectCreator.createDefaultItem(new LicensedAudioImpl());

        l4 = (LicensedAudioImpl) defaultObjectCreator.createDefaultItem(new LicensedAudioImpl());
        l4.setUploader(new UploaderImpl("I am a update  l4 "));

        darstellung_logic.addItems(iv1);
        darstellung_logic.addItems(iv2);
        darstellung_logic.addItems(iv3);
        darstellung_logic.addItems(l1);
        darstellung_logic.addItems(l2);
        darstellung_logic.addItems(l3);
        darstellung_logic.addItems(l31);
        darstellung_logic.addItems(l32);
        darstellung_logic.addItems(l33);
        darstellung_logic.addItems(l34);

        l35 = (LicensedAudioImpl)defaultObjectCreator.createDefaultItem(new LicensedAudioImpl());

    }

    /**
     * @throws Exception when the client use the hold space from the capacity
     * here will be also test if the action it is possible add a new items when the place is full
     */
    @Test
    void testMaxCapacity() throws Exception {

        String message = "";
        try {

            assertFalse(darstellung_logic.addItems(l35));

        } catch (Exception e){
          message =  e.getMessage();
        }

        assertEquals("Sorry we don`t have Capacity now for", message);
        assertEquals(10, darstellung_logic.getItemsList().size());
    }


    /**
     * @throws Exception add a new item
     * removing item from the list and create new space for to add new items
     */
    @Test
    void removeItems() {

        darstellung_logic.removeItems(l1);
        darstellung_logic.removeItems(iv1);
        assertEquals(8, darstellung_logic.getItemsList().size());

    }


    /**
     * @throws Exception  testing the setting method from the default item
     * the default methode will be modified for new elements
     */
    @Test
    void testSettingItems() throws Exception {

        //setting a new Address
        String defaultaddr = "https://de.wikipedia.org/wiki/CRUD";
        assertEquals(defaultaddr, iv1.getAddress());
        iv1.setAddress("google.com");
        assertNotEquals(defaultaddr, iv1.getAddress());

        //Setting Tags
        Set<Tag> defaultTag = Collections.singleton(Tag.Animal);
        assertEquals(defaultTag, iv1.getTags());
        iv1.setTags(Collections.singleton(Tag.Tutorial));
        assertNotEquals(defaultTag, iv1.getTags());
        Set<Tag> tag = Collections.singleton(Tag.Tutorial);
        assertEquals(tag, iv1.getTags());


        //setting Access Account
        long defaultaccessaccount = 25252L;
        assertEquals(defaultaccessaccount, iv1.getAccessCount());
        iv1.setAccessCount(12345);
        assertNotEquals(defaultaccessaccount, iv1.getAccessCount());
        assertEquals(12345, iv1.getAccessCount());


        //setting type
        String defaultType = "Documentary";
        assertEquals(defaultType, iv1.getType());
        iv1.setType("Sport");
        assertNotEquals(defaultType, iv1.getType());
        assertEquals("Sport", iv1.getType());


        //setting Resolution
        int defaultResolution = 8200;
        assertEquals(defaultResolution, iv1.getResolution());
        iv1.setResolution(1040);
        assertNotEquals(defaultResolution, iv1.getResolution());
        assertEquals(1040, iv1.getResolution());


        //setting a new Uploader

        String defaultname = "Tovias Nunez";
        assertEquals(defaultname, iv1.getUploader().getName());
        iv1.setUploader(new UploaderImpl("Jonny Jann"));
        assertNotEquals(defaultname, iv1.getUploader().getName());

        //setting date
        Date defaultDate = java.sql.Date.valueOf("2022-02-28");
        assertEquals(defaultDate, iv1.getUploadDate());
        iv1.setDate(java.sql.Date.valueOf("2019-03-28"));
        assertNotEquals(defaultDate, iv1.getUploadDate());
        assertEquals(java.sql.Date.valueOf("2019-03-28"), iv1.getUploadDate());


        //setting dration
        Duration defaultDuration = Duration.ofMinutes(125);
        assertEquals(defaultDuration, iv1.getLength());
        iv1.setDuration(Duration.ofMinutes(100));
        assertNotEquals(defaultDuration, iv1.getLength());
        assertEquals(Duration.ofMinutes(100), iv1.getLength());


        //setting bitrate
        BigDecimal defaultbitrate = BigDecimal.valueOf(53535353);
        assertEquals(defaultbitrate, iv1.getBitrate());
        iv1.setBitrate(BigDecimal.valueOf(35353535));
        assertNotEquals(defaultbitrate, iv1.getBitrate());
        assertEquals(BigDecimal.valueOf(35353535), iv1.getBitrate());

        //setting size
        BigDecimal defaultSize = BigDecimal.valueOf(42424);
        assertEquals(defaultSize, iv1.getSize());
        iv1.setSize(BigDecimal.valueOf(65656565));
        assertNotEquals(defaultSize, iv1.getSize());
        assertEquals(BigDecimal.valueOf(65656565), iv1.getSize());


    }

    /**
     * will be tested if the item was replaced from the  new one  without modified the size of the list
     * and capacity from
     */
    @Test
    void updateItems() {

        assertTrue(darstellung_logic.updateItems(iv4, iv1));
        assertTrue(darstellung_logic.updateItems(l4, l2));
        assertFalse(darstellung_logic.updateItems(iv4, l3));
        assertEquals(10, darstellung_logic.getItemsList().size());

        darstellung_logic.getItemsList().stream().forEach(x -> System.out.println(x));


    }

    /**
     * print the hold items list without id
     */
    @Test
    void testGetItemsList() {
        assertEquals(10, darstellung_logic.getItemsList().size());
       darstellung_logic.getItemsList().stream().forEach(x -> System.out.println(x));

    }



    /**
     * items will be created as empty items not value will be added as default
     */
    @Test
    void testCreatingItem() throws Exception {
      l35 = (LicensedAudioImpl) darstellung_logic.createItem(new LicensedAudioImpl());


        // setting value to the object
        l35.setAddress("new address");
        assertEquals("new address", l35.getAddress());
        l35.setUploader(new UploaderImpl("Mathias Jahn"));
        assertEquals("Mathias Jahn", l35.getUploader().getName());
        l35.setAccessCount(53535353);
        assertEquals(53535353 , l35.getAccessCount());
        l35.setBitrate(BigDecimal.valueOf(53535353));
        assertEquals(BigDecimal.valueOf(53535353), l35.getBitrate());

        l35.setDate(new Date(2022,4,26));
        assertEquals(new Date(2022,4,26) , l35.getUploadDate());
        l35.setHolder("Holder example");
        assertEquals("Holder example", l35.getHolder());
        l35.setDuration(Duration.ofMinutes(60));
        assertEquals(Duration.ofMinutes(60) , l35.getLength());

        l35.setTags(Collections.singleton(Tag.Animal));
        assertEquals(Collections.singleton(Tag.Animal), l35.getTags());
        l35.setSize(BigDecimal.valueOf(24242));
        assertEquals(BigDecimal.valueOf(24242), l35.getSize());
        l35.setSamplingRate(25252);
        assertEquals(25252, l35.getSamplingRate());




    }


}