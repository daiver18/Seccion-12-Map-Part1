package com.example.daiverandresdoria.seccion_12_map.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.daiverandresdoria.seccion_12_map.Fragments.MapFragment;
import com.example.daiverandresdoria.seccion_12_map.Fragments.WelcomeFragment;
import com.example.daiverandresdoria.seccion_12_map.R;

public class MainActivity extends AppCompatActivity {

    private Fragment currentlyFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Home");

        if (savedInstanceState == null){
            currentlyFragment = new MapFragment();
            changeFragment(currentlyFragment);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuWelcome:
                currentlyFragment = new WelcomeFragment();
                break;
            case R.id.menuMap:
                currentlyFragment = new MapFragment();
                break;
        }
        changeFragment(currentlyFragment);
        return super.onOptionsItemSelected(item);
    }

    private void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_Container,fragment).commit();
    }
}
