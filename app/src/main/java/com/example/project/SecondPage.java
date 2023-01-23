package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.project.adapter.ProductDetailAdapter;
import com.example.project.application.MyApplication;
import com.example.project.model.Data;
import com.example.project.model.ProductDetail;
import com.example.project.model.ProductsItem;
import com.example.project.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondPage extends AppCompatActivity implements ProductDetailAdapter.ProductDetailInterface {

    List<ProductsItem> productsItems=new ArrayList<>();
    RecyclerView rv;
    ProductDetailAdapter productDetailAdapter;
    int page=1;

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second_page);

        //ProgressBar progressBar;
        progressBar=findViewById(R.id.progressBar);
        rv=findViewById(R.id.as);
        productDetailAdapter = new ProductDetailAdapter(SecondPage.this,productsItems);
        rv.setAdapter(productDetailAdapter);
        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));

        ApiInterface apiInterface=((MyApplication)getApplication()).retrofit.create(ApiInterface.class);
        String searchTerm=getIntent().getStringExtra("searchTerm");
        progressBar.setVisibility(View.VISIBLE);
        apiInterface.search(searchTerm,false,20,0,0).enqueue(new Callback<ProductDetail>() {
            @Override
            public void onResponse(Call<ProductDetail> call, Response<ProductDetail> response) {
                if (response.isSuccessful() && response.body() != null) {
                    int startPosition = productsItems.size();
                    Data data = response.body().getData();
                    productsItems.addAll(data.getProducts());

                    if(productsItems.size()==0) {
                        Toast.makeText(rv.getContext(), "No Product Found", Toast.LENGTH_SHORT).show();
                        Log.i("okie", "check");
                    }

                    productDetailAdapter.notifyItemRangeInserted(startPosition, productsItems.size());
                    HideProgressBar();
                }
                else
                {
                    Log.i("Failure Response", "" + response.errorBody());
                }
            }


            @Override
            public void onFailure(Call<ProductDetail> call, Throwable t) {
                Log.e("Response failed ", "" + t);
            }
        });



        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(!rv.canScrollVertically(1))
                {
                    progressBar.setVisibility(View.VISIBLE);
                    apiInterface.search(searchTerm,false,20,page,productsItems.size()).enqueue(new Callback<ProductDetail>() {
                        @Override
                        public void onResponse(Call<ProductDetail> call, Response<ProductDetail> response) {

                            if (response.isSuccessful() && response.body() != null) {

                                int startPosition = productsItems.size();
                                Data data = response.body().getData();
                                productsItems.addAll(data.getProducts());

                                productDetailAdapter.notifyItemRangeInserted(startPosition, productsItems.size());
                                HideProgressBar();
                                page+=1;
                               // productDetailAdapter = new ProductDetailAdapter(SecondPage.this,productsItems);
                                //rv.setAdapter(productDetailAdapter);

                            }
                            else
                            {
                                Log.i("Failure Response", "" + response.errorBody());
                            }
                        }



                        @Override
                        public void onFailure(Call<ProductDetail> call, Throwable t) {
                            Log.e("Response failed ", "" + call);
                        }
                    });

                }



            }
        });
    }
    @Override
    public void HideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.layout_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item_linear:
                productDetailAdapter = new ProductDetailAdapter(SecondPage.this,productsItems);
                rv.setAdapter(productDetailAdapter);
                rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
                return true;

            case R.id.item_grid:
                String check="grid";
                productDetailAdapter = new ProductDetailAdapter(SecondPage.this,productsItems,check);
                rv.setAdapter(productDetailAdapter);
                rv.setLayoutManager(new GridLayoutManager(rv.getContext(),2));
                return true;

            case R.id.item_staggered:
                String check2="grid";
                productDetailAdapter = new ProductDetailAdapter(SecondPage.this,productsItems,check2);
                rv.setAdapter(productDetailAdapter);
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                rv.setLayoutManager(staggeredGridLayoutManager);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void ClickOnProduct(ProductsItem productsItem) {
        Intent intent=new Intent(this,ProductDetailPage.class);
        intent.putExtra("name",productsItem.getName());
        intent.putExtra("price",productsItem.getPrice().getPriceDisplay());
        intent.putExtra("img",productsItem.getImages().get(0));
        intent.putExtra("rating",String.valueOf(productsItem.getReview().getRating()));
         // intent.putExtra("proitem",productsItem);
        intent.putExtra("def_sku_id",productsItem.getDefaultSku());
        startActivity(intent);

    }


}