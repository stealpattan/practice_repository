package com.practice.sho_ma.practice_application.Fragments;

import com.practice.sho_ma.practice_application.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TextView;

public class recommendFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View vi = inflater.inflate(R.layout.recommend, null);
        Button button1 = (Button)vi.findViewById(R.id.button1);
        final TextView textview1 = (TextView)vi.findViewById(R.id.textView2);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                textview1.setText("ボタンが押されましたの");
            }
        });
        return vi;
    }
}
