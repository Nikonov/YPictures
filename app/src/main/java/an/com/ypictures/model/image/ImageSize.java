package an.com.ypictures.model.image;

import org.codehaus.jackson.annotate.JsonProperty;

import an.com.ypictures.model.Size;

/**
 * Created by andrey on 10/08/14.
 */
public class ImageSize extends Size {
    private String mHref;
    @JsonProperty("bytesize")
    private int mByteSize;

    public String getHref() {
        return mHref;
    }

    public void setHref(String href) {
        this.mHref = href;
    }

    public int getByteSize() {
        return mByteSize;
    }

    public void setByteSize(int byteSize) {
        this.mByteSize = byteSize;
    }
}
