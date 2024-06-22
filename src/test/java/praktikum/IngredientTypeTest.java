package praktikum;

import static org.junit.Assert.*;

import org.junit.Test;

public class IngredientTypeTest {

  private String expectedIngredient1 = "SAUCE";
  private String expectedIngredient2 = "FILLING";

  @Test
  public void shouldBeTwoElements() {
    IngredientType[] ingredientTypes = IngredientType.values();
    assertEquals(2, ingredientTypes.length);
  }

  @Test
  public void shouldBeCorrectIngredientSauce() {
    assertEquals(expectedIngredient1, IngredientType.valueOf(expectedIngredient1).toString());
  }

  @Test
  public void shouldBeCorrectIngredientFilling() {
    assertEquals(expectedIngredient2, IngredientType.valueOf(expectedIngredient2).toString());
  }

}