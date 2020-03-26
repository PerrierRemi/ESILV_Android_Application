package fr.esilv.cocktailapp.activity_main.fragment_search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.activity_category.CocktailAdapter;
import fr.esilv.cocktailapp.api.Cocktail;
import fr.esilv.cocktailapp.api.CocktailArray;
import fr.esilv.cocktailapp.api.TheCocktailDBService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchResultFragment extends Fragment {
    private String query;
    private View view;
    private RecyclerView recyclerView;
    private TheCocktailDBService service;
    private final String BaseURL = "https://www.thecocktaildb.com/api/json/v1/1/";
    private String nameSearched;
    private TextView textView;

    public SearchResultFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.searchresult_fragment,container,false);
        recyclerView = view.findViewById(R.id.recyclerSearch);
        textView = view.findViewById(R.id.textSearched);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(),2));
        Bundle bundle = getArguments();
        nameSearched = bundle.getString("query");
        textView.setText(nameSearched);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(TheCocktailDBService.class);
        service.searchCocktailName(nameSearched).enqueue(new Callback<CocktailArray>() {
            @Override
            public void onResponse(Call<CocktailArray> call, Response<CocktailArray> response) {
                if (response.isSuccessful()) {
                    List<Cocktail> drinks = response.body().getCocktails();
                    recyclerView.setAdapter(new CocktailAdapter(drinks));
                }
            }

            @Override
            public void onFailure(Call<CocktailArray> call, Throwable t) {
            }
        });









        return view;
    }


}
