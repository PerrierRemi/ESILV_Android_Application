package fr.esilv.cocktailapp.activity.activity_main.fragment_favorite;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.adapter.CocktailAdapter;
import fr.esilv.cocktailapp.api.Cocktail;
import fr.esilv.cocktailapp.utils.SharedPreference;

public class FavoriteFragment extends Fragment {
    private RecyclerView recylerView;
    private View view;
    private SharedPreference favoriteManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.favorite_fragment, container, false);

        // Set up RecyclerView
        recylerView = view.findViewById(R.id.recyclerFavorite);
        recylerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        // Get favorites from SharedPreferences
        favoriteManager = new SharedPreference();
        List<Cocktail> favorites = favoriteManager.getFavorites(this.getContext());
        recylerView.setAdapter(new CocktailAdapter(favorites));

        return view;
    }
}
