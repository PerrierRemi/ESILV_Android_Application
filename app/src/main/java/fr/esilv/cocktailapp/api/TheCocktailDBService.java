package fr.esilv.cocktailapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface TheCocktailDBService {

    @GET("list.php?c=list")
    Call<CategoryList> searchCategory();

    @GET("filter.php")
    Call<CocktailList> searchCategoryDrinks(@Query("c") String nameCategory);

    @GET("lookup.php")
    Call<CocktailList> searchCocktail(@Query("i") String idDrink);


}
