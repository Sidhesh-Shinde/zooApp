package com.goankart.zoo.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.goankart.zoo.R;
import com.goankart.zoo.activities.ExhibitDetailActivity;
import com.goankart.zoo.adapters.ExhibitsAdapter;
import com.goankart.zoo.models.Animal;
import com.goankart.zoo.utils.AnimalApiInterface;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * Created by user on 12/11/2015.
 */
public class ExhibitsListFragment extends ListFragment {

    private ExhibitsAdapter mAdapter;

    public static ExhibitsListFragment getInstance(){
        ExhibitsListFragment fragment = new ExhibitsListFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListShown(false);

        //getListView().setPadding(16, 0, 16, 0);
        getListView().setDivider(new ColorDrawable(Color.TRANSPARENT));
        getListView().setDividerHeight(18);
        getListView().setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        getListView().setClipToPadding(true);

        mAdapter = new ExhibitsAdapter(getActivity(), 0);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.exhibits_feed)).build();

        AnimalApiInterface animalApiInterface = restAdapter.create(AnimalApiInterface.class);
        animalApiInterface.getStreams(new Callback<List<Animal>>() {
            @Override
            public void success(List<Animal> animals, Response response) {
                if(animals == null|| animals.isEmpty() || !isAdded())
                    return;
                for(Animal animal : animals){
                    mAdapter.add(animal);
                }
                mAdapter.notifyDataSetChanged();
                setListAdapter(mAdapter);
                setListShown(true);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("Zoo", "Error Message" + error.getMessage());
            }
        });
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(getActivity(), ExhibitDetailActivity.class);
        intent.putExtra(ExhibitDetailActivity.EXTRA_ANIMAL, mAdapter.getItem(position));
        startActivity(intent);
    }
}























