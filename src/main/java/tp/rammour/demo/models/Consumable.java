package tp.rammour.demo.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import tp.rammour.demo.views.ConsumableView;

import java.util.List;

@Getter
@Setter
@Entity
public class Consumable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Length(min= 3, max = 50, message = "Le nom doit avoir entre 3 et 50 caractères")
    @NotNull(message = "Le nom est obligatoire")
    protected String nom;

    @ManyToMany(mappedBy = "consumables")
    @JsonView(ConsumableView.class)
    protected List<Task> tasks;
}
