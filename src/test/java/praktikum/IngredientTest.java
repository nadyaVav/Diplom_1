package praktikum;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.*;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

  private Ingredient ingredient;
  private String name;
  private float price;
  private IngredientType ingredientType;

  @Parameterized.Parameters
  public static Object[][] data() {
    return new Object[][] {
      {IngredientType.valueOf("SAUCE"), randomAlphabetic(10), new Random().nextFloat()},
      {IngredientType.valueOf("FILLING"), randomAlphabetic(10), new Random().nextFloat()},
      {null, null, 0.0f},
      {IngredientType.valueOf("SAUCE"), "Bun, Bun, Bun", 1.0f},
      {IngredientType.valueOf("SAUCE"), "Whole-wheat bun", 100.5f},
      {null, "", 5.0f},
      {IngredientType.valueOf("FILLING"), "$%bun&*'", -150.0f},
      {IngredientType.valueOf("FILLING"), "Longer name of bun", Float.MIN_VALUE},
      {IngredientType.valueOf("FILLING"), "Super bun", Float.MAX_VALUE}
    };
  }

  public IngredientTest(IngredientType ingredientType, String name, float price) {
    this.ingredientType = ingredientType;
    this.name = name;
    this.price = price;
  }

  @Before
  public void setUp() {
    ingredient = new Ingredient(ingredientType, name, price);
  }

  @Test
  public void shouldBeCorrectNameOfIngredient() {
    assertEquals("Incorrect name of ingredient", name, ingredient.getName());
  }

  @Test
  public void shouldBeCorrectPriceOfIngredient() {
    assertEquals("Incorrect price of ingredient", price, ingredient.getPrice(), 0);
  }

  @Test
  public void shouldBeCorrectTypeOfIngredient() {
    assertEquals("Incorrect type of ingredient", ingredientType, ingredient.getType());
  }

}