package com.example.ada;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class Drawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new OverallSummaryFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_summary);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_my_account:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MyAccountFragment()).commit();
                break;
            case R.id.nav_summary:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new OverallSummaryFragment()).commit();
                break;
            case R.id.nav_savings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MySavingsFragment()).commit();
                break;
            case R.id.nav_loans:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MyLoansFragment()).commit();
                break;
            case R.id.nav_incomes:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MyIncomesFragment()).commit();
                break;
            case R.id.nav_expenses:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MyExpensesFragment()).commit();
                break;
            case R.id.nav_cards:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MyCardsFragment()).commit();
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutFragment()).commit();
                break;
            case R.id.nav_signout:
                Toast.makeText(this, "Signing out...", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    public void setActionBarTitle(String title){
        setTitle(title);
    }
}