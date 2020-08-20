package spring.core.conventer;

import spring.core.dto.CategoriesDto;
import spring.core.model.Categories;

public class CategoriesConverter {

    public static CategoriesDto mapToDto(Categories categories){
        return new CategoriesDto(
                categories.getId(),
                categories.getName()
        );
    }

    public static Categories mapFromDto(CategoriesDto categories){
        return new Categories(
                categories.getId(),
                categories.getName()
        );
    }
}
