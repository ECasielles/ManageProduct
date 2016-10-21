package com.mercacortex.manageproduct;

import android.app.Application;

import com.mercacortex.manageproduct.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 10/20/16.
 */

public class ProductApplication extends Application {

    private ArrayList<Product> products = new ArrayList<>();
    private Product mProduct;

    public ProductApplication(ArrayList<Product> products, Product mProduct) {
        this.products = products;
        this.mProduct = mProduct;

        saveProduct(new Product("Gelocatil", "Con descripcion", "Mucha", "Pepito", 10.0d, 20,R.mipmap.dedo));
        saveProduct(new Product("Primperán", "Por la boca", "Concentración", "JP Morgan", 20.0d, 14, R.mipmap.gusano));
        saveProduct(new Product("Buscapina", "En cápsulas", "Concentración", "Marca", 40.0d, 0, R.mipmap.luna));
        saveProduct(new Product("Apiretal", "Uno al día", "Poca", "Tu madre", 80.0d, 66, R.mipmap.oreja));
        saveProduct(new Product("Paracetamol", "Sin descripción", "Bastante fuerte", "No", 160.0d, 31415, R.mipmap.ruedas));
        saveProduct(new Product("Equasym", "Por el ojete", "Del tirón", "KKK Laboratories", 320.0d, 666, R.mipmap.sonriente));
        saveProduct(new Product("Concerta", "Da cáncer", "Muy concentrado", "Marca España", 640.0d, 69, R.mipmap.triste));
        //
        saveProduct(new Product("Gelocatil", "Con descripcion", "Mucha", "Pepito", 10.0d, 20,R.mipmap.dedo));
        saveProduct(new Product("Primperán", "Por la boca", "Concentración", "JP Morgan", 20.0d, 14, R.mipmap.gusano));
        saveProduct(new Product("Buscapina", "En cápsulas", "Concentración", "Marca", 40.0d, 0, R.mipmap.luna));
        saveProduct(new Product("Apiretal", "Uno al día", "Poca", "Tu madre", 80.0d, 66, R.mipmap.oreja));
        saveProduct(new Product("Paracetamol", "Sin descripción", "Bastante fuerte", "No", 160.0d, 31415, R.mipmap.ruedas));
        saveProduct(new Product("Equasym", "Por el ojete", "Del tirón", "KKK Laboratories", 320.0d, 666, R.mipmap.sonriente));
        saveProduct(new Product("Concerta", "Da cáncer", "Muy concentrado", "Marca España", 640.0d, 69, R.mipmap.triste));
    }


    public void saveProduct(Product product){
        products.add(product);
    }

    public List<Product> getProducts(){
        return products;
    }

}
