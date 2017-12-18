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

public class Video2Fragment extends Fragment {
    VideoView vvPlayer2 = null;
    Button btnVideo2;
    TextView textL2;


    public  void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vvPlayer2 = (VideoView) getActivity().findViewById(R.id.vvplayer2);
        btnVideo2 = (Button) getActivity().findViewById(R.id.btnVideo2);
        textL2 = (TextView) getActivity().findViewById(R.id.textL2);
        btnVideo2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo(R.raw.small);
                showsmallbin(R.raw.smallbin);
            }
        });
    }
    public void playVideo(int tvy7Id){
        vvPlayer2.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + tvy7Id));
        vvPlayer2.setMediaController(new MediaController(getActivity()));
        vvPlayer2.requestFocus();
        vvPlayer2.start();
    }
    public  View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        return  inflater.inflate(R.layout.tvy7,container,false);
    }

    public  void  onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
    }

    private  void showsmallbin(int smallbinId){
        InputStream smallbinFile = getResources().openRawResource(smallbinId);

        String smallbin = "",line;
        BufferedReader br;
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(smallbinFile));
            while ((line=bf.readLine())!=null){
                smallbin+=line+"\n";

            }
            bf.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        textL2.setText(smallbin);
    }



    public boolean onOptionsItemSelected(MenuItem item){
        int id =item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
