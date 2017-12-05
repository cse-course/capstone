package com.github.nduyhai.capstone;

import android.gesture.OrientedBoundingBox;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSolve;
    private EditText txtA;
    private EditText txtB;
    private EditText txtC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
    }

    private void init() {
        btnSolve = findViewById(R.id.BtnSolve);
        txtA = findViewById(R.id.TxtA);
        txtB = findViewById(R.id.TxtB);
        txtC = findViewById(R.id.TxtC);
    }

    public void onSolveQuadraticEquation(View view) {

        Double a = Double.valueOf(txtA.getText().toString());
        Double b = Double.valueOf(txtB.getText().toString());
        Double c = Double.valueOf(txtC.getText().toString());

        if (a == 0 && b == 0) {
            Toast.makeText(this, "Have no real roots", Toast.LENGTH_LONG).show();
        } else if (a == 0) {
            Double x = -c / b;
            Toast.makeText(this,
                    String.join("\n", "Have exactly one real root", "x=" + x),
                    Toast.LENGTH_LONG).show();
        } else {
            Double delta = b * b - 4 * a * c;
            if (delta > 0) {  //2 root
                Double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                Double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                ;
                Toast.makeText(this,
                        String.join("\n", "Have two distinct real roots", "x1=" + x1, "x2=" + x2),
                        Toast.LENGTH_LONG).show();
            } else if (delta == 0) { //1 root
                Double x = -b / (2 * a);
                Toast.makeText(this,
                        String.join("\n", "Have exactly one real root", "x=" + x),
                        Toast.LENGTH_LONG).show();
            } else { //0 root
                Toast.makeText(this, "Have no real roots", Toast.LENGTH_LONG).show();
            }
        }


    }
}
