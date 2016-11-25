package com.mittereflores.brickinstructions;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Оксана on 19.02.2015.
 */
public class CityFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment_city, container, false);
        return rootView;
    }
}
