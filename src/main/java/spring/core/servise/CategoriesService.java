package spring.core.servise;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.core.conventer.CategoriesConverter;
import spring.core.dto.CategoriesDto;
import spring.core.model.Categories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesService {
    private RestTemplate restTemplate;

    public CategoriesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    //Dodajemy pare kategorii dla przykładu//
    private final Categories categories1 = new Categories(1L, "Elektronika");
    private final Categories categories2 = new Categories(2L, "Sport");
    private final Categories categories3 = new Categories(3L, "Motoryzacja");
    private final Categories categories4 = new Categories(4L, "Nieruchomości");
    private final Categories categories5 = new Categories(5L, "Dziecko");
    private final Categories categories6 = new Categories(6L, "Uroda");
    private final Categories categories7 = new Categories(7L, "Zdrowie");
    private final Categories categories8 = new Categories(8L, "Dom");
    private final Categories categories9 = new Categories(9L, "Ogród");
    private final Categories categories10 = new Categories(10L, "Moda");
    private final List<Categories> categoriesList = new ArrayList<>(Arrays.asList(categories1, categories2, categories3, categories4,
            categories5, categories6, categories7, categories8, categories9, categories10));


    public List<CategoriesDto> getAllCategories(){
        return categoriesList
                .stream()
                .map(CategoriesConverter::mapToDto)
                .collect(Collectors.toList());
    }
//Nie jestem pewny czy powinno być tu wyszukiwanie po id
// czy nie lepiej zmienić na wyszukiwanie po nazwie kategorii//
    public  CategoriesDto getSingleCategories(Long id){
        final Categories categoriesById = getCategoriesById(id);
        return CategoriesConverter.mapToDto(categoriesById);
    }

    //W tej metodzie podobnie jak wyżej//
    public Categories getCategoriesById(Long id){
        for (Categories categories : categoriesList){
            if (id.equals(categories.getId())){
                return categories;
            }
        }
        System.out.println("No categories with given id: "+id);
        return null;
    }
    //Metoda dodaje nową kategorię do listy kategorii//
    public void addNewCategories(CategoriesDto newCategories){
        final Categories categories = CategoriesConverter.mapFromDto(newCategories);
        categoriesList.add(categories);
    }

    //aktualizacji kategorii//
    public void updateCategories(CategoriesDto categoriesDto){
        final Categories categoriesById = getCategoriesById(categoriesDto.getId());
        if (categoriesById != null){
            categoriesById.setId(categoriesDto.getId());
            categoriesById.setName(categoriesDto.getName());
        }
    }

    public void removeCategories(Long id){
        categoriesList.remove(getCategoriesById(id));
        System.out.println("Categories remove");
    }

    public void testExternaServise(){
        final ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:9090/api/test", String.class);
        System.out.println("Extermal servise returned: " + forEntity.getBody());
    }
}
