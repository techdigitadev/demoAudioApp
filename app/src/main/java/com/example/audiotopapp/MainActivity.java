package com.example.audiotopapp;

import adapters.CategorieAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import models.Categorie;
import remote.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //String[] categories_ids = new Array() ;// new String[categoriesList.size()];

    //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);


    ListView topListView ;
    RecyclerView rvContacts ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContacts = (RecyclerView) findViewById(R.id.rvContacts);



     //   topListView = findViewById(R.id.topListView);
        getCategories();
    }

    private void getCategories() {

         Intent intent = new Intent(this, ListeAudioActivity.class);

        Call<List<Categorie>> call = RetrofitClient.getInstance().getMyApi().getAllCategories();
        call.enqueue(new Callback<List<Categorie>>() {
            @Override
            public void onResponse(Call<List<Categorie>> call, Response<List<Categorie>> response) {
                List<Categorie> categoriesList = response.body();
                String[] oneHeroes = new String[categoriesList.size()];
                Integer[] categories_ids = new Integer[categoriesList.size()];
                //Categorie[] categories = new  Categorie[categoriesList.size()] ;

                for (int i = 0; i < categoriesList.size(); i++) {
                    oneHeroes[i] = categoriesList.get(i).getNom();
                    categories_ids[i] = categoriesList.get(i).getId();
                    //categories[i] =  categoriesList.get(i);
//                    contacts = Contact.createContactsList(20);
                }

                CategorieAdapter adapter = new CategorieAdapter(categoriesList);
                // Attach the adapter to the recyclerview to populate items
                rvContacts.setAdapter(adapter);
                // Set layout manager to position the items
                rvContacts.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

               // topListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));
               // topListView.setAdapter(arrayAdapter);
               /* topListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Long selectedPosition = (Long) parent.getItemIdAtPosition(position); //getItemAtPosition(position);
                        intent.putExtra("categorie_id", categoriesList.get(position).getId());
                        startActivity(intent);
                        //Toast.makeText(getApplicationContext(), "Item View !", Toast.LENGTH_LONG).show();

                        // textView.setText("The best football player is : " + selectedItem);
                    }
                });
*/
            }

            @Override
            public void onFailure(Call<List<Categorie>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Une erreur est survenue. Vérifiez votre connexion internet !", Toast.LENGTH_LONG).show();
            }

        });
    }

    public void launchGestionStockActivity(View view) {
        Intent intent = new Intent(this, ListeAudioActivity.class);
        startActivity(intent);
    }


}