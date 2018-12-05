package com.carlosrd.recipepuppy.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PuppyRecipesResult implements Parcelable {


    @SerializedName("title")
    private String name;

    @SerializedName("ingredients")
    private String ingredients;

    @SerializedName("href")
    private String url;

    @SerializedName("thumbnail")
    private String imageURL;



    public PuppyRecipesResult(String name, String ingredients, String url, String imageURL) {
        this.name = name;
        this.ingredients = ingredients;
        this.url = url;
        this.imageURL = imageURL;
    }


    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getURL() {
        return url;
    }

    public String getImageURL() {
        return imageURL;
    }


    public PuppyRecipesResult(Parcel in){
        readFromParcel(in);
    }

    public static Creator<PuppyRecipesResult> getCreator() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeString(ingredients);
        dest.writeString(url);
        dest.writeString(imageURL);

    }


    private void readFromParcel(Parcel in) {

        name = in.readString();
        ingredients = in.readString();
        url = in.readString();
        imageURL = in.readString();

    }


    public static final Creator<PuppyRecipesResult> CREATOR
            = new Creator<PuppyRecipesResult>() {

        public PuppyRecipesResult createFromParcel(Parcel in) {
            return new PuppyRecipesResult(in);
        }

        public PuppyRecipesResult[] newArray(int size) {
            return new PuppyRecipesResult[size];
        }

    };

    @Override
    public int describeContents() {
        return 0;
    }

}
