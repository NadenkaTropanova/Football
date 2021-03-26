package com.example.football;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.RequiresApi;

public class MainActivity extends Activity {

    TextView counter1View;
    TextView counter2View;
    private Integer counter1 = 0;
    private Integer counter2 = 0;
    ImageButton btnBLue;
    ImageButton btnGreen;
    Button btnReset;

    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter1View = (TextView) findViewById(R.id.TextViewScoreRussia);
        counter2View = (TextView) findViewById(R.id.TextViewScoreBrazil);
        btnGreen = (ImageButton) findViewById(R.id.imageButtonGreen);
        btnBLue = (ImageButton) findViewById(R.id.imageButtonBlue);
        btnReset = (Button) findViewById(R.id.ButtonReset);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResume() {
        super.onResume();
        counter1View.setText(counter1.toString());
        counter2View.setText(counter2.toString());
    }

    @SuppressLint({"ResourceType", "NonConstantResourceId", "SetTextI18n"})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageButtonBlue:
                counter1++;
                break;
            case R.id.imageButtonGreen:
                counter2++;
                break;
            case R.id.ButtonReset:
                counter1 = 0;
                counter2 = 0;
                break;
        }
        counter1View.setText(counter1.toString());
        counter2View.setText(counter2.toString());
    }

    // Вызывается перед выходом из активного состояния
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count 1", counter1);
        outState.putInt("count 2", counter2);
    }

    // Вызывается после завершения метода onCreate
    @Override
    public void onRestoreInstanceState(Bundle savedInstanteState) {
        super.onRestoreInstanceState(savedInstanteState);
        counter1 = savedInstanteState.getInt("count 1");
        counter2 = savedInstanteState.getInt("count 2");
    }
}
