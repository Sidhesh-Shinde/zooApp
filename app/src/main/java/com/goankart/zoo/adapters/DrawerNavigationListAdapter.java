package com.goankart.zoo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.goankart.zoo.R;

/**
 * Created by user on 11/11/2015.
 */
public class DrawerNavigationListAdapter extends ArrayAdapter<String> {
    public DrawerNavigationListAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if( convertView == null ) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate( R.layout.navigation_drawer_list_item, parent, false );
            convertView.setTag( holder );
            holder.title = (TextView) convertView.findViewById( R.id.title );
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText( getItem( position ) );

        return convertView;
    }

    class ViewHolder {
        TextView title;
    }
}
