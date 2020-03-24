package fr.esilv.cocktailapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface TheCocktailDBService {

    @GET("list.php?c=list")
    Call<CategoryArray> searchCategory();

    @GET("filter.php")
    Call<CocktailArray> searchCategoryDrinks(@Query("c") String nameCategory);

    @GET("lookup.php")
    Call<CocktailArray> searchCocktail(@Query("i") String idDrink);


}
