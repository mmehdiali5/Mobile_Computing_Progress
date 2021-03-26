package com.mmali.listpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> friendArrayList;
    EditText editText;
    ArrayAdapter<String>arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.myListView);
        editText=findViewById(R.id.addPerson);
        String[] friendList={"Ali","Saad","Musa","Zia"};
        friendArrayList=new ArrayList<String>();
        friendArrayList.add("Ali");
        friendArrayList.add("Babar");
        friendArrayList.add("Shabbir");
        friendArrayList.add("Yasir");

        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,friendArrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("You clicked",friendArrayList.get(position));
                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("Friend Name",friendArrayList.get(position));
                startActivity(intent);
            }
        });
    }

    public void addPerson(View view) {
        arrayAdapter.notifyDataSetChanged();
        friendArrayList.add(editText.getText().toString());
        Collections.sort(friendArrayList);
    }

}