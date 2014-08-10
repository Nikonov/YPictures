package an.com.ypictures.model;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import an.com.ypictures.model.image.ImageSize;

@JsonDeserialize(as = ImageSize.class)
public abstract class Size {
    private int mWidth;
    private int mHeight;

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        this.mWidth = width;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        this.mHeight = height;
    }
}
