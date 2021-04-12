package com.kasperknop.networkingexample;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class PokemonViewModel extends ViewModel {
    PokemonRepository repository;

    public PokemonViewModel() {
        repository = PokemonRepository.getInstance();
    }

    LiveData<Pokemon> getSearchedPokemon() {
        return repository.getSearchedPokemon();
    }

    public void searchForPokemon(String s) {
        repository.searchForPokemon(s);
    }
}
