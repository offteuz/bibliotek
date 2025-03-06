package br.com.teksystem.bibliotek.service;

import br.com.teksystem.bibliotek.dto.display.CategoryDisplayDTO;
import br.com.teksystem.bibliotek.dto.register.CategoryRegisterDTO;
import br.com.teksystem.bibliotek.exception.CategoryNotFoundException;
import br.com.teksystem.bibliotek.model.Category;
import br.com.teksystem.bibliotek.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public CategoryDisplayDTO create(CategoryRegisterDTO categoryRegisterDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryRegisterDTO, category);

        Category categoryCreated = repository.save(category);

        return new CategoryDisplayDTO(categoryCreated);
    }

    public CategoryDisplayDTO findId(Long id) throws CategoryNotFoundException {
        Category category = repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        return new CategoryDisplayDTO(category);
    }

    public List<CategoryDisplayDTO> findAll() {

        return repository.
                findAll().
                stream().
                map(CategoryDisplayDTO::new).
                toList();
    }

    public CategoryDisplayDTO update(Long id, CategoryRegisterDTO categoryRegisterDTO) throws CategoryNotFoundException {

        Category category = repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        BeanUtils.copyProperties(categoryRegisterDTO, category);

        Category categorySaved = repository.save(category);

        return new CategoryDisplayDTO(categorySaved);
    }

    public void delete(Long id) throws CategoryNotFoundException {

        Category category = repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        repository.delete(category);
    }
}
