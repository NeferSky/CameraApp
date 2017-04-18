package nefersky.cameraapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCamera(View view) {
        Intent intent = new Intent();
//        getGoogleCamera(intent);
        getStandardCamera(intent);
    }

    private void getStandardCamera(Intent intent){
        intent.setAction(Intent.ACTION_CAMERA_BUTTON);
        intent.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_CAMERA));
        sendOrderedBroadcast(intent, null);
    }

    private void getGoogleCamera(Intent intent){
        intent.setComponent(null);
        intent.setPackage("com.google.android.GoogleCamera");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
