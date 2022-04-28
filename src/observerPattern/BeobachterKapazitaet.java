package observerPattern;

import logc.G_logik;

import java.math.BigDecimal;
import java.util.Objects;

public class BeobachterKapazitaet implements Beobachter {

    private ConcreteSubjectCapasity concreteSubjectCapasity;
    private BigDecimal altSize;
   // private G_logik g_logik = new G_logik();

    public BeobachterKapazitaet(ConcreteSubjectCapasity concreteSubjectCapasity){

        this.concreteSubjectCapasity=concreteSubjectCapasity;
        this.concreteSubjectCapasity.meldeAn(this);
        this.altSize=this.concreteSubjectCapasity.getSize();
    }

    @Override
    public void update() {
        BigDecimal newSize = concreteSubjectCapasity.getSize();
        if (!Objects.equals(newSize, this.altSize)){
            System.out.println("The data use the more that 90% from the capacity, the data is " + newSize + " big");
        }

    }
}
