package com.mercacortex.manageproduct.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mercacortex.manageproduct.ProductApplication;
import com.mercacortex.manageproduct.R;
import com.mercacortex.manageproduct.model.Product;

/**
 * Created by usuario on 10/21/16.
 */

// Remember: There's an internal ArrayList implemented in Adapter
// to which we can have access
public class ProductAdapterA extends ArrayAdapter<Product> {

    // For simplicity, the adapter manages the daos and their connections
    public ProductAdapterA(Context context) {
        super(context, R.layout.item_product,
             ((ProductApplication)context.getApplicationContext()).getProducts());
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // We are trying now an inefficient way of managing the view
        // We've saved the context because we need to inflate (take the xml -> mem)
        // and assign a value to that attribute

        // Create as many elements as
        ImageView productImage;
        TextView txvName, txvStock, txvPrice;
        View item;
        LayoutInflater inflater;

        // Wrong: We get the item components and assign them the values
        // LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        // Step 1: Create an object to be further initialized with context's LayoutInflater
        inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // DANGER: Second parameter (nullable)
        // ViewGroup is a container contained by our ListView
        // We want it to not to be nested, we want it below and to create a visual hierarchy
        // Step 2: View inflation. Create view object containing XML widgets
        item = inflater.inflate(R.layout.item_product, null);

        // MORE DANGER: We want the ID from the item taken directly from memory
        // Step 3: Assign widget variables with findViewById
        productImage = (ImageView) item.findViewById(R.id.imgProductImage);
        txvName = (TextView) item.findViewById(R.id.txvName);
        txvStock = (TextView) item.findViewById(R.id.txvStock);
        txvPrice = (TextView) item.findViewById(R.id.txvPrice);

        // Step 4: Assign adapter's data into the widgets
        // When defining ArrayAdapter, which was a Product ArrayList, get item returns the data.
        // We are always working with the adapter, never with the view's data
        productImage.setImageResource(getItem(position).getmImage());
        txvName.setText(getItem(position).getmName());
        txvStock.setText(getItem(position).getFormattedUnitsInStock());
        txvPrice.setText(getItem(position).getFormattedPrice());

        return item;
    }
}
