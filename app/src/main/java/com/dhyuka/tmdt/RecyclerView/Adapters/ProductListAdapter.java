package com.dhyuka.tmdt.RecyclerView.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhyuka.tmdt.ProductDetails;
import com.dhyuka.tmdt.R;
import com.dhyuka.tmdt.models.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by DH Yuka on 5/31/2016.
 */
public class ProductListAdapter extends android.support.v7.widget.RecyclerView.Adapter {

    List<Product> listProduct;
    Context context;

    public ProductListAdapter(Context context, List<Product> listProduct) {
        this.context = context;
        this.listProduct = listProduct;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_product_list, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final String name = listProduct.get(position).getName();
        final String priceOld = listProduct.get(position).getGiaBD();
        final String priceNew = listProduct.get(position).getGiaHT();
        final String maSP = listProduct.get(position).getMaSP();

        ((ViewHolder)holder).txtName.setText(name);
        ((ViewHolder)holder).txtPriceOld.setText(priceOld);
        ((ViewHolder)holder).txtPriceNew.setText(priceNew);
        Picasso.with(context).load(listProduct.get(position).getImage()).into(((ViewHolder) holder).img);

        ((ViewHolder)holder).cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(context, ProductDetails.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                if (name != ""){
                    bundle.putString("name", name);
                    bundle.putString("priceOld", priceOld);
                    bundle.putString("priceNew", priceNew);
                    bundle.putString("maSP", maSP);

                    intent.putExtra("bundle",bundle);
                    context.startActivity(intent);
                }
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName, txtPriceOld, txtPriceNew;
        public ImageView img;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.text_view_name);
            txtPriceOld = (TextView) itemView.findViewById(R.id.txtPriceOld);
            txtPriceNew = (TextView) itemView.findViewById(R.id.txtPriceNew);
            img = (ImageView) itemView.findViewById(R.id.imgProduct);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }
}
