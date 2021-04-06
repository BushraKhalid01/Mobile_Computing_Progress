package org.haqnawaz.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
    }
    public void Call(View view){
        Uri uri=Uri.parse("tel:+92334037449");
        Intent intent=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
    public void ShowWebsite(View view){
        Uri uri=Uri.parse("http://www.pucit.edu.pk");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}