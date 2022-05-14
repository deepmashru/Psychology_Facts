package com.deeppsy.psychologyfacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class AndroidSettingsAdapter extends ArrayAdapter<FactData> {


    public AndroidSettingsAdapter(AppCompatActivity paramAppCompatActivity, ArrayList<FactData> paramArrayList) { super(paramAppCompatActivity, 0, paramArrayList); }

    @NonNull
    public View getView(int paramInt, View paramView, @NonNull ViewGroup paramViewGroup) {
        View view = paramView;
        if (paramView == null)
            view = LayoutInflater.from(getContext()).inflate(R.layout.settings, paramViewGroup, false);
        FactData factData = (FactData)getItem(paramInt);
        TextView textView = (TextView)view.findViewById(R.id.settings_text);
        ((ImageView)view.findViewById(R.id.settings_image)).setImageResource(factData.getImageRef());
        textView.setText(factData.getTitle());
        return view;
    }
}

