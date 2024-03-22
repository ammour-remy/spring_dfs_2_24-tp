package tp.rammour.demo.models;

import com.fasterxml.jackson.annotation.JsonView;
import tp.rammour.demo.views.RoleView;
import tp.rammour.demo.views.OperationView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;

@Getter
@Setter
@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(RoleView.class)
    protected Integer id;


    @Length(min= 3, max = 100, message = "Le nom doit avoir entre 3 et 100 caractères")
    @NotNull(message = "Le nom est obligatoire")
    @JsonView({OperationView.class, RoleView.class})
    protected String nom;

    protected Date local_date;

    @ManyToOne
    @JoinColumn(name = "task_id")
    protected Task task;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonView(OperationView.class)
    protected User user;

    @ManyToOne
    @JoinColumn(name = "site_id")
    @JsonView(OperationView.class)
    protected Site site;
}
