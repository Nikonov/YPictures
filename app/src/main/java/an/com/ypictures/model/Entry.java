package an.com.ypictures.model;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import an.com.ypictures.model.image.ImageEntry;


@JsonDeserialize(as = ImageEntry.class)
public abstract class Entry {
    private String mEdited;
    private String mUpdated;
    private String mTitle;
    private String mAuthor;
    private String mAccess;
    private String mCreated;
    private boolean mDisableComments;
    private String mId;
    private String mPublished;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        this.mAuthor = author;
    }

    public String getEdited() {
        return mEdited;
    }

    public void setEdited(String edited) {
        this.mEdited = edited;
    }

    public String getUpdated() {
        return mUpdated;
    }

    public void setUpdated(String updated) {
        this.mUpdated = updated;
    }

    public String getAccess() {
        return mAccess;
    }

    public void setAccess(String access) {
        this.mAccess = access;
    }

    public String getCreated() {
        return mCreated;
    }

    public void setCreated(String created) {
        this.mCreated = created;
    }

    public boolean isDisableComments() {
        return mDisableComments;
    }

    public void setDisableComments(boolean disableComments) {
        this.mDisableComments = disableComments;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getPublished() {
        return mPublished;
    }

    public void setPublished(String published) {
        this.mPublished = published;
    }
}
