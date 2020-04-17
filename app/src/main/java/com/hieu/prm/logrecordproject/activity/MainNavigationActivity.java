package com.hieu.prm.logrecordproject.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.hieu.prm.logrecordproject.R;
import com.hieu.prm.logrecordproject.fragment.ApplicationFragment;
import com.hieu.prm.logrecordproject.fragment.ApplicationInstanceFragment;
import com.hieu.prm.logrecordproject.fragment.EmployeeFragment;
import com.hieu.prm.logrecordproject.fragment.LogFragment;
import com.hieu.prm.logrecordproject.fragment.ProfileFragment;
import com.hieu.prm.logrecordproject.response.AccountResponse;
import com.hieu.prm.logrecordproject.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainNavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer)
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);

        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        HeaderViewHolder headerViewHolder = new HeaderViewHolder(headerView);

        SharedPreferences preferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        if (preferences.contains(SharedPreferencesUtils.ACCOUNT)) {
            String json = SharedPreferencesUtils.getString(this, SharedPreferencesUtils.ACCOUNT);
            Gson gson = new Gson();
            AccountResponse accountResponse = gson.fromJson(json, AccountResponse.class);
            headerViewHolder.headerName.setText(accountResponse.getName());
            headerViewHolder.headerEmail.setText(accountResponse.getEmail());
        }

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ApplicationFragment()).commit();
        navigationView.setCheckedItem(R.id.menu_application);
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
            case R.id.menu_logout:
                logout();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void clickToMoveToProfile(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    protected class HeaderViewHolder {

        @BindView(R.id.nav_header_name)
        TextView headerName;
        @BindView(R.id.nav_header_email)
        TextView headerEmail;

        HeaderViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    private void logout() {
        SharedPreferences preferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
        Intent intent = new Intent(this, MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
