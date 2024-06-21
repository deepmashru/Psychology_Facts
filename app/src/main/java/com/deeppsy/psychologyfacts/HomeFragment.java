package com.deeppsy.psychologyfacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    static FactAdapter factAdapter;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(R.layout.home_fragment, viewGroup, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv1);
        ArrayList<FactData> arrayList = new ArrayList<>();
        arrayList.add(new FactData("Anger", R.drawable.anger));
        arrayList.add(new FactData("Animals", R.drawable.animals));
        arrayList.add(new FactData("Attraction", R.drawable.attraction));
        arrayList.add(new FactData("Biological Facts", R.drawable.biology));
        arrayList.add(new FactData("Body Language", R.drawable.bodylanguage));
        arrayList.add(new FactData("Children", R.drawable.children));
        arrayList.add(new FactData("Colour", R.drawable.color));
        arrayList.add(new FactData("Dating", R.drawable.dating));
        arrayList.add(new FactData("Depression", R.drawable.depression));
        arrayList.add(new FactData("Dream", R.drawable.dream));
        arrayList.add(new FactData("Extroverts", R.drawable.extrovert));
        arrayList.add(new FactData("Fear Of Phobias", R.drawable.fear));
        arrayList.add(new FactData("Female", R.drawable.female));
        arrayList.add(new FactData("Friendship", R.drawable.friends));
        arrayList.add(new FactData("Happiness", R.drawable.happy));
        arrayList.add(new FactData("Health", R.drawable.health));
        arrayList.add(new FactData("Human Behaviours", R.drawable.humanb));
        arrayList.add(new FactData("Human Emotions", R.drawable.emotions));
        arrayList.add(new FactData("Human Mind", R.drawable.humanmind));
        arrayList.add(new FactData("Hunger And Food", R.drawable.food));
        arrayList.add(new FactData("Introverts", R.drawable.introvert));
        arrayList.add(new FactData("Jealousy", R.drawable.jealusy));
        arrayList.add(new FactData("Laughter", R.drawable.laugh));
        arrayList.add(new FactData("Laziness", R.drawable.lazzy));
        arrayList.add(new FactData("Left Handed People", R.drawable.lefthand));
        arrayList.add(new FactData("Love", R.drawable.love));
        arrayList.add(new FactData("Male", R.drawable.male));
        arrayList.add(new FactData("Music", R.drawable.music));
        arrayList.add(new FactData("OCD", R.drawable.ocd));
        arrayList.add(new FactData("People", R.drawable.people));
        arrayList.add(new FactData("Personality", R.drawable.personality));
        arrayList.add(new FactData("Sixth Sense", R.drawable.sixthsence));
        arrayList.add(new FactData("Sleep", R.drawable.sleep));
        arrayList.add(new FactData("Social Media Life", R.drawable.social1));
        arrayList.add(new FactData("Teenagers", R.drawable.teenager));
        arrayList.add(new FactData("Writing", R.drawable.writing));
        FactAdapter factAdapter1 = new FactAdapter(getContext(), arrayList);
        factAdapter = factAdapter1;
        recyclerView.setAdapter(factAdapter1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}
