package fr.esilv.cocktailapp.activity.activity_main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.activity.activity_main.fragment_category.CategoryFragment;
import fr.esilv.cocktailapp.activity.activity_main.fragment_favorite.FavoriteFragment;
import fr.esilv.cocktailapp.activity.activity_main.fragment_search.SearchFragment;

public class MainActivity extends AppCompatActivity {
    Fragment frag_category = new CategoryFragment();
    Fragment frag_search = new SearchFragment();
    Fragment frag_favorite = new FavoriteFragment();

    private BottomNavigationView navigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener itemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nb_home:
                    display(frag_category);
                    break;
                case R.id.nb_search:
                    display(frag_search);
                    break;
                case R.id.nb_favorite:
                    display(frag_favorite);
                    break;
            }
            return false;
        }
    };

    private void display(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment_emplacement, fragment)
                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);

        navigationView = findViewById(R.id.bottom_navigation);
        display(frag_category);
        navigationView.setOnNavigationItemSelectedListener(itemSelectedListener);
    }
}
