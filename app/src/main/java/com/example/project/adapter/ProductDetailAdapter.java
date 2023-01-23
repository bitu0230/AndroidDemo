package com.example.project.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.example.project.WishModel;
import com.example.project.model.Price;
import com.example.project.model.ProductsItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductDetailAdapter extends RecyclerView.Adapter<ProductDetailAdapter.customViewHolder> {
    List<ProductsItem> adapterList;
    ProductDetailInterface productDetailInterface;
    ProgressBar progressBar;
    String check="no";

    public ProductDetailAdapter(List<ProductsItem> adapterList) {
        this.adapterList = adapterList;
    }

    public ProductDetailAdapter(ProductDetailInterface productDetailInterface, List<ProductsItem> adapterList) {
        this.productDetailInterface=productDetailInterface;
        this.adapterList = adapterList;

    }

    public ProductDetailAdapter(ProductDetailInterface productDetailInterface, List<ProductsItem> adapterList, String check) {
        this.adapterList = adapterList;
        this.productDetailInterface = productDetailInterface;
        this.check = check;
    }

    @NonNull
    @Override
    public customViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(check=="grid") {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, parent, false);
            return new customViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);

        //progressBar=parent.findViewById(R.id.progressBar);
        return new customViewHolder(view);}
    }

    @Override
    public void onBindViewHolder(@NonNull customViewHolder holder, int position) {
        holder.bind(adapterList.get(position),position);
    }

    @Override
    public int getItemCount() {
        if (Objects.nonNull(adapterList)){
            return adapterList.size();
        }
        return 1;
    }


    public class customViewHolder extends RecyclerView.ViewHolder
    {
        View view;
        public customViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            Button bt=view.findViewById(R.id.btn);
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()!=-1)
                        productDetailInterface.ClickOnProduct(adapterList.get(getAdapterPosition()));
                }
            });

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition()!=-1)
                        productDetailInterface.ClickOnProduct(adapterList.get(getAdapterPosition()));
                }
            });
        }

        public void bind(ProductsItem productsItem,int count)
        {
            //progressBar=parent.findViewById(R.id.progressBar);

            if(getAdapterPosition()==5) {
                productDetailInterface.HideProgressBar();
               // progressBar.setVisibility(View.INVISIBLE);
               // System.out.println(count);
            }
            // for image
            List<String> img=new ArrayList<>();
            img=productsItem.getImages();
            ImageView imageView= view.findViewById(R.id.iv);
            Glide.with(imageView.getContext()).load(String.valueOf(img.get(0))).into(imageView);
            // now text
            TextView textView1=view.findViewById(R.id.tv_1);
            String name=productsItem.getName();
            textView1.setText(name);

            // for text 2
            Price price;
            TextView textView2=view.findViewById(R.id.tv_2);
            price=productsItem.getPrice();
            textView2.setText(price.getPriceDisplay());


        }
    }




    public interface ProductDetailInterface{
        public void ClickOnProduct(ProductsItem productsItem);
        public void HideProgressBar();
    }
}
