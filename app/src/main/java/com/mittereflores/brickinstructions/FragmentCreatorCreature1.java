package com.mittereflores.brickinstructions;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ali on 3/23/2015.
 */
public class FragmentCreatorCreature1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment_creator_creature_1, container, false);
        return rootView;
    }
}
