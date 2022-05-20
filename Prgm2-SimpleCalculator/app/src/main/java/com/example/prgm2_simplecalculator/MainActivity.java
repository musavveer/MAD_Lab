package com.example.prgm2_simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero,
            btnAdd, btnSub, btnMul, btnDiv, btnClr, btnEql, btnDot;
    EditText txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOne=(Button) findViewById(R.id.btn_1);
        btnOne.setOnClickListener(this);

        btnTwo=(Button) findViewById(R.id.btn_2);
        btnTwo.setOnClickListener(this);

        btnThree=(Button) findViewById(R.id.btn_3);
        btnThree.setOnClickListener(this);

        btnFour=(Button) findViewById(R.id.btn_4);
        btnFour.setOnClickListener(this);

        btnFive=(Button) findViewById(R.id.btn_5);
        btnFive.setOnClickListener(this);

        btnSix=(Button) findViewById(R.id.btn_6);
        btnSix.setOnClickListener(this);

        btnSeven=(Button) findViewById(R.id.btn_7);
        btnSeven.setOnClickListener(this);

        btnEight=(Button) findViewById(R.id.btn_8);
        btnEight.setOnClickListener(this);

        btnNine=(Button) findViewById(R.id.btn_9);
        btnNine.setOnClickListener(this);

        btnZero=(Button) findViewById(R.id.btn_0);
        btnZero.setOnClickListener(this);

        btnAdd=(Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);

        btnSub=(Button) findViewById(R.id.btn_sub);
        btnSub.setOnClickListener(this);

        btnDiv=(Button) findViewById(R.id.btn_div);
        btnDiv.setOnClickListener(this);

        btnMul=(Button) findViewById(R.id.btn_mul);
        btnMul.setOnClickListener(this);

        btnDot=(Button) findViewById(R.id.btn_dot);
        btnDot.setOnClickListener(this);

        btnClr=(Button) findViewById(R.id.btn_clr);
        btnClr.setOnClickListener(this);

        btnEql=(Button) findViewById(R.id.btn_eql);
        btnEql.setOnClickListener(this);

        txtRes=(EditText) findViewById(R.id.edit_txt);
        txtRes.setText("");
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnOne))
            txtRes.append("1");
        if (v.equals(btnTwo))
            txtRes.append("2");
        if (v.equals(btnThree))
            txtRes.append("3");
        if (v.equals(btnFour))
            txtRes.append("4");
        if (v.equals(btnFive))
            txtRes.append("5");
        if (v.equals(btnSix))
            txtRes.append("6");
        if (v.equals(btnSeven))
            txtRes.append("7");
        if (v.equals(btnEight))
            txtRes.append("8");
        if (v.equals(btnNine))
            txtRes.append("9");
        if (v.equals(btnZero))
            txtRes.append("0");
        if (v.equals(btnAdd))
            txtRes.append("+");
        if (v.equals(btnSub))
            txtRes.append("-");
        if (v.equals(btnDiv))
            txtRes.append("/");
        if (v.equals(btnMul))
            txtRes.append("*");
        if (v.equals(btnDot))
            txtRes.append(".");
        if (v.equals(btnClr))
            txtRes.setText("");
        if (v.equals(btnEql)) {
            try {
                String data = txtRes.getText().toString();
                if (data.contains("/")) {
                    division(data);
                } else if (data.contains("*")) {
                    multiplication(data);
                } else if (data.contains("+")) {
                    addition(data);
                } else if (data.contains("-")) {
                    subtraction(data);
                }
            }
            catch (Exception e) {
                displayInvalidMessage("Invalid  Input");
            }
        }
    }

    private void addition(String data) {
        String[] operands=data.split(Pattern.quote("+"));
        if (operands.length==2) {
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result=operand1+operand2;
            txtRes.setText(String.valueOf(result));
        }
        else {
            displayInvalidMessage("Invalid Input");
        }
    }

    private void subtraction(String data) {
        String[] operands=data.split("-");
        if (operands.length==2) {
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result=operand1-operand2;
            txtRes.setText(String.valueOf(result));
        }
        else {
            displayInvalidMessage("Invalid Input");
        }
    }

    private void multiplication(String data) {
        String[] operands=data.split(Pattern.quote("*"));
        if (operands.length==2) {
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result=operand1*operand2;
            txtRes.setText(String.valueOf(result));
        }
        else {
            displayInvalidMessage("Invalid Input");
        }
    }

    private void division(String data) {
        String[] operands=data.split("/");
        if (operands.length==2) {
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result=operand1/operand2;
            txtRes.setText(String.valueOf(result));
        }
        else {
            displayInvalidMessage("Invalid Input");
        }
    }

    private void displayInvalidMessage(String message) {
        Toast.makeText(getBaseContext(),message,Toast.LENGTH_LONG).show();
    }
}