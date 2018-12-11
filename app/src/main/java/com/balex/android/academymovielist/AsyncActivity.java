package com.balex.android.academymovielist;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AsyncActivity extends AppCompatActivity {

    private static final String SAVED_STATE_CURRENT_NUMBER = "LAST_NUMBER";
    private static final Integer COUNT_DOWN_STARTS_FROM = 5;

    private TextView countDownTextView;
    private CountDown task;
    private static Integer currentNumber;
    private static boolean isRunning;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        countDownTextView = findViewById(R.id.tv_async);

        if (savedInstanceState != null) {
            currentNumber = savedInstanceState.getInt(SAVED_STATE_CURRENT_NUMBER);
            task = new CountDown(countDownTextView);
            isRunning = true;
            task.execute(currentNumber);
        }
    }

    public void startButtonActions (View view) {
        //Toast.makeText (view.getContext(), "start async", Toast.LENGTH_SHORT).show();
        task = new CountDown(countDownTextView);
        //task.execute(3,2,1);
        isRunning = true;
        task.execute(COUNT_DOWN_STARTS_FROM);
    }

    public void cancelButtonActions (View view) {
        if (task != null) {
            task.cancel(true);
            isRunning = false;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (task != null) { task.cancel(true); }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (task != null) { task.cancel(true); }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        if (isRunning) {
            outState.putInt(SAVED_STATE_CURRENT_NUMBER, currentNumber);
        }
    }

    /** Async Task */
    public static class CountDown extends AsyncTask <Integer, Integer, String> {

        private TextView asyncTextView;

        CountDown (TextView pTextView) {
            asyncTextView = pTextView;
        }

        //protected String doInBackground(Integer ... numbers) {
        protected String doInBackground(Integer ... startNumber) {

            //for (Integer number: numbers) {
            for (Integer number = startNumber[0]; number > 0; number--) {
                if (!isCancelled()) {
                    publishProgress(number);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }

            isRunning = false;
            return "Done!";
        }

        protected void onPreExecute() {
            asyncTextView.setText("");
        }

        /**
        protected void onProgressUpdate(Integer ... number) {
            asyncTextView.setText(String.valueOf(number[0]));
        }
         */

        protected void onProgressUpdate(Integer ... number) {
            asyncTextView.setText(String.valueOf(number[0]));
            currentNumber = number[0];
        }

        protected void onPostExecute(String result) {
            asyncTextView.setText(result);
        }

        @Override
        protected void onCancelled() {
            asyncTextView.setText("cancelled");
        }
    }

}
