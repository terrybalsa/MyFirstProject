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

public class Video3Fragment extends Fragment {
    VideoView vvPlayer3 = null;
    Button btnVideo3;
    TextView textL3;


    public  void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vvPlayer3 = (VideoView) getActivity().findViewById(R.id.vvplayer3);
        btnVideo3 = (Button) getActivity().findViewById(R.id.btnVideo3);
        textL3 = (TextView) getActivity().findViewById(R.id.textL3);
        btnVideo3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo(R.raw.red);
                showredgirl(R.raw.redgirl);
            }
        });
    }
    public void playVideo(int tv14Id){
        vvPlayer3.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + tv14Id));
        vvPlayer3.setMediaController(new MediaController(getActivity()));
        vvPlayer3.requestFocus();
        vvPlayer3.start();
    }
    public  View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        return  inflater.inflate(R.layout.tv14,container,false);
    }

    public  void  onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
    }



    private  void showredgirl(int redgirlId){
        InputStream redgirlFile = getResources().openRawResource(redgirlId);

        String redgirl = "",line;
        BufferedReader br;
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(redgirlFile));
            while ((line=bf.readLine())!=null){
                redgirl+=line+"\n";

            }
            bf.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        textL3.setText(redgirl);
    }



    public boolean onOptionsItemSelected(MenuItem item){
        int id =item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
