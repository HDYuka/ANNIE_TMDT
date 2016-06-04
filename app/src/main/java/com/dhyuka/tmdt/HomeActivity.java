package com.dhyuka.tmdt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dhyuka.tmdt.DataSource.ProductCatalogData;
import com.dhyuka.tmdt.RecyclerView.Adapters.CatalogAdapter;
import com.dhyuka.tmdt.RecyclerView.Adapters.CatalogItemAdapter;
import com.dhyuka.tmdt.models.CatalogModel;

public class HomeActivity extends AppCompatActivity implements Animation.AnimationListener {

    Toolbar toolbar;
    RelativeLayout lnMenu, lnMenuItem;
    RecyclerView rvMenuCatagory, rvMenuItemCatagory;
    RecyclerView.Adapter recyclerViewAdapter;
    Animation animSideDown;
    ProductCatalogData catalogData;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        catalogData = new ProductCatalogData();

        rvMenuItemCatagory = (RecyclerView) findViewById(R.id.recylerview_catalog_menu_item);
        rvMenuCatagory = (RecyclerView) findViewById(R.id.recylerview_catalog_menu);
        rvMenuItemCatagory.setLayoutManager(new LinearLayoutManager(this));
        rvMenuCatagory.setLayoutManager(new LinearLayoutManager(this));

        animSideDown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_down);
        // set animation listener
        animSideDown.setAnimationListener(this);

        lnMenu = (RelativeLayout) findViewById(R.id.lnMenu);
        lnMenuItem = (RelativeLayout) findViewById(R.id.lnMenuItem);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Trang chủ");
            toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (i == 0) {
                        openMenuCatagory();

                    } else {
                        closeMenuCatagory();
                    }
                }
            });
        }

    }


    // Danh mục cha
    private void openMenuCatagory() {
        i = 1;
        recyclerViewAdapter = new CatalogAdapter(HomeActivity.this, catalogData.Menu());
        rvMenuCatagory.setAdapter(recyclerViewAdapter);

        animSideDown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_down);
        lnMenu.setVisibility(View.VISIBLE);
        lnMenu.startAnimation(animSideDown);
        getSupportActionBar().setTitle("Danh mục");
        toolbar.setNavigationIcon(R.drawable.ic_back_white_24dp);
    }

    private void closeMenuCatagory() {
        i = 0;
        animSideDown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up_out);
        lnMenu.setVisibility(View.GONE);
        lnMenu.startAnimation(animSideDown);
        getSupportActionBar().setTitle("Trang chủ");
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        lnMenuItem.setVisibility(View.GONE);

    }

    // Danh mục con
    public void openMenuItemCatagory(String title) {
        switch (title) {
            case "Quần Áo Nam":
                recyclerViewAdapter = new CatalogItemAdapter(HomeActivity.this, catalogData.QuanAoNam());
                rvMenuItemCatagory.setAdapter(recyclerViewAdapter);
                break;
            case "Quần Áo Nữ":
                recyclerViewAdapter = new CatalogItemAdapter(HomeActivity.this, catalogData.QuanAoNu());
                rvMenuItemCatagory.setAdapter(recyclerViewAdapter);
                break;
            case "Đồng Hồ Nam":
                recyclerViewAdapter = new CatalogItemAdapter(HomeActivity.this, catalogData.DongHoNam());
                rvMenuItemCatagory.setAdapter(recyclerViewAdapter);
                break;
            case "Đồng Hồ Nữ":
                recyclerViewAdapter = new CatalogItemAdapter(HomeActivity.this, catalogData.DongHoNu());
                rvMenuItemCatagory.setAdapter(recyclerViewAdapter);
                break;
            case "Đồ Chơi Trẻ Em":
                recyclerViewAdapter = new CatalogItemAdapter(HomeActivity.this, catalogData.DoChoiTreEm());
                rvMenuItemCatagory.setAdapter(recyclerViewAdapter);
                break;
            case "Sale OFF":
                recyclerViewAdapter = new CatalogItemAdapter(HomeActivity.this, catalogData.SaleOff());
                rvMenuItemCatagory.setAdapter(recyclerViewAdapter);
                break;
            case "Top Sale":
                Intent intent = new Intent(HomeActivity.this, Product_List_Activity.class);
                startActivity(intent);
                break;
        }

        animSideDown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_left);
        lnMenuItem.setVisibility(View.VISIBLE);
        lnMenuItem.startAnimation(animSideDown);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.itCart:
                Toast.makeText(HomeActivity.this, "Cart", Toast.LENGTH_LONG).show();
                break;
            case R.id.itFavotite:
                Toast.makeText(HomeActivity.this, "Favorite", Toast.LENGTH_LONG).show();
                break;
            case R.id.itSearchView:
                break;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
