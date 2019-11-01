package com.kasperknop.networkingexample;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonRepository {

    private static PokemonRepository instance;
    private MutableLiveData<Pokemon> pokemon;

    private PokemonRepository() {
        pokemon = new MutableLiveData<>();
    }

    public static synchronized PokemonRepository getInstance() {
        if (instance == null) {
            instance = new PokemonRepository();
        }
        return instance;
    }

    public LiveData<Pokemon> getPokemon() {
        return pokemon;
    }

    public void requestPokemon(String pokemonName) {
        PokemonApi pokemonApi = ServiceGenerator.getPokemonApi();
        Call<PokemonResponse> call = pokemonApi.getPokemon(pokemonName);
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.code() == 200) {
                    pokemon.postValue(response.body().getPokemon());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
    }
}
