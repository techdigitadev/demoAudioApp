package remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

import models.Categorie;
import models.Fichier;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface Api {
    String BASE_URL = "http://audioapp.tdigitale.com/public/api/v1/";
    @GET("categories")
    Call<List<Categorie>> getAllCategories();

    @GET("fichiers")
    Call<List<Fichier>> getAllFichiers();

    @GET("fichiers/categorie/{id}")
    Call<List<Fichier>> getFichierByCategory(@Path("id") int groupId);

    @GET("fichiers/{id}")
    Call<Fichier>getUnFichier();

    @POST("categories")
    Call<Categorie>createCategorie(@Body Categorie categorie);
}
