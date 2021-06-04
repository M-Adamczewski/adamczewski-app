package com.AdamczewskiIndustries;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private Button add_button;
    private Button losu;
    private ListView listView;
    private EditText editText;
    private ListAdapter listAdapter;
    private List<String> texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        add_button = (Button) findViewById(R.id.add_button);
        losu = (Button) findViewById(R.id.losu);
        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText);



        texts = new ArrayList<>();
        listAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, texts);
        listView.setAdapter(listAdapter);

        losu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("onClick", "" + v.getId());
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                AlertDialog.Builder adb = new AlertDialog.Builder(ListActivity.this)
                                                        .setTitle("Usuwanie")
                                                        .setMessage("Czy na pewno usunąć " + texts.get(position))
                                                        .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                texts.remove(position);
                                                                listView.invalidateViews();
                                                                Toast.makeText(getApplicationContext(), "Usuwam!", Toast.LENGTH_LONG)
                                                                        .show();
                                                                    }
                                                                })
                                                        .setNegativeButton("Nie",  new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                Toast.makeText(getApplicationContext(), "Nie usuwam!", Toast.LENGTH_LONG)
                                                                        .show();

                                                                    }
                                                                });
                                                adb.show();
                                            }
                                        }
        );
    }
    public void addText(View v) {
        String text = editText.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, R.string.edittext_cant_be_empty,
                    Toast.LENGTH_LONG)
                    .show();
        } else {
            texts.add(text);
            listView.invalidateViews();
            editText.getText().clear();
        }
    }
}