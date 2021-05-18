package com.tutoriales.messagequeuehandler;

import android.os.Handler;
import android.os.Message;

public class ManagerMessageTask {
    private int result;
    private final TaskHandler handler;

    public ManagerMessageTask(TaskHandler handler) {
        this.handler = handler;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void startThread(){
        TaskThread thread = new TaskThread(this);
        thread.start();
    }

    public void sendMessage(int what){
        Message message = handler.obtainMessage(what,this);
        message.sendToTarget();
    }
}
