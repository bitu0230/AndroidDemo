package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.project.adapter.ProductDetailAdapter;
import com.example.project.application.MyApplication;
import com.example.project.model.Data;
import com.example.project.model.ProductDetail;
import com.example.project.model.ProductsItem;
import com.example.project.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class wishlist extends AppCompatActivity {


    List<ProductsItem> productsItems=new ArrayList<>();
    int size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);
        SharedPreferences sharedPreferences=getSharedPreferences("sample",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

//        String data1=sharedPreferences.getString("name",null);
//        String data2=sharedPreferences.getString("price",null);
//        String data3=sharedPreferences.getString("img",null);
//        String data4=sharedPreferences.getString("rating",null);

        Set<String> hash_Set = sharedPreferences.getStringSet("id",null);

        size=hash_Set.size();
        for(String sku_id:hash_Set) {
            ApiInterface apiInterface = ((MyApplication) getApplication()).retrofit.create(ApiInterface.class);
            apiInterface.search(sku_id, false, 20, 0, 0).enqueue(new Callback<ProductDetail>() {
                @Override
                public void onResponse(Call<ProductDetail> call, Response<ProductDetail> response) {

                    if (response.isSuccessful() && response.body() != null) {
                        Data data = response.body().getData();
                        Log.i("got it ", " " + response.code());
                        List<ProductsItem> productsItemsList = data.getProducts();
                        for (ProductsItem p : productsItemsList) {
                            System.out.println("product name" + p.getName());
                            productsItems.add(p);
                            size-=1;
                        }
                    }

                }

                @Override
                public void onFailure(Call<ProductDetail> call, Throwable t) {
                    Log.i("failedd", " " + call);
                }
            });

        }


        Button button=findViewById(R.id.bt_wish);
        button.setOnClickListener(v -> {
            RecyclerView rv;
            rv=findViewById(R.id.rv_wishlist);
            ProductDetailAdapter productDetailAdapter;
            productDetailAdapter = new ProductDetailAdapter(productsItems);
            rv.setAdapter(productDetailAdapter);
            rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        });







        //WishModel wishModel=new WishModel(data1,data4,data3,data2);

//        RecyclerView rv1=findViewById(R.id.rv_wishlist);
//        rv1.setAdapter(new WishlistAdapter(wishModel));
//        rv1.setLayoutManager(new LinearLayoutManager(rv1.getContext()));


        //List<WishModel> wishModelList=new ArrayList<>();




    }

}