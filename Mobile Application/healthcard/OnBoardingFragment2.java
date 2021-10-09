package com.example.healthcard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class OnBoardingFragment2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        boolean attachToRoot;
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_on_boarding2,container, attachToRoot=false);
        return root;
    }

}
