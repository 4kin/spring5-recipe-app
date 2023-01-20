package guru.springframework.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CategoryTest {
    Category category;

    @Test
    public void name() {
        //todo доделать
    }

    @BeforeEach
    public void setUp() {
        category = new Category();
    }


    @Test
    public void getId() throws Exception {
        Long idValue = 4L;

        category.setId(idValue);

        Assertions.assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() throws Exception {
        //todo доделать
    }

    @Test
    public void getRecipes() {
        //todo доделать
    }
}