package com.example.scratch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SharedPreferences sharedpreferences = getSharedPreferences("nameKey", Context.MODE_PRIVATE);
        Toast.makeText(getApplicationContext(), sharedpreferences.getString("nameKey", ""), Toast.LENGTH_SHORT).show();



        // Create an instance of the AnnouncementsFragment
        FragmentAnunturi fragment = new FragmentAnunturi();

        // Get the FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Start a new FragmentTransaction
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // Add the fragment to the container in the activity layout (assuming the container is a FrameLayout with the id "fragment_container")
        transaction.replace(R.id.fragment_container, fragment);

        // Commit the transaction
        transaction.commit();
    }
}