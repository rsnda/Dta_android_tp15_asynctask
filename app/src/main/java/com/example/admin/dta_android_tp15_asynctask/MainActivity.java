package com.example.admin.dta_android_tp15_asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar bar;
    Traitement traitement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = (ProgressBar) findViewById(R.id.progressBar);

        traitement = new Traitement();
        traitement.execute();



    }

    class Traitement extends AsyncTask<Void, Integer, String> {

        @Override
        protected String doInBackground(Void... voids) {

            int progress;
            for (progress = 0; progress <= 100; progress++){
                if (isCancelled()) break;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){

                }
                publishProgress(progress);
            }
            return " , dong !";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            bar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), "Ding !" + result, Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onCancelled() {
            Toast.makeText(getApplicationContext(), "D'oh !", Toast.LENGTH_LONG).show();
        }
    }
}
