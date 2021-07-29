package com.example.audiotopapp;

import adapters.AudioAdapter;
import adapters.CategorieAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import models.Categorie;
import models.Fichier;
import remote.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Path;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListeAudioActivity extends AppCompatActivity {

    //ListView topListView ;
    Integer categorie_id;
    String categorie_name;
    ListView topListView ;
    TextView category_name;
    RecyclerView rvContacts ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent mIntent = getIntent();
         categorie_id = mIntent.getIntExtra("categorie_id", 0);
         categorie_name = mIntent.getStringExtra("categorie_name");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_audio);

        rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        category_name = (TextView) findViewById(R.id.textView8);
        category_name.setText(categorie_name);


       // topListView = findViewById(R.id.topListView);

       // Toast.makeText(getApplicationContext(), "Categorie = "+categorie_id, Toast.LENGTH_LONG).show();
        getAudios();

    }

    private void getAudios() {

        Intent intent = new Intent(this, AudioLectureActivity.class);
       // Call<List<Categorie>> call = RetrofitClient.getInstance().getMyApi().getAllCategories();
        Call<List<Fichier>> call = RetrofitClient.getInstance().getMyApi().getFichierByCategory(categorie_id);
        call.enqueue(new Callback<List<Fichier>>() {
            @Override
            public void onResponse(Call<List<Fichier>> call, Response<List<Fichier>> response) {
                List<Fichier> fichiersList = response.body();
                String[] oneHeroes = new String[fichiersList.size()];
                //Integer[] categories_ids = new Integer[categoriesList.size()];

                for (int i = 0; i < fichiersList.size(); i++) {
                    oneHeroes[i] = fichiersList.get(i).getNomFichier();
                 //   categories_ids[i] = categoriesList.get(i).getId();
                }

                AudioAdapter adapter = new AudioAdapter(fichiersList);
                // Attach the adapter to the recyclerview to populate items
                rvContacts.setAdapter(adapter);
                // Set layout manager to position the items
                rvContacts.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

              //  topListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));
                // topListView.setAdapter(arrayAdapter);
               /*topListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Long selectedPosition = (Long) parent.getItemIdAtPosition(position); //getItemAtPosition(position);
                        intent.putExtra("audio_name", fichiersList.get(position).getNomFichier());
                        startActivity(intent);
                        //Toast.makeText(getApplicationContext(), "Audio Name = http://audioapp.tdigitale.com/public/files/fichiers_audios/", Toast.LENGTH_LONG).show();

                        // textView.setText("The best football player is : " + selectedItem);
                    }
                });*/

            }

            @Override
            public void onFailure(Call<List<Fichier>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Une erreur est survenue. Vérifiez votre connexion internet !", Toast.LENGTH_LONG).show();
            }

        });
    }

}