package an.com.ypictures.model;

import java.util.ArrayList;

/**
 * Created by andrey on 10/08/14.
 */
public class ImageResponse {
    private ArrayList<Entry> mEntries;
    private String mId;
    private Links mLinks;
    private String mTitle;
    private String mUpdated;

    public ArrayList<Entry> getEntries() {
        return mEntries;
    }

    public void setEntries(ArrayList<Entry> entries) {
        this.mEntries = entries;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getUpdated() {
        return mUpdated;
    }

    public void setUpdated(String updated) {
        this.mUpdated = updated;
    }

    public Links getLinks() {
        return mLinks;
    }

    public void setLinks(Links links) {
        this.mLinks = links;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }
}
