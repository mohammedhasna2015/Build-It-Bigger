package com.com.udacity.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.udacity.builditbigger.R;

import mohamedcoder.telljoks.TellJokeActivity;



public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        final Context ct = this;
        (new EndpointsAsyncTask(
                new EndpointsAsyncTask.AsyncResponse(){

                    @Override
                    public void processFinish(String output){
                        //Here you will receive the result fired from async class
                        //of onPostExecute(result) method.
                        Intent myIntent = new Intent(ct, TellJokeActivity.class);
                        myIntent.putExtra(Intent.EXTRA_TEXT, output);
                        startActivity(myIntent);
                    }
                }
        )).execute(new Pair<Context, String>(this, "Manfred"));
    }


}
