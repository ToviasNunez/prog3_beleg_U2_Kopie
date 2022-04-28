package logc;

import mediaDB.InteractiveVideo;
import mediaDB.Tag;
import mediaDB.Uploader;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * implementation from the InteractiveVideo interface
 */
public class InteractiveVideoImpl implements InteractiveVideo {

    private String address;
    private Collection<Tag> tags;
    private long accessCount;
    private String type;
    private BigDecimal bitrate;
    private Duration duration;
    private BigDecimal size;
    private Uploader uploader;
    private Date date;
    private int resolution;


    /**
     * default constructors
     */
    public InteractiveVideoImpl() {
        this.address = "https://de.wikipedia.org/wiki/CRUD";
        this.tags = Collections.singleton(Tag.Animal);
        this.accessCount = 1234;
        this.type = "Documentary";
        this.bitrate = BigDecimal.valueOf(123);
        this.duration = Duration.ofMinutes(125);
        this.size = BigDecimal.valueOf(1);
        this.uploader = new UploaderImpl("Tovias Nunez");
        this.date = java.sql.Date.valueOf("2000-01-1");
        this.resolution = 8200;
    }

    /**
     * @return address
     */
    @Override
    public String getAddress() {
        return this.address;
    }

    /**
     * @return Tag
     */
    @Override
    public Collection<Tag> getTags() {
        return this.tags;
    }

    /**
     * @return accessCount
     */
    @Override
    public long getAccessCount() {
        return this.accessCount;
    }

    /**
     * @return type
     */
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * @return bitrate
     */
    @Override
    public BigDecimal getBitrate() {
        return bitrate;
    }

    /**
     * @return return duration
     */
    @Override
    public Duration getLength() {
        return this.duration;
    }

    /**
     * @return size
     */
    @Override
    public BigDecimal getSize() {
        return this.size;
    }

    /**
     * @return Uploader
     */
    @Override
    public Uploader getUploader() {
        return this.uploader;
    }

    /**
     * @return date
     */
    @Override
    public Date getUploadDate() {
        return this.date;
    }

    /**
     * @return resolution
     */
    @Override
    public int getResolution() {
        return this.resolution;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param tags set the Tag of the item
     */
    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }

    /**
     * @param accessCount
     * no negative access Count it is allowed
     */
    public void setAccessCount(long accessCount) {

        if (accessCount < 0) {
            throw new IllegalArgumentException("Not negative accessCount is allow");
        } else

            this.accessCount = accessCount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBitrate(BigDecimal bitrate) {
        if (bitrate.intValue() <= 768000) {
            throw new IllegalArgumentException("Bitrate too small 768000");
        } else
            this.bitrate = bitrate;

    }

    /**
     * @param duration  how long the video can be play
     *          duration can not be negative
     */
    public void setDuration(Duration duration) {
        if (duration.isNegative()) {
            throw new IllegalArgumentException("negative duration not allowed");
        } else

            this.duration = duration;
    }

    /**
     * @param size of the interactive video
     * @throws Exception size can not be negative
     */
    public void setSize(BigDecimal size) throws Exception {
        if (size.intValue() < 0) {
            throw new IllegalArgumentException("Illegal size");
        } else
            this.size = size;
    }

    /**
     * @param uploader who create the item
     */
    public void setUploader(Uploader uploader) {
        if (uploader == null && uploader.getName().equals("MUSTERMAN")) {
           throw new IllegalArgumentException("Uploader should no be null or musterman");
        }else
            this.uploader = uploader;

    }

    /**
     * @param date that the item was created
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @param resolution quality from video
     * @throws Exception resolution can not be under 480px
     */
    public void setResolution(int resolution) throws Exception {
        if (resolution < 480) {
            throw new IllegalArgumentException("Resolution is not gut enough");
        } else
            this.resolution = resolution;


    }

    /**
     * @return all the information from the interaction video
     */
    @Override
    public String toString() {
        return System.lineSeparator() +
                "InteractiveVideo{" +
                "address='" + address + '\'' +
                ", tags=" + tags +
                ", accessCount=" + accessCount +
                ", type='" + type + '\'' +
                ", bitrate=" + bitrate +
                ", duration=" + duration +
                ", size=" + size +
                ", uploader=" + uploader +
                ", date=" + date +
                ", resolution=" + resolution +
                '}'
                + System.lineSeparator();
    }
}
