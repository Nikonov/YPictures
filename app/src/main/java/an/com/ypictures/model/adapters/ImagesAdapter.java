package an.com.ypictures.model.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.appmobileos.android.utils.image.ImageDownloader;

import java.util.List;

import an.com.ypictures.R;
import an.com.ypictures.model.Entry;
import an.com.ypictures.model.image.ImageEntry;

/**
 * Created by andrey on 10/08/14.
 */
public class ImagesAdapter extends ArrayAdapter<Entry> {
    private LayoutInflater mInflater;
    private ImageDownloader mImageDownloader;
    private int mItemHeight;
    private GridView.LayoutParams mImageViewLayoutParams;


    public ImagesAdapter(Context context, int resource, List<Entry> objects, ImageDownloader downloader) {
        super(context, resource);
        if (objects != null) {
            addAll(objects);
        }
        mImageDownloader = downloader;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mImageViewLayoutParams = new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View rootView = convertView;
        if (convertView == null) {
            rootView = mInflater.inflate(R.layout.item_image_adapter, parent, false);
            holder = new ViewHolder();
            holder.icon = (ImageView) rootView.findViewById(R.id.place_icon);
            holder.icon.setLayoutParams(mImageViewLayoutParams);
            rootView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Check the height matches our calculated column width
        if (holder.icon.getLayoutParams().height != mItemHeight) {
            holder.icon.setLayoutParams(mImageViewLayoutParams);
        }
        Entry place = getItem(position);
        if(place instanceof ImageEntry){
            mImageDownloader.loaderBitmap(((ImageEntry) place).getImagesOptionsSize().getL().getHref(), holder.icon, ImageDownloader.MODE_LOADING_IMAGES.LOADINT_URL);
        }
        return rootView;
    }

    public void updateData(List<Entry> newValue) {
        clear();
        if (newValue != null) {
            addAll(newValue);
        }
    }

    public void setItemHeight(int columnHeight) {
        if (columnHeight == mItemHeight) {
            return;
        }
        mItemHeight = columnHeight;
        mImageViewLayoutParams = new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mItemHeight);
        mImageDownloader.setImageSize(columnHeight);
        notifyDataSetChanged();
    }

    private class ViewHolder {
        ImageView icon;
    }
}
