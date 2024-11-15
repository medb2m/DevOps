package tn.foyer.mohamedbenmohamedtpfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    long idBloc;

    @Column(nullable = false)
    String nomBloc;

    @Column(nullable = false)
    long capaciteBloc;

    @ManyToOne
    @JsonIgnore
    Foyer foyer;

    @OneToMany(mappedBy = "bloc", fetch = FetchType.EAGER)
    List<Chambre> chambre;
}
