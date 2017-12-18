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

public class Video1Fragment extends Fragment {
    VideoView vvPlayer1 = null;
    Button btnVideo1;
    TextView textL1;


public  void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    vvPlayer1 = (VideoView) getActivity().findViewById(R.id.vvplayer1);
    btnVideo1 = (Button) getActivity().findViewById(R.id.btnVideo1);
    textL1 = (TextView) getActivity().findViewById(R.id.textL1);
    btnVideo1.setOnClickListener(new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            playVideo(R.raw.lady);
            showmylady(R.raw.mylady);
        }
    });
}
public void playVideo(int tvyId){
vvPlayer1.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + tvyId));
vvPlayer1.setMediaController(new MediaController(getActivity()));
    vvPlayer1.requestFocus();
    vvPlayer1.start();
}
    public  View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        return  inflater.inflate(R.layout.tvy,container,false);
    }

    public  void  onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
    }

    private  void showmylady(int myladyId){
        InputStream myladyFile = getResources().openRawResource(myladyId);

        String mylady = "",line;
        BufferedReader br;
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(myladyFile));
            while ((line=bf.readLine())!=null){
                mylady+=line+"\n";

            }
            bf.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        textL1.setText(mylady);
    }



    public boolean onOptionsItemSelected(MenuItem item){
        int id =item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
