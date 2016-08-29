package jp.techacademy.toshiakinishiyama.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // メンバ変数
    TextView mTextView;         // 画面表示用のテキストビュー
    int mHourOfDay;             // 時間
    int mMinute;                // 分

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 時刻に応じた挨拶を判断し、表示するためのボタン
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);

        // 時刻を設定するためのボタン
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);

        // 挨拶を表示するためのテキストビュー
        mTextView = (TextView)findViewById(R.id.textView);

        // 初期値設定
        mHourOfDay = 13;
        mMinute = 0;
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.button1)
        {
            showAisatsu();
        }
        else if(v.getId() == R.id.button2)
        {
            showTimePickerDialog();
        }
    }

    private void showAisatsu()
    {
        if((mHourOfDay >= 2) && (mHourOfDay <= 9))
        {
            mTextView.setText("「おはよう」");
        }
        else if((mHourOfDay >= 10) && (mHourOfDay <= 17))
        {
            mTextView.setText("「こんにちは」");
        }
        else
        {
            mTextView.setText("「こんばんは」");
        }
    }

    private void showTimePickerDialog()
    {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));

                        // メンバ変数に保存
                        mHourOfDay = hourOfDay;
                        mMinute = minute;
                    }
                },
                13,         // 初期値（時間）
                0,          // 初期値（分）
                true
        );
        timePickerDialog.show();
    }
}
