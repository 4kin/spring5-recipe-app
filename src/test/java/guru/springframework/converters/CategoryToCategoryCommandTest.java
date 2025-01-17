package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Created by jt on 6/21/17.
 */
public class CategoryToCategoryCommandTest {


    public static final Long ID_VALUE = Long.valueOf(1L);
    public static final String DESCRIPTION = "descript";
    CategoryToCategoryCommand convter;

    @BeforeEach
    public void setUp() throws Exception {
        convter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() throws Exception {
        Assertions.assertNull(convter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
         Assertions.assertNotNull(convter.convert(new Category()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = convter.convert(category);

        //then
         Assertions.assertNotNull(ID_VALUE, String.valueOf(categoryCommand.getId()));
         Assertions.assertNotNull(DESCRIPTION, categoryCommand.getDescription());

    }

}