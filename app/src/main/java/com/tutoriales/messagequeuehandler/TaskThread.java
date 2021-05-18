package com.tutoriales.messagequeuehandler;

import android.os.SystemClock;
import android.util.Log;

public class TaskThread extends Thread{

    private static final String TAG = "TaskThread";
    private final ManagerMessageTask managerMessageTask;

    public TaskThread(ManagerMessageTask managerMessageTask) {
        this.managerMessageTask = managerMessageTask;
    }

    @Override
    public synchronized void start() {
        super.start();
        Log.d(TAG, "start: ");
    }

    @Override
    public void run() {
       try{
           for (int i = 0; i < 3; i++) {
               Log.d(TAG, "run: " + i);
               managerMessageTask.setResult(1000+i);
               managerMessageTask.sendMessage(i);
               SystemClock.sleep(3000);
           }
           Log.d(TAG, "run: finished");
       }catch (Exception ex){
           ex.printStackTrace();
       }
    }

    @Override
    public void interrupt() {
        super.interrupt();
        Log.d(TAG, "interrupt: ");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d(TAG, "finalize: ");
    }
}
