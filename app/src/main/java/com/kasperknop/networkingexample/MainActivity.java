package com.kasperknop.networkingexample;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ImageView imageView;
    PokemonViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);
        viewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);
        viewModel.getPokemon().observe(this, new Observer<Pokemon>() {
            @Override
            public void onChanged(Pokemon pokemon) {
                Glide.with(MainActivity.this).load(pokemon.getImageUrl()).into(imageView);
            }
        });
    }

    public void makeRequest(View view) {
        viewModel.requestPokemon(editText.getText().toString());
    }
}
