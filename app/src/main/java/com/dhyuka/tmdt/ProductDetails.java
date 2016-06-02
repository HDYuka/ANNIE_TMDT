package com.dhyuka.tmdt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dhyuka.tmdt.json.DownLoadDataJSON;
import com.dhyuka.tmdt.models.DesProduct;

public class ProductDetails extends AppCompatActivity {

    String url = "http://annieandroid.somee.com/api/getDesProduc?_maSP=";
    String name, maSP;
    TextView txtName;
    ProgressBar progress_loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");

        maSP = bundle.getString("maSP");
        name = bundle.getString("name");

        this.setTitle(name);
        progress_loading = (ProgressBar) findViewById(R.id.progress_loading);
        progress_loading.setVisibility(View.VISIBLE);
        txtName = (TextView) findViewById(R.id.txtName);
        txtName.setText(maSP);

        DownLoadDataJSON dataJSON = new DownLoadDataJSON(new DownLoadDataJSON.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                loadDesProduct(output);
            }
        });
        dataJSON.execute(url + maSP);
    }

    private void loadDesProduct(String output) {
        ParseDataJSON parseDataJSON = new ParseDataJSON();
        DesProduct desProduct = parseDataJSON.getDesProduct(output);

        if (desProduct.getMaSP() != null) {
            progress_loading.setVisibility(View.GONE);
            txtName.setText(desProduct.getMaSP() + "\n"
                    + desProduct.getDsHinhAnh()
                    + desProduct.getThongTinChiTiet()
                    + desProduct.getFullSize());
        }
    }

}
