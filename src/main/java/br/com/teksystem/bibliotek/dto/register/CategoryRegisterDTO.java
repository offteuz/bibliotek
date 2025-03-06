package br.com.teksystem.bibliotek.dto.register;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CategoryRegisterDTO(

        @NotNull
        @Size(min = 4, max = 50, message = "Tamanho inválido. Verifique!")
        String description
) {
}
