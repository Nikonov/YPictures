package an.com.ypictures.model;

/**
 * Created by andrey on 10/08/14.
 */
public abstract class ImageSize {
    private int mWidth;
    private int mHeight;
    private String mHref;

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

    public String getHref() {
        return mHref;
    }

    public void setHref(String href) {
        this.mHref = href;
    }
}
