package fr.esilv.cocktailapp.home_activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.api.Category;
import fr.esilv.cocktailapp.api.CategoryArray;
import fr.esilv.cocktailapp.api.TheCocktailDBService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    private final String baseURL = "https://www.thecocktaildb.com/api/json/v1/1/";
    private RecyclerView categoryView;
    private TheCocktailDBService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_activity);

        // Set up RecyclerView
        categoryView = findViewById(R.id.recyclerCategory);
        categoryView.setLayoutManager(new LinearLayoutManager(this));

        // Set up retrofit for API call
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(TheCocktailDBService.class);

        service.searchCategory().enqueue(new Callback<CategoryArray>() {
            @Override
            public void onResponse(Call<CategoryArray> call, Response<CategoryArray> response) {
                if (response.isSuccessful()) {
                    List<Category> categories = response.body().getDrinks();
                    categoryView.setAdapter(new CategoryAdapter(categories));
                }
            }

            @Override
            public void onFailure(Call<CategoryArray> call, Throwable t) {
            }
        });
    }
}
