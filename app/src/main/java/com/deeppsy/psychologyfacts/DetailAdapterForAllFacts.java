package com.deeppsy.psychologyfacts;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
public class DetailAdapterForAllFacts extends RecyclerView.Adapter<DetailAdapterForAllFacts.FactViewHolder> {
    public static String FAV_DATA = "fav list";

    public static String SHARED_FAV = "sha;red fav";

    static ArrayList<FavData> mFavData;

    private ArrayList<FactData> mAndroidNews;

    private Context mContext;

    class FactViewHolder extends RecyclerView.ViewHolder {
        TextView bottomTextView;

        ImageView copyImage;

        ImageView saveImage;

        ImageView shareImage;

        TextView textView;

        FactViewHolder(View param1View) {
            super(param1View);
            this.textView = (TextView)param1View.findViewById(R.id.detail_text);
            this.bottomTextView = (TextView)param1View.findViewById(R.id.bottom_text_details);
            this.shareImage = (ImageView)param1View.findViewById(R.id.sharetext);
            this.copyImage = (ImageView)param1View.findViewById(R.id.copybord);
            this.saveImage = (ImageView)param1View.findViewById(R.id.bookMark);
        }
    }

    public DetailAdapterForAllFacts(Context context, ArrayList<FactData> data) {
        this.mContext = context;
        this.mAndroidNews = data;
        loadData();
    }
    @NonNull
    public FactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        return new FactViewHolder(LayoutInflater.from(this.mContext)
            .inflate(R.layout.details, viewGroup, false));
    }

    private void loadData() {
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SHARED_FAV, 0);
        ArrayList<FavData> arrayList = (new Gson()).fromJson
                (sharedPreferences.getString(FAV_DATA, null),
                        (new TypeToken<ArrayList<FavData>>() {
        }).getType());
        mFavData = arrayList;
        if (arrayList == null)
            mFavData = new ArrayList<>();
    }

    private void saveData() {
        SharedPreferences.Editor editor = this.mContext.
                getSharedPreferences(SHARED_FAV, 0).edit();
        String str = (new Gson()).toJson(mFavData);
        editor.putString(FAV_DATA, str);
        editor.apply();
    }

    public int getItemCount() { return this.mAndroidNews.size(); }

    public void onBindViewHolder(FactViewHolder viewHolder, final int position) {
        /*final FactData factData = (FactData)this.mAndroidNews.get(position);//TODO its a question
*/      final FactData factData = (FactData)this.mAndroidNews.get(position);
        viewHolder.textView.setText(factData.getTitle());
        TextView textView = viewHolder.bottomTextView;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(All_facts_together.position);
        stringBuilder.append(" Fact");
        textView.setText(stringBuilder.toString());
        factData.setId(factData.getTitle());
        if (mFavData != null) {
            for (byte b = 0; b < mFavData.size(); b++) {
                if (((FavData) mFavData
                        .get(b))
                        .getId()
                        .equals
                                (factData.getId())) {
                    factData.setState(true);
                }
            }
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(DetailAdapterForAllFacts.this.mContext, FactViewHorizontalActivity.class);
                intent.putExtra("position", position);
                DetailAdapterForAllFacts.this.mContext.startActivity(intent);
            }
        });
        viewHolder.shareImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(DetailAdapterForAllFacts.this.mContext, "Sharing...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                String stringBuilder = ((FactData) DetailAdapterForAllFacts.this.mAndroidNews.get(position)).getTitle() +
                        "\n\nFor More Download the PsychologyFacts App now:" +
                        "\n" +
                        "https://play.google.com/store/apps/details?id=com.deeppsy.psychologyfacts";
                intent.putExtra("android.intent.extra.TEXT", stringBuilder);
                intent.putExtra("android.intent.extra.SUBJECT", "hello");
                DetailAdapterForAllFacts.this.mContext.startActivity(intent);
            }
        });
        viewHolder.copyImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((ClipboardManager) DetailAdapterForAllFacts.this.mContext.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("CopyText", ((FactData) DetailAdapterForAllFacts.this.mAndroidNews.get(position)).getTitle()));
                Toast.makeText(DetailAdapterForAllFacts.this.mContext, "Copied to clipboard.", Toast.LENGTH_LONG).show();
            }
        });
        viewHolder.saveImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                byte b = 0;
                while (true) {
                    if (b < DetailAdapterForAllFacts.mFavData.size()) {
                        if (((FavData) DetailAdapterForAllFacts.mFavData.get(b))
                                .getId()
                                .equals(factData.getId())) {
                            Toast.makeText(DetailAdapterForAllFacts.this.mContext, "Removed from bookmark", Toast.LENGTH_LONG).show();
                            factData.setState(false);
                            DetailAdapterForAllFacts.mFavData.remove(b);
                            DetailAdapterForAllFacts.this.notifyDataSetChanged();
                            DetailAdapterForAllFacts.this.saveData();
                            b = 1;
                            break;
                        }
                        b++;
                        continue;
                    }
                    b = 0;
                    break;
                }
                if (b == 0) {
                    Toast.makeText(DetailAdapterForAllFacts.this.mContext,
                            "Saved to bookmark", Toast.LENGTH_SHORT).show();
                    factData.setState(true);
                    ArrayList<FavData> arrayList = DetailAdapterForAllFacts.mFavData;
                    String str1 = factData.getId();
                    String str2 = factData.getTitle();
                    String stringBuilder = All_facts_together.position +
                            " Fact";
                    arrayList.add(new FavData(str1, str2, stringBuilder));
                    DetailAdapterForAllFacts.this.saveData();
                    DetailAdapterForAllFacts.this.notifyDataSetChanged();
                }
            }
        });
        if (factData.getState()) {
            viewHolder.saveImage.setBackgroundResource(R.drawable.ic_bookmark_yellow_24dp);
            return;
        }
        viewHolder.saveImage.setBackgroundResource(R.drawable.ic_bookmark_black_24dp);
    }

}
