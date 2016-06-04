package com.dhyuka.tmdt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.dhyuka.tmdt.RecyclerView.Adapters.ProductListAdapter;
import com.dhyuka.tmdt.animator.SlideInOutLeftItemAnimator;
import com.dhyuka.tmdt.json.DownLoadDataJSON;
import com.dhyuka.tmdt.models.Product;

import java.util.ArrayList;
import java.util.List;

public class Product_List_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    ProgressBar proLoading;
    String url = "http://annieandroid.somee.com/api/getAllProduct?m=1&page=1";
    List<Product> listProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_);

        recyclerView = (RecyclerView) findViewById(R.id.recyler_view_product_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new SlideInOutLeftItemAnimator(recyclerView));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        proLoading = (ProgressBar) findViewById(R.id.progress_loading);
        proLoading.setVisibility(View.VISIBLE);


        DownLoadDataJSON dataJSON = new DownLoadDataJSON(new DownLoadDataJSON.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                loadListProduct(output);
            }
        });
        dataJSON.execute(url);

    }


    private void loadListProduct(String s){
        listProduct = new ArrayList<>();

        ParseDataJSON parseDataJSON = new ParseDataJSON();
        listProduct = parseDataJSON.getListProduct(s);


        recyclerViewAdapter = new ProductListAdapter(getApplication(), listProduct);
        recyclerView.setAdapter(recyclerViewAdapter);

        if (listProduct.size() > 0) {
            proLoading.setVisibility(View.GONE);
        }
    }

}
