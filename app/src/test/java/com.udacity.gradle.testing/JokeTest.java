package com.udacity.gradle.builditbigger;

import org.junit.Test;
import static org.junit.Assert.*;
import com.example.JokeProvider;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;
import com.udacity.gradle.builditbigger.MainActivity;

public class JokeTest extends ActivityInstrumentationTestCase2{
    public JokeTest() {
        super(MainActivity.class);
    }


    @Test
    public void testIfTheJokeExists(){
        String joke= JokeProvider.getJoke();
        assertFalse(joke.isEmpty());
    }
    @Test
    public void testIfTheJokeExistsInAsyncTask(){

        EndpointsAsyncTask endpointsAsyncTask=new EndpointsAsyncTask();
        endpointsAsyncTask.execute(getActivity());

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