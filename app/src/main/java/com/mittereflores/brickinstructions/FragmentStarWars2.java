package com.mittereflores.brickinstructions;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Оксана on 08.05.2015.
 */
public class FragmentStarWars2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment_star_wars2, container, false);
        return rootView;
    }
}
