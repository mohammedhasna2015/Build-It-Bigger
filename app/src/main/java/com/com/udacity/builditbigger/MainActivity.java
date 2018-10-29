package com.com.udacity.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import mohamedcoder.telljoks.TellJokeActivity;
import com.udacity.builditbigger.R;


public class MainActivity extends AppCompatActivity implements EndpointAsyncTask.Callback{

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
        new EndpointAsyncTask(this).execute();
    }


    @Override
    public void onFinished(String result) {
        Intent intent = new Intent(this, TellJokeActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, result);
        startActivity(intent);
    }
}
