package com.example.agence_immobiliere;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.agence_immobiliere.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RecyclerAdapterBiens adapterBiens;
    private ArrayList<BienImmobilier> biensImmobiliers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        biensImmobiliers = new ArrayList<BienImmobilier>();

        binding.recyclerViewBiensImmobiliers.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        binding.recyclerViewBiensImmobiliers.setLayoutManager(layoutManager);
        binding.recyclerViewBiensImmobiliers.setFocusable(false);

        adapterBiens = new RecyclerAdapterBiens(biensImmobiliers);
        binding.recyclerViewBiensImmobiliers.setAdapter(adapterBiens);

        binding.buttonCreerBienImmobilier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ville = binding.editTextVille.getText().toString();
                String codePostal = binding.editTextCodePostal.getText().toString();
                String rue = binding.editTextRue.getText().toString();

                BienImmobilier bienImmobilier = new BienImmobilier(ville, codePostal, rue);
                biensImmobiliers.add(bienImmobilier);
                adapterBiens.notifyDataSetChanged();
            }
        });

        binding.recyclerViewBiensImmobiliers.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), binding.recyclerViewBiensImmobiliers, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                BienImmobilier bien = biensImmobiliers.get(position);
                Toast.makeText(MainActivity.this, bien.toString(), Toast.LENGTH_SHORT).show();
            }
        }));

    }

}