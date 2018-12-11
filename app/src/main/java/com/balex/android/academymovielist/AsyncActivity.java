package com.balex.android.academymovielist;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncActivity extends AppCompatActivity {

    private static final String SAVED_STATE_CURRENT_NUMBER = "LAST_NUMBER";
    private static final String SAVED_STATE_TV_TEXT = "SAVED_TEXT";
    private static final Integer COUNT_DOWN_STARTS_FROM = 9;

    private TextView countDownTextView;
    private CountDown task;
    private static Integer currentNumber;
    private static String currentText;
    private static boolean isRunning;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        countDownTextView = findViewById(R.id.tv_async);

        Log.d("Alex", "in onCreate AsyncActivity");

        if (savedInstanceState != null) {
            currentText = savedInstanceState.getString(SAVED_STATE_TV_TEXT);
            currentNumber = savedInstanceState.getInt(SAVED_STATE_CURRENT_NUMBER);
            Log.d("Alex", "we have saved data-currNum: " + currentNumber);

            if (currentText != null) { countDownTextView.setText(currentText); }

            if (currentNumber != 0) {
                task = new CountDown(countDownTextView);
                isRunning = true;
                task.execute(currentNumber);
            }
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
    public void onSaveInstanceState(Bundle outState) {
        //Toast.makeText(getApplicationContext(), "onSaveInst currentNumber: " + currentNumber, Toast.LENGTH_SHORT).show();
        Log.d("Alex","AsyncActivity.onSaveInstanceState is running: " + isRunning + "currNum: " + currentNumber);
        super.onSaveInstanceState(outState);
        if (isRunning) {
            outState.putInt(SAVED_STATE_CURRENT_NUMBER, currentNumber);
        }
        outState.putString(SAVED_STATE_TV_TEXT, currentText);
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
            currentText = "";
            asyncTextView.setText(currentText);
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
            currentText = result;
            asyncTextView.setText(currentText);
        }

        @Override
        protected void onCancelled() {
            currentText = "Cancelled!";
            asyncTextView.setText(currentText);
        }
    }

}
