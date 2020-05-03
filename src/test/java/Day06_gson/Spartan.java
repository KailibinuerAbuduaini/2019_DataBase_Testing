package Day06_gson;

public class Spartan {

/*
    {
    "id": 15,
    "name": "Meta",
    "gender": "Female",
    "phone": 1938695106
    }
 */

        private int id;
        private String name;
        private String gender;
        private Long Phone;

    public Spartan() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getPhone() {
        return Phone;
    }

    public void setPhone(Long phone) {
        Phone = phone;
    }

    public Spartan(int id, String name, String gender, Long phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        Phone = phone;
    }


}
