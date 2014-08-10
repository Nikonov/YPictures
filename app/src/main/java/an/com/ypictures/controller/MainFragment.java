package an.com.ypictures.controller;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.appmobileos.android.utils.image.ImageCache;
import com.appmobileos.android.utils.image.ImageDownloader;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import an.com.ypictures.BuildConfig;
import an.com.ypictures.R;
import an.com.ypictures.model.Response;
import an.com.ypictures.model.adapters.ImagesAdapter;

/**
 * Created by andrey on 10/08/14.
 */
public class MainFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static final String LAST_PICTURES_URL = "http://api-fotki.yandex.ru/api/recent/";
    private static final String TAG = "MainFragment";
    private static final String IMAGE_CACHE_DIR = "thumbs";
    private ImagesAdapter mImagesAdapter;
    private GridView mGridInfo;
    private TextView mEmptyPlaces;
    private ImageDownloader mImageDownloader;
    private int mImageThumbnailSize = 100; //default size
    private int mImageThumbnailSpacing = 1;//default size

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Activity activity = getActivity();
        if (activity != null) {
            ImageCache.ImageCacheParameters cacheParameters = new ImageCache.ImageCacheParameters(activity, IMAGE_CACHE_DIR);
            cacheParameters.setMemCacheSizePercent(0.3f);
            Resources resources = getResources();
            if (resources != null) {
                mImageThumbnailSize = resources.getDimensionPixelOffset(R.dimen.image_thumbnail);
                mImageThumbnailSpacing = resources.getDimensionPixelOffset(R.dimen.image_thumbnail_vertical_spacing);
            }
            mImageDownloader = new ImageDownloader(mImageThumbnailSize, activity);
            mImageDownloader.addImageCache(activity.getFragmentManager(), cacheParameters);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        if (rootView != null) {
            mGridInfo = (GridView) rootView.findViewById(R.id.images);
            mEmptyPlaces = (TextView) rootView.findViewById(R.id.empty_places);
            mEmptyPlaces.setOnClickListener(this);
            mGridInfo.setEmptyView(mEmptyPlaces);
            mGridInfo.setOnItemClickListener(this);
            final ViewTreeObserver viewTreeObserver = mGridInfo.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        final int numberColumns = (int) Math.floor(mGridInfo.getWidth() / (mImageThumbnailSize + mImageThumbnailSpacing));
                        if (numberColumns > 0) {
                            final int columnWidth = (mGridInfo.getWidth() / numberColumns) - mImageThumbnailSpacing;

                            mImagesAdapter.setItemHeight(columnWidth);

                            if (viewTreeObserver.isAlive()) {
                                viewTreeObserver.removeGlobalOnLayoutListener(this);
                            } else {
                                ViewTreeObserver viewTreeObserver = mGridInfo.getViewTreeObserver();
                                if (viewTreeObserver != null) {
                                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                                }
                            }
                        }
                    }
                });
            }
        }
        return rootView;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mImagesAdapter = new ImagesAdapter(getActivity(), R.layout.item_image_adapter, null, mImageDownloader);
        mGridInfo.setAdapter(mImagesAdapter);
        new DownloadImages().execute();
    }

    private class DownloadImages extends AsyncTask<Void, Void, Response> {
        @Override
        protected Response doInBackground(Void... voids) {
            Response response = null;
            try {
                HttpURLConnection connection = null;
                BufferedInputStream inputStream = null;
                try {
                    URL urlPictures = new URL(LAST_PICTURES_URL);
                    connection = (HttpURLConnection) urlPictures.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);
                    connection.setUseCaches(false);
                    connection.setRequestProperty("Accept", "application/json");
                    connection.connect();
                    inputStream = new BufferedInputStream(connection.getInputStream());
                    ObjectMapper mapper = new ObjectMapper();
                    response = mapper.readValue(inputStream, Response.class);
                    if (BuildConfig.DEBUG) {
                        Log.d(TAG, "Found entries = " + response.getEntries().size());
                    }
                } finally {
                    if (connection != null) connection.disconnect();
                    if (inputStream != null) inputStream.close();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(Response response) {
            if (response != null) {
               mImagesAdapter.updateData(response.getEntries());
            }
        }
    }
}
