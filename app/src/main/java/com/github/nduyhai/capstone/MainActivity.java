package com.github.nduyhai.capstone;

import android.gesture.OrientedBoundingBox;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSolve;
    private EditText txtA;
    private EditText txtB;
    private EditText txtC;
    private TextView lblResult;
    private TextView x1;
    private TextView x2;

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
        lblResult = findViewById(R.id.LblResult);
        x1 = findViewById(R.id.LblX1);
        x2 = findViewById(R.id.LblX2);
    }

    public void onSolveQuadraticEquation(View view) {
        try {
            this.lblResult.setText("");
            this.x1.setText("");
            this.x2.setText("");

            Double a = Double.valueOf(txtA.getText().toString());
            Double b = Double.valueOf(txtB.getText().toString());
            Double c = Double.valueOf(txtC.getText().toString());


            if (a == 0 && b == 0) {
                this.lblResult.setText("Have no real roots");
            } else if (a == 0) {
                Double x = -c / b;
                this.lblResult.setText("Have exactly one real root");
                this.x1.setText("x="+x);
            } else {
                Double delta = b * b  - 4 * a * c;

                if (delta > 0) {  //2 root
                    Double x1 = (-b + Math.sqrt(delta))/(2*a);
                    Double x2 = (-b - Math.sqrt(delta))/(2*a);;

                    this.lblResult.setText("Have two distinct real roots");
                    this.x1.setText("x1=" + x1);
                    this.x2.setText("x2=" + x2);
                } else if (delta == 0) { //1 root
                    Double x = -b / (2 * a);

                    this.lblResult.setText("Have exactly one real root");
                    this.x1.setText("x="+x);
                } else { //0 root
                    this.lblResult.setText("Have no real roots");
                }
            }
        } catch (Exception ex) {
            Log.v("Invalid Number", ex.toString());
            this.lblResult.setText("Invalid Number");
        }

    }
}
