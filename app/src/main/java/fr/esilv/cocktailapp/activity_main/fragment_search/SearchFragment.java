package fr.esilv.cocktailapp.activity_main.fragment_search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import fr.esilv.cocktailapp.R;

public class SearchFragment extends Fragment {

    View view;
    SearchView searchView;
    SearchResultFragment searchResultFragment = new SearchResultFragment();
    FragmentTransaction transaction;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_fragment, container, false);
        searchView =view.findViewById(R.id.searchView);

        transaction = getFragmentManager().beginTransaction();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Bundle bundle = new Bundle();
                bundle.putString("query",query);
                searchResultFragment.setArguments(bundle);
                transaction.replace(R.id.main_fragment_emplacement,searchResultFragment).commit();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return view;
    }
}
