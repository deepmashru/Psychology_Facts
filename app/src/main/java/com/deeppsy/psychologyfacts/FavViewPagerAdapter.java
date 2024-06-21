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

public class FavViewPagerAdapter extends PagerAdapter {
    public static String FAV_DATA = "fav list";

    public static String SHARED_FAV = "shared fav";

    private final Context mContext;
    private ImageView imageView3;
    private final ArrayList<FavData> mFavData;

    public FavViewPagerAdapter(Context paramContext, ArrayList<FavData> paramArrayList) {
        this.mContext = paramContext;
        this.mFavData = paramArrayList;
    }

    private void saveData() {
        SharedPreferences.Editor editor = this.mContext.getSharedPreferences(SHARED_FAV, 0).edit();
        String str = (new Gson()).toJson(this.mFavData);
        editor.putString(FAV_DATA, str);
        editor.apply();
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
        paramViewGroup.removeView((View) paramObject);
    }

    public int getCount() {
        return this.mFavData.size();
    }

    public int getItemPosition(Object paramObject) {
        return -2;
    }

    public Object instantiateItem(ViewGroup paramViewGroup, final int position) {
        View view = LayoutInflater.from(this.mContext).inflate(R.layout.viewpager_view, paramViewGroup, false);
        TextView textView1 = view.findViewById(R.id.viewpagertext);
        TextView textView2 = view.findViewById(R.id.psychologyText);
        TextView textView3 = view.findViewById(R.id.bottom_text);
        ImageView imageView1 = view.findViewById(R.id.copy_horizontal);
        ImageView imageView2 = view.findViewById(R.id.share_horizontal);
        final ImageView saveImage = view.findViewById(R.id.save);
        saveImage.setBackgroundResource(R.drawable.ic_bookmark_blue);
        imageView1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                String stringBuilder = FavViewPagerAdapter.this.mFavData.get(position).getTitle() +
                        "\n\nFor More Download the PsychologyFacts App now:" +
                        "\n" +
                        "https://play.google.com/store/apps/details?id=com.deeppsy.psychologyfacts";
                intent.putExtra("android.intent.extra.TEXT", stringBuilder);
                intent.putExtra("android.intent.extra.SUBJECT", "hello");
                FavViewPagerAdapter.this.mContext.startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                ((ClipboardManager) FavViewPagerAdapter.this.mContext.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("CopyText", FavViewPagerAdapter.this.mFavData.get(position).getTitle()));
                Toast.makeText(FavViewPagerAdapter.this.mContext, "Copied to clipboard.", Toast.LENGTH_LONG).show();
            }
        });
        saveImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View param1View) {
                saveImage.setBackgroundResource(R.drawable.ic_bookmark_white_24dp);
                FavViewPagerAdapter.this.mFavData.remove(position);
                FavViewPagerAdapter.this.saveData();
                Toast.makeText(FavViewPagerAdapter.this.mContext, "Removed from bookmark", Toast.LENGTH_LONG).show();
                FavViewPagerAdapter.this.notifyDataSetChanged();
            }
        });
        textView1.setText(this.mFavData.get(position).getTitle());
        textView3.setText(this.mFavData.get(position).getFactTitle());
        paramViewGroup.addView(view);
        return view;
    }

    public boolean isViewFromObject(View paramView, Object paramObject) {
        return paramView.equals(paramObject);
    }
}
