package observerPattern;

import logc.InteractiveVideoImpl;
import mediaDB.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class BeobachterTagsTest {
   private  ConcreteSubjectTags  concreteSubjectTags;
    private InteractiveVideoImpl interactiveVideo;

    @BeforeEach
    void setUp(){
        concreteSubjectTags = new ConcreteSubjectTags();
        BeobachterTags beobachterTags = new BeobachterTags(concreteSubjectTags);
        interactiveVideo = new InteractiveVideoImpl();
    }


    @Test
    void testUpdate() {
        interactiveVideo.setTags(Collections.singleton(Tag.Animal));
        concreteSubjectTags.setNewTags(interactiveVideo.getTags());




    }
}