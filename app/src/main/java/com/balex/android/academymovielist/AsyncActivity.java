package com.balex.android.academymovielist;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncActivity extends AppCompatActivity {

    private TextView countDownTextView;
    private CountDown task;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        countDownTextView = findViewById(R.id.tv_async);
    }

    public void startButtonActions (View view) {
        //Toast.makeText (view.getContext(), "start async", Toast.LENGTH_SHORT).show();
        task = new CountDown(countDownTextView);
        task.execute(3,2,1);
    }

    public void cancelButtonActions (View view) {
        task.cancel(true);
    }

    public static class CountDown extends AsyncTask <Integer, Integer, String> {

        private TextView asyncTextView;

        public CountDown (TextView pTextView) {
            asyncTextView = pTextView;
        }

        protected String doInBackground(Integer ... numbers) {
            //Toast.makeText(asyncTextView.getContext(), "doInBackground my", Toast.LENGTH_SHORT ).show();
            for (Integer number: numbers) {
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

            return "Done!";
        }

        protected void onPreExecute() {
            asyncTextView.setText("");
        }

        protected void onProgressUpdate(Integer ... number) {
            asyncTextView.setText(String.valueOf(number[0]));
        }

        protected void onPostExecute(String result) {
            asyncTextView.setText(result);
        }

        @Override
        protected void onCancelled() {
            asyncTextView.setText("Cancelled!");
        }
    }

}
