package com.goankart.zoo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.goankart.zoo.R;
import com.goankart.zoo.adapters.DrawerNavigationListAdapter;
import com.goankart.zoo.events.DrawerSectionItemClickedEvent;
import com.goankart.zoo.utils.EventBus;

/**
 * Created by user on 11/11/2015.
 */
public class DrawerNavigationListView extends ListView implements AdapterView.OnItemClickListener {
    public DrawerNavigationListView(Context context) {
        this(context, null);
    }

    public DrawerNavigationListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawerNavigationListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        DrawerNavigationListAdapter adapter = new DrawerNavigationListAdapter( getContext(), 0 );
        adapter.add(getContext().getString(R.string.section_exhibits));
        adapter.add(getContext().getString(R.string.section_gallery));
        adapter.add(getContext().getString(R.string.section_map));

        setAdapter( adapter );

        setOnItemClickListener( this );
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        EventBus.getInstance().post(new DrawerSectionItemClickedEvent((String) parent.getItemAtPosition(position)));
    }
}
