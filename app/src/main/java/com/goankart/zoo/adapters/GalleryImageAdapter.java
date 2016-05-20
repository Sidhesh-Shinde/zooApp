package com.goankart.zoo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.goankart.zoo.R;
import com.goankart.zoo.models.GalleryImage;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by user on 17/11/2015.
 */
public class GalleryImageAdapter extends ArrayAdapter<GalleryImage> {

    public GalleryImageAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_gallery_thumbnail, parent, false);
            holder.progress = (ProgressBar) convertView.findViewById(R.id.progress);
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.image.setVisibility(View.GONE);
        holder.progress.setVisibility(View.VISIBLE);

        final ViewHolder tmp = holder;

        Picasso.with(getContext()).load(getItem( position ).getThumbnail()).into(holder.image, new Callback() {
            @Override
            public void onSuccess() {
                tmp.progress.setVisibility(View.GONE);
                tmp.image.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError() {
                tmp.progress.setVisibility(View.GONE);
            }
        });
        return convertView;
    }

    private class ViewHolder{
        ImageView image;
        ProgressBar progress;
    }
}
