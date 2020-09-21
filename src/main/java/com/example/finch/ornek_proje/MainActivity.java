package com.example.finch.ornek_proje;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    String account_name;
    boolean have_account_number = false;
    List<String> playlists = new ArrayList<String>();
    List<String> watchlist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chechk_account();
        if(have_account_number) {
            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
            setSupportActionBar(toolbar);
            tabLayout = (TabLayout) findViewById(R.id.tab_layout);
            viewPager = (ViewPager) findViewById(R.id.viewpager);
            viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
            viewPagerAdapter.addFragments(new HomeFragment(), "Ana Sayfa");
            viewPagerAdapter.addFragments(new Trends(), "Trendler");
            viewPagerAdapter.addFragments(new Subscriptions(), "Abonelikler");
            viewPager.setAdapter(viewPagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }
        else{
            setContentView(R.layout.activity_login);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                return true;

            case R.id.account:
                Intent intent = new Intent(this.getApplicationContext(), Account.class);
                startActivity(intent);


            case R.id.search:
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void chechk_account(){
        try {
            FileInputStream fileInputStream = openFileInput("info.txt");
            InputStreamReader input = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(input);
            StringBuilder finalstring = new StringBuilder();
            String oneLine;
            while ((oneLine = bufferedReader.readLine()) != null){
                finalstring.append(oneLine);
            }
            bufferedReader.close();
            fileInputStream.close();
            input.close();
            account_name = finalstring.toString();
            have_account_number = true;

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void onLogin(View v){
        String name = "Samet";
        try {

            FileOutputStream fileout=openFileOutput("info.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(name);
            outputWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        init_main_act();
    }

    public void init_main_act(){
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new HomeFragment(), "Ana Sayfa");
        viewPagerAdapter.addFragments(new Trends(), "Trendler");
        viewPagerAdapter.addFragments(new Subscriptions(), "Abonelikler");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
