package com.example.sendbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String MY_ACTION = "codefresher.ACTION";
    private static final String MY_TEXT1 = "codefresher.TEXT1";
    private static final String MY_TEXT2 = "codefresher.TEXT2";
    private static final String MY_TEXT3 = "codefresher.TEXT3";

    private Button btnSendBroadcast;
    private EditText tvSend1;
    private EditText tvSend2;
    private EditText tvSend3;

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(MY_ACTION.equals(intent.getAction()))
            {
//                String text1 = intent.getStringExtra(MY_TEXT1);
//                tvSend1.setText(text1);
//                String text2 = intent.getStringExtra(MY_TEXT2);
//                tvSend2.setText(text2);
//                String text3 = intent.getStringExtra(MY_TEXT3);
//                tvSend3.setText(text3);


            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendBroadcast = findViewById(R.id.btn_sendbroadcast);
        tvSend1 = findViewById(R.id.tv_send1);
        tvSend2 = findViewById(R.id.tv_send2);
        tvSend3 = findViewById(R.id.tv_send3);

        btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickSendBroadcast();
            }
        });
    }

    private void clickSendBroadcast() {

        String text1 = tvSend1.getText().toString().trim();
        String text2 = tvSend2.getText().toString().trim();
        String text3 = tvSend3.getText().toString().trim();

        Intent intent = new Intent(MY_ACTION);
//        intent.putExtra(MY_TEXT1, " Tran Tien Anh");
//        intent.putExtra(MY_TEXT2, " Trung Van - Ha Noi ");
//        intent.putExtra(MY_TEXT3, " HVANND");
        intent.putExtra(MY_TEXT1,text1);
        intent.putExtra(MY_TEXT2,text2);
        intent.putExtra(MY_TEXT3,text3);
        sendBroadcast(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(MY_ACTION);
        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mBroadcastReceiver);
    }
}