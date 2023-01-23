package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.HashSet;
import java.util.Set;

public class ProductDetailPage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences sharedPreferences=getSharedPreferences("sample",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail_page);
        String name=getIntent().getStringExtra("name");
        String price=getIntent().getStringExtra("price");
        String img=getIntent().getStringExtra("img");
        String rating=String.valueOf(getIntent().getStringExtra("rating"));
        String sku=getIntent().getStringExtra("def_sku_id");
        //hash_Set.add(sku);

        ImageView imageView=findViewById(R.id.iv_product_1);
        TextView textView1=findViewById(R.id.tv_product_1);
        TextView textView2=findViewById(R.id.tv_product_2);
        TextView textView3=findViewById(R.id.tv_product_3);

        // setting it according to user click
        Glide.with(imageView.getContext()).load(img).into(imageView);

        textView1.setText(name);
        textView2.setText(price);
        textView3.setText(rating);
        ImageView imageView2=findViewById(R.id.iv_product_2);


        Glide.with(imageView2.getContext()).load("https://icon-library.com/images/wishlist-icon/wishlist-icon-16.jpg").into(imageView2);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Glide.with(imageView2.getContext()).load("https://cdn-icons-png.flaticon.com/128/7245/7245139.png").into(imageView2);

                Set<String> hash_Set = new HashSet<>();
                hash_Set=sharedPreferences.getStringSet("id",hash_Set);
                hash_Set.add(sku);
                editor.putStringSet("id",hash_Set);

                editor.commit();

                //Intent intent=new Intent(v.getContext(),wishlist.class);
                //startActivity(intent);


            }
        });
    }
}