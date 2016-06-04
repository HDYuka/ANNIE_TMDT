package com.dhyuka.tmdt.RecyclerView.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dhyuka.tmdt.HomeActivity;
import com.dhyuka.tmdt.R;
import com.dhyuka.tmdt.models.CatalogModel;

import java.util.List;

/**
 * Created by DH Yuka on 6/4/2016.
 */
public class CatalogItemAdapter extends android.support.v7.widget.RecyclerView.Adapter {

    HomeActivity context;
    List<CatalogModel> listCatalogItem;

    public CatalogItemAdapter(HomeActivity context, List<CatalogModel> listCatalogItem) {
        this.context = context;
        this.listCatalogItem = listCatalogItem;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_catagory_item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final String title = listCatalogItem.get(position).getTitle();
        if (title != "") {
            ((ViewHolder) holder).txtTitle.setText(title);
            ((ViewHolder) holder).lnItemClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, title, Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle;
        public ImageView img;
        public RelativeLayout lnItemClick;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitleItem);
            img = (ImageView) itemView.findViewById(R.id.imgCatalogItem);
            lnItemClick = (RelativeLayout) itemView.findViewById(R.id.lnMenuItemClick);
        }
    }

    @Override
    public int getItemCount() {
        return listCatalogItem.size();
    }
}
