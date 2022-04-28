package logc;

import mediaDB.LicensedVideo;
import mediaDB.Tag;
import mediaDB.Uploader;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class LicensedVideoImpl implements LicensedVideo {

    private String address;
    private Collection<Tag> tags;
    private long accessCount;
    private BigDecimal bitrate;
    private Duration duration;
    private BigDecimal size;
    private Uploader uploader;
    private Date date;
    private int resolution;
    private String holder;

    /**
     * default constructor
     */
    public LicensedVideoImpl() {
        this.address = "https://de.wikipedia.org/wiki/CRUD";
        this.tags = Collections.singleton(Tag.Animal);
        this.accessCount = 1234;
        this.bitrate = BigDecimal.valueOf(123);
        this.duration = Duration.ofMinutes(125);
        this.size = BigDecimal.valueOf(1);
        this.uploader = new UploaderImpl("Tovias Nunez");
        this.date = java.sql.Date.valueOf("2000-01-1");
        this.holder = "holder";
        this.resolution = 8200;

    }

    /**
     * @param address
     * setting the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param tags
     * setting the tags
     */
    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }

    /**
     * @param accessCount
     * setting the accessCount should not be negative
     */
    public void setAccessCount(long accessCount) {
        if (accessCount<0){
            throw new IllegalArgumentException("AccessCount should no be negative");
        }
        else
            this.accessCount = accessCount;

    }


    /**
     * @param bitrate
     * setting the bitrate should no smaller than 2900000
     */
    public void setBitrate(BigDecimal bitrate) {
        if (bitrate.intValue()<290000){
            throw new IllegalArgumentException("Bitrate should not be under 2900000");
        }else
            this.bitrate = bitrate;

    }

    /**
     * @param duration
     * setting the duration from the video should not negative
     */
    public void setDuration(Duration duration) {
        if (duration.isNegative()){
            throw new IllegalArgumentException("Duration do not should be negative");
        }else
            this.duration = duration;

    }

    /**
     * @param size
     * setting the size from the video should not be negative
     */
    public void setSize(BigDecimal size) {
        if (size.intValue()<0)
            throw new IllegalArgumentException("size should no be negative");
        else
            this.size = size;

    }

    /**
     * @param uploader  set information from the Uploader
     *                  should no null or musterman
     */
    public void setUploader(Uploader uploader) {
        if (uploader == null || uploader.getName().equals("MUSTERMAN"))
            throw new IllegalArgumentException("Uploader should not be null or musterman");
        else
            this.uploader = uploader;

    }

    /**
     * @param date  set the date that the video was created
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @param resolution  from the video should not be under 420 px
     */
    public void setResolution(int resolution) {
        if (resolution<420){
            throw new IllegalArgumentException("Resolution should not be under 420px");
        }else
            this.resolution = resolution;

    }

    /**
     * @param holder
     * setting the holder
     */
    public void setHolder(String holder) {
        this.holder = holder;
    }

    /**
     * @return the address
     */
    @Override
    public String getAddress() {
        return this.address;
    }

    /**
     * @return  tag
     */
    @Override
    public Collection<Tag> getTags() {
        return this.tags;
    }

    /**
     * @return  access count
     */
    @Override
    public long getAccessCount() {
        return this.accessCount;
    }

    /**
     * @return  the holder
     */
    @Override
    public String getHolder() {
        return this.holder;
    }

    /**
     * @return the bitrate
     */
    @Override
    public BigDecimal getBitrate() {
        return bitrate;
    }

    /**
     * @return  the duration from the video
     */
    @Override
    public Duration getLength() {
        return this.duration;
    }

    /**
     * @return the size from the licensed video
     */
    @Override
    public BigDecimal getSize() {
        return size;
    }

    /**
     * @return  the information from Uploader
     */
    @Override
    public Uploader getUploader() {
        return this.uploader;
    }

    /**
     * @return  the date from the video was uploaded
     */
    @Override
    public Date getUploadDate() {
        return this.date;
    }

    /**
     * @return return the resolution from the licensed video
     */
    @Override
    public int getResolution() {
        return this.resolution;
    }

    /**
     * @return all information from the licensed video
     */
    @Override
    public String toString() {
        return System.lineSeparator() +
                "LicensedVideo{" +
                "address='" + this.address + '\'' +
                ", tags=" + this.tags +
                ", accessCount=" + this.accessCount +
                ", bitrate=" + this.bitrate +
                ", duration=" + this.duration +
                ", size=" + this.size +
                ", uploader=" + this.uploader +
                ", date=" + this.date +
                ", resolution=" + this.resolution +
                ", holder='" + this.holder + '\'' +
                '}' + System.lineSeparator();
    }
}
