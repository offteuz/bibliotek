package br.com.teksystem.bibliotek.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(generator = "seq_category", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_category", sequenceName = "seq_category", allocationSize = 1)
    private Long id;

    private String description;
}
