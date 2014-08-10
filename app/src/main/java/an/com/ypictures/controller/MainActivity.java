package an.com.ypictures.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import an.com.ypictures.R;

/**
 * Created by andrey on 10/08/14.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);
    }

}
