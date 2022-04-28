package defaultObject;

import logc.*;
import mediaDB.Licensed;
import mediaDB.Tag;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Duration;
import java.util.Collections;

public class DefaultObjectCreator {


    public  Object createDefaultItem(Object objc) throws Exception {

        if (objc instanceof InteractiveVideoImpl) {

            ((InteractiveVideoImpl) objc).setAddress("https://de.wikipedia.org/wiki/CRUD");
            ((InteractiveVideoImpl) objc).setTags(Collections.singleton(Tag.Animal));
            ((InteractiveVideoImpl) objc).setAccessCount(25252);
            ((InteractiveVideoImpl) objc).setType("Documentary");
            ((InteractiveVideoImpl) objc).setResolution(8200);
            ((InteractiveVideoImpl) objc).setUploader(new UploaderImpl("Tovias Nunez"));
            ((InteractiveVideoImpl) objc).setDate(Date.valueOf("2022-02-28"));
            ((InteractiveVideoImpl) objc).setDuration(Duration.ofMinutes(125));
            ((InteractiveVideoImpl) objc).setBitrate(BigDecimal.valueOf(53535353));
            ((InteractiveVideoImpl) objc).setSize(BigDecimal.valueOf(42424));


        }


        if (objc instanceof Licensed) {

            if (objc instanceof LicensedAudioImpl) {
                ((LicensedAudioImpl) objc).setAddress("https://de.wikipedia.org/wiki/JAVA");
                ((LicensedAudioImpl) objc).setTags(Collections.singleton(Tag.Tutorial));
                ((LicensedAudioImpl) objc).setAccessCount(25252);
                ((LicensedAudioImpl) objc).setUploader(new UploaderImpl("Mathias John"));
                ((LicensedAudioImpl) objc).setDate(Date.valueOf("2022-04-28"));
                ((LicensedAudioImpl) objc).setDuration(Duration.ofMinutes(200));
                ((LicensedAudioImpl) objc).setBitrate(BigDecimal.valueOf(53535353));
                ((LicensedAudioImpl) objc).setSize(BigDecimal.valueOf(42424));
                ((LicensedAudioImpl) objc).setSamplingRate(5);
                ((LicensedAudioImpl) objc).setHolder("holder");
            }

            if (objc instanceof LicensedVideoImpl) {
                ((LicensedVideoImpl) objc).setAddress("https://de.wikipedia.org/wiki/C#");
                ((LicensedVideoImpl) objc).setTags(Collections.singleton(Tag.Tutorial));
                ((LicensedVideoImpl) objc).setAccessCount(25275);
                ((LicensedVideoImpl) objc).setResolution(8200);
                ((LicensedVideoImpl) objc).setUploader(new UploaderImpl("Sofia Jonny"));
                ((LicensedVideoImpl) objc).setDate(Date.valueOf("2022-04-28"));
                ((LicensedVideoImpl) objc).setDuration(Duration.ofMinutes(200));
                ((LicensedVideoImpl) objc).setBitrate(BigDecimal.valueOf(53535353));
                ((LicensedVideoImpl) objc).setSize(BigDecimal.valueOf(42424));
                ((LicensedVideoImpl) objc).setHolder("holder");
            }

            if (objc instanceof LicensedAudioVideoImpl) {
                ((LicensedAudioVideoImpl) objc).setAddress("https://de.wikipedia.org/wiki/Phyton");
                ((LicensedAudioVideoImpl) objc).setTags(Collections.singleton(Tag.Tutorial));
                ((LicensedAudioVideoImpl) objc).setAccessCount(25275);
                ((LicensedAudioVideoImpl) objc).setResolution(8200);
                ((LicensedAudioVideoImpl) objc).setUploader(new UploaderImpl("Karl Marx"));
                ((LicensedAudioVideoImpl) objc).setDate(Date.valueOf("2022-04-28"));
                ((LicensedAudioVideoImpl) objc).setDuration(Duration.ofMinutes(200));
                ((LicensedAudioVideoImpl) objc).setBitrate(BigDecimal.valueOf(53535353));
                ((LicensedAudioVideoImpl) objc).setSize(BigDecimal.valueOf(42424));
                ((LicensedAudioVideoImpl) objc).setHolder("holder");
                ((LicensedAudioVideoImpl) objc).setSamplingRate(2);
            }


        }


        return objc;
    }
}
