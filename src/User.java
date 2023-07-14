import java.io.Serializable;

public class User implements Serializable {
    private int number;
    private String name;
    private String surname;

    public User(int number, String name, String surname) {
        this.number = number;
        this.name = name;
        this.surname = surname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return number + " "+name + " " + surname;
    }
}
