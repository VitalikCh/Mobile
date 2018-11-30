package com.example.vlad.androidapp.Activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.vlad.androidapp.Entities.Product;
import com.example.vlad.androidapp.Entities.ProductResponse;
import com.example.vlad.androidapp.R;
import com.example.vlad.androidapp.ServerUtilities.LCBOClient;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.vlad.androidapp.ServerUtilities.LCBOUtility.generateRequest;

public class ProductDetailActivity extends AppCompatActivity {
    ImageView imageView;
    public int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        id = bundle.getInt("id");
        imageView = findViewById(R.id.listview_image2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fullScreen();
            }
        });

        getData();
    }

    public void getData() {
        LCBOClient client = generateRequest();
        Call<ProductResponse> call = client.getProduct(id);

        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                Product product = response.body().getProduct();
                System.out.println(product.getPackage());
                Picasso.get().load(product.getImageUrl()).into(imageView);

            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                t.getCause();
            }
        });


    }

    public void fullScreen() {


        int uiOptions = getWindow().getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOptions;


        if (Build.VERSION.SDK_INT >= 14) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }

        if (Build.VERSION.SDK_INT >= 16) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        }

        if (Build.VERSION.SDK_INT >= 18) {
            newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        }

        getWindow().getDecorView().setSystemUiVisibility(newUiOptions);
    }

}
