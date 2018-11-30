package com.example.vlad.androidapp.Activities;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.vlad.androidapp.Entities.ListItem;
import com.example.vlad.androidapp.Adapters.MyAdapter;
import com.example.vlad.androidapp.Entities.Product;
import com.example.vlad.androidapp.Entities.Products;
import com.example.vlad.androidapp.R;
import com.example.vlad.androidapp.ServerUtilities.LCBOClient;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.vlad.androidapp.ServerUtilities.LCBOUtility.generateRequest;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.textNoData)
    TextView textNoData;
    @BindView(R.id.pullToRefresh)
    SwipeRefreshLayout pullToRefresh;


    private static MainActivity instance;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getData();


        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
                pullToRefresh.setRefreshing(false);
            }
        });
    }

    public void getData() {
        LCBOClient client = generateRequest();
        Call<Products> call = client.allProducts();

        call.enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                ArrayList<ListItem> listItems = new ArrayList<>();
                List<Product> products = response.body().getResult();
                for (int i = 0; i < products.size(); i++) {
                    if (products.get(i).getImageUrl() != null) {
                        ListItem listItem = new ListItem(
                                products.get(i).getId(),
                                products.get(i).getName(),
                                products.get(i).getPriceInCents(),
                                products.get(i).getImageUrl()
                        );
                        listItems.add(listItem);
                    }
                }

                textNoData.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                adapter = new MyAdapter(listItems, getContext());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {
                recyclerView.setVisibility(View.GONE);
                textNoData.setVisibility(View.VISIBLE);
                t.getCause();
            }
        });


    }

    public static Context getContext() {
        return instance;
    }
}