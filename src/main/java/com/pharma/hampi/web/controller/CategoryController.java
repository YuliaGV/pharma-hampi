package com.pharma.hampi.web.controller;

import com.pharma.hampi.domain.dto.CategoryDTO;
import com.pharma.hampi.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getCategories(){
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable("id") int categoryId){
        return categoryService.getCategory(categoryId)
                .map(categories -> new ResponseEntity<>(categories, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/save")
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO category){
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CategoryDTO> delete(@PathVariable("id") int categoryId){
        if(categoryService.delete(categoryId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
