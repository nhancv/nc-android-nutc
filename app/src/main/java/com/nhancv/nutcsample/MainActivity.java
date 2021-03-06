package com.nhancv.nutcsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nhancv.nutc.NUtc;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    TextView tvMessage;
    Button btRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        btRequest = (Button) findViewById(R.id.btRequest);

        NUtc.getInstance().setEnableLog(true);
        NUtc.build(getApplicationContext());

        btRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLog("Request: " + NUtc.getUtcNow());
            }
        });
    }

    private void showLog(String message) {
        Log.e(TAG, message);
        tvMessage.setText(message);
    }
}
