package com.example.a331androidpetukhova_landscapeposition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnPoint;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnDelete;
    private Button btnPositiveNegative;
    private Button btnPer;
    private Button btnDivide;
    private Button btnMultiplication;
    private Button btnMinus;
    private Button btnPlus;
    private Button btnEquals;
    private TextView result;
    private TextView numberField;
    private TextView operationField;
    String lastOperation = "=";
    Double operand = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnPoint = findViewById(R.id.btnPoint);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        result = findViewById(R.id.result);
        btnDelete = findViewById(R.id.btnDelete);
        btnPositiveNegative = findViewById(R.id.btnPositiveNegative);
        btnPer = findViewById(R.id.btnPer);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnEquals = findViewById(R.id.btnEquals);
        numberField = findViewById(R.id.numberField);
        operationField = findViewById(R.id.operationField);


        setOnClickButton();
        setOnClickOperation();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) { // сохранение состояния
        outState.putString("OPERATION", lastOperation);
        if (operand != null)
            outState.putDouble("OPERAND", operand);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastOperation = savedInstanceState.getString("OPERATION");
        operand = savedInstanceState.getDouble("OPERAND");
        result.setText(operand.toString());
        operationField.setText(lastOperation);
    }


    private void setOnClickButton() {
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberField.append(btnPoint.getText());
                if (lastOperation.equals("=") && operand != null) {
                    operand = null;
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberField.append(btn0.getText());
                if (lastOperation.equals("=") && operand != null) {
                    operand = null;
                }
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberField.append(btn1.getText());
                if (lastOperation.equals("=") && operand != null) {
                    operand = null;
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberField.append(btn2.getText());
                if (lastOperation.equals("=") && operand != null) {
                    operand = null;
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberField.append(btn3.getText());
                if (lastOperation.equals("=") && operand != null) {
                    operand = null;
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberField.append(btn4.getText());
                if (lastOperation.equals("=") && operand != null) {
                    operand = null;
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberField.append(btn5.getText());
                if (lastOperation.equals("=") && operand != null) {
                    operand = null;
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberField.append(btn6.getText());
                if (lastOperation.equals("=") && operand != null) {
                    operand = null;
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberField.append(btn7.getText());
                if (lastOperation.equals("=") && operand != null) {
                    operand = null;
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberField.append(btn8.getText());
                if (lastOperation.equals("=") && operand != null) {
                    operand = null;
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //result.setText("9");
                numberField.append(btn9.getText());
                if (lastOperation.equals("=") && operand != null) {
                    operand = null;
                }
            }
        });

    }

    private void setOnClickOperation() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String op = btnDelete.getText().toString();
                String number = numberField.getText().toString();
                if (number.length() > 0) {
                    try {
                        performOperation(Double.valueOf(number), op);
                    } catch (NumberFormatException ex) {
                        numberField.setText("");
                    }
                }
                operand = null;
                lastOperation = "";
                operationField.setText(lastOperation);
                numberField.setText("");
                result.setText("");
            }
        });


        btnDivide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String op = btnDivide.getText().toString();
                String number = numberField.getText().toString();
                if (number.length() > 0) {
                    try {
                        performOperation(Double.valueOf(number), op);
                    } catch (NumberFormatException ex) {
                        numberField.setText("");
                    }
                }
                lastOperation = op;
                operationField.setText(lastOperation);
            }
        });
        btnEquals.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String op = btnEquals.getText().toString();
                String number = numberField.getText().toString();
                if (number.length() > 0) {
                    try {
                        performOperation(Double.valueOf(number), op);
                    } catch (NumberFormatException ex) {
                        numberField.setText("");
                    }
                }
                lastOperation = op;
                operationField.setText(lastOperation);
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String op = btnMinus.getText().toString();
                String number = numberField.getText().toString();
                if (number.length() > 0) {
                    try {
                        performOperation(Double.valueOf(number), op);
                    } catch (NumberFormatException ex) {
                        numberField.setText("");
                    }
                }
                lastOperation = op;
                operationField.setText(lastOperation);
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String op = btnPlus.getText().toString();
                String number = numberField.getText().toString();
                if (number.length() > 0) {
                    try {
                        performOperation(Double.valueOf(number), op);
                    } catch (NumberFormatException ex) {
                        numberField.setText("");
                    }
                }
                lastOperation = op;
                operationField.setText(lastOperation);
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String op = btnPlus.getText().toString();
                String number = numberField.getText().toString();
                if (number.length() > 0) {
                    try {
                        performOperation(Double.valueOf(number), op);
                    } catch (NumberFormatException ex) {
                        numberField.setText("");
                    }
                }
                lastOperation = op;
                operationField.setText(lastOperation);
            }
        });
        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String op = btnMultiplication.getText().toString();
                String number = numberField.getText().toString();
                if (number.length() > 0) {
                    try {
                        performOperation(Double.valueOf(number), op);
                    } catch (NumberFormatException ex) {
                        numberField.setText("");
                    }
                }
                lastOperation = op;
                operationField.setText(lastOperation);
            }
        });
        btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String op = btnPer.getText().toString();
                String number = numberField.getText().toString();
                if (number.length() > 0) {
                    try {
                        performOperation(Double.valueOf(number), op);
                    } catch (NumberFormatException ex) {
                        numberField.setText("");
                    }
                }
                lastOperation = op;
                operationField.setText(lastOperation);
            }
        });
        btnPositiveNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String op = btnPositiveNegative.getText().toString();
                String number = numberField.getText().toString();
                if (number.length() > 0) {
                    try {
                        performOperation(Double.valueOf(number), op);
                    } catch (NumberFormatException ex) {
                        numberField.setText("");
                    }
                }
                lastOperation = op;
                operationField.setText(lastOperation);

            }
        });

    }

    private void performOperation(Double number, String operation) {

        // если операнд ранее не был установлен (при вводе самой первой операции)
        if (operand == null) {
            operand = number;
        } else {
            if (lastOperation.equals("=")) {
                lastOperation = operation;
            }
            switch (lastOperation) {
                case "=":
                    operand = number;
                    break;
                case "/":
                    if (number == 0) {
                        operand = 0.0;
                    } else {
                        operand /= number;
                    }
                    break;
                case "x":
                    operand *= number;
                    break;
                case "+":
                    operand += number;
                    break;
                case "-":
                    operand -= number;
                    break;
                case "C":
                    operand = null;
                    break;
                case "%":
                    operand *= number / 100;
                    break;
                case "+/-":
                    operand = number * (-1);
                    break;
            }
        }

        result.setText(operand.toString());
        numberField.setText("");
    }
}

















