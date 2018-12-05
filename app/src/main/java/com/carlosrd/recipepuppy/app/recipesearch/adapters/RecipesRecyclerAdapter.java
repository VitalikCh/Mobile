package com.carlosrd.recipepuppy.app.recipesearch.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.carlosrd.recipepuppy.R;
import com.carlosrd.recipepuppy.data.models.PuppyRecipesResult;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public  class RecipesRecyclerAdapter
        extends RecyclerView.Adapter<RecipesRecyclerAdapter.ViewHolder> {


    public interface RecipeListItemClickListener {

        void onRecipeClicked(ImageView imageView, PuppyRecipesResult puppyRecipe);

    }


    private ArrayList<PuppyRecipesResult> recipesList;
    private static RecipesRecyclerAdapter.RecipeListItemClickListener listener;


    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        @BindView(R.id.list_item_recipe_img_recipe) ImageView recipeImage;
        @BindView(R.id.list_item_recipe_lbl_title) TextView recipeTitle;
        @BindView(R.id.list_item_recipe_lbl_subtitle) TextView recipeSubtitle;
        @BindView(R.id.list_item_recipe_lbl_url) TextView recipeURL;

        public ViewHolder(View item) {
            super(item);

            ButterKnife.bind(this,item);
            item.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            listener.onRecipeClicked(recipeImage, recipesList.get(getLayoutPosition()));

        }

    }


    public RecipesRecyclerAdapter(ArrayList<PuppyRecipesResult> recipesList,
                                  RecipesRecyclerAdapter.RecipeListItemClickListener listener) {

        this.recipesList = recipesList;
        this.listener = listener;

    }



    @Override
    public RecipesRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_recipe, parent, false);

        RecipesRecyclerAdapter.ViewHolder vh = new RecipesRecyclerAdapter.ViewHolder(v);

        return vh;

    }

    @Override
    public void onBindViewHolder(RecipesRecyclerAdapter.ViewHolder holder, int position) {


        if (!recipesList.get(position).getImageURL().equals("")) {
            Picasso.get()
                    .load(recipesList.get(position).getImageURL())
                    .resize(74, 74)
                    .centerCrop()
                    .placeholder(R.drawable.recipe_placeholder)
                    .into(holder.recipeImage);
        } else {

            Picasso.get()
                    .load(R.drawable.recipe_placeholder)
                    .resize(74, 74)
                    .centerCrop()
                    .placeholder(R.drawable.recipe_placeholder)
                    .into(holder.recipeImage);
        }

        holder.recipeTitle.setText(Html.fromHtml(recipesList.get(position).getName()));
        holder.recipeSubtitle.setText(recipesList.get(position).getIngredients());
        holder.recipeURL.setText(recipesList.get(position).getURL());

    }



    @Override
    public int getItemCount() {

        return recipesList.size();

    }


    public void updateDataSet(ArrayList<PuppyRecipesResult> recipeList){
        this.recipesList = recipeList;
        notifyDataSetChanged();
    }

}



