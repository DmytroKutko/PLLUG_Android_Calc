package ua.com.zzz.dmytrokutko.pllug_calc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero,
            btnPoint, btnResult, btnDiv, btnDelete, btnPi, btnMult, btnLScope, btnRScope, btnMinus,
            btnSin, btnCos, btnPlus, btnTg, btnClear, btnPow, btnSquare, btnHistory;

    TextView tvExp;

    static List<String> history;

    private static String expression = "";
    private boolean mistake;
    private String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnOnClick();
        tvExp.setText(expression);
    }

    private void btnOnClick() {
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "1";
                tvExp.setText(expression);
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "2";
                tvExp.setText(expression);
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "3";
                tvExp.setText(expression);
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "4";
                tvExp.setText(expression);
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "5";
                tvExp.setText(expression);
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "6";
                tvExp.setText(expression);
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "7";
                tvExp.setText(expression);
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "8";
                tvExp.setText(expression);
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "9";
                tvExp.setText(expression);
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "0";
                tvExp.setText(expression);
            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += ".";
                tvExp.setText(expression);
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += " = " + eval(expression);
                if (mistake) {
                    expression = "";
                }
                mistake = false;
                tvExp.setText(expression);
                if (expression != "") {
                    history.add(expression);
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "/";
                tvExp.setText(expression);
            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "*";
                tvExp.setText(expression);
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "-";
                tvExp.setText(expression);
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "+";
                tvExp.setText(expression);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expression.length() != 0) {
                    expression = expression.substring(0, expression.length() - 1);
                }
                tvExp.setText(expression);
            }
        });
        btnPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += String.valueOf(Math.PI);
                tvExp.setText(expression);
            }
        });
        btnLScope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "(";
                tvExp.setText(expression);
            }
        });
        btnRScope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += ")";
                tvExp.setText(expression);
            }
        });
        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "sin(";
                tvExp.setText(expression);
            }
        });
        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "cos(";
                tvExp.setText(expression);
            }
        });
        btnTg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "tan(";
                tvExp.setText(expression);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = "";
                tvExp.setText(expression);
            }
        });
        btnPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "^";
                tvExp.setText(expression);
            }
        });
        btnSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "sqrt(";
                tvExp.setText(expression);
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, History.class);
                startActivity(intent);
            }
        });
        tvExp.setText(expression);
    }

    private void init() {
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnZero = findViewById(R.id.btnZero);
        btnPoint = findViewById(R.id.btnPoint);
        btnResult = findViewById(R.id.btnResult);
        btnDiv = findViewById(R.id.btnDiv);
        btnMult = findViewById(R.id.btnMult);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnDelete = findViewById(R.id.btnDelete);
        btnPi = findViewById(R.id.btnPi);
        btnLScope = findViewById(R.id.btnLScope);
        btnRScope = findViewById(R.id.btnRScope);
        btnSin = findViewById(R.id.btnSin);
        btnCos = findViewById(R.id.btnCos);
        btnTg = findViewById(R.id.btnTg);
        btnClear = findViewById(R.id.btnClear);
        btnPow = findViewById(R.id.btnPow);
        btnSquare = findViewById(R.id.btnSquare);
        btnHistory = findViewById(R.id.btnHistory);
        history = new ArrayList<>();
        tvExp = findViewById(R.id.tvExp);
    }

    private strictfp String eval(String expression) {
        double val;
        mistake = false;
        try {
            Expression e = new ExpressionBuilder(expression).build();
            val = e.evaluate();
            res = String.format("%.4f", val);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Oops, wrong expression", Toast.LENGTH_SHORT).show();
            mistake = true;
        }
        return res;
    }
}