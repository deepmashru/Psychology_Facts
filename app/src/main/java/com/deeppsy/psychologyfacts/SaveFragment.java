package com.deeppsy.psychologyfacts;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class SaveFragment extends Fragment {
    static FavAdapter favAdapter;

    static ArrayList<FavData> favData;

    RelativeLayout emptyRel;

    private void loadData() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(DetailAdapterForAllFacts.SHARED_FAV, 0);
        ArrayList arrayList = (new Gson()).fromJson(sharedPreferences.getString(DetailAdapterForAllFacts.FAV_DATA, null), (new TypeToken<ArrayList<FavData>>() {

        }).getType());
        favData = arrayList;

        if (arrayList == null)
            favData = new ArrayList<>();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(R.layout.activity_save_fragment, viewGroup, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv2);
        loadData();
        FavAdapter favAdapter1 = new FavAdapter(getContext(), favData);
        favAdapter = favAdapter1;
        recyclerView.setAdapter(favAdapter1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.emptyRel = view.findViewById(R.id.empty_view);
        if (favData.isEmpty()) {
            this.emptyRel.setVisibility(View.VISIBLE);
            return view;
        }
        this.emptyRel.setVisibility(View.INVISIBLE);
        return view;
    }

    public void onResume() {
        favAdapter.notifyDataSetChanged();
        if (favData.isEmpty()) {
            this.emptyRel.setVisibility(View.VISIBLE);
        } else {
            this.emptyRel.setVisibility(View.GONE);
        }
        super.onResume();
    }
}
