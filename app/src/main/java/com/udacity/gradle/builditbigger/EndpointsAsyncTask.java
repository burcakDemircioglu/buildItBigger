package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.example.burcakdemircioglu.libandroid.JokeActivity;
import com.example.burcakdemircioglu.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by burcakdemircioglu on 19/02/16.
 */
class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    String result;

    public String getResult() {
        return result;
    }

    Activity activity;

    EndpointsAsyncTask(Activity context){
        activity=context;
        ProgressBar progressBar=(ProgressBar)activity.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
    }
    EndpointsAsyncTask(){
        activity=null;
    }

    @Override
    protected String doInBackground(Context... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-1225.appspot.com/_ah/api/");
            myApiService = builder.build();
        }
        context = params[0];
        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        this.result = result;
        if(activity!=null) {
            ProgressBar progressBar = (ProgressBar) activity.findViewById(R.id.progressBar);
            progressBar.setVisibility(View.GONE);
            Intent intent = new Intent(context, JokeActivity.class);
            intent.putExtra("Joke", result);
            context.startActivity(intent);
        }


        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}