package com.example.note_1;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

public class AddReminderActivity extends AppCompatActivity implements View.OnClickListener {
    
    private EditText et_title;
    private EditText et_content;

    private Context context = this;
    
    private boolean isModeAdd;
    private int idNote;

    EditText et;

    ModeNotifPagerAdapter pgAdapter;
    String s = "hahaha";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        anhXa();

        final TabLayout tlModeNotif = findViewById(R.id.tl_mode_notif);
        final ViewPager vpModeNotif = findViewById(R.id.vp_mode_notif);
        pgAdapter = new ModeNotifPagerAdapter(getSupportFragmentManager());
        vpModeNotif.setAdapter(pgAdapter);
        tlModeNotif.setupWithViewPager(vpModeNotif);
        vpModeNotif.getCurrentItem();

        Intent intent = getIntent();
        idNote = intent.getExtras().getInt("idNote");
        if (idNote != -1)
        {
            isModeAdd = false;
            MyDatabaseHelper db = new MyDatabaseHelper(this);
            Note note = db.getNote(idNote);
            et_title.setText(note.getTitle());
            et_content.setText(note.getContent());
        }
        else isModeAdd = true;

        /*vpModeNotif.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if(i == 0){
                    ModeNotifPagerAdapter.mode_notif_1 a = new ModeNotifPagerAdapter.mode_notif_1();

                    Log.e("ZZZZZZZZZZZ: ", "0000000000000000000000");
                }
                if(i == 1){
                    Log.e("ZZZZZZZZZZZ: ", "1111111111111111111111");
                }
                if(i == 2){
                    ModeNotifPagerAdapter.mode_notif_3 mode3 = new ModeNotifPagerAdapter.mode_notif_3();
                   mode3.anhXa();
                    String s = mode3.getTime_repeat() == null ? "Null" : "Not NULL";
                    Log.e("ZZZZZZZZZZZ: ", s);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });*/

//        et.setText("10");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_actionbar_add_reminder, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void anhXa() {
        et_title = (EditText) findViewById(R.id.et_tile_main2);
        et_content = (EditText) findViewById(R.id.et_content_main2);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;

            case R.id.save_reminder:
                String titleNote = String.valueOf(et_title.getText());
                String contentNote = String.valueOf(et_content.getText());
                MyDatabaseHelper db = new MyDatabaseHelper(this);
                if (isModeAdd)
                db.addNote(new Note(titleNote, contentNote, "", 0, true));
                else db.editNote(idNote, new Note(titleNote, contentNote, "", 0, true));
                finish();
                return true;
        }
        return super .onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

    }
}
