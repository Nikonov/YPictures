package an.com.ypictures;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

import com.appmobileos.android.utils.file.FileUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by andrey on 10/08/14.
 */
public class MainActivity extends Activity {
    private static final String LAST_PICTURES_URL = "http://api-fotki.yandex.ru/api/recent/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                searchLastPhotos();
            }
        }).start();
    }

    private void searchLastPhotos() {
        try {
            URL urlPictures = new URL(LAST_PICTURES_URL);
            HttpURLConnection connection = (HttpURLConnection) urlPictures.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestProperty("Accept", "application/json");
            connection.connect();
            InputStream in = new BufferedInputStream(connection.getInputStream());
            if (BuildConfig.DEBUG) {
                FileUtils.saveISInFile(in, new File(Environment.getExternalStorageDirectory(), "y.json"));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
