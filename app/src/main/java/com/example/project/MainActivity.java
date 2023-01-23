package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.application.MyApplication;
import com.example.project.model.Data;
import com.example.project.model.ProductDetail;
import com.example.project.model.ProductsItem;
import com.example.project.network.ApiInterface;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onStart() {
        SharedPreferences sharedPreferences=getSharedPreferences("sample",MODE_PRIVATE);
        super.onStart();
        Button button2=findViewById(R.id.bt_2);
        Set<String> hash_Set = sharedPreferences.getStringSet("id",new HashSet<>());
        if(hash_Set.size()>0)
            button2.setVisibility(View.VISIBLE);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),wishlist.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences=getSharedPreferences("sample",MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ApiInterface apiInterface = ((Application) getApplication()).retrofit.create(ApiInterface.class);


        Button btn=findViewById(R.id.bt_1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et=findViewById(R.id.et);
                String searchTerm=String.valueOf(et.getText());
                if(searchTerm.length()==0)
                    Toast.makeText(v.getContext(),"search can't be empty",Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(v.getContext(), SecondPage.class);
                    intent.putExtra("searchTerm", searchTerm);
                    startActivity(intent);
                }

            }
        });




    }//APF-70017-00150-00008
}