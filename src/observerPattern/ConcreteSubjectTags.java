package observerPattern;

import logc.G_logik;
import mediaDB.Tag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * listener will be notified the notification when new Tags is added
 */
public class ConcreteSubjectTags implements Subject {

    List<Beobachter> beobachterList = new ArrayList<>();
    G_logik g_logik = new G_logik();

    /**
     * @param beobachter  will be added from the list
     */
    @Override
    public void meldeAn(Beobachter beobachter) {
        beobachterList.add(beobachter);
    }

    /**
     * @param beobachter  will be removed from the list
     */
    @Override
    public void meldeAb(Beobachter beobachter) {
        beobachterList.remove(beobachter);
    }

    /**
     * the observer will be notified
     */
    @Override
    public void notificate() {

        for (Beobachter beobachter : beobachterList) {

           beobachter.update();
        }
    }

    private Collection<Tag> tag;

    public Collection<Tag> getTag() {
        return tag;
    }

    /**
     * @param tag  new value that will be notified to the observer
     */
    public void setNewTags(Collection<Tag> tag){

        this.tag = tag;
        notificate();
    }

}
