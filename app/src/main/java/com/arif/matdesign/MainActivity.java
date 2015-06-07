package com.arif.matdesign;


import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import activity.FragmentDrawer;


class MainActivity extends ActionBarActivity implements FragmentDrawer.FragmentDrawerListener {
    private Toolbar toolbar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        try {
            drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
            drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
            drawerFragment.setDrawerListener(this);
        } catch (NullPointerException e)
        {
            e.printStackTrace();
        }





//    toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//        @Override
//        public boolean onMenuItemClick(MenuItem menuItem) {
//            switch (menuItem.getItemId()){
//                case R.id.action_search:
//                    Toast.makeText(getApplicationContext(),"Search Item selected",Toast.LENGTH_SHORT).show();
//                    return true;
//                case R.id.action_user:
//                    Toast.makeText(getApplicationContext(),"User Item selected",Toast.LENGTH_SHORT ).show();
//
//
//
//
//            }
//
//
//
//            return false;
//        }
//    });


//     toolbar.setOnClickListener(new View.OnClickListener() {
//         @Override
//         public void onClick(View v) {
//
//
//         }
//     });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id==R.id.action_search)
        {
            startActivity(new Intent(this,subActivity.class));


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onDrawerItemSelected(View view, int position) {

    }
}
