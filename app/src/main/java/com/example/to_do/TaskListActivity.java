package com.example.to_do;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class TaskListActivity extends SingleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

    }
    protected Fragment createFragment()
    {
        Fragment fragment= new TaskFragment();
        return fragment;
    }
}