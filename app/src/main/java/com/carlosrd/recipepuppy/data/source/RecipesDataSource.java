package com.carlosrd.recipepuppy.data.source;

import com.carlosrd.recipepuppy.data.models.PuppyRecipes;

import java.util.ArrayList;


public interface RecipesDataSource {

    interface LoadRecipesCallback {

        void onRecipesLoaded(PuppyRecipes recipesList);

        void onError(int statusCode);

    }

    void loadRecipes(String query, LoadRecipesCallback callback);

}