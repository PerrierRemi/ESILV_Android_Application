package fr.esilv.cocktailapp.cocktail_activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.api.Cocktail;
import fr.esilv.cocktailapp.api.TheCocktailDBService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CocktailActivity extends AppCompatActivity {

    private final String baseURL = "https://www.thecocktaildb.com/api/json/v1/1/";
    private TheCocktailDBService service;
    private String idCocktail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cocktail_activity);

        // Set up id
        Intent intent = getIntent();
        idCocktail = intent.getExtras().getString("ID_DRINK");
        Log.d("DEV", idCocktail);

        // Set up Retrofit for API call
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(TheCocktailDBService.class);

        service.searchCocktail(idCocktail).enqueue(new Callback<Cocktail>() {
            @Override
            public void onResponse(Call<Cocktail> call, Response<Cocktail> response) {
                if (response.isSuccessful()) {
                    Cocktail cocktail = response.body();
                    // TODO: Finish this function
                }
            }

            @Override
            public void onFailure(Call<Cocktail> call, Throwable t) {
            }
        });
    }
}
