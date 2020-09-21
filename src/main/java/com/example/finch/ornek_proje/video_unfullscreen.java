package com.example.finch.ornek_proje;

import android.nfc.Tag;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.Toast;
import android.view.View;
import android.net.Uri;
import android.widget.RelativeLayout;
import android.widget.PopupWindow;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.os.Handler;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.DataInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

public class video_unfullscreen extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    ImageButton start_btn;
    ImageButton setting_btn;
    RelativeLayout main_layout;
    PopupWindow popupwin;
    TextView txtview;
    public String current_video_number = "12345";
    public String video_name;
    public String vd_canal;
    public String vd_time;
    public String vd_length;
    public String vd_watched;
    boolean win_bool = false;
    protected String dstAddress = "192.168.1.39";
    protected int dstPort = 2000;
    private String TAG = getClass().getName();
    private Socket socket;
    private static final int SERVERPORT = 2000;
    private static final String SERVER_IP = "192.168.1.40";
    private BufferedReader input;
    private BufferedWriter output;
    Handler updateConversationHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        current_video_number = extras.getString("vd_number");
        setContentView(R.layout.activity_video_unfullscreen);
        main_layout = (RelativeLayout) findViewById(R.id.mn_layout);
        //Tab stuff
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new about_video(), "Hakkında");
        viewPagerAdapter.addFragments(new recommendations_video(), "Öneriler");
        viewPagerAdapter.addFragments(new comments_video(), "Yorumlar");
        viewPagerAdapter.addFragments(new history_video(), "Geçmiş");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        //Tab stuff ending

        start_btn = (ImageButton) findViewById(R.id.start_btn);
        setting_btn = (ImageButton) findViewById(R.id.sets_btn);
        txtview = (TextView)  findViewById(R.id.video_txt1);

        //video stuff

        new Thread(new GetVideoInfo()).start();
        //video stuff

    }
    public void onButtonClick(View v) {
        VideoView mVideoView = (VideoView) findViewById(R.id.videovw);
        //Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()+"tempVideo.mp4");
        //mVideoView.setVideoURI(uri);
        //mVideoView.seekTo(0);
        //mVideoView.start();

        //Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.test);
        start_btn.setVisibility(View.INVISIBLE);
    }
    public void onSetBtnClick(View v){

        if (!win_bool){
            createPopupWindow();
        }
        if (win_bool){
            ClosePopupWindow();
        }
    }

    public void onLiked(View view){
        add_to_favourites(current_video_number);
    }

    public void add_to_favourites(String text){
        try {

            FileOutputStream fileout=openFileOutput("info.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(text+"\n");
            outputWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createPopupWindow(){
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);
        int width = RelativeLayout.LayoutParams.MATCH_PARENT;
        popupwin = new PopupWindow(popupView, width,250, true);
        popupwin.showAtLocation(main_layout, Gravity.BOTTOM, 0, 0);
    }

    public  void  ClosePopupWindow(){
        popupwin.dismiss();
    }

    class GetVideoInfo implements Runnable {

        @Override
        public void run() {
                try {
                    InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
                    socket = new Socket(serverAddr, SERVERPORT);
                    output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())),
                    true);
                    out.println("get_video_info_less:");
                    String read = input.readLine();
                    updateConversationHandler.post(new updateUIThread(read));
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    class updateUIThread implements Runnable {
        private String msg;
        public updateUIThread(String str) {
            this.msg = str;
        }
        @Override
        public void run() {
            txtview.setText("Client Says: "+ msg + "\n");
        }
    }
}

class VideoDownloadTask extends AsyncTask<Void, Void, Void> {

    private String dstAddress;
    private int dstPort;
    String response = "";
    private Socket socket=null;

    VideoDownloadTask(String addr, int port){
        dstAddress = addr;
        dstPort = port;
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        try {
            socket = new Socket(InetAddress.getByName(dstAddress), dstPort);
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                if(socket!=null)socket.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }


        File f = new File(Environment.getExternalStorageDirectory().getPath()+"tempVideo.mp4");

        try {
            f.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DataInputStream in=null;
        try {
            in = new DataInputStream (socket.getInputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        FileOutputStream videoFile = null;
        try {
            videoFile = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int len;
        byte buffer[] = new byte[8192];

        try {
            while((len = in.read(buffer)) != -1) {
                videoFile.write(buffer, 0, len);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            videoFile.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }

}
