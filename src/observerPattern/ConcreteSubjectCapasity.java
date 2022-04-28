package observerPattern;

import logc.G_logik;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * notified the observer in the case the argument is true
 */
public class ConcreteSubjectCapasity implements Subject {

    private List<Beobachter> beobachtersCapacityList = new ArrayList<>();

    /**
     * @param beobachter  will be removed
     */
    @Override
    public void meldeAn(Beobachter beobachter) {

        beobachtersCapacityList.add(beobachter);
    }

    /**
     * @param beobachter  will be added
     */
    @Override
    public void meldeAb(Beobachter beobachter) {
        beobachtersCapacityList.remove(beobachter);
    }

    /**
     * notified the observer
     */
    @Override
    public void notificate() {
        for (Beobachter beobachter : beobachtersCapacityList) {
            beobachter.update();
        }
    }

    private BigDecimal size ;


    /**
     * @return the size value
     */
    public BigDecimal getSize() {
        return size;
    }

    /**
     * @param size  setting if the data over cross the 90% will be notified the observer
     */
    public void setSize(BigDecimal size) {

        this.size = size;
       double max = G_logik.maxsize;
       double alert = max*90/100;
        if(this.size.compareTo(BigDecimal.valueOf(alert)) > 0){
            this.notificate();
        }



    }
}
