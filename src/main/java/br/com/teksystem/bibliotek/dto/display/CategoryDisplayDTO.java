package br.com.teksystem.bibliotek.dto.display;

import br.com.teksystem.bibliotek.model.Category;

public record CategoryDisplayDTO(

        Long id,

        String description
) {

    private CategoryDisplayDTO(Category category) {
        this(
                category.getId(),
                category.getDescription()
        );
    }
}
