package com.example.divya.demoday;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class activity_judge extends AppCompatActivity {
    ArrayList<String> selection = new ArrayList<String>();
    private Button button;
    private TextView textView;
    public EditText name, design, place;
   /** private CheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15;**/

     private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_judge);
        name = (EditText) findViewById(R.id.editText3);
        design = (EditText) findViewById(R.id.editText);
        place = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);
        textView=(TextView) findViewById(R.id.textView6);
        textView.setEnabled(false);
        textView.setVisibility(View.GONE);
        progressBar = (ProgressBar)findViewById(R.id.progressBar6) ;
        progressBar.setVisibility(View.GONE);
        /**c1 = (CheckBox) findViewById(R.id.checkBox23);
        c2 = (CheckBox) findViewById(R.id.checkBox22);
        c3 = (CheckBox) findViewById(R.id.checkBox19);
        c4 = (CheckBox) findViewById(R.id.checkBox18);
        c5 = (CheckBox) findViewById(R.id.checkBox17);
        c6 = (CheckBox) findViewById(R.id.checkBox16);
        c7 = (CheckBox) findViewById(R.id.checkBox15);
        c8 = (CheckBox) findViewById(R.id.checkBox14);
        c9 = (CheckBox) findViewById(R.id.checkBox13);
        c10 = (CheckBox) findViewById(R.id.checkBox12);
        c11 = (CheckBox) findViewById(R.id.checkBox24);
        c12 = (CheckBox) findViewById(R.id.checkBox25);
        c13 = (CheckBox) findViewById(R.id.checkBox26);
        c14 = (CheckBox) findViewById(R.id.checkBox27);
        c15 = (CheckBox) findViewById(R.id.checkBox28);**/



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submit();
            }
        });

    }

    private void submit() {

        final String namee = name.getText().toString().trim();
        final String designation = design.getText().toString().trim();
        final String workplace = place.getText().toString().trim();
        String teams="";
        for(String Selections: selection)
        {
            teams=teams+Selections+"\n";
        }
        textView.setText(teams);
        textView.setEnabled(true);
        final String teamss=textView.getText().toString().trim();
        if (namee.isEmpty()) {
            Toast.makeText(this, "Please enter name", Toast.LENGTH_LONG).show();

            return;
        }
        if (designation.isEmpty()) {
            Toast.makeText(this, "Please enter designation", Toast.LENGTH_LONG).show();

            return;
        }
        if (workplace.isEmpty()) {
            Toast.makeText(this, "Please enter workplace", Toast.LENGTH_LONG).show();

            return;
        }


        if(!TextUtils.isEmpty(namee)&&!TextUtils.isEmpty(designation)&&!TextUtils.isEmpty(workplace) ) {
            progressBar.setVisibility(View.VISIBLE);
            judges judge = new judges(namee, designation, workplace,teamss);
            FirebaseDatabase.getInstance().getReference("judges")
                    .child(namee)
                    .setValue(judge).addOnCompleteListener(new OnCompleteListener<Void>() {
                public void onComplete(@NonNull Task<Void> task) {
                    progressBar.setVisibility(View.GONE);
                    if (task.isSuccessful()) {
                        Toast.makeText(activity_judge.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        name.setText("");
                        design.setText("");
                        place.setText("");
                        Intent i=new Intent(activity_judge.this,activity_score.class);
                        i.putExtra("name",namee);
                        startActivity(i);
                        }
                    else
                    {
                        Toast.makeText(activity_judge.this, "Registration Failed,Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }






    }

    public void selectitem(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox23:
                if (checked) {
                    selection.add("1.goFish");
                } else {
                        selection.remove("1.goFish");
                }
                break;
            case R.id.checkBox22:
                if (checked) {
                    selection.add("2.Smart handwash monitoring");
                } else {
                    selection.remove("2.Smart handwash monitoring");
                }
                break;
            case R.id.checkBox19:
                if (checked) {
                    selection.add("3.Popcorn vending machine");
                } else {
                    selection.remove("3.Popcorn vending machine");
                }
                break;
            case R.id.checkBox18:
                if (checked) {
                    selection.add("4.Truck weighing");
                } else {
                    selection.remove("4.Truck weighing");
                }
                break;
            case R.id.checkBox17:
                if (checked) {
                    selection.add("5.Insulin Pump");
                } else {
                    selection.remove("5.Insulin Pump");
                }
                break;
            case R.id.checkBox16:
                if (checked) {
                    selection.add("6.GrowthBox");
                } else {
                    selection.remove("6.GrowthBox");
                }
                break;
            case R.id.checkBox15:
                if (checked) {
                    selection.add("7.MaxByte");
                } else {
                    selection.remove("7.MaxByte");
                }
                break;
            case R.id.checkBox14:
                if (checked) {
                    selection.add("8.TestedOk");
                } else {
                    selection.remove("8.TestedOk");
                }
                break;
            case R.id.checkBox13:
                if (checked) {
                    selection.add("9.Kitty Cam");
                } else {
                    selection.remove("9.Kitty Cam");
                }
                break;
            case R.id.checkBox12:
                if (checked) {
                    selection.add("10.iHale");
                } else {
                    selection.remove("10.iHale");
                }
                break;
            case R.id.checkBox24:
                if (checked) {
                    selection.add("11.AirBot");
                } else {
                    selection.remove("11.AirBot");
                }
                break;
            case R.id.checkBox25:
                if (checked) {
                    selection.add("12.SpyCam");
                } else {
                    selection.remove("12.SpyCam");
                }
                break;
            case R.id.checkBox26:
                if (checked) {
                    selection.add("13.AquaBot");
                } else {
                    selection.remove("13.AquaBot");
                }
                break;
            case R.id.checkBox27:
                if (checked) {
                    selection.add("14.60min health checkup");
                } else {
                    selection.remove("14.60min health checkup");
                }
                break;
            case R.id.checkBox28:
                if (checked) {
                    selection.add("15.Industry 4.0");
                } else {
                    selection.remove("15.Industry 4.0");
                }
                break;
        }
    }
}
