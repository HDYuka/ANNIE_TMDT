package com.dhyuka.tmdt;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.dhyuka.tmdt.animator.SlideInOutLeftItemAnimator;
import com.dhyuka.tmdt.json.DownLoadDataJSON;
import com.dhyuka.tmdt.models.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

        DownLoadDataJSON d = new DownLoadDataJSON();
        d.execute(url);

        DownLoadDlJSON downLoadDlJSON = new DownLoadDlJSON();

        downLoadDlJSON.execute(url);
    }

    public class DownLoadDlJSON extends AsyncTask<String, Void, String> {
        StringBuilder dulieu = new StringBuilder();

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();

                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);

                String dong = "";

                while ((dong = bufferedReader.readLine()) != null) {
                    dulieu.append(dong);
                }

                bufferedReader.close();
                reader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                Log.d("du lieu: ", dulieu.toString());

            } catch (MalformedURLException e) {

            } catch (IOException e) {
                e.printStackTrace();
            }
            return dulieu.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            listProduct = new ArrayList<>();

            ParseDataJSON parseDataJSON = new ParseDataJSON(s);
            listProduct = parseDataJSON.getListProduct();


            recyclerViewAdapter = new ProductListAdapter(getApplication(), listProduct);
            recyclerView.setAdapter(recyclerViewAdapter);

            if ( listProduct.size() >0){
                proLoading.setVisibility(View.GONE);
            }
        }
    }
}
