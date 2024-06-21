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

import androidx.viewpager.widget.PagerAdapter;

import com.google.gson.Gson;

import java.util.ArrayList;

public class FactViewPagerAdapter extends PagerAdapter {
    private final Context mContext;

    private final ArrayList<FactData> mFactData;

    public FactViewPagerAdapter(Context mContext, ArrayList<FactData> mArrayList) {
        this.mContext = mContext;
        this.mFactData = mArrayList;
    }

    private void saveData() {
        SharedPreferences.Editor editor = this.mContext.getSharedPreferences(DetailAdapterForAllFacts.SHARED_FAV, 0).edit();
        String str = (new Gson()).toJson(DetailAdapterForAllFacts.mFavData);
        editor.putString(DetailAdapterForAllFacts.FAV_DATA, str);
        editor.apply();
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
        paramViewGroup.removeView((View) paramObject);
    }

    public int getCount() {
        return this.mFactData.size();
    }

    public Object instantiateItem(ViewGroup paramViewGroup, final int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.mContext);
        byte b = 0;
        View view = layoutInflater.inflate(R.layout.viewpager_view, paramViewGroup, false);
        TextView textView = view.findViewById(R.id.viewpagertext);
        TextView textView1 = view.findViewById(R.id.psychologyText);
        TextView textView2 = view.findViewById(R.id.bottom_text);
        ImageView imageView = view.findViewById(R.id.copy_horizontal);
        ImageView imageView1 = view.findViewById(R.id.share_horizontal);
        final ImageView saveImage = view.findViewById(R.id.save);
        this.mFactData.get(position).setId(this.mFactData.
                get(position).getTitle());
        if (DetailAdapterForAllFacts.mFavData != null)
            while (b < DetailAdapterForAllFacts.mFavData.size()) {
                if (DetailAdapterForAllFacts.mFavData.get(b)
                        .getId()
                        .equals
                                (this.
                                        mFactData
                                        .get(position)
                                        .getId()))
                    this.mFactData.get(position).setState(true);
                b++;
            }
        imageView1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                Toast.makeText(FactViewPagerAdapter.this.mContext, "Sharing...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                String stringBuilder = FactViewPagerAdapter.this.mFactData.get(position).getTitle() +
                        "\n\nFor More Download the PsychologyFacts App now:" +
                        "\n" +
                        "https://play.google.com/store/apps/details?id=com.example.psychologyfacts";
                intent.putExtra("android.intent.extra.TEXT", stringBuilder);
                intent.putExtra("android.intent.extra.SUBJECT", "hello");
                FactViewPagerAdapter.this.mContext.startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                ((ClipboardManager) FactViewPagerAdapter.this.mContext.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("CopyText", FactViewPagerAdapter.this.mFactData.get(position).getTitle()));
                Toast.makeText(FactViewPagerAdapter.this.mContext, "Copied to clipboard.", Toast.LENGTH_SHORT).show();
            }
        });
        saveImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                byte b = 0;
                while (true) {
                    if (b < DetailAdapterForAllFacts.mFavData.size()) {
                        if (DetailAdapterForAllFacts.mFavData.get(b).getId()
                                .equals(FactViewPagerAdapter
                                        .this.mFactData.get(position).getId())) {
                            Toast.makeText(FactViewPagerAdapter.this.mContext, "Removed from bookmark", Toast.LENGTH_LONG).show();
                            FactViewPagerAdapter.this.mFactData.get(position).setState(false);
                            DetailAdapterForAllFacts.mFavData.remove(b);
                            FactViewPagerAdapter.this.notifyDataSetChanged();
                            FactViewPagerAdapter.this.saveData();
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
                    Toast.makeText(FactViewPagerAdapter.this.mContext, "Saved to bookmark", Toast.LENGTH_LONG).show();
                    FactViewPagerAdapter.this.mFactData.get(position).setState(true);
                    ArrayList arrayList = DetailAdapterForAllFacts.mFavData;
                    String str1 = FactViewPagerAdapter.this.mFactData.get(position).getTitle();
                    String str2 = FactViewPagerAdapter.this.mFactData.get(position).getTitle();
                    String stringBuilder = All_facts_together.position +
                            " Fact";
                    arrayList.add(new FavData(str1, str2, stringBuilder));
                    FactViewPagerAdapter.this.saveData();
                    FactViewPagerAdapter.this.notifyDataSetChanged();
                }
                if (FactViewPagerAdapter.this.mFactData.get(position).getState()) {
                    saveImage.setBackgroundResource(R.drawable.ic_bookmark_blue);
                    return;
                }
                saveImage.setBackgroundResource(R.drawable.ic_bookmark_black_24dp);
            }
        });
        if (this.mFactData.get(position).getState()) {
            saveImage.setBackgroundResource(R.drawable.ic_bookmark_blue);
        } else {
            saveImage.setBackgroundResource(R.drawable.ic_bookmark_black_24dp);
        }
        textView.setText(this.mFactData.get(position).getTitle());
        //textView1.setText(Html.fromHtml("<font color=#000000>Psychology</font> <font color=#ea3046>Facts</font>"));
        String stringBuilder = All_facts_together.position +
                " Fact";
        textView2.setText(stringBuilder);
        paramViewGroup.addView(view);
        return view;
    }

    public boolean isViewFromObject(View paramView, Object paramObject) {
        return paramView.equals(paramObject);
    }
}
