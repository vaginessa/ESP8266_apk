package com.gta.administrator.infraredcontrol.bulb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.gta.administrator.infraredcontrol.R;

public class BulbActivity extends AppCompatActivity {
    private static final String TAG = "BulbActivity";

    private TextView txtColor;
    private ColorPickView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulb_brands);


        myView = (ColorPickView) findViewById(R.id.color_picker_view);
        txtColor = (TextView) findViewById(R.id.txt_color);
        myView.setOnColorChangedListener(new ColorPickView.OnColorChangedListener() {

            @Override
            public void onColorChange(int color) {



                Log.d(TAG, "color=" + color + ":" + Integer.toHexString(color));
                txtColor.setTextColor(color);
            }

        });

    }
}
