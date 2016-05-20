package com.goankart.zoo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.goankart.zoo.R;
import com.goankart.zoo.models.Animal;
import com.squareup.picasso.Picasso;

/**
 * Created by user on 16/11/2015.
 */
public class ExhibitDetailActivity extends AppCompatActivity {

        public static final String EXTRA_ANIMAL = "extra_animal";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_exhibit_detail);

                Animal animal = getIntent().getExtras().getParcelable(EXTRA_ANIMAL);

                TextView species = (TextView) findViewById(R.id.species);
                TextView description = (TextView) findViewById(R.id.description);
                ImageView image = (ImageView) findViewById(R.id.image);

                species.setText(animal.getSpecies());
                description.setText(animal.getDescription());
                Picasso.with(this).load(animal.getImage()).into(image);

        }
}
