package com.tutoriales.messagequeuehandler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class TaskHandler extends Handler {
    private static final String TAG = "TaskHandler";
    private final AppCompatActivity compatActivity;

    public TaskHandler(Looper looper,AppCompatActivity compatActivity) {
        super(looper);
        this.compatActivity = compatActivity;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        try {
            TextView tvTitle = compatActivity.findViewById(R.id.tvTitle);
            ManagerMessageTask messageTask = (ManagerMessageTask)msg.obj;
            String message = String.valueOf(messageTask.getResult());
            switch (msg.what) {
                case 0:
                    Toast.makeText(compatActivity, "case 0", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(compatActivity, "case 1", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(compatActivity, "case 2", Toast.LENGTH_SHORT).show();
                    break;
            }

            if(tvTitle!=null){
                tvTitle.setText(message);
            }
        }catch (Exception ex){
            Log.d(TAG, "handleMessage: " + ex.getMessage());
        }
    }
}
