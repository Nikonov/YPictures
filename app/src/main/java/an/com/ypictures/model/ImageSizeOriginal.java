package an.com.ypictures.model;

/**
 * Created by andrey on 10/08/14.
 */
public abstract class ImageSizeOriginal extends ImageSize {
    private int mByteSize;

    public int getByteSize() {
        return mByteSize;
    }

    public void setByteSize(int byteSize) {
        this.mByteSize = byteSize;
    }
}
