package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void getIngredientPriceIsMoreThan0Test(){
        Ingredient ingredientSauce = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        assertTrue("The price of a ingredient must exceed 0!", ingredientSauce.getPrice() > 0);
    }

    @Test
    public void getIngredientNameIsNotNullTest(){
        Ingredient ingredientFilling = new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000);
        assertNotNull("Ingredient name can't be null!", ingredientFilling.getName());
    }

    @Test
    public void getIngredientTypeTest(){
        Ingredient ingredientFilling = new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000);
        assertEquals("Method getType() must returns a correct type!", IngredientType.FILLING, ingredientFilling.getType());
    }


}
