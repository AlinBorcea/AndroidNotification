package com.alin.androidnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String CHANNEL_1_ID = "1";
    public static final String CHANNEL_2_ID = "2";
    public static final String CHANNEL_1_NAME = "Channel_One";
    public static final String CHANNEL_2_NAME = "Channel_Two";

    private EditText title, descr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.edit_text_title);
        descr = findViewById(R.id.edit_text_description);

        findViewById(R.id.button_send_notification_one).setOnClickListener(this);
        findViewById(R.id.button_send_notification_two).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_send_notification_one:
                NotificationHelper.sendNotification(this, CHANNEL_1_ID, CHANNEL_1_NAME,
                        NotificationManager.IMPORTANCE_DEFAULT,
                        title.getText().toString(), descr.getText().toString(),
                        R.drawable.ic_launcher_background);
                break;

            case R.id.button_send_notification_two:
                NotificationHelper.sendNotification(this, CHANNEL_2_ID, CHANNEL_2_NAME,
                        NotificationManager.IMPORTANCE_DEFAULT,
                        title.getText().toString(), descr.getText().toString(),
                        R.drawable.ic_launcher_background);
                break;
        }

    }
}
