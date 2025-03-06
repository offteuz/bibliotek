package br.com.teksystem.bibliotek.controller;

import br.com.teksystem.bibliotek.dto.display.CategoryDisplayDTO;
import br.com.teksystem.bibliotek.dto.register.CategoryRegisterDTO;
import br.com.teksystem.bibliotek.exception.CategoryNotFoundException;
import br.com.teksystem.bibliotek.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bibliotek")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDisplayDTO create(@Valid @RequestBody CategoryRegisterDTO categoryRegisterDTO) {
        return service.create(categoryRegisterDTO);
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDisplayDTO findId(@PathVariable Long id) throws CategoryNotFoundException {
        return service.findId(id);
    }

    @GetMapping("/find/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDisplayDTO> findAll() {
        return service.findAll();
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDisplayDTO update(@Valid @PathVariable Long id, @RequestBody CategoryRegisterDTO categoryRegisterDTO) throws CategoryNotFoundException {
        return service.update(id, categoryRegisterDTO);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws CategoryNotFoundException {
        service.delete(id);
    }
}
