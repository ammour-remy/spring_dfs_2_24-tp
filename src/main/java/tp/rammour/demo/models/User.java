package tp.rammour.demo.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import tp.rammour.demo.views.OperationView;
import tp.rammour.demo.views.UserView;

import java.util.List;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(unique = true, length = 50)
    @Length(min= 3, max = 50, message = "Le Pseudo doit avoir entre 3 et 50 caractères")
    @NotNull(message = "Le Pseudo est obligatoire")
    @JsonView({UserView.class, OperationView.class})
    protected String pseudo;

    @Length(min= 12, max = 400, message = "Le mot de passe doit avoir entre 12 et 200 caractères")
    @NotNull(message = "Le mot de passe est obligatoire")
    @JsonView(UserView.class)
    protected String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id")
    protected Role role;

    @OneToMany(mappedBy = "user")
    @JsonView(UserView.class)
    protected List<Operation> operations;

    @OneToMany(mappedBy = "client")
    @JsonView(UserView.class)
    protected List<Site> sitesClient;


    @OneToMany(mappedBy = "ouvrier")
    @JsonView(UserView.class)
    protected List<Site> sitesOuvrier;

}
