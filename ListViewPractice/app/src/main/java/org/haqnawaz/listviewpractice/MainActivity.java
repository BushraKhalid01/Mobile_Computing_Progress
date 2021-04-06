package org.haqnawaz.listviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ArrayList<String>friendArrayList;
    EditText editText;
    ListView listView;
    ArrayAdapter<String>arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.myListView);
        Button button=findViewById(R.id.btnAdd);
        editText=findViewById(R.id.editTextAdd);

        String[]friendList={"Ali","Saad","Musa","Yasin","Zia"};

        friendArrayList=new ArrayList<String>();
        friendArrayList.add("Musa");
        friendArrayList.add("Saad");
        friendArrayList.add("Ibrahim");
        friendArrayList.add("Shahid");
        friendArrayList.add("Mahad");

        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,friendArrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView, View view,int i,long l){
                Log.d("you clicked",friendArrayList.get(i));
                Intent intent =new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("Friend Name",friendArrayList.get(i));
                startActivity(intent);
            }
        });

    }

    public void AddFriend(View view) {
        friendArrayList.add(editText.getText().toString());
        //listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        Collections.sort(friendArrayList);
    }
}