package com.kasperknop.networkingexample;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class PokemonRepository {
    private static PokemonRepository instance;
    private final MutableLiveData<Pokemon> searchedPokemon;

    private PokemonRepository() {
        searchedPokemon = new MutableLiveData<>();
    }

    public static synchronized PokemonRepository getInstance() {
        if (instance == null) {
            instance = new PokemonRepository();
        }
        return instance;
    }

    public LiveData<Pokemon> getSearchedPokemon() {
        return searchedPokemon;
    }

    public void searchForPokemon(String pokemonName) {
        PokemonApi pokemonApi = ServiceGenerator.getPokemonApi();
        Call<PokemonResponse> call = pokemonApi.getPokemon(pokemonName);
        call.enqueue(new Callback<PokemonResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    searchedPokemon.setValue(response.body().getPokemon());
                }
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
