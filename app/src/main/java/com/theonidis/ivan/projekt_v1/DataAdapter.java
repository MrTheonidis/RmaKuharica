package com.theonidis.ivan.projekt_v1;

/**
 * Created by Ivan on 5.6.2017..
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements Filterable {
    private ArrayList<AndroidVersion> mArrayList;
    private ArrayList<AndroidVersion> mFilteredList;
    Context ctx;
    private Context context;

    public DataAdapter(ArrayList<AndroidVersion> arrayList, Context ctx,Context context) {
        mArrayList = arrayList;
        mFilteredList = arrayList;
        this.ctx = ctx;
        this.context = context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view,ctx,mFilteredList);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.ime_rec.setText(mFilteredList.get(i).getIme());
        viewHolder.id_rec.setText(mFilteredList.get(i).getId());
        viewHolder.vrs_rec.setText(mFilteredList.get(i).getVrsta());
        viewHolder.sas_rec.setText(mFilteredList.get(i).getSastojci().toString());
        viewHolder.vri_rec.setText(mFilteredList.get(i).getVrijeme());
        Picasso.with(context).load(mFilteredList.get(i).getUrlslike()).resize(240, 150).into(viewHolder.slika_rec);
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = mArrayList;
                } else {

                    ArrayList<AndroidVersion> filteredList = new ArrayList<>();

                    for (AndroidVersion androidVersion : mArrayList) {

                        if (charString.contains(",")) {
                            String searchChar[] = charString.split(",");
                            for (int i = 0; i < searchChar.length; i++) {

                                if (androidVersion.getVrsta().toLowerCase().contains(searchChar[i]) || androidVersion
                                        .getIme()
                                        .toLowerCase().contains(searchChar[i]) || androidVersion.getSastojci().toString().toLowerCase().contains(searchChar[i])) {

                                    filteredList.add(androidVersion);
                                }
                            }
                        } else {
                            if (androidVersion.getVrsta().toLowerCase().contains(charString) || androidVersion.getIme()
                                    .toLowerCase().contains(charString) || androidVersion.getSastojci().toString().toLowerCase().contains(charString)) {

                                filteredList.add(androidVersion);
                            }
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<AndroidVersion>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView ime_rec,id_rec,vrs_rec,sas_rec,vri_rec,pri_rec;
        private ImageView slika_rec;
        ArrayList<AndroidVersion> arrayList = new ArrayList<AndroidVersion>();
        Context ctx;
        public ViewHolder(View view, Context ctx, ArrayList<AndroidVersion> arrayList) {
            super(view);

            this.arrayList = arrayList;
            this.ctx = ctx;
            view.setOnClickListener(this);

            ime_rec = (TextView)view.findViewById(R.id.rec_ime);
            id_rec = (TextView)view.findViewById(R.id.rec_id);
            vrs_rec = (TextView)view.findViewById(R.id.rec_vrs);
            sas_rec = (TextView)view.findViewById(R.id.rec_sas);
            vri_rec = (TextView)view.findViewById(R.id.rec_vri);
            slika_rec = (ImageView)view.findViewById(R.id.rec_slika);
            pri_rec = (TextView)view.findViewById(R.id.rec_pri);

        }

        @Override
        public void onClick(View v) {
            int i = getAdapterPosition();
            AndroidVersion arrayList = this.arrayList.get(i);
            Intent intent = new Intent(this.ctx, RecipeDetails.class);
            intent.putExtra("ime_id",arrayList.getIme());
            intent.putExtra("id_id",arrayList.getId());
            intent.putExtra("vrsta_id",arrayList.getVrsta());
            intent.putExtra("sastojci_id",arrayList.getSastojci().toString());
            intent.putExtra("slika_id",arrayList.getUrlslike());
            intent.putExtra("priprema_id",arrayList.getPriprema());
            ((Context) this.ctx).startActivity(intent);

        }
    }

}