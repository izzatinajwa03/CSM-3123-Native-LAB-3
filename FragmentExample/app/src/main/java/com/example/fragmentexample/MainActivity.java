package com.example.fragmentexample;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            Fragment myFragment = new MyFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, myFragment);
            transaction.commit();
        }
    }

    public void sendDataToFragment2(String data) {
        Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentByTag("fragment2");
        if (fragment2 != null) {
            fragment2.updateData(data);
        }
    }

    public void loadFragment2() {

        Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentByTag("fragment2");
        if (fragment2 == null) {
            fragment2 = new Fragment2();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment2, "fragment2");
            transaction.addToBackStack(null); // Optionally, add it to the back stack
            transaction.commit();
        } else {
            // If Fragment2 is already loaded, send the data immediately
            sendDataToFragment2("Hello from Fragment1");
        }
    }
}