package guru.springframework.domain;

import org.mockito.MockitoAnnotations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
    Category category;

    @Test
    public void name() {
    }

    @Before
    public void setUP() {
        category = new Category();
    }


    @Test
    public void getId() {
        category.setId(4l);
        Assert.assertEquals((Long) 4l, category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}