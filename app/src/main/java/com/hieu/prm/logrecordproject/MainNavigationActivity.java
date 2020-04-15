package com.hieu.prm.logrecordproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.hieu.prm.logrecordproject.features.user.login.view.ApplicationFragment;
import com.hieu.prm.logrecordproject.features.user.login.view.ApplicationInstanceFragment;
import com.hieu.prm.logrecordproject.features.user.login.view.ChangePasswordActivity;
import com.hieu.prm.logrecordproject.features.user.login.view.EmployeeFragment;
import com.hieu.prm.logrecordproject.features.user.login.view.HomeFragment;
import com.hieu.prm.logrecordproject.features.user.login.view.LogFragment;
import com.hieu.prm.logrecordproject.features.user.login.view.ProfileFragment;


public class MainNavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;
            case R.id.menu_application:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ApplicationFragment()).commit();
                break;
            case R.id.menu_application_instance:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ApplicationInstanceFragment()).commit();
                break;
            case R.id.menu_employee:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EmployeeFragment()).commit();
                break;
            case R.id.menu_log:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LogFragment()).commit();
                break;
            case R.id.menu_change_password:
                intent = new Intent(this, ChangePasswordActivity.class);
                break;
            case R.id.menu_logout:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void clickToMoveToProfile(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }

}
