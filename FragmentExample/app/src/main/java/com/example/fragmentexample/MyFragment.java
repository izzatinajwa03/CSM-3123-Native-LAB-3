package com.example.fragmentexample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.Button;


public class MyFragment extends Fragment {
    private static final String TAG = "MyFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        View view = inflater.inflate(R.layout.fragment_my, container, false); // Inflate the view first

        // Now set up the button
        Button sendButton = view.findViewById(R.id.sendButton);
        sendButton.setOnClickListener(v -> {
            // Load Fragment2 and send data to it
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).loadFragment2();
                ((MainActivity) getActivity()).sendDataToFragment2("Hello from Fragment1");
            }
        });

        return view; // Return the view after setting up the button
    }


    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroyV");
    }
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }
}
