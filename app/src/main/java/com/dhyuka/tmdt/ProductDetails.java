package com.dhyuka.tmdt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {

    String name, maSP;
    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");

        maSP = bundle.getString("maSP");
        name = bundle.getString("name");

        this.setTitle(name);
        txtName = (TextView) findViewById(R.id.txtName);
        txtName.setText(maSP);



    }
}
