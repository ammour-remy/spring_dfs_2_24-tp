package tp.rammour.demo.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import tp.rammour.demo.views.RoleView;

import java.util.List;

@Getter
@Setter
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(unique = true, length = 100)
    @JsonView(RoleView.class)
    @Length(min= 10, max = 200, message = "La designation doit avoir entre 10 et 200 caractères")
    @NotNull(message = "La designation est obligatoire")
    protected String designation;

    @OneToMany(mappedBy = "role")
    @JsonView(RoleView.class)
    protected List<User> users;

}
