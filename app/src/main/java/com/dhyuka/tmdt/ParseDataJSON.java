package com.dhyuka.tmdt;

import android.util.Log;

import com.dhyuka.tmdt.models.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DH Yuka on 5/30/2016.
 */
public class ParseDataJSON {
    String data;
    List<Product> listProduct;

    public ParseDataJSON(String data) {
        this.data = data;
    }

    public List<Product> getListProduct() {

        listProduct = new ArrayList<>();

        try {
            JSONArray jsonarray = new JSONArray(data);

            for (int i = 0; i < jsonarray.length(); i++) {

                JSONObject jsonobj = jsonarray.getJSONObject(i);

                String _maSP = jsonobj.getString("MaSP");
                String _name = jsonobj.getString("Name");
                String _image = jsonobj.getString("Image");
                String _priceOld = jsonobj.getString("GiaBD") + ".000";
                String _priceNew = jsonobj.getString("GiaHT") + ".000";

                if (_maSP != ""){
                    listProduct.add(new Product(1, _maSP, _name, _image, "", true, _priceOld, _priceNew, new Date(), ""));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listProduct;
    }
}
