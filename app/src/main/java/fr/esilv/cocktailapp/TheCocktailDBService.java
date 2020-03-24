package fr.esilv.cocktailapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface TheCocktailDBService {

    @GET("list.php?c=list")
    Call<CategorySearchResponse> searchCategory();

    @GET("filter.php")
    Call<CategorySearchResponseCocktails> searchCategoryDrinks(@Query("c") String nameCategory);

    @GET("lookup.php")
    Call<CocktailSearchResponse> searchCocktail(@Query("i") String idDrink);


}
