package web.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author Karina.
 */
@Entity
@Table(name = "User")
public class User {

    public User() {
    }
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    @NotEmpty(message =  "Обязательное поле")
    private String name;

    @Column(name = "age")
    @Min(value = 0, message = "Недопустимое значение")
    private int age;

    @Column
    @NotEmpty(message =  "Обязательное поле")
    @Email
    private String email;


    public User(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail () {
        return  email;
    }
}
