package com.udacity.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;
import android.util.Log;
import android.util.Pair;

import junit.framework.Assert;
import com.com.udacity.builditbigger.*;
import java.util.concurrent.TimeUnit;

public class AsyncTest extends AndroidTestCase {
    private static final String LOG_TAG = "NonEmptyStringTest";
    public void testSomething() throws Throwable {

            String joke = null;
            EndpointsAsyncTask jokeTask = new EndpointsAsyncTask(
                    new EndpointsAsyncTask.AsyncResponse(){

                        @Override
                        public void processFinish(String output){

                        }
                    }
            );
            jokeTask.execute(new Pair<Context, String>(new MockContext(), "Manfred"));

            try{

            joke = jokeTask.get(30, TimeUnit.SECONDS);
                Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + joke);

        } catch (Exception e){
                e.printStackTrace();
        }
        Assert.assertNotNull(joke);
    }
}