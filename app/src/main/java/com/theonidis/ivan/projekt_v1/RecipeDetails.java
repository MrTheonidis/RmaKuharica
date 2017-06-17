package com.theonidis.ivan.projekt_v1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RecipeDetails extends AppCompatActivity {

    Context ctx;

    TextView tx_ime,tx_id,tx_vrsta,tx_sastojci, tx_priprema;
    ImageView tx_slika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        tx_ime = (TextView)findViewById(R.id.rec_ime_ex);
        //tx_id = (TextView)findViewById(R.id.rec_id_ex);
        tx_vrsta = (TextView)findViewById(R.id.rec_vrs_ex);
        tx_sastojci = (TextView)findViewById(R.id.rec_sas_ex);
        tx_slika = (ImageView)findViewById(R.id.rec_slika_ex);
        tx_priprema = (TextView)findViewById(R.id.rec_pri_ex);

        tx_ime.setText("Ime: "+getIntent().getStringExtra("ime_id"));
        //tx_id.setText("Id: "+getIntent().getStringExtra("id_id"));
        tx_vrsta.setText("Vrsta: "+getIntent().getStringExtra("vrsta_id"));
        tx_sastojci.setText("Sastojci: \n"+getIntent().getStringExtra("sastojci_id"));
        tx_priprema.setText("Priprema: \n"+getIntent().getStringExtra("priprema_id"));
        Picasso.with(ctx).load(getIntent().getStringExtra("slika_id")).into(tx_slika);
    }
}
