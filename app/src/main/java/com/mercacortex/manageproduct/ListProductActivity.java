package com.mercacortex.manageproduct;

import android.app.ListActivity;
import android.os.Bundle;

import com.mercacortex.manageproduct.adapter.ProductAdapterC;

/**
 * Created by usuario on 10/20/16.
 */

public class ListProductActivity extends ListActivity {
    //private ListView lvProduct
    //private ArrayAdapter<Product> adapter;
    //private ProductAdapterA adapter;
    //private ProductAdapterB adapter;
    private ProductAdapterC adapter;

    // Add:
    //FloatingActionButton fabtnAdd;
    // Intents AddProduct
    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        //lvProduct = (ListView) findViewById(R.id.lvProduct);

        // CASE 1: Default Adapter
        //adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1,
        // ((ProductApplication)getApplication()).getProducts());

        // CASE 2: Custom Adapter
        //The adapter manages the information
        // 2a)
        //  adapter = new ProductAdapterA(this);
        // 2b)
        //  adapter = new ProductAdapterB(this);
        // 2c)
            adapter = new ProductAdapterC(this);

        getListView().setAdapter(adapter);
    }
}
