package com.example.finch.ornek_proje;


import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Trends extends Fragment {

    Handler updateConversationHandler = new Handler();
    Handler updateConversationHandler2 = new Handler();
    private static final int SERVERPORT = 2001;
    private static final String SERVER_IP = "192.168.1.45";
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textView11;
    private TextView textView12;
    private TextView textView13;
    private TextView textView14;
    private TextView textView15;
    private TextView textView16;
    private TextView textView17;
    private TextView textView18;
    private TextView textView19;
    private TextView textView20;
    private TextView textView21;
    private TextView textView22;
    private TextView textView23;
    private TextView textView24;
    private TextView textView25;
    private TextView textView26;
    private TextView textView27;
    private TextView textView28;
    private TextView textView29;
    private TextView textView30;
    private ImageButton imagebtn1;
    private ImageButton imagebtn2;
    private ImageButton imagebtn3;
    private ImageButton imagebtn4;
    private ImageButton imagebtn5;
    private ImageButton imagebtn6;
    private ImageButton imagebtn7;
    private ImageButton imagebtn8;
    private ImageButton imagebtn9;
    private ImageButton imagebtn10;
    private ImageButton imagebtn11;
    private ImageButton imagebtn12;
    private ImageButton imagebtn13;
    private ImageButton imagebtn14;
    private ImageButton imagebtn15;
    private ImageButton imagebtn16;
    private ImageButton imagebtn17;
    private ImageButton imagebtn18;
    private ImageButton imagebtn19;
    private ImageButton imagebtn20;

    public Trends() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.trends, container, false);
        textView1 = view.findViewById(R.id.hl1_txt3);
        textView2 = view.findViewById(R.id.hl1_txt1);
        textView3 = view.findViewById(R.id.hl1_txt2);
        textView4 = view.findViewById(R.id.hl2_txt3);
        textView5 = view.findViewById(R.id.hl2_txt1);
        textView6 = view.findViewById(R.id.hl2_txt2);
        textView7 = view.findViewById(R.id.hl3_txt3);
        textView8 = view.findViewById(R.id.hl3_txt1);
        textView9 = view.findViewById(R.id.hl3_txt2);
        textView10 = view.findViewById(R.id.hl4_txt3);
        textView11 = view.findViewById(R.id.hl4_txt1);
        textView12 = view.findViewById(R.id.hl4_txt2);
        textView13 = view.findViewById(R.id.hl5_txt3);
        textView14 = view.findViewById(R.id.hl5_txt1);
        textView15 = view.findViewById(R.id.hl5_txt2);
        textView16 = view.findViewById(R.id.hl6_txt3);
        textView17 = view.findViewById(R.id.hl6_txt1);
        textView18 = view.findViewById(R.id.hl6_txt2);
        textView19 = view.findViewById(R.id.hl7_txt3);
        textView20 = view.findViewById(R.id.hl7_txt1);
        textView21 = view.findViewById(R.id.hl7_txt2);
        textView22 = view.findViewById(R.id.hl8_txt3);
        textView23 = view.findViewById(R.id.hl8_txt1);
        textView24 = view.findViewById(R.id.hl8_txt2);
        textView25 = view.findViewById(R.id.hl9_txt3);
        textView26 = view.findViewById(R.id.hl9_txt1);
        textView27 = view.findViewById(R.id.hl9_txt2);
        textView28 = view.findViewById(R.id.hl10_txt3);
        textView29 = view.findViewById(R.id.hl10_txt1);
        textView30 = view.findViewById(R.id.hl10_txt2);
        imagebtn1 = view.findViewById(R.id.hl1_img1);
        imagebtn2 = view.findViewById(R.id.hl1_img2);
        imagebtn3 = view.findViewById(R.id.hl2_img1);
        imagebtn4 = view.findViewById(R.id.hl2_img2);
        imagebtn5 = view.findViewById(R.id.hl3_img1);
        imagebtn6 = view.findViewById(R.id.hl3_img2);
        imagebtn7 = view.findViewById(R.id.hl4_img1);
        imagebtn8 = view.findViewById(R.id.hl4_img2);
        imagebtn9 = view.findViewById(R.id.hl5_img1);
        imagebtn10 = view.findViewById(R.id.hl5_img2);
        imagebtn11 = view.findViewById(R.id.hl6_img1);
        imagebtn12 = view.findViewById(R.id.hl6_img2);
        imagebtn13 = view.findViewById(R.id.hl7_img1);
        imagebtn14 = view.findViewById(R.id.hl7_img2);
        imagebtn15 = view.findViewById(R.id.hl8_img1);
        imagebtn16 = view.findViewById(R.id.hl8_img2);
        imagebtn17 = view.findViewById(R.id.hl9_img1);
        imagebtn18 = view.findViewById(R.id.hl9_img2);
        imagebtn19 = view.findViewById(R.id.hl10_img1);
        imagebtn20 = view.findViewById(R.id.hl10_img2);
        new Thread(new GetTrendList()).start();


        return view;
    }
    class GetTrendList implements Runnable {

        @Override
        public void run() {
            try {
                InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
                Socket socket = new Socket(serverAddr, SERVERPORT);
                InputStream input_stream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(input_stream);
                BufferedReader input = new BufferedReader(new InputStreamReader(input_stream));
                PrintWriter out = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())),
                        true);
                out.println("get_trend_list:0");
                String read = input.readLine();
                String [] infos;
                String[] trend_list = read.split(",");
                int a = 0;
                while (a < 10){
                    out.println("get_vd_info_less:"+ trend_list[a]);
                    read = input.readLine();
                    infos = read.split(",");
                    updateConversationHandler.post(new updateUIThread2(infos,a));
                    a += 1;
                }
                a = 0;
                String file_size;
                int filesize;
                int read2 = 0;
                int totalRead = 0;
                int remaining;
                byte [] bytes = new byte[4096];
                while (a < 10){
                    out.println("get_vd_img1:"+ trend_list[a]);
                    file_size = input.readLine();
                    filesize = Integer.valueOf(file_size);
                    remaining = filesize;
                    String filepath = getContext().getFilesDir().getPath() +"img"+a+".png";
                    File file = new File(filepath);
                    OutputStream outputStream = new FileOutputStream(file);
                    while ((read2 = dataInputStream.read(bytes, 0, Math.min(bytes.length, remaining))) > 0){
                        totalRead += read2;
                        remaining -= read2;
                        outputStream.write(bytes,0,read2);

                    }
                    a += 1;
                    outputStream.close();
                    filesize = 0;
                    read2 = 0;
                    totalRead = 0;
                    remaining = 0;
                    bytes = new byte[4096];
                }
                while (a < 20){
                    out.println("get_vd_img2:"+ trend_list[a]);
                    file_size = input.readLine();
                    filesize = Integer.valueOf(file_size);
                    remaining = filesize;
                    String filepath = getContext().getFilesDir().getPath() +"img"+a+".png";
                    File file = new File(filepath);
                    OutputStream outputStream = new FileOutputStream(file);
                    while ((read2 = dataInputStream.read(bytes, 0, Math.min(bytes.length, remaining))) > 0){
                        totalRead += read2;
                        remaining -= read2;
                        outputStream.write(bytes,0,read2);

                    }
                    a += 1;
                    outputStream.close();
                    filesize = 0;
                    read2 = 0;
                    totalRead = 0;
                    remaining = 0;
                    bytes = new byte[4096];
                }
                updateConversationHandler2.post(new updateUIThread3());


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    class updateUIThread2 implements Runnable {
        private String [] msg;
        private int no;
        public updateUIThread2(String[] str,int no) {
            this.msg = str;
            this.no = no;
        }
        @Override
        public void run() {
            String text;
            if(no == 0){
                text = msg[1] + " " + msg[0];
                textView1.setText(text);
                textView2.setText(msg[4]);
                textView3.setText(msg[3]);

            } else if(no == 1){
                text = msg[1] + " " + msg[0];
                textView4.setText(text);
                textView5.setText(msg[4]);
                textView6.setText(msg[3]);

            } else if(no == 2){
                text = msg[1] + " " + msg[0];
                textView7.setText(text);
                textView8.setText(msg[4]);
                textView9.setText(msg[3]);

            } else if(no == 3){
                text = msg[1] + " " + msg[0];
                textView10.setText(text);
                textView11.setText(msg[4]);
                textView12.setText(msg[3]);

            } else if(no == 4){
                text = msg[1] + " " + msg[0];
                textView13.setText(text);
                textView14.setText(msg[4]);
                textView15.setText(msg[3]);

            } else if(no == 5){
                text = msg[1] + " " + msg[0];
                textView16.setText(text);
                textView17.setText(msg[4]);
                textView18.setText(msg[3]);

            } else if(no == 6){
                text = msg[1] + " " + msg[0];
                textView19.setText(text);
                textView20.setText(msg[4]);
                textView21.setText(msg[3]);

            } else if(no == 7){
                text = msg[1] + " " + msg[0];
                textView22.setText(text);
                textView23.setText(msg[4]);
                textView24.setText(msg[3]);

            } else if(no == 8){
                text = msg[1] + " " + msg[0];
                textView25.setText(text);
                textView26.setText(msg[4]);
                textView27.setText(msg[3]);

            } else if(no == 9){
                text = msg[1] + " " + msg[0];
                textView28.setText(text);
                textView29.setText(msg[4]);
                textView30.setText(msg[3]);

            }


            //txtview.setText("Client Says: "+ msg + "\n");
        }
    }

    class updateUIThread3 implements Runnable {
        @Override
        public void run() {
            //float density = getContext().getResources().getDisplayMetrics().density;
            //int height = Math.round((float) 400 * density);
            //int width = Math.round((float) 500 * density);
            int height = 100;
            int width = 100;
            File file;
            file = new File(getContext().getFilesDir().getPath() +"img0.png");
            if (file.exists()) {
                imagebtn1.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img0.png"));
                imagebtn1.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn1.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
                }
            file = new File(getContext().getFilesDir().getPath()+"img1.png");
            if (file.exists()) {
                imagebtn3.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img1.png"));
                imagebtn3.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn3.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length())); 
            }
            file = new File(getContext().getFilesDir().getPath()+"img2.png");
            if (file.exists()) {
                imagebtn5.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img2.png"));
                imagebtn5.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn5.setMinimumHeight(height);
                textView5.setText(String.format("%s",file.length())); 
            }
            file = new File(getContext().getFilesDir().getPath()+"img3.png");
            if (file.exists()) {
                imagebtn7.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img3.png"));
                imagebtn7.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn7.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
                }
            file = new File(getContext().getFilesDir().getPath()+"img4.png");
            if (file.exists()) {
                imagebtn9.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img4.png"));
                imagebtn9.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn9.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
                }
            file = new File(getContext().getFilesDir().getPath()+"img5.png");
            if (file.exists()) {
                imagebtn11.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img5.png"));
                imagebtn11.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn11.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
            }
            file = new File(getContext().getFilesDir().getPath()+"img6.png");
            if (file.exists()) {
                imagebtn13.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img6.png"));
                imagebtn13.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn13.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
            }
            file = new File(getContext().getFilesDir().getPath()+"img7.png");
            if (file.exists()) {
                imagebtn15.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img7.png"));
                imagebtn15.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn15.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
            }
            file = new File(getContext().getFilesDir().getPath()+"img8.png");
            if (file.exists()) {
                imagebtn17.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img8.png"));
                imagebtn17.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn17.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
            }
            file = new File(getContext().getFilesDir().getPath()+"img9.png");
            if (file.exists()) {
                imagebtn19.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img9.png"));
                imagebtn19.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn19.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
            }
            file = new File(getContext().getFilesDir().getPath()+"img10.png");
            if (file.exists()) {
                imagebtn2.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img10.png"));
                imagebtn2.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn2.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
            }
            file = new File(getContext().getFilesDir().getPath()+"img11.png");
            if (file.exists()) {
                imagebtn4.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img11.png"));
                imagebtn4.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn4.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
            }
            file = new File(getContext().getFilesDir().getPath()+"img12.png");
            if (file.exists()) {
                imagebtn6.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img12.png"));
                imagebtn6.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn6.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
            }
            file = new File(getContext().getFilesDir().getPath()+"img13.png");
            if (file.exists()) {
                imagebtn8.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img13.png"));
                imagebtn8.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn8.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
            }
            file = new File(getContext().getFilesDir().getPath()+"img14.png");
            if (file.exists()) {
                imagebtn10.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img14.png"));
                imagebtn10.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn10.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
            }
            file = new File(getContext().getFilesDir().getPath()+"img15.png");
            if (file.exists()) {
                imagebtn12.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img15.png"));
                imagebtn12.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn12.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
            }
            file = new File(getContext().getFilesDir().getPath()+"img16.png");
            if (file.exists()) {
                imagebtn14.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img16.png"));
                imagebtn14.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn14.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
            }
            file = new File(getContext().getFilesDir().getPath()+"img17.png");
            if (file.exists()) {
                imagebtn16.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img17.png"));
                imagebtn16.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn16.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
            }
            file = new File(getContext().getFilesDir().getPath()+"img18.png");
            if (file.exists()) {
                imagebtn18.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img18.png"));
                imagebtn18.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn18.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
            }
            file = new File(getContext().getFilesDir().getPath()+"img19.png");
            if (file.exists()) {
                imagebtn20.setImageURI(Uri.parse(getContext().getFilesDir().getPath()+"img19.png"));
                imagebtn20.setMinimumWidth(width);
                FrameLayout.LayoutParams parms = new FrameLayout.LayoutParams(width,height);
                imagebtn20.setMinimumHeight(height);
                textView1.setText(String.format("%s",file.length()));
            }
        }

    }

}
