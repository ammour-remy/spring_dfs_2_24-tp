package tp.rammour.demo.models;

import com.fasterxml.jackson.annotation.JsonView;
import tp.rammour.demo.views.OperationView;
import tp.rammour.demo.views.RoleView;
import tp.rammour.demo.views.SiteView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter
@Entity
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(unique = true, length = 50)
    @Length(min= 3, max = 50, message = "Le nom doit avoir entre 3 et 50 caractères")
    @NotNull(message = "Le nom est obligatoire")
    @JsonView({SiteView.class, RoleView.class, OperationView.class})
    protected String nom;

    @JsonView(SiteView.class)
    @Length(min= 10, max = 200, message = "L'adresse doit avoir entre 10 et 200 caractères")
    @NotNull(message = "L'adresse est obligatoire")
    protected String adresse;

    @OneToMany(mappedBy = "site")
    @JsonView(SiteView.class)
    protected List<Operation> operations;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonView(SiteView.class)
    protected User client;

    @ManyToOne
    @JoinColumn(name = "ouvrier_id")
    @JsonView(SiteView.class)
    protected User ouvrier;
}
