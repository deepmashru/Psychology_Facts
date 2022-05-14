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
        private Context mContext;

        private ArrayList<FactData> mFactData;

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
            paramViewGroup.removeView((View)paramObject);
        }

        public int getCount() { return this.mFactData.size(); }

        public Object instantiateItem(ViewGroup paramViewGroup, final int position) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.mContext);
            byte b = 0;
            View view = layoutInflater.inflate(R.layout.viewpager_view, paramViewGroup, false);
            TextView textView = (TextView)view.findViewById(R.id.viewpagertext);
            TextView textView1 = (TextView)view.findViewById(R.id.psychologyText);
            TextView textView2 = (TextView)view.findViewById(R.id.bottom_text);
            ImageView imageView = (ImageView)view.findViewById(R.id.copy_horizontal);
            ImageView imageView1 = (ImageView)view.findViewById(R.id.share_horizontal);
            final ImageView saveImage = (ImageView)view.findViewById(R.id.save);
            ((FactData)this.mFactData.get(position)).setId(((FactData)this.mFactData.
                    get(position)).getTitle());
            if (DetailAdapterForAllFacts.mFavData != null)
                while (b < DetailAdapterForAllFacts.mFavData.size()) {
                    if (((FavData) DetailAdapterForAllFacts.mFavData.get(b))
                            .getId()
                            .equals
                                    (((FactData)this.
                                            mFactData
                                    .get(position))
                                    .getId()))
                        ((FactData)this.mFactData.get(position)).setState(true);
                    b++;
                }
            imageView1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    Toast.makeText(FactViewPagerAdapter.this.mContext, "Sharing...", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(((FactData)FactViewPagerAdapter.this.mFactData.get(position)).getTitle());
                    stringBuilder.append("\n\nFor More Download the PsychologyFacts App now:");
                    stringBuilder.append("\n");
                    stringBuilder.append("https://play.google.com/store/apps/details?id=com.example.psychologyfacts");
                    intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                    intent.putExtra("android.intent.extra.SUBJECT", "hello");
                    FactViewPagerAdapter.this.mContext.startActivity(intent);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    ((ClipboardManager)FactViewPagerAdapter.this.mContext.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("CopyText", ((FactData)FactViewPagerAdapter.this.mFactData.get(position)).getTitle()));
                    Toast.makeText(FactViewPagerAdapter.this.mContext, "Copied to clipboard.", Toast.LENGTH_SHORT).show();
                }
            });
            saveImage.setOnClickListener(new View.OnClickListener() {
                public void onClick(View param1View) {
                    byte b = 0;
                    while (true) {
                        if (b < DetailAdapterForAllFacts.mFavData.size()) {
                            if (((FavData) DetailAdapterForAllFacts.mFavData.get(b)).getId()
                                    .equals(((FactData)FactViewPagerAdapter
                                            .this.mFactData.get(position)).getId())) {
                                Toast.makeText(FactViewPagerAdapter.this.mContext, "Removed from bookmark", Toast.LENGTH_LONG).show();
                                ((FactData)FactViewPagerAdapter.this.mFactData.get(position)).setState(false);
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
                        ((FactData)FactViewPagerAdapter.this.mFactData.get(position)).setState(true);
                        ArrayList arrayList = DetailAdapterForAllFacts.mFavData;
                        String str1 = ((FactData)FactViewPagerAdapter.this.mFactData.get(position)).getTitle();
                        String str2 = ((FactData)FactViewPagerAdapter.this.mFactData.get(position)).getTitle();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(All_facts_together.position);
                        stringBuilder.append(" Fact");
                        arrayList.add(new FavData(str1, str2, stringBuilder.toString()));
                        FactViewPagerAdapter.this.saveData();
                        FactViewPagerAdapter.this.notifyDataSetChanged();
                    }
                    if (((FactData)FactViewPagerAdapter.this.mFactData.get(position)).getState()) {
                        saveImage.setBackgroundResource(R.drawable.ic_bookmark_blue);
                        return;
                    }
                    saveImage.setBackgroundResource(R.drawable.ic_bookmark_black_24dp);
                }
            });
            if (((FactData)this.mFactData.get(position)).getState()) {
                saveImage.setBackgroundResource(R.drawable.ic_bookmark_blue);
            } else {
                saveImage.setBackgroundResource(R.drawable.ic_bookmark_black_24dp);
            }
            textView.setText(((FactData)this.mFactData.get(position)).getTitle());
            //textView1.setText(Html.fromHtml("<font color=#000000>Psychology</font> <font color=#ea3046>Facts</font>"));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(All_facts_together.position);
            stringBuilder.append(" Fact");
            textView2.setText(stringBuilder.toString());
            paramViewGroup.addView(view);
            return view;
        }

        public boolean isViewFromObject(View paramView, Object paramObject) { return paramView.equals(paramObject); }
    }
