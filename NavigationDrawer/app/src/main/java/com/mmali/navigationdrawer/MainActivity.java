package com.mmali.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView nav;
    DrawerLayout drawer;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
            Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"End",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        nav=findViewById(R.id.navMENU);
        drawer=findViewById(R.id.myDrawer);
        toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.menu_home:
                        Toast.makeText(getApplicationContext(),"HOME IS CLICKED", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_Call:
                        Toast.makeText(getApplicationContext(),"Call IS CLICKED", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_Setting:
                        Toast.makeText(getApplicationContext(),"Setting IS CLICKED", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }
}