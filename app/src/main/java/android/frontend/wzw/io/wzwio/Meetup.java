package android.frontend.wzw.io.wzwio;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by PELLO_ALTADILL on 22/10/2016.
 */
public class Meetup implements Serializable {
    private Long id;
    private String title;
    private String description;
    private Date date;
    private Date since;
    private Float latitude;
    private Float longitude;

    public Meetup () {

    }

    public Meetup(Long id, String title, String description, Date date, Date since, Float latitude, Float longitude) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.since = since;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Meetup{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", longitude=" + since +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

