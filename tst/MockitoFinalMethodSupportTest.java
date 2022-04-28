import defaultObject.DefaultObjectCreator;
import logc.*;
import mediaDB.Tag;
import mediaDB.Uploader;
import observerPattern.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Duration;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;


public class MockitoFinalMethodSupportTest {


    private DefaultObjectCreator client;
    private InteractiveVideoImpl interactiveVideo;
    private LicensedAudioImpl licensedAudio;
    private LicensedVideoImpl licensedVideo;
    private LicensedAudioVideoImpl licensedAudioVideo;
    private UploaderImpl uploader;
    private ArgumentCaptor<Uploader> captor;


    private ConcreteSubjectCapasity concreteSubjectCapasity;
    private BeobachterKapazitaet beobachterKapazitaet;

    private ConcreteSubjectTags concreteSubjectTags;
    private BeobachterTags beobachterTags;

    @BeforeEach
    void setUp() {

        client = new DefaultObjectCreator();

        interactiveVideo = mock(InteractiveVideoImpl.class);
        licensedAudio = mock(LicensedAudioImpl.class);
        licensedVideo = mock(LicensedVideoImpl.class);
        licensedAudioVideo = mock(LicensedAudioVideoImpl.class);
        captor = ArgumentCaptor.forClass(UploaderImpl.class);

        concreteSubjectCapasity = mock(ConcreteSubjectCapasity.class);
        beobachterKapazitaet = new BeobachterKapazitaet(concreteSubjectCapasity);

        concreteSubjectTags = mock(ConcreteSubjectTags.class);
        beobachterTags = new BeobachterTags(concreteSubjectTags);

    }


    @Test
    void testSettingMethodSpy() throws Exception {

        //InteractiveVideo

        client.createDefaultItem(interactiveVideo);

        verify(interactiveVideo).setAddress("https://de.wikipedia.org/wiki/CRUD");
        verify(interactiveVideo).setTags(Collections.singleton(Tag.Animal));
        verify(interactiveVideo).setAccessCount(25252);
        verify(interactiveVideo).setType("Documentary");
        verify(interactiveVideo).setResolution(8200);
        verify(interactiveVideo).setDate(Date.valueOf("2022-02-28"));
        verify(interactiveVideo).setDuration(Duration.ofMinutes(125));
        verify(interactiveVideo).setBitrate(BigDecimal.valueOf(53535353));
        verify(interactiveVideo).setSize(BigDecimal.valueOf(42424));

        verify(interactiveVideo).setUploader(captor.capture());
        uploader = (UploaderImpl) captor.getValue();
        assertEquals(new UploaderImpl("Tovias Nunez").getName(), uploader.getName());


        //LicensedAudio
        client.createDefaultItem(licensedAudio);
        verify(licensedAudio).setAddress("https://de.wikipedia.org/wiki/JAVA");
        verify(licensedAudio).setTags(Collections.singleton(Tag.Tutorial));
        verify(licensedAudio).setAccessCount(25252);
        verify(licensedAudio).setDate(Date.valueOf("2022-04-28"));
        verify(licensedAudio).setDuration(Duration.ofMinutes(200));
        verify(licensedAudio).setBitrate(BigDecimal.valueOf(53535353));
        verify(licensedAudio).setSize(BigDecimal.valueOf(42424));
        verify(licensedAudio).setSamplingRate(5);
        verify(licensedAudio).setHolder("holder");

        verify(licensedAudio).setUploader(captor.capture());
        uploader = (UploaderImpl) captor.getValue();
        assertEquals(new UploaderImpl("Mathias John").getName(), uploader.getName());

        //LicensedVideo

        client.createDefaultItem(licensedVideo);
        verify(licensedVideo).setTags(Collections.singleton(Tag.Tutorial));
        verify(licensedVideo).setAccessCount(25275);
        verify(licensedVideo).setResolution(8200);
        verify(licensedVideo).setDate(Date.valueOf("2022-04-28"));
        verify(licensedVideo).setDuration(Duration.ofMinutes(200));
        verify(licensedVideo).setBitrate(BigDecimal.valueOf(53535353));
        verify(licensedVideo).setSize(BigDecimal.valueOf(42424));
        verify(licensedVideo).setHolder("holder");

        verify(licensedVideo).setUploader(captor.capture());
        uploader = (UploaderImpl) captor.getValue();
        assertEquals(new UploaderImpl("Sofia Jonny").getName(), uploader.getName());


        //LicensedVideoAudio

        client.createDefaultItem(licensedAudioVideo);
        verify(licensedAudioVideo).setAddress("https://de.wikipedia.org/wiki/Phyton");
        verify(licensedAudioVideo).setTags(Collections.singleton(Tag.Tutorial));
        verify(licensedAudioVideo).setAccessCount(25275);
        verify(licensedAudioVideo).setResolution(8200);
        verify(licensedAudioVideo).setDate(Date.valueOf("2022-04-28"));
        verify(licensedAudioVideo).setDuration(Duration.ofMinutes(200));
        verify(licensedAudioVideo).setBitrate(BigDecimal.valueOf(53535353));
        verify(licensedAudioVideo).setSize(BigDecimal.valueOf(42424));
        verify(licensedAudioVideo).setHolder("holder");
        verify(licensedAudioVideo).setSamplingRate(2);
        verify(licensedAudioVideo).setUploader(captor.capture());
        uploader = (UploaderImpl) captor.getValue();
        assertEquals(new UploaderImpl("Karl Marx").getName(), uploader.getName());

    }


    @Test
    void testBeobacterCapacity() {

        // here the listener will notify the observer
        when(interactiveVideo.getSize()).thenReturn(BigDecimal.valueOf(92));
        concreteSubjectCapasity.setSize(interactiveVideo.getSize());
        verify(concreteSubjectCapasity).setSize(BigDecimal.valueOf(92));

        // here the listener would not notify the observer
        when(interactiveVideo.getSize()).thenReturn(BigDecimal.valueOf(89));
        concreteSubjectCapasity.setSize(interactiveVideo.getSize());
        verify(concreteSubjectCapasity).setSize(BigDecimal.valueOf(89));

        // verification how many times the observer will call the value from the listener
        verify(concreteSubjectCapasity, times(1)).getSize();

    }

    @Test
    void testBeobacterTag() {

        when(licensedAudioVideo.getTags()).thenReturn(Collections.singleton(Tag.Tutorial));
        concreteSubjectTags.setNewTags(licensedAudioVideo.getTags());
        verify(concreteSubjectTags).setNewTags(Collections.singleton(Tag.Tutorial));

        verify(concreteSubjectTags, times(1)).getTag();


    }


}
