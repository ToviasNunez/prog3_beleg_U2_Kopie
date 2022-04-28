package observerPattern;

import logc.InteractiveVideoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConcreteSubjectCapasityTest {

    private InteractiveVideoImpl interactiveVideo;;
    private ConcreteSubjectCapasity concreteSubjectCapasity;
    private BeobachterKapazitaet beobachterKapazitaet;
    @BeforeEach
    void setUp() throws Exception {
        interactiveVideo = new InteractiveVideoImpl();
        concreteSubjectCapasity = new ConcreteSubjectCapasity();
         beobachterKapazitaet = new BeobachterKapazitaet(concreteSubjectCapasity);
        interactiveVideo.setSize(BigDecimal.valueOf(92));


    }

    @Test
    void getSize() throws Exception {


        concreteSubjectCapasity.setSize(interactiveVideo.getSize());
        assertEquals(BigDecimal.valueOf(92) , concreteSubjectCapasity.getSize());

        interactiveVideo.setSize(BigDecimal.valueOf(93));
        concreteSubjectCapasity.setSize(interactiveVideo.getSize());
        assertEquals(BigDecimal.valueOf(93) , concreteSubjectCapasity.getSize());





    }


}