package com.aytekincomez.recyclerview_searchview.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.aytekincomez.recyclerview_searchview.Holder.UlkeHolder;
import com.aytekincomez.recyclerview_searchview.Model.Ulke;
import com.aytekincomez.recyclerview_searchview.R;

import java.util.ArrayList;
import java.util.List;

public class UlkeAdapter extends RecyclerView.Adapter<UlkeHolder> implements Filterable {
    private List<Ulke> ulkeler;
    private List<Ulke> ulkelerKopya;
    private Context context;

    public UlkeAdapter() {
    }
    public UlkeAdapter(List<Ulke> ulkeler, Context context){
        this.ulkeler = ulkeler;
        this.context = context;
    }

    @NonNull
    @Override
    public UlkeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.satir_goruntusu, null);
        return new UlkeHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UlkeHolder ulkeHolder, int i) {
        ulkeHolder.tvUlkeAd.setText(ulkeler.get(i).getUlkeAdi());
        ulkeHolder.tvBaskent.setText(ulkeler.get(i).getUlkeBaskent());
        ulkeHolder.tvKurulus.setText(""+ulkeler.get(i).getKurulusYili());
        ulkeHolder.tvTelKodu.setText(ulkeler.get(i).getTelefonKodu());
        int resId = ulkeHolder.itemView.getResources().getIdentifier(
                ulkeler.get(i).getUlkeResimUrl(),"drawable",context.getPackageName()
        );
        ulkeHolder.ivUlkeBayrak.setImageResource(resId);
    }

    @Override
    public int getItemCount() {
        return ulkeler.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    ulkelerKopya = ulkeler;
                } else {
                    List<Ulke> filteredList = new ArrayList<>();
                    for (Ulke row : ulkeler) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getUlkeAdi().toLowerCase().contains(charString.toLowerCase()) || row.getUlkeBaskent().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    ulkelerKopya = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = ulkelerKopya;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                ulkelerKopya = (ArrayList<Ulke>) filterResults.values;

                // refresh the list with filtered data
                notifyDataSetChanged();
            }
        };
    }
}
