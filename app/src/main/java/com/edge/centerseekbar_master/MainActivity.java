package com.edge.centerseekbar_master;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.edge.edge_centerseekbar.CenterSeekBar;

/**
 * Created by user1 on 2017-11-23.
 */

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    CenterSeekBar centerSeekBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.parent);
        CenterSeekBar centerSeekBar = new CenterSeekBar.Builder().with(getApplicationContext())
                .setThumbColor(R.color.colorAccent)
                .setBackgroundColor(R.color.colorPrimary)
                .setHeight(10f)
                .setProgressColor(R.color.colorPrimaryDark)
                .build();
        linearLayout.addView(centerSeekBar);
    }
}
