package fr.esilv.cocktailapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.esilv.cocktailapp.api.Cocktail;

public class SharedPreference {
    public static final String PREFS_NAME = "TEST";
    public static final String FAVORITES = "TEST";

    public SharedPreference() {
        super();
    }

    // This four methods are used for maintaining favorites.
    // We can't directly store list so we store JSON object in string.

    public void saveFavorites(Context context, List<Cocktail> favorites) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.commit();
    }

    public void addFavorite(Context context, Cocktail cocktail) {
        List<Cocktail> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<Cocktail>();
        favorites.add(cocktail);
        saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, Cocktail cocktail) {
        List<Cocktail> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(cocktail);
            saveFavorites(context, favorites);
        }
    }

    public List<Cocktail> getFavorites(Context context) {
        SharedPreferences settings;
        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Log.d("GET", jsonFavorites);
            Gson gson = new Gson();
            Cocktail[] favoriteItems = gson.fromJson(jsonFavorites, Cocktail[].class);
            Log.d("GET", Arrays.asList(favoriteItems).toString());
            return Arrays.asList(favoriteItems);
        } else
            return null;
    }
}
