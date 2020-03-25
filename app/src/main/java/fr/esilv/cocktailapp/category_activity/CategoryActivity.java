package fr.esilv.cocktailapp.category_activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.api.Cocktail;
import fr.esilv.cocktailapp.api.CocktailArray;
import fr.esilv.cocktailapp.api.TheCocktailDBService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryActivity extends AppCompatActivity {

    private final String baseURL = "https://www.thecocktaildb.com/api/json/v1/1/";
    private RecyclerView drinkView;
    private TheCocktailDBService service;
    private String nameCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.category_activity);

        // Set up RecyclerView
        drinkView = findViewById(R.id.recyclerDrink);
        drinkView.setLayoutManager(new GridLayoutManager(this, 2));

        // Set up name category via Intent
        Intent intent = getIntent();
        nameCategory = intent.getExtras().getString("NAME_CATEGORY");

        // Set up Retrofit for API call
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(TheCocktailDBService.class);

        service.searchCategoryDrinks(nameCategory).enqueue(new Callback<CocktailArray>() {
            @Override
            public void onResponse(Call<CocktailArray> call, Response<CocktailArray> response) {
                if (response.isSuccessful()) {
                    List<Cocktail> drinks = response.body().getCocktails();
                    drinkView.setAdapter(new CocktailAdapter(drinks));
                }
            }

            @Override
            public void onFailure(Call<CocktailArray> call, Throwable t) {
            }
        });
    }
}
