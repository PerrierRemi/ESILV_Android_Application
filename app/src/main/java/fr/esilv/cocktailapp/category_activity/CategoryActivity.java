package fr.esilv.cocktailapp.category_activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.api.Cocktail;
import fr.esilv.cocktailapp.api.CocktailList;
import fr.esilv.cocktailapp.api.TheCocktailDBService;
import fr.esilv.cocktailapp.home_activity.HomeCategoryAdapter;
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
        drinkView = findViewById(R.id.recyclerDrink);
        drinkView.setLayoutManager(new GridLayoutManager(this, 2));
        Intent intent = getIntent();
        nameCategory = intent.getExtras().getString("NAME_CATEGORY");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(TheCocktailDBService.class);
        service.searchCategoryDrinks(nameCategory).enqueue(new Callback<CocktailList>() {
            @Override
            public void onResponse(Call<CocktailList> call, Response<CocktailList> response) {
                if (response.isSuccessful()) {
                    CocktailList drinks = response.body();
                    List<Cocktail> c = null;
                    if (drinks != null) {
                        c = drinks.getDrinks();
                    }
                    drinkView.setAdapter(new HomeCategoryAdapter(c));
                }
            }


            @Override
            public void onFailure(Call<CocktailList> call, Throwable t) {

            }
        });
    }
}
