package fr.esilv.cocktailapp.activity.activity_main.fragment_category;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.adapter.CategoryAdapter;
import fr.esilv.cocktailapp.api.Category;
import fr.esilv.cocktailapp.api.CategoryArray;
import fr.esilv.cocktailapp.api.TheCocktailDBService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryFragment extends Fragment {

    private final String baseURL = "https://www.thecocktaildb.com/api/json/v1/1/";
    private RecyclerView categoryView;
    private View view;
    private TheCocktailDBService service;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.category_fragment, container, false);

        // Set up RecyclerView
        categoryView = view.findViewById(R.id.recyclerCategory);
        categoryView.setLayoutManager(new LinearLayoutManager(this.getContext()));

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
                    Log.d("DEV !!", "here");
                    List<Category> categories = response.body().getCategories();
                    categoryView.setAdapter(new CategoryAdapter(categories));
                }
            }

            @Override
            public void onFailure(Call<CategoryArray> call, Throwable t) {
            }
        });
        return view;
    }
}
