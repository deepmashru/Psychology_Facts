package com.deeppsy.psychologyfacts;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavViewHolder> implements Filterable {
    public static String FAV_DATA = "fav list";

    public static String SHARED_FAV = "shared fav";

    static ArrayList<FavData> mFavData;

    Context mContext;

    private Filter mFavListFilter = new Filter() {
        protected FilterResults performFiltering(CharSequence mCharSequence) {
            ArrayList<FavData> arrayList = new ArrayList<FavData>();
            if (mCharSequence == null || mCharSequence.length() == 0) {
                arrayList.addAll(FavAdapter.this.mFavDataFull);
            }else{
                String string = mCharSequence.toString().toLowerCase().trim();
                Iterator<FavData> fuck=FavAdapter.this.mFavDataFull.iterator();
                while (fuck.hasNext()){
                    FavData favData = fuck.next();
                    if (favData.getTitle().toLowerCase().contains(string)){
                        arrayList.add(favData);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = arrayList;
            return filterResults;
        }


        protected void publishResults(CharSequence param1CharSequence, FilterResults param1FilterResults) {
            FavAdapter.mFavData.clear();
            FavAdapter.mFavData.addAll((ArrayList)param1FilterResults.values);
            FavAdapter.this.notifyDataSetChanged();
        }
    };
    private ArrayList<FavData> mFavDataFull;
    static  {
    }
    public FavAdapter(Context paramContext, ArrayList<FavData> paramArrayList) {
        this.mContext = paramContext;
        mFavData = paramArrayList;
        this.mFavDataFull = new ArrayList<>(paramArrayList);
    }
    private void saveData() {
        SharedPreferences.Editor editor = this.mContext.getSharedPreferences(SHARED_FAV, 0).edit();
        String str = (new Gson()).toJson(mFavData);
        editor.putString(FAV_DATA, str);
        editor.apply();
    }

    public Filter getFilter() { return this.mFavListFilter; }

    public int getItemCount() { return mFavData.size(); }

    public void onBindViewHolder(FavViewHolder paramFavViewHolder, final int position) {
        paramFavViewHolder.textView.setText(((FavData) mFavData.get(position)).getTitle());
        paramFavViewHolder.factTitleTextView.setText(((FavData) mFavData.get(position)).getFactTitle());
        paramFavViewHolder.savImage.setBackgroundResource(R.drawable.ic_bookmark_yellow_24dp);
        paramFavViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                Intent intent = new Intent(FavAdapter.this.mContext, FavViewPagerActivity.class);
                intent.putExtra("position", position);
                FavAdapter.this.mContext.startActivity(intent);
            }
        });
        paramFavViewHolder.shareImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                Toast.makeText(FavAdapter.this.mContext, "Sharing...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(((FavData)FavAdapter.mFavData.get(position)).getTitle());
                stringBuilder.append("\n\nFor More Download the PsychologyFacts App now:");
                stringBuilder.append("\n");
                stringBuilder.append("https://play.google.com/store/apps/details?id=com.deeppsy.psychologyfacts");
                intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                intent.putExtra("android.intent.extra.SUBJECT", "hello");
                FavAdapter.this.mContext.startActivity(intent);
            }
        });
        paramFavViewHolder.copyImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                ((ClipboardManager)FavAdapter.this.mContext.getSystemService(Context.CLIPBOARD_SERVICE))
                        .setPrimaryClip(ClipData.newPlainText("CopyText",
                        ((FavData)FavAdapter.mFavData.get(position)).getTitle()));
                Toast.makeText(FavAdapter.this.mContext, "Copied to clipboard.", Toast.LENGTH_LONG).show();
            }
        });
        paramFavViewHolder.savImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                FavAdapter.mFavData.remove(position);
                FavAdapter.this.saveData();
                Toast.makeText(FavAdapter.this.mContext, "Removed from bookmark", Toast.LENGTH_LONG).show();
                FavAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public FavViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) { return new FavViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.details, paramViewGroup, false)); }

    class FavViewHolder extends RecyclerView.ViewHolder {
        ImageView copyImage;

        TextView factTitleTextView;

        ImageView savImage;

        ImageView shareImage;

        TextView textView;

        public FavViewHolder(View param1View) {
            super(param1View);
            this.textView = (TextView)param1View.findViewById(R.id.detail_text);
            this.factTitleTextView = (TextView)param1View.findViewById(R.id.bottom_text_details);
            this.savImage = (ImageView)param1View.findViewById(R.id.bookMark);
            this.shareImage = (ImageView)param1View.findViewById(R.id.sharetext);
            this.copyImage = (ImageView)param1View.findViewById(R.id.copybord);
        }
    }
}
