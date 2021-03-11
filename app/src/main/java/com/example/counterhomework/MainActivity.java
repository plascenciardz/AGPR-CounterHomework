package com.example.counterhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.txt_count);

        //Restaurar el estado de la aplicación
        if (savedInstanceState != null) {
            boolean mayorCero = savedInstanceState.getBoolean("mayor_cero");
            if (mayorCero) {
                mCount = Integer.parseInt(savedInstanceState.getString("text"));
                mShowCount.setText(savedInstanceState.getString("text"));
            }
        }
    }

    /**
     * Método para incrementar el contador
     * @param view
     */
    public void countIncrement(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    /**
     * Método en el que se guarda el estado de la aplicación
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mCount > 0) {
            outState.putBoolean("mayor_cero", true);
            outState.putString("text", mShowCount.getText().toString());
        }
    }


}