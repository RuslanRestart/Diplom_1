package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest{
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] testData(){
        return new Object[][]{
                {IngredientType.SAUCE, "Соус Spicy-X", 90},
                {IngredientType.FILLING, "Говяжий метеорит", 3000},
                {IngredientType.SAUCE, "Соус традиционный", 15}
        };
    }

    @Test
    public void testIngredientNameTypeAndPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Method getType() must returns a correct type!", type, ingredient.getType());
        assertNotNull("Ingredient name can't be null!", ingredient.getName());
        assertTrue("The price of a ingredient must exceed 0!", ingredient.getPrice() > 0);

    }
}
