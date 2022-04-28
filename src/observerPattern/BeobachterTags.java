package observerPattern;

import logc.G_logik;
import mediaDB.Tag;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * will be notified  from the listener
 */
public class BeobachterTags implements Beobachter{

    private ConcreteSubjectTags concreteSubjectTags;
    private Collection<Tag> altTags;


    /**
     * @param concreteSubjectTags from listener
     *                            the connection with the listener
     */
    public BeobachterTags(ConcreteSubjectTags concreteSubjectTags){
        this.concreteSubjectTags = concreteSubjectTags;
        this.concreteSubjectTags.meldeAn(this);
        this.altTags = this.concreteSubjectTags.getTag();
    }

    @Override
    public void update() {
        Collection<Tag> newTags = concreteSubjectTags.getTag();
     if (altTags != newTags)
         System.out.println("The tags had been changed " + newTags);



    }
}
