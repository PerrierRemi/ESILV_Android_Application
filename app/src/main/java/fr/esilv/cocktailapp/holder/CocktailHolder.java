package fr.esilv.cocktailapp.holder;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.activity_cocktail.CocktailActivity;
import fr.esilv.cocktailapp.api.Cocktail;


public class CocktailHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    String nameDrink;
    String thumbDrink;
    String idDrink;

    private TextView nameDrinkView;
    private ImageView thumbDrinkView;

    public CocktailHolder(@NonNull View itemView) {
        super(itemView);
        this.nameDrinkView = itemView.findViewById(R.id.nameDrinkView);
        this.thumbDrinkView = itemView.findViewById(R.id.thumbDrinkView);
        itemView.setOnClickListener(this);

    }

    public void bind(final Cocktail Cocktail) {
        nameDrink = Cocktail.getStrDrink();
        nameDrinkView.setText(nameDrink);
        thumbDrink = Cocktail.getStrDrinkThumb();
        Picasso.get().load(thumbDrink).resize(500, 500).centerCrop().into(thumbDrinkView);
        idDrink = Cocktail.getIdDrink();

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), CocktailActivity.class);
        intent.putExtra("ID_DRINK", idDrink);
        v.getContext().startActivity(intent);
    }
}
