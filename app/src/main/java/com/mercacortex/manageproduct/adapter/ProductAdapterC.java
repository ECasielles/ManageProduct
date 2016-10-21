package com.mercacortex.manageproduct.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.mercacortex.manageproduct.ProductApplication;
import com.mercacortex.manageproduct.R;
import com.mercacortex.manageproduct.model.Product;

/**
 * Created by usuario on 10/21/16.
 */

// Remember: There's an internal ArrayList implemented in Adapter
// to which we can have access
public class ProductAdapterC extends ArrayAdapter<Product> {

    // For simplicity, the adapter manages the daos and their connections
    public ProductAdapterC(Context context) {
        super(context, R.layout.item_product,
            ((ProductApplication)context.getApplicationContext()).getProducts());
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // We are trying now an inefficient way of managing the view
        // We've saved the context because we need to inflate (take the xml -> mem)
        // and assign a value to that attribute

        // Create as many elements as in view

        // UPDATE: Instantiate the view item with the parameter
        View item = convertView;
        ProductHolder productHolder;
        LayoutInflater inflater;

        // UPDATE: We avoid fetching the xml each time and inflating it into memory
        // that way we can reuse it
        if(item == null) {
            // Wrong: We get the item components and assign them the values
            // LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            // Step 1: Create an object to be further initialized with context's LayoutInflater
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            productHolder = new ProductHolder();


            // MORE DANGER: We want the ID from the item taken directly from memory
            // UPDATE: Assign tags to productHolder object
            // Step 3: Assign widget variables with findViewById
            productHolder.productImage = (ImageView) item.findViewById(R.id.imgProductImage);
            productHolder.txvName = (TextView) item.findViewById(R.id.txvName);
            productHolder.txvStock = (TextView) item.findViewById(R.id.txvStock);
            productHolder.txvPrice = (TextView) item.findViewById(R.id.txvPrice);
            item.setTag(productHolder);

            // DANGER: Second parameter (nullable)
            // ViewGroup is a container contained by our ListView
            // We want it to not to be nested, we want it below and to create a visual hierarchy
            // Step 2: View inflation. Create view object containing XML widgets
            item = inflater.inflate(R.layout.item_product, null);

        }else{
            // UPDATE: In case of an existing item, we just need to get its tag
            productHolder = (ProductHolder)item.getTag();
        }

        // Step 4: Assign adapter's data into the widgets
        // When defining ArrayAdapter, which was a Product ArrayList, get item returns the data.
        // We are always working with the adapter, never with the view's data
        productHolder.productImage.setImageResource(getItem(position).getmImage());
        productHolder.txvName.setText(getItem(position).getmName());
        productHolder.txvStock.setText(getItem(position).getFormattedUnitsInStock());
        productHolder.txvPrice.setText(getItem(position).getFormattedPrice());

        // Step 5: Added alternating background color
        if (position % 2 == 0)
            item.setBackgroundResource(R.color.item_product_color);
        else
            item.setBackgroundResource(android.R.color.background_light);

        return item;

    }

    /**
     * Encapsulated class containing xml's widgets
     */
    class ProductHolder{
        ImageView productImage;
        TextView txvName, txvStock, txvPrice;
    }
}
