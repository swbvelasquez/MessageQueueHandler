package com.tutoriales.messagequeuehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TaskHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            handler = new TaskHandler(getMainLooper(),this);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void startThread(View view){
        ManagerMessageTask messageTask = new ManagerMessageTask(handler);
        messageTask.startThread();
    }
}