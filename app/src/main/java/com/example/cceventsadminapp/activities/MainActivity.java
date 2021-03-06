package com.example.cceventsadminapp.activities;

import android.os.Bundle;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.cceventsadminapp.R;

import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Codechef";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupBottomNavBar();
    }

    private void setupBottomNavBar() {
        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        SmoothBottomBar bottomBar = findViewById(R.id.bottomBar);
        PopupMenu popupMenu = new PopupMenu(this, null);
        popupMenu.inflate(R.menu.menu_bottom);
        bottomBar.setupWithNavController(popupMenu.getMenu(), navController);
    }
}

