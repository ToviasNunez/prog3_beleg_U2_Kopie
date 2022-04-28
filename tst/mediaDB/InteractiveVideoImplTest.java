package mediaDB;

import logc.InteractiveVideoImpl;
import logc.UploaderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Duration;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class InteractiveVideoImplTest {

    InteractiveVideoImpl interactiveVideo = new InteractiveVideoImpl();
    String messageException = "";

    InteractiveVideoImplTest() throws Exception {
    }

    @BeforeEach
    void setUp() {
        interactiveVideo.setAddress("https://de.wikipedia.org/wiki/CRUD");
        interactiveVideo.setTags(Collections.singleton(Tag.Animal));
        interactiveVideo.setType("Documentary");
        interactiveVideo.setUploader(new UploaderImpl("Tovias Nunez"));
        interactiveVideo.setDate(Date.valueOf("2022-02-28"));
    }


    @Test
    void getAddress() {
        assertEquals("https://de.wikipedia.org/wiki/CRUD", interactiveVideo.getAddress());
    }

    @Test
    void getTags() {
        assertEquals(Collections.singleton(Tag.Animal), interactiveVideo.getTags());
    }

    @Test
    void getAccessCount() {
        try {
            interactiveVideo.setAccessCount(-25252);
        }catch (IllegalArgumentException e){
            messageException = e.getMessage();
        }
        assertTrue("Not negative accessCount is allow".equals(messageException));
        interactiveVideo.setAccessCount(25252);
        assertEquals(25252, interactiveVideo.getAccessCount());
    }

    @Test
    void getType() {
        assertEquals("Documentary", interactiveVideo.getType());
    }

    @Test
    void getBitrate() {

        try {
            interactiveVideo.setBitrate(BigDecimal.valueOf(768000));
        } catch (IllegalArgumentException e) {
            messageException = e.getMessage();
        }
        assertTrue("Bitrate too small".equals(messageException));
        interactiveVideo.setBitrate(BigDecimal.valueOf(768001));
        assertEquals(BigDecimal.valueOf(768001), interactiveVideo.getBitrate());
    }

    @Test
    void getLength() {
        try {
            interactiveVideo.setDuration(Duration.ofMinutes(-125));
        } catch (IllegalArgumentException e) {
            messageException = e.getMessage();

        }
        assertTrue("negative duration not allowed".equals(messageException));
        interactiveVideo.setDuration(Duration.ofMinutes(125));
        assertEquals(Duration.ofMinutes(125), interactiveVideo.getLength());
    }

    @Test
    void getSize() throws Exception {

        try {
            interactiveVideo.setSize(BigDecimal.valueOf(-1));
        } catch (IllegalArgumentException exception) {
            messageException = exception.getMessage();

        }

        assertTrue("Illegal size".equals(messageException));
        interactiveVideo.setSize(BigDecimal.valueOf(1));
        assertEquals(BigDecimal.valueOf(1), interactiveVideo.getSize());
    }

    @Test
    void getUploader() {
        assertEquals("Tovias Nunez", interactiveVideo.getUploader().getName());
    }

    @Test
    void getUploadDate() {
        assertTrue(Date.valueOf("2022-02-28").equals(interactiveVideo.getUploadDate()));
    }

    @Test
    void getResolution() throws Exception {

        try {
            interactiveVideo.setResolution(200);
        } catch (IllegalArgumentException exception) {
            messageException = exception.getMessage();

        }
        assertEquals("Resolution is not gut enough", messageException);

        interactiveVideo.setResolution(720);
        assertEquals(720, interactiveVideo.getResolution());


    }


}