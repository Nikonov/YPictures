package an.com.ypictures.model.image;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import an.com.ypictures.model.Entry;
import an.com.ypictures.model.Links;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageEntry extends Entry {
    @JsonProperty("img")
    private ImageOptionsSize mImagesOptionsSize;
    private boolean mXXX;
    private Links mLinks;
    private boolean mHideOriginal;


    public ImageOptionsSize getImagesOptionsSize() {
        return mImagesOptionsSize;
    }

    public void setImagesOptionsSize(ImageOptionsSize imagesOptionsSize) {
        this.mImagesOptionsSize = imagesOptionsSize;
    }


    public boolean isXXX() {
        return mXXX;
    }

    public void setXXX(boolean XXX) {
        this.mXXX = XXX;
    }

    public Links getLinks() {
        return mLinks;
    }

    public void setLinks(Links links) {
        this.mLinks = links;
    }

    public boolean isHideOriginal() {
        return mHideOriginal;
    }

    public void setHideOriginal(boolean hideOriginal) {
        this.mHideOriginal = hideOriginal;
    }
}
