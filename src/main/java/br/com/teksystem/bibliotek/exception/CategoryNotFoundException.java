package br.com.teksystem.bibliotek.exception;

public class CategoryNotFoundException extends ClassNotFoundException{

    public CategoryNotFoundException() {
        super("Categoria não encontrada!");
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
