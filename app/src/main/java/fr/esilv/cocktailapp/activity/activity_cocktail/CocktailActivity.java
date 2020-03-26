package fr.esilv.cocktailapp.activity.activity_cocktail;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.List;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.api.Cocktail;
import fr.esilv.cocktailapp.api.CocktailArray;
import fr.esilv.cocktailapp.api.TheCocktailDBService;
import fr.esilv.cocktailapp.utils.SharedPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CocktailActivity extends AppCompatActivity {

    private final String baseURL = "https://www.thecocktaildb.com/api/json/v1/1/";
    private TheCocktailDBService service;
    private String idCocktail;

    private Cocktail cocktail;

    private TextView cocktailName;
    private TextView instructions;
    private TextView requirements;
    private ImageView picture;
    private CheckBox checkBox;

    private SharedPreference favoriteManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up view
        setContentView(R.layout.cocktail_activity);
        cocktailName = findViewById(R.id.cocktail_name);
        instructions = findViewById(R.id.instruction);
        requirements = findViewById(R.id.requirement);
        picture = findViewById(R.id.cocktail_picture);
        checkBox = findViewById(R.id.favorite);

        // Get cocktail ID via Intent
        Intent intent = getIntent();
        idCocktail = intent.getExtras().getString("ID_DRINK");

        // Set up Retrofit for API call
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(TheCocktailDBService.class);

        service.searchCocktail(idCocktail).enqueue(new Callback<CocktailArray>() {
            @Override
            public void onResponse(Call<CocktailArray> call, Response<CocktailArray> response) {
                if (response.isSuccessful()) {
                    // Get cocktail from API response
                    cocktail = response.body().getCocktails().get(0);
                    // Set view with API response
                    // Title
                    cocktailName.setText(cocktail.getStrDrink());
                    // Instructions
                    instructions.setText(cocktail.getStrInstructions());
                    // Requirements
                    String strRequirements = "";
                    if (cocktail.getStrIngredient1() != null) {
                        strRequirements += cocktail.getStrIngredient1();
                    }
                    if (cocktail.getStrMeasure1() != null) {
                        strRequirements += " - " + cocktail.getStrMeasure1();
                    }
                    if (cocktail.getStrIngredient2() != null) {
                        strRequirements += "\n" + cocktail.getStrIngredient2();
                    }
                    if (cocktail.getStrMeasure2() != null) {
                        strRequirements += " - " + cocktail.getStrMeasure2();
                    }
                    if (cocktail.getStrIngredient3() != null) {
                        strRequirements += "\n" + cocktail.getStrIngredient3();
                    }
                    if (cocktail.getStrMeasure3() != null) {
                        strRequirements += " - " + cocktail.getStrMeasure3();
                    }
                    if (cocktail.getStrIngredient4() != null) {
                        strRequirements += "\n" + cocktail.getStrIngredient4();
                    }
                    if (cocktail.getStrMeasure4() != null) {
                        strRequirements += " - " + cocktail.getStrMeasure4();
                    }
                    if (cocktail.getStrIngredient5() != null) {
                        strRequirements += "\n" + cocktail.getStrIngredient5();
                    }
                    if (cocktail.getStrMeasure5() != null) {
                        strRequirements += " - " + cocktail.getStrMeasure5();
                    }
                    if (cocktail.getStrIngredient6() != null) {
                        strRequirements += "\n" + cocktail.getStrIngredient6();
                    }
                    if (cocktail.getStrMeasure6() != null) {
                        strRequirements += " - " + cocktail.getStrMeasure6();
                    }
                    if (cocktail.getStrIngredient7() != null) {
                        strRequirements += "\n" + cocktail.getStrIngredient7();
                    }
                    if (cocktail.getStrMeasure7() != null) {
                        strRequirements += " - " + cocktail.getStrMeasure7();
                    }
                    if (cocktail.getStrIngredient8() != null) {
                        strRequirements += "\n" + cocktail.getStrIngredient8();
                    }
                    if (cocktail.getStrMeasure8() != null) {
                        strRequirements += " - " + cocktail.getStrMeasure8();
                    }
                    if (cocktail.getStrIngredient9() != null) {
                        strRequirements += "\n" + cocktail.getStrIngredient9();
                    }
                    if (cocktail.getStrMeasure9() != null) {
                        strRequirements += " - " + cocktail.getStrMeasure9();
                    }
                    if (cocktail.getStrIngredient10() != null) {
                        strRequirements += "\n" + cocktail.getStrIngredient10();
                    }
                    if (cocktail.getStrMeasure10() != null) {
                        strRequirements += " - " + cocktail.getStrMeasure10();
                    }
                    requirements.setText(strRequirements);
                    // Picture
                    Picasso.get().load(cocktail.getStrDrinkThumb()).resize(500, 500).centerCrop().into(picture);
                    // Checkbox
                    favoriteManager = new SharedPreference();
                    List<Cocktail> favorite = favoriteManager.getFavorites(getApplicationContext());
                    if (favorite != null) {
                        if (favorite.contains(cocktail)) checkBox.setChecked(true);
                    }
                }
            }

            @Override
            public void onFailure(Call<CocktailArray> call, Throwable t) {
            }
        });
    }

    public void ChangeFavorite(View view) {
        if (this.checkBox.isChecked()) {
            Log.d("ChangeFavorite", "ADD");
            favoriteManager.addFavorite(getApplicationContext(), cocktail);
        } else {
            favoriteManager.removeFavorite(getApplicationContext(), cocktail);
        }
    }
}
