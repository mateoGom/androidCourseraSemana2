package com.example.tareasemana2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout srLayout;
    ListView lvList;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miFab();

        srLayout=  findViewById(R.id.srLayout);
        lvList = findViewById(R.id.lvList);
        String[] planetas= getResources().getStringArray(R.array.planetas);
        lvList.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,planetas));
        srLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });
    }

public void refreshContent(){
    String[] planetas= getResources().getStringArray(R.array.planetas2);
    lvList.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,planetas));
    srLayout.setRefreshing(false);
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
