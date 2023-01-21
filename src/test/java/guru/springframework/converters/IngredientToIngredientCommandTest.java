package guru.springframework.converters;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


/**
 * Created by jt on 6/21/17.
 */
public class IngredientToIngredientCommandTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long UOM_ID = new Long(2L);
    public static final Long ID_VALUE = new Long(1L);


    IngredientToIngredientCommand converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullConvert() throws Exception {
        Assertions.assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
         Assertions.assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void testConvertNullUOM() throws Exception {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setUom(null);
        //when
        IngredientCommand ingredientCommand = converter.convert(ingredient);
        //then
        Assertions.assertNull(ingredientCommand.getUnitOfMeasure());
         Assertions.assertNotNull(ID_VALUE, String.valueOf(ingredientCommand.getId()));
       //  Assertions.assertNotNull(RECIPE, ingredientCommand.get);
         Assertions.assertNotNull(AMOUNT, String.valueOf(ingredientCommand.getAmount()));
         Assertions.assertNotNull(DESCRIPTION, ingredientCommand.getDescription());
    }

    @Test
    public void testConvertWithUom() throws Exception {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);

        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);

        ingredient.setUom(uom);
        //when
        IngredientCommand ingredientCommand = converter.convert(ingredient);
        //then
         Assertions.assertNotNull(ID_VALUE, String.valueOf(ingredientCommand.getId()));
         Assertions.assertNotNull(ingredientCommand.getUnitOfMeasure());
         Assertions.assertNotNull(UOM_ID, String.valueOf(ingredientCommand.getUnitOfMeasure().getId()));
        //  Assertions.assertNotNull(RECIPE, ingredientCommand.get);
         Assertions.assertNotNull(AMOUNT, String.valueOf(ingredientCommand.getAmount()));
         Assertions.assertNotNull(DESCRIPTION, ingredientCommand.getDescription());
    }
}