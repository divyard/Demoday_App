package com.example.divya.demoday;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class activity_score extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    FirebaseDatabase database;
    DatabaseReference users;
    private Button button;
    private SeekBar seekBar,seekBar2,seekBar3,seekBar4,seekBar5;
    private TextView textView,textView2,textView3,textView4,textView5,textView6;
    private String str;
    private int progress_value1,progress_value2,progress_value3,progress_value4,progress_value5;
    private EditText editText;
    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        bundle = getIntent().getExtras();
        button=(Button)findViewById(R.id.button);
        editText=(EditText) findViewById(R.id.comm);

        Intent intent = getIntent();
        intent.getStringExtra("name");
        textView6=(TextView) findViewById(R.id.te);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data();
            }
        });
        seekBar=(SeekBar) findViewById(R.id.sb1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value1=progress;
                textView.setText("Score : "+ progress + " / " +seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("Score : "+ progress_value1 + " / " +seekBar.getMax());

            }
        });
        textView=(TextView) findViewById(R.id.tx1) ;
        textView.setText("Score : "+ seekBar.getProgress() + " / " +seekBar.getMax());
        seekBar2=(SeekBar) findViewById(R.id.sb2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value2=progress;
                textView2.setText("Score : "+ progress + " / " +seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView2.setText("Score : "+ progress_value2 + " / " +seekBar.getMax());

            }
        });
        textView2=(TextView) findViewById(R.id.tx2) ;
        textView2.setText("Score : "+ seekBar2.getProgress() + " / " +seekBar2.getMax());
        seekBar3=(SeekBar) findViewById(R.id.sb3);
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value3=progress;
                textView3.setText("Score : "+ progress + " / " +seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView3.setText("Score : "+ progress_value3 + " / " +seekBar.getMax());

            }
        });
        textView3=(TextView) findViewById(R.id.tx3) ;
        textView3.setText("Score : "+ seekBar3.getProgress() + " / " +seekBar3.getMax());
        seekBar4=(SeekBar) findViewById(R.id.sb4);
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value4=progress;
                textView4.setText("Score : "+ progress + " / " +seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView4.setText("Score : "+ progress_value4 + " / " +seekBar.getMax());

            }
        });
        textView4=(TextView) findViewById(R.id.tx4) ;
        textView4.setText("Score : "+ seekBar4.getProgress() + " / " +seekBar4.getMax());
        seekBar5=(SeekBar) findViewById(R.id.sb5);
        seekBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value5=progress;
                textView5.setText("Score : "+ progress + " / " +seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView5.setText("Score : "+ progress_value5 + " / " +seekBar.getMax());

            }
        });
        textView5=(TextView) findViewById(R.id.tx5) ;
        textView5.setText("Score : "+ seekBar5.getProgress() + " / " +seekBar5.getMax());
        navigationView = (NavigationView) findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        database = FirebaseDatabase.getInstance();
        users = database.getReference().child("judges");
        /**button=(Button)findViewById(R.id.button6);**/
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /**button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jud();
            }
        });**/
    }


   public void data(){

        final String te=textView6.getText().toString().trim();
        final String tename = te.replaceAll("[^a-zA-Z0-9]", " ");
        final String namee= bundle.getString("name");
        final String pvcd=Integer.toString(progress_value1);
        final String innovation=Integer.toString(progress_value2);
        final String soln=Integer.toString(progress_value3);
        final String tech=Integer.toString(progress_value4);
        final String team=Integer.toString(progress_value5);
        final String comment=editText.getText().toString().trim();

        if (pvcd.isEmpty()) {
            Toast.makeText(this, "Do score", Toast.LENGTH_LONG).show();
            return;
        }
        if(comment.isEmpty()){
            Toast.makeText(this, "Please enter comment", Toast.LENGTH_LONG).show();
            return;
        }

        if(!TextUtils.isEmpty(pvcd) && !TextUtils.isEmpty(comment) ) {

            score s = new score(tename,namee,pvcd,innovation,soln,tech,team,comment);
            FirebaseDatabase.getInstance().getReference("scores")
                    .child(tename)
                    .setValue(s).addOnCompleteListener(new OnCompleteListener<Void>() {
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()) {
                        Toast.makeText(activity_score.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(activity_score.this, "Registration Failed,Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.db:
                Intent h = new Intent(this, activity_score.class);
                startActivity(h);
                break;
            case R.id.dbb:
                Intent j = new Intent(this, activity_handwash.class);
                startActivity(j);
                break;
            case R.id.setting:
                Intent i = new Intent(this, activity_setting.class);
                startActivity(i);
                break;
            case R.id.log:
                Intent g = new Intent(this, activity_judge.class);
                startActivity(g);
                break;


                }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    private void jud() {
        ArrayList<String> itemlist = new ArrayList<>();
        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot judges : dataSnapshot.getChildren()) {
                    judges info=judges.getValue(judges.class);
                    Toast.makeText(getApplicationContext(), "Name =" +info.getName(), Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }








    }

