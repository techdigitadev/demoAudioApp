package models;
//-----------------------------------com.example.Fichier.java-----------------------------------
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Fichier {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nom")
    @Expose
    private String nom;
    @SerializedName("nom_fichier")
    @Expose
    private String nomFichier;
    @SerializedName("categorie_id")
    @Expose
    private Integer categorieId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    /**
     * No args constructor for use in serialization
     *
     */
    public Fichier() {
    }

    /**
     *
     * @param createdAt
     * @param categorieId
     * @param id
     * @param nom
     * @param nomFichier
     * @param updatedAt
     */
    public Fichier(Integer id, String nom, String nomFichier, Integer categorieId, String createdAt, String updatedAt) {
        super();
        this.id = id;
        this.nom = nom;
        this.nomFichier = nomFichier;
        this.categorieId = categorieId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Fichier withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Fichier withNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public Fichier withNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
        return this;
    }

    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }

    public Fichier withCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Fichier withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Fichier withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

}