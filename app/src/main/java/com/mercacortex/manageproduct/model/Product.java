package com.mercacortex.manageproduct.model;

import java.util.Locale;
import java.util.UUID;

/**
 * Class: Product
 * Description: Product Object Model from the Product DB
 */

public class Product {
    private int mId;
    private String mName;
    private String mDescription;
    private String mDose;
    private String mBrand;
    private double mPrice;
    private int mStock;
    private int mImage; // Saved as a string at the DB

    // Constructor for all fields but mId, which is obtained from the DB
    public Product(String mName, String mDescription, String mDose, String mBrand, double mPrice, int mStock, int mImage) {

        // Podemos asignar el Id con la clase UUID de forma automática y única
        // Se suele usar de forma profesional para firmar documentos (desde Java7)
        // Lo hace teniendo en cuenta los datos del servidor, números aleatorios y
        // la hora actual en ms.
        //
        //this.mId = UUID.randomUUID().toString();
        this.mName = mName;
        this.mDescription = mDescription;
        this.mDose = mDose;
        this.mBrand = mBrand;
        this.mPrice = mPrice;
        this.mStock = mStock;
        this.mImage = mImage;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmDose() {
        return mDose;
    }

    public void setmDose(String mDose) {
        this.mDose = mDose;
    }

    public String getmBrand() {
        return mBrand;
    }

    public void setmBrand(String mBrand) {
        this.mBrand = mBrand;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public int getmStock() {
        return mStock;
    }

    public void setmStock(int mStock) {
        this.mStock = mStock;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    // $ is currency, % is the parsed value, s is the general conversion type
    public String getFormattedPrice() { return String.format("$%s", mPrice); }
    // We are using Lcale library to access device's internal configuration
    public String getFormattedUnitsInStock() { return String.format(Locale.getDefault(), "%d u.", mStock); }

    @Override
    // Hay que personalizar el toString
    public String toString() {
        return "mName='" + mName + '\'' +
                ", mDose='" + mDose + '\'' +
                ", mBrand='" + mBrand
                ;
    }

    @Override
    // Two drugs are the same iff they have same name, brand and dosage
    // Equals siempre tiene que usar Object
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!mName.equals(product.mName)) return false;
        if (!mDose.equals(product.mDose)) return false;
        return mBrand.equals(product.mBrand);

    }

    @Override
    // Si usamos HashSet y HashMap (que generan un hash único por cada elemento distinto)
    // Debemos tener nuestro propio hash.
    public int hashCode() {
        int result = mName.hashCode();
        result = 31 * result + mDose.hashCode();
        result = 31 * result + mBrand.hashCode();
        return result;
    }
}
