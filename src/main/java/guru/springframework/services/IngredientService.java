package guru.springframework.services;

import guru.springframework.commands.IngredientCommand;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jt on 6/27/17.
 */
public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    @Transactional
    IngredientCommand saveIngredientCommand(IngredientCommand command);
}
