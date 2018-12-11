package com.balex.android.academymovielist;

import android.os.AsyncTask;
import android.widget.TextView;

public class CountDown1 extends AsyncTask {

    private TextView asyncTextView;

    public CountDown1 (TextView pTextView) {
        asyncTextView = pTextView;
    }

    protected String doInBackground(Integer ... numbers) {
        for (Integer number: numbers) {
            publishProgress(number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "Done!";
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }
}
