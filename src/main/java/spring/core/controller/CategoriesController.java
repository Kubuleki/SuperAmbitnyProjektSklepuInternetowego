package spring.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.core.dto.CategoriesDto;
import spring.core.servise.CategoriesService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoriesController {
    private final CategoriesService categoriesSrvice;

    //Coś w rodzaju konstruktora, który wstrzykuje Beana
    @Autowired
    public CategoriesController(CategoriesService categoriesSrvice){
        this.categoriesSrvice = categoriesSrvice;
    }

    //@GetMapping - uruchamia tę metodę (metoda wyświetli wszystkie kategorie)//
    @GetMapping
    public ResponseEntity<List<CategoriesDto>> gettAllCategories(){
        final List<CategoriesDto> allCategories = categoriesSrvice.getAllCategories();
        return ResponseEntity.ok().body(allCategories);
    }

    // Wysyłamy na serwer żądanie HTTP za pomocą metody HTTP GET oraz zdefiniowaliśmy URL tego żądania,
    // to Spring przechwyci to żądanie i uruchomi metodę getCategories//
    @GetMapping("/{id}")
    public ResponseEntity<CategoriesDto> getCategories(@PathVariable("id") Long id){
        final CategoriesDto singleCategories = categoriesSrvice.getSingleCategories(id);
        return ResponseEntity.ok().body(singleCategories);
    }
    //wysyłamy do serwera żądanie o stworzenie nowej kategorii przy użyciu metody cerateCategories
    //adnotacja @Valid sprawdza czy podana przez nas nowa kategoria nie jest null'em//
    @PostMapping
    public ResponseEntity<Object> createCategories (@Valid @RequestBody CategoriesDto categoriesDto){
        categoriesSrvice.addNewCategories(categoriesDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //wysyłamy do serwera żądanie o aktulizację danej kategorii//
    @PutMapping
    public ResponseEntity<Object> updateCategories(@Valid @RequestBody CategoriesDto categoriesDto){
        categoriesSrvice.updateCategories(categoriesDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //wysyłamy do serwera żądanie o usunięcie danej kategorii//
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategories(@PathVariable("id") Long id){
        categoriesSrvice.removeCategories(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //
    @GetMapping("/test")
    public ResponseEntity<Object> testRest(){
        categoriesSrvice.testExternaServise();
        return ResponseEntity.ok().build();
    }
}
