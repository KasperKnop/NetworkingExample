package com.kasperknop.networkingexample;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class PokemonViewModel extends ViewModel {

    PokemonRepository repository;

    public PokemonViewModel(){
        repository = PokemonRepository.getInstance();
    }

    LiveData<Pokemon> getPokemon() {
        return repository.getPokemon();
    }

    public void updatePokemon(String s) {
        repository.updatePokemon(s);
    }
}
