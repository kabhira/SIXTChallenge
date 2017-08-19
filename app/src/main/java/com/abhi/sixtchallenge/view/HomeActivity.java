package com.abhi.sixtchallenge.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.abhi.sixtchallenge.R;
import com.abhi.sixtchallenge.utilities.FragmentTransactionHelper;

/**
 *  Author: Abhiraj Khare
 *  Description: Main Activity which houses all the fragments in the application.
 */

public class HomeActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fragmentManager = getSupportFragmentManager();
        FragmentTransactionHelper.switchFragment(this, R.id.content, CarListFragment.newInstance());
    }

    @Override
    public void onBackPressed() {
        if(fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
            return;
        }

        super.onBackPressed();
    }
}
