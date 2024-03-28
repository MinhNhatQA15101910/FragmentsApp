package com.donhat.fragmentsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        Button secondFragmentButton = view.findViewById(R.id.second_fragment_btn);

        secondFragmentButton.setOnClickListener(
                v1 -> Toast.makeText(
                        getActivity(),
                        "Good Bye from Second Fragment",
                        Toast.LENGTH_SHORT)
                        .show());

        return view;
    }
}