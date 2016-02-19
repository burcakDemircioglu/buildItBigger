package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.test.AndroidTestCase;
/**
 * Created by burcakdemircioglu on 19/02/16.
 */
public class AsyncTaskTest extends AndroidTestCase{
    public void testIfTheJokeExists(){
        EndpointsAsyncTask endpointsAsyncTask=new EndpointsAsyncTask();
        endpointsAsyncTask.execute(getContext());

        while(endpointsAsyncTask.getStatus() != AsyncTask.Status.FINISHED){
            SystemClock.sleep(500);
        }

        if(endpointsAsyncTask.getStatus() == AsyncTask.Status.FINISHED){
            String joke= endpointsAsyncTask.getResult();
            assertNotNull(joke);
            if(joke!=null)
                assertEquals(false, joke.isEmpty());
        }


    }
}
