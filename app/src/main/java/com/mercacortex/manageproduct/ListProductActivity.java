package com.mercacortex.manageproduct;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import com.mercacortex.manageproduct.model.Product;

/**
 * Created by usuario on 10/20/16.
 */

public class ListProductActivity extends ListActivity {
    //private ListView lvProduct
    private ArrayAdapter<Product> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        //lvProduct = (ListView) findViewById(R.id.lvProduct);

        // CASE 1: Default Adapter
        adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1,
                ((ProductApplication)getApplication()).getProducts());

        getListView().setAdapter(adapter);

        // CASE 2:
    }
}
