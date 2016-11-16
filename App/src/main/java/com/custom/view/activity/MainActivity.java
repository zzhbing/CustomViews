package com.custom.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.custom.view.R;
import com.custom.view.activity.base.BaseActivity;
import com.custom.view.activity.view.UnlockViewActivity;

public class MainActivity extends BaseActivity {

    // ListView
    private ListView lstView = null;

    // Values
    private CustomView[] VALUES = {new CustomView(R.string.view_title_unlockView, R.string.view_introduction_unlockView, UnlockViewActivity.class)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.init();
    }

    private void init() {
        lstView = (ListView) findViewById(R.id.lst_view);
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, VALUES[position].getViewClass());
                MainActivity.this.startActivity(intent);
            }
        });

        lstView.setAdapter(new DefaultAdapter(this, VALUES));
    }
}
