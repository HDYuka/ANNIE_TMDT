package com.dhyuka.tmdt.DataSource;

import android.widget.ListAdapter;

import com.dhyuka.tmdt.R;
import com.dhyuka.tmdt.models.CatalogModel;

import java.util.ArrayList;

/**
 * Created by DH Yuka on 6/3/2016.
 */
public class ProductCatalogData {

    public ArrayList<CatalogModel> DongHoNam() {
        ArrayList<CatalogModel> list = new ArrayList<>();

        list.add(new CatalogModel("Đồng Hồ Nam", "dong-ho-nam", -1));
        list.add(new CatalogModel("Đồng hồ LED nam", "dong-ho-led-nam", -1));
        list.add(new CatalogModel("Đồng hồ điện tử nam", "dong-ho-dien-tu-nam", -1));
        list.add(new CatalogModel("Đồng hồ cặp", "dong-ho-cap", -1));
        list.add(new CatalogModel("Đồng hồ cơ", "dong-ho-co", -1));

        return list;
    }

    public ArrayList<CatalogModel> DongHoNu() {
        ArrayList<CatalogModel> list = new ArrayList<>();

        list.add(new CatalogModel("Đồng Hồ Nữ", "dong-ho-nu", -1));
        list.add(new CatalogModel("Đồng hồ LED nữ", "dong-ho-led-nu", -1));
        list.add(new CatalogModel("Đồng hồ điện tử nữ", "dong-ho-dien-tu-nu", -1));
        list.add(new CatalogModel("Đồng hồ cặp", "dong-ho-cap", -1));

        return list;
    }

    public ArrayList<CatalogModel> DoChoiTreEm() {
        ArrayList<CatalogModel> list = new ArrayList<>();

        list.add(new CatalogModel("Dành Cho Nam", "do-choi-tre-em?g=1", -1));
        list.add(new CatalogModel("Bé nam", "be-nam", -1));
        list.add(new CatalogModel("Dành Cho Nữ", "do-choi-tre-em?g=-1", -1));
        list.add(new CatalogModel("Bé Nữ", "be-nu", -1));

        return list;
    }

    public ArrayList<CatalogModel> SaleOff() {
        ArrayList<CatalogModel> list = new ArrayList<>();

        list.add(new CatalogModel("Dành Cho Nam", "sale-off?g=1", -1));
        list.add(new CatalogModel("Thời trang nam SALE", "thoi-trang-nam-sale", -1));
        list.add(new CatalogModel("Giày dép nam SALE", "giay-dep-nam-sale", -1));
        list.add(new CatalogModel("Đồng hồ nam SALE", "dong-ho-nam-sale", -1));
        list.add(new CatalogModel("Phụ kiện SALE", "phu-kien-sale", -1));
        list.add(new CatalogModel("Phụ kiện Hitech SALE", "phu-kien-hitech-sale", -1));
        list.add(new CatalogModel("Sale off khác", "sale-off-khac", -1));
        list.add(new CatalogModel("Dành Cho Nữ", "sale-off?g=-1", -1));
        list.add(new CatalogModel("Thời trang nữ SALE", "thoi-trang-nu-sale", -1));
        list.add(new CatalogModel("Giày dép nữ SALE", "giay-dep-nu-sale", -1));
        list.add(new CatalogModel("Đồng hồ nữ SALE", "dong-ho-nu-sale", -1));
        list.add(new CatalogModel("Phụ kiện SALE", "phu-kien-sale", -1));
        list.add(new CatalogModel("Phụ kiện Hitech SALE", "phu-kien-hitech-sale", -1));
        list.add(new CatalogModel("Sale off khác", "sale-off-khac", -1));

        return list;
    }

    public ArrayList<CatalogModel> QuanAoNam() {
        ArrayList<CatalogModel> list = new ArrayList<>();

        list.add(new CatalogModel("Áo sơ mi nam", "ao-so-mi-nam", -1));
        list.add(new CatalogModel("Áo thun nam", "ao-thun-nam", -1));
        list.add(new CatalogModel("Áo đôi - Áo cặp", "ao-doi-ao-cap", -1));
        list.add(new CatalogModel("Áo khoác nam", "ao-khoac-nam", -1));
        list.add(new CatalogModel("Quần dài nam", "quan-dai-nam", -1));
        list.add(new CatalogModel("Quần short nam", "quan-short-nam", -1));
        list.add(new CatalogModel("Quần thể thao nam", "quan-the-thao-nam", -1));
        list.add(new CatalogModel("Quần jean nam", "quan-jean-nam", -1));
        list.add(new CatalogModel("Quần lót nam", "quan-lot-nam", -1));

        return list;
    }

    public ArrayList<CatalogModel> QuanAoNu() {
        ArrayList<CatalogModel> list = new ArrayList<>();

        list.add(new CatalogModel("Áo sơ mi nữ", "ao-so-mi-nu", -1));
        list.add(new CatalogModel("Áo thun nữ", "ao-thun-nu", -1));
        list.add(new CatalogModel("Áo đôi - Áo cặp", "ao-doi-ao-cap", -1));
        list.add(new CatalogModel("Áo khoác nữ", "ao-khoac-nu", -1));
        list.add(new CatalogModel("Váy đầm nữ", "vay-dam-nu", -1));
        list.add(new CatalogModel("Quần dài nữ", "quan-dai-nu", -1));
        list.add(new CatalogModel("Quần jean nữ", "quan-jean-nu", -1));
        list.add(new CatalogModel("Quần short nữ", "quan-short-nu", -1));
        list.add(new CatalogModel("Quần thun nữ", "quan-thun-nu", -1));
        list.add(new CatalogModel("Đồ bộ nữ", "do-bo-nu", -1));
        list.add(new CatalogModel("Váy đầm ngủ", "vay-dam-ngu", -1));

        return list;
    }

    public ArrayList<CatalogModel> Menu() {
        ArrayList<CatalogModel> list = new ArrayList<>();

        list.add(new CatalogModel("Quần Áo Nam", "quan-ao?g=1", R.drawable.ic_menfashion));
        list.add(new CatalogModel("Quần Áo Nữ", "quan-ao?g=-1", R.drawable.ic_dress));
        list.add(new CatalogModel("Đồng Hồ Nam", "dong-ho?g=1", R.drawable.ic_menwatch));
        list.add(new CatalogModel("Đồng Hồ Nữ", "dong-ho?g=-1", R.drawable.ic_womenwatches));
        list.add(new CatalogModel("Đồ Chơi Trẻ Em", "do-choi-tre-em", R.drawable.ic_childrentoy));
        list.add(new CatalogModel("Sale OFF", "sale-off", R.drawable.ic_saleoff));
        list.add(new CatalogModel("Top Sale", "dang-hot", R.drawable.ic_hotproducts));

        return list;
    }
}
