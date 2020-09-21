package com.example.finch.ornek_proje;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Account extends AppCompatActivity {

    List<String> playlists = new ArrayList<String>();
    List<String> watchlist = new ArrayList<String>();
    List<String> likelist = new ArrayList<String>();
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        textView = (TextView) findViewById(R.id.account_text);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new HomeFragment(), "Hesap Ayarları");
        viewPagerAdapter.addFragments(new Liked(), "Beğendiklerim");
        viewPagerAdapter.addFragments(new PlayList(), "Listelerim");
        viewPagerAdapter.addFragments(new Watch_after(), "Sonra izleyeceklerim");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void get_playlists(){
        try {
            FileInputStream fileInputStream = openFileInput("playlist.txt");
            InputStreamReader input = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(input);
            String oneLine;
            while ((oneLine = bufferedReader.readLine()) != null){
                playlists.add(oneLine);
            }
            bufferedReader.close();
            fileInputStream.close();
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void get_watched_list(){
        try {
            FileInputStream fileInputStream = openFileInput("watched.txt");
            InputStreamReader input = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(input);
            String oneLine;
            while ((oneLine = bufferedReader.readLine()) != null){
                watchlist.add(oneLine);
            }
            bufferedReader.close();
            fileInputStream.close();
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void get_liked_list(){
        try {
            FileInputStream fileInputStream = openFileInput("liked.txt");
            InputStreamReader input = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(input);
            String oneLine;
            while ((oneLine = bufferedReader.readLine()) != null){
                likelist.add(oneLine);
            }
            bufferedReader.close();
            fileInputStream.close();
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
