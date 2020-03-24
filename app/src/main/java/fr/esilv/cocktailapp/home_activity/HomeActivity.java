package fr.esilv.cocktailapp.home_activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.api.Category;
import fr.esilv.cocktailapp.api.CategoryList;
import fr.esilv.cocktailapp.api.TheCocktailDBService;
import fr.esilv.cocktailapp.category_activity.CategoryCocktailAdapter;
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

        // Set up API call
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(TheCocktailDBService.class);

        service.searchCategory().enqueue(new Callback<CategoryList>() {
            @Override
            public void onResponse(Call<CategoryList> call, Response<CategoryList> response) {
                if (response.isSuccessful()) {
                    CategoryList categories = response.body();
                    List<Category> c = null;
                    if (categories != null) {
                        c = categories.getDrinks();
                    }
                    categoryView.setAdapter(new CategoryCocktailAdapter(c));
                }
            }

            @Override
            public void onFailure(Call<CategoryList> call, Throwable t) {
            }
        });
    }
}
