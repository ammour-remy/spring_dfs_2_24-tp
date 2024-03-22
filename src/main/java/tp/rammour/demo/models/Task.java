package tp.rammour.demo.models;


import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import tp.rammour.demo.views.TaskView;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(TaskView.class)
    protected Integer id;

    @Length(min= 12, max = 50, message = "Le nom doit avoir entre 12 et 50 caractères")
    @NotNull(message = "Le nom est obligatoire")
    protected String nom;

    @Min(value = 1, message = "Le temps doit être supérieur à 0 minute")
    @Max(value = 400, message = "Le temps ne peut pas dépasser 400 minutes")
    protected int temps;


    @ManyToMany
    @JoinTable(
            name = "task_consumable",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "consumable_id")
    )
    @JsonView(TaskView.class)
    protected List<Consumable> consumables = new ArrayList<>();


    @OneToMany(mappedBy = "task")
    @JsonView(TaskView.class)
    private List<Operation> operations;

}
