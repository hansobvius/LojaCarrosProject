package com.e.lojadecarros.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "vehicle_table")
public class VehicleGeneral {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("ID")
    public int movieId;

    @NonNull
    @ColumnInfo(name = "make")
    @SerializedName("Make")
    public String make;

    @NonNull
    @ColumnInfo(name = "model")
    @SerializedName("Model")
    public String model;

    @NonNull
    @ColumnInfo(name = "version")
    @SerializedName("Version")
    public String version;

    @NonNull
    @ColumnInfo(name = "image")
    @SerializedName("Image")
    public String image;

    @NonNull
    @ColumnInfo(name = "km")
    @SerializedName("KM")
    public int km;

    @NonNull
    @ColumnInfo(name = "price")
    @SerializedName("Price")
    public String price;

    @NonNull
    @ColumnInfo(name = "year_model")
    @SerializedName("YearModel")
    public int yearModel;

    @NonNull
    @ColumnInfo(name = "year_fab")
    @SerializedName("YearFab")
    public int yearFab;

    @NonNull
    @ColumnInfo(name = "color")
    @SerializedName("Color")
    public String color;

    @NonNull
    public String getMake() {
        return make;
    }

    public void setMake(@NonNull String make) {
        this.make = make;
    }

    @NonNull
    public String getModel() {
        return model;
    }

    public void setModel(@NonNull String model) {
        this.model = model;
    }

    @NonNull
    public String getVersion() {
        return version;
    }

    public void setVersion(@NonNull String version) {
        this.version = version;
    }

    @NonNull
    public String getImage() {
        return image;
    }

    public void setImage(@NonNull String image) {
        this.image = image;
    }

    @NonNull
    public int getKm() {
        return km;
    }

    public void setKm(@NonNull int km) {
        this.km = km;
    }

    @NonNull
    public String getPrice() {
        return price;
    }

    public void setPrice(@NonNull String price) {
        this.price = price;
    }

    @NonNull
    public int getYearModel() {
        return yearModel;
    }

    public void setYearModel(@NonNull int yearModel) {
        this.yearModel = yearModel;
    }

    @NonNull
    public int getYearFab() {
        return yearFab;
    }

    public void setYearFab(@NonNull int yearFab) {
        this.yearFab = yearFab;
    }

    @NonNull
    public String getColor() {
        return color;
    }

    public void setColor(@NonNull String color) {
        this.color = color;
    }
}
