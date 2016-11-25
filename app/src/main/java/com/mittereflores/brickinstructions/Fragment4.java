package com.mittereflores.brickinstructions;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment4 extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.fragment4, container, false);
        return rootView;
    }
}


