package an.com.ypictures.model.image;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by andrey on 10/08/14.
 */
public class ImageOptionsSize {
    @JsonProperty("XXS")
    private ImageSize mXXS;
    @JsonProperty("XL")
    private ImageSize mXL;
    @JsonProperty("M")
    private ImageSize mM;
    @JsonProperty("L")
    private ImageSize mL;
    @JsonProperty("XXXS")
    private ImageSize mXXXS;
    @JsonProperty("XXXL")
    private ImageSize mXXXL;
    @JsonProperty("S")
    private ImageSize mS;
    @JsonProperty("XS")
    private ImageSize mXS;
    @JsonProperty("XXL")
    private ImageSize mXXL;
    @JsonProperty("orig")
    private ImageSize mOriginal;

    public ImageSize getXXS() {
        return mXXS;
    }

    public void setXXS(ImageSize XXS) {
        this.mXXS = XXS;
    }

    public ImageSize getXL() {
        return mXL;
    }

    public void setXL(ImageSize XL) {
        this.mXL = XL;
    }

    public ImageSize getM() {
        return mM;
    }

    public void setM(ImageSize M) {
        this.mM = M;
    }

    public ImageSize getL() {
        return mL;
    }

    public void setL(ImageSize L) {
        this.mL = L;
    }

    public ImageSize getXXXS() {
        return mXXXS;
    }

    public void setXXXS(ImageSize XXXS) {
        this.mXXXS = XXXS;
    }

    public ImageSize getXXXL() {
        return mXXXL;
    }

    public void setXXXL(ImageSize XXXL) {
        this.mXXXL = XXXL;
    }

    public ImageSize getS() {
        return mS;
    }

    public void setS(ImageSize S) {
        this.mS = S;
    }

    public ImageSize getXS() {
        return mXS;
    }

    public void setXS(ImageSize XS) {
        this.mXS = XS;
    }

    public ImageSize getXXL() {
        return mXXL;
    }

    public void setXXL(ImageSize XXL) {
        this.mXXL = XXL;
    }

    public ImageSize getOriginal() {
        return mOriginal;
    }

    public void setOriginal(ImageSize original) {
        this.mOriginal = original;
    }
}
