package an.com.ypictures.controller;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;

import com.appmobileos.android.utils.image.ImageDownloader;

import an.com.ypictures.R;

/**
 * Created by anikonov on 4/1/14.
 */
public class ImageDetailActivity extends Activity {
    public static final String EXTRA_TITLE = "extraTitle";
    private static final String TAG = "ImageDetailActivity";
    private ImageDownloader mImageDownloader;
    private String mImageUrl;
    private String mImageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        final ActionBar actionBar = getActionBar();
        initImageDownloader();
        Intent intent = getIntent();
        if (intent != null) {
            mImageUrl = intent.getStringExtra(ImageDetailFragment.EXTRA_URL);
            mImageTitle = intent.getStringExtra(EXTRA_TITLE);
            if (mImageUrl != null) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.image_container, ImageDetailFragment.newInstance(mImageUrl), ImageDetailFragment.TAG);
                transaction.commit();
            }
            if (mImageTitle != null) {
                initActionBar(actionBar, mImageTitle);
            }
        }
    }

    private void initImageDownloader() {
        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        final int height = metrics.heightPixels;
        final int width = metrics.widthPixels;
        final int longest = (height > width ? height : width) / 2;
        mImageDownloader = new ImageDownloader(longest, getApplicationContext());
        mImageDownloader.setImageFadeIn(false);
    }

    private void initActionBar(ActionBar actionBar, String title) {
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public ImageDownloader getImageDownloader() {
        return mImageDownloader;
    }
}
