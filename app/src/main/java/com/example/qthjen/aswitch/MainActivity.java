package com.example.qthjen.aswitch;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch      swtHello;
    CheckBox    cbJava;
    CheckBox    cbSwift;
    CheckBox    cbKotlin;
    Button      btCheck;
    RadioGroup  radioGroup;
    ProgressBar pb;
    Button      btDownloads;
    SeekBar     sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swtHello    = (Switch)      findViewById(R.id.swtHello);
        cbJava      = (CheckBox)    findViewById(R.id.cbJava);
        cbSwift     = (CheckBox)    findViewById(R.id.cbSwift);
        cbKotlin    = (CheckBox)    findViewById(R.id.cbKotlin);
        btCheck     = (Button)      findViewById(R.id.btCheck);
        radioGroup  = (RadioGroup)  findViewById(R.id.radioGroup);
        pb          = (ProgressBar) findViewById(R.id.pb);
        btDownloads = (Button)      findViewById(R.id.btDownloads);
        sb          = (SeekBar)     findViewById(R.id.sb);

        swtHello.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if ( isChecked ) { //isChecked == true thì switch đang được bật
                    Toast.makeText(MainActivity.this, "Switch is opening", Toast.LENGTH_SHORT).show();
                } else { // isChecked == false thì switch đã tắt
                    Toast.makeText(MainActivity.this, "Switch is closing", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cbJava.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if ( isChecked) {
                    Toast.makeText(MainActivity.this, "You are choose Java", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You are not Java", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lenguagePrograming = "You are choose: ";
                if ( cbJava.isChecked()) { // isChecked giống với isSelected trong javaSwing
                    lenguagePrograming += cbJava.getText().toString() + ", ";
                }
                if ( cbSwift.isChecked()) {
                    lenguagePrograming += cbSwift.getText().toString() + ", ";
                }
                if ( cbKotlin.isChecked()) {
                    lenguagePrograming += cbKotlin.getText().toString();
                }
                Toast.makeText(MainActivity.this, lenguagePrograming, Toast.LENGTH_SHORT).show();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch ( checkedId ) {

                    case R.id.rbJava:
                        Toast.makeText(MainActivity.this, "You are selected Java", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbKotlin:
                        Toast.makeText(MainActivity.this, "You are selected Kotlin", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbSwift:
                        Toast.makeText(MainActivity.this, "You are selected Swift", Toast.LENGTH_SHORT).show();
                        break;
                    /** hàm isCheked trong radioButton tương tự như checkBox và tương tự như isSelected trong javaSwing **/
                }
            }
        });

        btDownloads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /** 10000 = 10 giây
                 *  1000 = 1 giấy
                 *  Tức là chạy hết khối lệnh (do something) trong hàm onTick chạy trong 10 giây và cứ 1 giây lại chạy lại
                 *  khối lệnh trong onTick **/

                CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = pb.getProgress();
                        if ( current >= pb.getMax()) {
                            current = 0;
                        }
                        pb.setProgress(current + 10);
                    }

                    @Override
                    public void onFinish() {
                        this.start(); // để nó chạy ko dừng
                        Toast.makeText(MainActivity.this, "End", Toast.LENGTH_SHORT).show();
                    }
                };
                countDownTimer.start();
            }
        });

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("Key","Result: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("Key","Start");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("Key","Stop");
            }
        });

        // sb.getProgress(); giống với progressBar

    }
}
