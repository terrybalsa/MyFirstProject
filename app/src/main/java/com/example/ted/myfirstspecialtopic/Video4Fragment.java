package com.example.ted.myfirstspecialtopic;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Video4Fragment extends Fragment {
    VideoView vvPlayer4 = null;
    Button btnVideo4;
    TextView textL4;


    public  void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vvPlayer4 = (VideoView) getActivity().findViewById(R.id.vvplayer4);
        btnVideo4 = (Button) getActivity().findViewById(R.id.btnVideo4);
        textL4 = (TextView) getActivity().findViewById(R.id.textL4);
        btnVideo4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo(R.raw.oil);
                showzombie(R.raw.zombie);
            }
        });
    }
    public void playVideo(int tvmaId){
        vvPlayer4.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + tvmaId));
        vvPlayer4.setMediaController(new MediaController(getActivity()));
        vvPlayer4.requestFocus();
        vvPlayer4.start();
    }
    public  View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        return  inflater.inflate(R.layout.tvma,container,false);
    }

    public  void  onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
    }



    private  void showzombie(int zombieId){
        InputStream zombieFile = getResources().openRawResource(zombieId);

        String zombie = "",line;
        BufferedReader br;
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(zombieFile));
            while ((line=bf.readLine())!=null){
                zombie+=line+"\n";

            }
            bf.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        textL4.setText(zombie);
    }



    public boolean onOptionsItemSelected(MenuItem item){
        int id =item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
