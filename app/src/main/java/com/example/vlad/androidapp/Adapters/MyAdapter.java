package com.example.vlad.androidapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vlad.androidapp.Activities.ProductDetailActivity;
import com.example.vlad.androidapp.Entities.ListItem;
import com.example.vlad.androidapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListItem listItem = listItems.get(position);

        holder.textViewTitle.setText(listItem.getTitle());
        String price = "$" + listItem.getPrice() / 100.0;
        holder.textViewPrice.setText(price);

        Picasso.get().load(listItem.getImageUrl()).fit().into(holder.imageView);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openProductDetailActivity = new Intent(view.getContext(), ProductDetailActivity.class);
                openProductDetailActivity.putExtra("id", listItem.getId());
                view.getContext().startActivity(openProductDetailActivity);
            }
        });

    }



    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.listview_title)
        TextView textViewTitle;
        @BindView(R.id.listview_price)
        TextView textViewPrice;
        @BindView(R.id.listview_image)
        ImageView imageView;
        @BindView(R.id.linearLayout)
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
