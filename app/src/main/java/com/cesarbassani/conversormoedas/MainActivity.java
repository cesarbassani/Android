package com.cesarbassani.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDollar = findViewById(R.id.text_dollar);
        this.mViewHolder.textEduro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();
    }

    private void clearValues() {
        this.mViewHolder.textDollar.setText("");
        this.mViewHolder.textEduro.setText("");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.button_calculate) {
            Double value = Double.valueOf(this.mViewHolder.editValue.getText().toString());

            this.mViewHolder.textDollar.setText(String.format("%.2f", value * 3));
            this.mViewHolder.textEduro.setText(String.format("%.2f", value * 4));
        }
    }

    private static class ViewHolder {
        EditText editValue;
        TextView textDollar;
        TextView textEduro;
        Button buttonCalculate;
    }
}
