package com.practice.sho_ma.practice_application.Fragments;

import com.practice.sho_ma.practice_application.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.support.v4.app.Fragment;

public class recommendFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.recommend, null);
    }
}
