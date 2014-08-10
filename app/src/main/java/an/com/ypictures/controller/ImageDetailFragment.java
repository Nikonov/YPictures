package an.com.ypictures.controller;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.appmobileos.android.utils.AndroidVersion;
import com.appmobileos.android.utils.image.ImageDownloader;

import an.com.ypictures.R;

/**
 * Created by anikonov on 4/1/14.
 */
public class ImageDetailFragment extends Fragment {
    public static final String EXTRA_URL = "extraUrl";
    public static final String TAG = "tag_image_details";
    private ImageView mImage;
    private String mImageUrl;
    private ImageDownloader mImageDownloader;

    public static ImageDetailFragment newInstance(String imageUrl) {
        ImageDetailFragment fragment = new ImageDetailFragment();
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_URL, imageUrl);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageUrl = getArguments() != null ? getArguments().getString(EXTRA_URL) : null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_image_detail, container, false);
        if (rootView != null) {
            mImage = (ImageView) rootView.findViewById(R.id.image_detail);
        }
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();
        if (activity != null && activity instanceof ImageDetailActivity) {
            mImageDownloader = ((ImageDetailActivity) activity).getImageDownloader();
            mImageDownloader.loaderBitmap(mImageUrl, mImage, ImageDownloader.MODE_LOADING_IMAGES.LOADINT_URL);
        }
        // Pass clicks on the ImageView to the parent activity to handle
        if (View.OnClickListener.class.isInstance(getActivity()) && AndroidVersion.hasHoneycomb()) {
            mImage.setOnClickListener((View.OnClickListener) getActivity());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mImage != null) {
            ImageDownloader.cancelWork(mImage);
            mImage.setImageDrawable(null);
        }
    }


}
