package com.mercacortex.manageproduct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Shows Add product view
 * Talks with AddProduct presenter class
 */
public class AddProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
    }
}
