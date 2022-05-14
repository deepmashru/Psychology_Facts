package com.deeppsy.psychologyfacts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Iterator;


public class FactAdapter extends RecyclerView.Adapter<FactAdapter.FactsViewHolder> implements Filterable {
    private ArrayList<FactData> mAndroidNews;

    private Filter mAndroidNewsFilter = new Filter() {
        protected FilterResults performFiltering(CharSequence mCharSequence) {
            ArrayList<FactData> arrayList = new ArrayList<FactData>();
            if (mCharSequence == null || mCharSequence.length() == 0) {
                arrayList.addAll(FactAdapter.this.mAndroidNewsFull);
            }else{
                String string = mCharSequence.toString().toLowerCase().trim();
                Iterator<FactData> fuck=FactAdapter.this.mAndroidNewsFull.iterator();
                while (fuck.hasNext()){
                    FactData factData = fuck.next();
                    if (factData.getTitle().toLowerCase().contains(string)){
                        arrayList.add(factData);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = arrayList;
            return filterResults;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            FactAdapter.this.mAndroidNews.clear();
            FactAdapter.this.mAndroidNews.addAll((ArrayList)filterResults.values);
            FactAdapter.this.notifyDataSetChanged();
        }
    };

    private ArrayList<FactData> mAndroidNewsFull;

    private Context mContext;

    public FactAdapter(Context paramContext, ArrayList<FactData> paramArrayList) {
        this.mContext = paramContext;
        this.mAndroidNews = paramArrayList;
        this.mAndroidNewsFull = new ArrayList<>(paramArrayList);
    }

    public Filter getFilter() { return this.mAndroidNewsFilter; }

    public int getItemCount() { return this.mAndroidNews.size(); }

    public void onBindViewHolder(@NonNull FactsViewHolder holder, int paramInt) {
        final FactData factData = (FactData)this.mAndroidNews.get(paramInt);
        if (factData.getTitle()!=null){
            if (factData.getTitle().equals("Social Media Life") || factData.getTitle().equals("Friendship")||factData.getTitle().equals("Introverts")||factData.getTitle().equals("OCD")){
                holder.textView.setText(" ");
            }else{
                holder.textView.setText(factData.getTitle());
            }

        }
        holder.imageView.setImageResource(factData.getImageRef());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                if (factData.getTitle().equals(" "))
                    return;
                Intent intent = new Intent(FactAdapter.this.mContext, All_facts_together.class);
                intent.putExtra("position", factData.getTitle());
                FactAdapter.this.mContext.startActivity(intent);
            }
        });
    }

    @NonNull
    public FactsViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
        return new FactsViewHolder(LayoutInflater.from(this.mContext)
                .inflate(R.layout.main_view, paramViewGroup, false));
    }

    public class FactsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        TextView textView;

        public FactsViewHolder(View param1View) {
            super(param1View);

            this.textView = (TextView)param1View.findViewById(R.id.cardTitle);

            this.imageView = (ImageView)param1View.findViewById(R.id.cardImage);
        }
    }
}
//dont do anything just complete this fucking work first

