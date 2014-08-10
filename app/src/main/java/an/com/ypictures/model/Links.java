package an.com.ypictures.model;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import an.com.ypictures.model.image.ImageLinks;

@JsonDeserialize(as = ImageLinks.class)
public abstract class Links {
    private String mAlbum;
    private String mEditMedia;
    private String mSelf;
    private String mAlternate;
    private String mEdit;

    public String getAlbum() {
        return mAlbum;
    }

    public void setAlbum(String album) {
        this.mAlbum = album;
    }

    public String getEditMedia() {
        return mEditMedia;
    }

    public void setEditMedia(String editMedia) {
        this.mEditMedia = editMedia;
    }

    public String getSelf() {
        return mSelf;
    }

    public void setSelf(String self) {
        this.mSelf = self;
    }

    public String getAlternate() {
        return mAlternate;
    }

    public void setAlternate(String alternate) {
        this.mAlternate = alternate;
    }

    public String getEdit() {
        return mEdit;
    }

    public void setEdit(String edit) {
        this.mEdit = edit;
    }
}
