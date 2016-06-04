package com.dhyuka.tmdt.RecyclerView.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dhyuka.tmdt.HomeActivity;
import com.dhyuka.tmdt.R;
import com.dhyuka.tmdt.models.CatalogModel;

import java.util.List;

/**
 * Created by DH Yuka on 6/3/2016.
 */
public class CatalogAdapter extends android.support.v7.widget.RecyclerView.Adapter {

    List<CatalogModel> listCatalog;
    HomeActivity _activity;

    public CatalogAdapter(HomeActivity activity, List<CatalogModel> listCatalog) {
        this._activity = activity;
        this.listCatalog = listCatalog;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_catalog_list, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final String title = listCatalog.get(position).getTitle();
        final int img = listCatalog.get(position).getImage();
        if (title != "") {
            ((ViewHolder) holder).txtTitle.setText(title);
            if (img != -1) {
                ((ViewHolder) holder).img.setImageResource(img);
            }
            ((ViewHolder) holder).lnItemClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _activity.openMenuItemCatagory(title);
                }
            });
        }


    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle;
        public ImageView img;
        public LinearLayout lnItemClick;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            img = (ImageView) itemView.findViewById(R.id.imgCatalog);
            lnItemClick = (LinearLayout) itemView.findViewById(R.id.lnItemClick);
        }
    }

    @Override
    public int getItemCount() {
        return listCatalog.size();
    }


}
