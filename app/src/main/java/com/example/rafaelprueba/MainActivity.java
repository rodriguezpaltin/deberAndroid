package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.example.list.adapter.ListAdapter;
import com.example.list.adapter.adminSQL;
import com.example.rafaelprueba.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private TextView mostra_datos;
    private ListAdapter listItemAdapter;
    private ArrayList<String> listaNombres = new ArrayList<>();
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        llenarArreglo();
        listItemAdapter = new ListAdapter(this, listaNombres);

        listView.setAdapter(listItemAdapter);


        nombre = (EditText) findViewById(R.id.IngreseDatos);
        mostra_datos = (TextView) findViewById(R.id.textResult);setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        llenarArreglo();
        listItemAdapter = new ListAdapter(this, listaNombres);

        listView.setAdapter(listItemAdapter);


        nombre = (EditText) findViewById(R.id.IngreseDatos);
        mostra_datos = (TextView) findViewById(R.id.textResult);setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        llenarArreglo();
        listItemAdapter = new ListAdapter(this, listaNombres);

        listView.setAdapter(listItemAdapter);


        nombre = (EditText) findViewById(R.id.IngreseDatos);
        mostra_datos = (TextView) findViewById(R.id.textResult);setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        llenarArreglo();
        listItemAdapter = new ListAdapter(this, listaNombres);

        listView.setAdapter(listItemAdapter);


        nombre = (EditText) findViewById(R.id.IngreseDatos);
        mostra_datos = (TextView) findViewById(R.id.textResult);setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        llenarArreglo();
        listItemAdapter = new ListAdapter(this, listaNombres);

        listView.setAdapter(listItemAdapter);


        nombre = (EditText) findViewById(R.id.IngreseDatos);
        mostra_datos = (TextView) findViewById(R.id.textResult);

    }

    public void llenarArreglo() {
        listaNombres.add("Hola mundo1");
        listaNombres.add("Hola mundo2");
        listaNombres.add("Hola mundo3");
        listaNombres.add("Hola mundo4");

        System.out.println("lista de nombres: " + listaNombres);

    }

    public void registrar(View view) {
        adminSQL admin = new adminSQL(this, "administracion", null, 1);
        SQLiteDatabase basededatos = admin.getWritableDatabase();
        String nombree = nombre.getText().toString();
        if (!nombree.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("nombree", nombree);
            basededatos.insert("datos_personales",null, registro);
            Toast.makeText(this, "Su dato se ha guardado", Toast.LENGTH_SHORT).show();
            basededatos.close();
            nombre.setText("");
        }else{
            Toast.makeText(this, "Ingrese un datos", Toast.LENGTH_SHORT).show();
        } }
    public void mostrar_datos (View view){
        adminSQL adm = new adminSQL(this, "administracion", null,1);
        SQLiteDatabase basededatos = adm.getWritableDatabase();
        Cursor fila = basededatos.rawQuery
                ("select nombre from datos_personales", null);

        fila.moveToFirst();
        mostra_datos.setText("El dato que guardo es : " +fila.getString(0));
        basededatos.close();


    }

}