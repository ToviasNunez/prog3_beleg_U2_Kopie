package logc;

import mediaDB.LicensedAudioVideo;
import mediaDB.Tag;
import mediaDB.Uploader;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * licensed audio video
 */
public class LicensedAudioVideoImpl implements LicensedAudioVideo {

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
    private int samplingRate;

    /**
     * default constructor
     */
    public LicensedAudioVideoImpl() {
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
        this.samplingRate = 5;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param tags
     */
    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }

    /**
     * @param accessCount should not be negative
     */
    public void setAccessCount(long accessCount) {
        if (accessCount < 0) {
            throw new IllegalArgumentException("AccessCount should not be negative");
        } else
            this.accessCount = accessCount;

    }


    /**
     * @param bitrate should not be smaller that xxxx
     */
    public void setBitrate(BigDecimal bitrate) {
        if (bitrate.intValue() < 290000) {
            throw new IllegalArgumentException("Bitrate should not be smaller that 290000");
        } else
            this.bitrate = bitrate;

    }

    /**
     * @param duration should not be negative
     */
    public void setDuration(Duration duration) {
        if (duration.isNegative())
            throw new IllegalArgumentException("Duration should not negative");
        else
            this.duration = duration;

    }

    /**
     * @param size should not be negative
     */
    public void setSize(BigDecimal size) {
        if (size.intValue()<0)
            throw  new IllegalArgumentException("Size should be negative");
        else
            this.size = size;

    }

    /**
     * @param uploader should not be null or musterman
     */
    public void setUploader(Uploader uploader) {
        if (uploader == null || uploader.getName().equals("MUSTERMAN"))
            throw new IllegalArgumentException("Uploader is not allow");
        else
            this.uploader = uploader;

    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @param resolution should be under xxxxxx
     */
    public void setResolution(int resolution) {
        if (resolution < 420){
            throw new IllegalArgumentException("Resolution it is not enough");
        }
        else
            this.resolution = resolution;

    }

    /**
     * @param holder
     */
    public void setHolder(String holder) {
        this.holder = holder;
    }

    /**
     * @param samplingRate should not be negative
     */
    public void setSamplingRate(int samplingRate) {
        if (samplingRate<0)
            throw new IllegalArgumentException("samplingRate should not be negative");
        else
            this.samplingRate = samplingRate;

    }

    /**
     * @return samplingRate
     */
    @Override
    public int getSamplingRate() {
        return samplingRate;
    }

    /**
     * @return address
     */
    @Override
    public String getAddress() {
        return this.address;
    }

    /**
     * @return tags
     */
    @Override
    public Collection<Tag> getTags() {
        return this.tags;
    }

    /**
     * @return access count
     */
    @Override
    public long getAccessCount() {
        return this.accessCount;
    }

    /**
     * @return the holder
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
        return this.bitrate;
    }

    /**
     * @return return the duration that the licensedaudiovideo can be played
     */
    @Override
    public Duration getLength() {
        return this.duration;
    }

    /**
     * @return the size of the item
     */
    @Override
    public BigDecimal getSize() {
        return this.size;
    }

    /**
     * @return the information form the uploader
     */
    @Override
    public Uploader getUploader() {
        return this.uploader;
    }

    /**
     * @return the date was the item was uploader
     */
    @Override
    public Date getUploadDate() {
        return this.date;
    }

    /**
     * @return return the resolution
     */
    @Override
    public int getResolution() {
        return this.resolution;
    }

    /**
     * @return all information from the licensed audio video
     */
    @Override
    public String toString() {
        return System.lineSeparator() +
                "LicensedAudioVideoImpl{" +
                "address='" + address + '\'' +
                ", tags=" + tags +
                ", accessCount=" + accessCount +
                ", bitrate=" + bitrate +
                ", duration=" + duration +
                ", size=" + size +
                ", uploader=" + uploader +
                ", date=" + date +
                ", resolution=" + resolution +
                ", holder='" + holder + '\'' +
                ", samplingRate=" + samplingRate +
                '}'
                + System.lineSeparator();
    }
}
