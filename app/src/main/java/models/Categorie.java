package models;
        import javax.annotation.Generated;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Categorie {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nom")
    @Expose
    private String nom;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("fichier_total")
    @Expose
    private Integer fichierTotal;

    /**
     * No args constructor for use in serialization
     *
     */
    public Categorie() {
    }

    /**
     *
     * @param fichierTotal
     * @param createdAt
     * @param id
     * @param nom
     * @param updatedAt
     */
    public Categorie(Integer id, String nom, String createdAt, String updatedAt, Integer fichierTotal) {
        super();
        this.id = id;
        this.nom = nom;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.fichierTotal = fichierTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categorie withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie withNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Categorie withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Categorie withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Integer getFichierTotal() {
        return fichierTotal;
    }

    public void setFichierTotal(Integer fichierTotal) {
        this.fichierTotal = fichierTotal;
    }

    public Categorie withFichierTotal(Integer fichierTotal) {
        this.fichierTotal = fichierTotal;
        return this;
    }

}