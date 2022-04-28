package observerPattern;

public interface  Subject {

    void meldeAn(Beobachter beobachter);

    void meldeAb(Beobachter beobachter);

    void notificate();

}
