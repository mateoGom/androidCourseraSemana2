package com.example.tareasemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miFab();

    }

public void miFab(){
    FloatingActionButton fab = findViewById(R.id.fab_airballoon);
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar.make(view, getResources().getString(R.string.message), Snackbar.LENGTH_SHORT)
                    .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            Log.i("SNACKBAR", "Click en snackbar");
                        }
                    })
                    .setActionTextColor(getColor(R.color.colorPrimary))
                    .show();
        }
    });
}

}
