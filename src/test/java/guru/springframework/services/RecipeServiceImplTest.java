package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before public void setUp(){
        MockitoAnnotations.openMocks(this);

        recipeService= new RecipeServiceImpl(recipeRepository);
    }



    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet receipesData = new HashSet<>();
        receipesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(receipesData);


        
        Set<Recipe> recipes = recipeService.getRecipes() ;
        Assert.assertEquals(recipes.size(),1);
        verify(recipeRepository, times(1)).findAll();

    }
}