package logc;

import mediaDB.InteractiveVideo;
import mediaDB.Licensed;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * create item: data media , store into a list , remove from the list
 * completed administration from data
 * memory has a capacity only for 10 items
 */
public class Darstellung_logic {


    private final AtomicBoolean atomicBoolean = new AtomicBoolean();
    private  List<Object> itemsList = new ArrayList<>();
    private final AtomicInteger atomicInteger = new AtomicInteger();
    private final static int MAXSTOREDITEMS = 10;

    /**
     * here will be created  an empty item
     *
     * @param objc the object that will be created
     * @return new object was create (items)
     */
    public Object createItem(Object objc) throws Exception {

        if (objc instanceof InteractiveVideoImpl)
            objc = new InteractiveVideoImpl();
        if (objc instanceof LicensedAudioImpl)
            objc = new LicensedAudioImpl();
        if (objc instanceof LicensedVideoImpl)
            objc = new LicensedVideoImpl();
        if (objc instanceof LicensedAudioVideoImpl)
            objc = new LicensedAudioVideoImpl();

        return objc;
    }

    /**
     * @param neu item
     * @param old old item
     * @return true or false if the action was possible
     */
    public boolean updateItems(Object neu, Object old) {



        if (itemsList.contains(old)) {

            itemsList.remove(old);
            itemsList.add(neu);
            atomicBoolean.set(true);
        }
        else
            atomicBoolean.set(false);


        return atomicBoolean.get();
    }

    /**
     * @param obj item add a new item to the list and occupated a new place in the capacity
     */
    public Boolean addItems(Object obj) throws Exception {
        if (atomicInteger.get() < MAXSTOREDITEMS) {
            if (obj instanceof  Licensed|| obj instanceof InteractiveVideo){
                itemsList.add(obj);
                atomicInteger.incrementAndGet();
                atomicBoolean.set(true);
            }else
                throw  new IllegalArgumentException("the argument is not valid");

        } else {
            atomicBoolean.set(false);
            throw new Exception("Sorry we don`t have Capacity now for");
        }
        return atomicBoolean.get();
    }


    /**
     * will be removed the item from the list and will be created a place for new item
     *
     * @param obj item
     * @return
     */
    public boolean removeItems(Object obj) {

        if (!itemsList.isEmpty()){
            itemsList.remove(obj);
            atomicInteger.decrementAndGet();
            atomicBoolean.set(true);
        }else
            atomicBoolean.set(false);


        return atomicBoolean.get();
    }

    /**
     * @return the list with the information from item and id
     */
    public List<?> getItemsList() {
        return itemsList;
    }


}
