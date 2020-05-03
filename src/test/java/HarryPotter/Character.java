
package HarryPotter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class Character {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("house")
    @Expose
    private String house;
    @SerializedName("school")
    @Expose
    private String school;
    @SerializedName("__v")
    @Expose
    private int v;
    @SerializedName("ministryOfMagic")
    @Expose
    private boolean ministryOfMagic;
    @SerializedName("orderOfThePhoenix")
    @Expose
    private boolean orderOfThePhoenix;
    @SerializedName("dumbledoresArmy")
    @Expose
    private boolean dumbledoresArmy;
    @SerializedName("deathEater")
    @Expose
    private boolean deathEater;
    @SerializedName("bloodStatus")
    @Expose
    private String bloodStatus;
    @SerializedName("species")
    @Expose
    private String species;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Character() {
    }

    /**
     * 
     * @param role
     * @param bloodStatus
     * @param school
     * @param species
     * @param v
     * @param deathEater
     * @param dumbledoresArmy
     * @param name
     * @param ministryOfMagic
     * @param id
     * @param orderOfThePhoenix
     * @param house
     */
    public Character(String id, String name, String role, String house, String school, int v, boolean ministryOfMagic, boolean orderOfThePhoenix, boolean dumbledoresArmy, boolean deathEater, String bloodStatus, String species) {
        super();
        this.id = id;
        this.name = name;
        this.role = role;
        this.house = house;
        this.school = school;
        this.v = v;
        this.ministryOfMagic = ministryOfMagic;
        this.orderOfThePhoenix = orderOfThePhoenix;
        this.dumbledoresArmy = dumbledoresArmy;
        this.deathEater = deathEater;
        this.bloodStatus = bloodStatus;
        this.species = species;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public boolean isMinistryOfMagic() {
        return ministryOfMagic;
    }

    public void setMinistryOfMagic(boolean ministryOfMagic) {
        this.ministryOfMagic = ministryOfMagic;
    }

    public boolean isOrderOfThePhoenix() {
        return orderOfThePhoenix;
    }

    public void setOrderOfThePhoenix(boolean orderOfThePhoenix) {
        this.orderOfThePhoenix = orderOfThePhoenix;
    }

    public boolean isDumbledoresArmy() {
        return dumbledoresArmy;
    }

    public void setDumbledoresArmy(boolean dumbledoresArmy) {
        this.dumbledoresArmy = dumbledoresArmy;
    }

    public boolean isDeathEater() {
        return deathEater;
    }

    public void setDeathEater(boolean deathEater) {
        this.deathEater = deathEater;
    }

    public String getBloodStatus() {
        return bloodStatus;
    }

    public void setBloodStatus(String bloodStatus) {
        this.bloodStatus = bloodStatus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("role", role).append("house", house).append("school", school).append("v", v).append("ministryOfMagic", ministryOfMagic).append("orderOfThePhoenix", orderOfThePhoenix).append("dumbledoresArmy", dumbledoresArmy).append("deathEater", deathEater).append("bloodStatus", bloodStatus).append("species", species).toString();
    }

}
