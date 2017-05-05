package org.example.admusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class Admuic extends AppCompatActivity {
    private Button play;
    private Button pause;
    private Button stop;
    private Button next;
    private Button previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admuic);

        play = (Button) findViewById(R.id.btnPlay);
        pause = (Button) findViewById(R.id.btnPause);
        stop = (Button) findViewById(R.id.btnStop);
        next = (Button) findViewById(R.id.btnNext);
        previous = (Button) findViewById(R.id.btnPrevious);
    }

    public void play(View view){
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "play");
        sendBroadcast(intent);
    }
    public void pause(View view){
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        sendBroadcast(intent);
    }
    public void stop(View view){
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "stop");
        sendBroadcast(intent);
    }
    public void next(View view){
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "next");
        sendBroadcast(intent);
    }
    public void previous(View view){
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "previous");
        sendBroadcast(intent);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event){
        super.onKeyUp(keyCode, event);
        if(keyCode==KeyEvent.KEYCODE_VOLUME_UP){
            next(next);
            return true;
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        super.onKeyDown(keyCode, event);
        if(keyCode==KeyEvent.KEYCODE_VOLUME_DOWN){
            previous(previous);
            return true;
        }
        return false;
    }
}
