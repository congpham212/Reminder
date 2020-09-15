package com.example.note_1;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    
    private EditText et_title;
    private EditText et_content;

    private Context context = this;
    
    private Button btn_once;
    private Button btn_loop;
    private Button btn_everyDay;

    String data[] = new String[]{"giây", "phút","giờ","ngày","tuần","tháng", "năm"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        
        anhXa();
        controlButton(this);
    }



    private void controlButton(final Activity main2) {
        btn_once.setOnClickListener((View.OnClickListener) main2);
        btn_loop.setOnClickListener((View.OnClickListener) main2);
        btn_everyDay.setOnClickListener((View.OnClickListener) main2);
    }

    private void anhXa() {
        et_title = (EditText) findViewById(R.id.et_tile_main2);
        et_content = (EditText) findViewById(R.id.et_content_main2);
        
        btn_once = (Button) findViewById(R.id.btn_1_lan);
        btn_loop = (Button) findViewById(R.id.btn_lapLai);
        btn_everyDay = (Button) findViewById(R.id.btn_hangNgay);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_1_lan: {
                android.support.v7.app.AlertDialog dialogCustom = new android.support.v7.app.AlertDialog.Builder(this)
                        .setTitle("")
                        .setView(R.layout.chon_gio)
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                dialogCustom.show();
                break;
            }

            case R.id.btn_lapLai: {
                android.support.v7.app.AlertDialog dialogCustom = new android.support.v7.app.AlertDialog.Builder(this)
                        .setTitle("")
                        .setView(R.layout.chon_gio_va_thu)
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // ok
                            }
                        }).setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // cancel
                            }
                        })
                        .create();
                dialogCustom.show();
                break;
            }

            case R.id.btn_hangNgay: {

                final AlertDialog.Builder d = new AlertDialog.Builder(context);
                LayoutInflater inflater = this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.chon_thoi_gian_lap_lai, null);
                d.setView(dialogView);
                final NumberPicker numberPicker = (NumberPicker) dialogView.findViewById(R.id.number_picker);
                numberPicker.setMaxValue(data.length-1);
                numberPicker.setMinValue(0);
                numberPicker.setDisplayedValues(data);
                numberPicker.setWrapSelectorWheel(true);
                numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
//                        Log.d(TAG, "onValueChange: ");
                    }
                });
                d.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Log.d(TAG, "onClick: " + numberPicker.getValue());
                    }
                });
                d.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AlertDialog alertDialog = d.create();
                alertDialog.show();


//                Toast.makeText(this, String.valueOf(picker.getId()), Toast.LENGTH_LONG).show();
//                android.support.v7.app.AlertDialog dialogCustom = new android.support.v7.app.AlertDialog.Builder(this)
//                        .setTitle("")
//                        .setView(R.layout.chon_thoi_gian_lap_lai)
//                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                // ok
//                            }
//                        }).setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                // cancel
//                            }
//                        })
//                        .create();
//                dialogCustom.show();
//
//                picker = new NumberPicker(dialogCustom.getContext());
//                picker = (NumberPicker) findViewById(R.id.number_picker);
//                picker.setMinValue(0);
//                picker.setMaxValue(data1.length);
//                picker.setDisplayedValues(data1);
                break;
            }
        }
    }
}