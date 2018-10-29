package com.udacity.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;
import android.util.Pair;

import junit.framework.Assert;
import com.com.udacity.builditbigger.*;
import java.util.concurrent.TimeUnit;

public class AsyncTest extends AndroidTestCase {

    public void testSomething() throws Throwable {
        try {
            String joke = null;
            EndpointsAsyncTask jokeTask = new EndpointsAsyncTask(
                    new EndpointsAsyncTask.AsyncResponse(){

                        @Override
                        public void processFinish(String output){

                        }
                    }
            );
            jokeTask.execute(new Pair<Context, String>(new MockContext(), "Manfred"));
            joke = jokeTask.get(30, TimeUnit.SECONDS);
            Assert.assertNotNull(joke);
        } catch (Exception e){
            fail("Timed out");
        }
    }
}