package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int idUser;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "ADDRESS")
    private String address;

    @OneToMany(mappedBy = "idUser", cascade = CascadeType.ALL)
    private List<Order> orderList = new ArrayList<> ();

}
