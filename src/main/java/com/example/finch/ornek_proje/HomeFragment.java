package com.example.finch.ornek_proje;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class HomeFragment extends Fragment{


    public ImageButton imgbtn1;
    public String current_video_number = "000001";
    public TextView txtview;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imgbtn1 = (ImageButton) view.findViewById(R.id.hl1_img1);
        txtview = (TextView) view.findViewById(R.id.hl1_txt1);
        View.OnClickListener imgbuttonlistener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), video_unfullscreen.class);
                intent.putExtra("vd_number",current_video_number);
                startActivity(intent);
            }
        };
        imgbtn1.setOnClickListener(imgbuttonlistener);
        // Inflate the layout for this fragment
        return view;
    }

}
