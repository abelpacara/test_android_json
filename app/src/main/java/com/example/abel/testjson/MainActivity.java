package com.example.abel.testjson;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        resultView = (TextView) findViewById(R.id.resultView);

        Button btnSave = (Button) this.findViewById(R.id.btnSave);



        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click




                String result;
                result = "";
                EditText etNombre = (EditText) findViewById(R.id.name);
                EditText etEdad = (EditText) findViewById(R.id.age);

                String n;
                int e=0;
                n = etNombre.getText().toString();
                e = Integer.parseInt(etEdad.getText().toString());

                JSONObject json = new JSONObject();
                JSONArray jsarray = new JSONArray();
                try{
                    json.put("name",n);
                    json.put("edad",e);

                    jsarray.put("hola");
                    jsarray.put(100);
                    jsarray.put(-10);

                    json.put("array",jsarray);
                }catch (JSONException error){}


                resultView.setText(json.toString());



            }
        });







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
