package Medium.no2115;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
	public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

		HashMap<String, CookUnit> map = new HashMap<>();
		for (String recipe : recipes) {
			map.put(recipe, new CookUnit(recipe));
		}
		for (String supply : supplies) {
			map.put(supply, new CookUnit(supply));
		}

		for (int i = 0; i < recipes.length; i++) {
			CookUnit recipe = map.get(recipes[i]);
			List<String> list = ingredients.get(i);
			for (String item : list) {
				recipe.ingredient.add(map.get(item));
			}
		}

		List<String> answer = new ArrayList<>();
		for (String recipe : recipes) {
			if (map.get(recipe).getCreatable()) {
				answer.add(recipe);
			}
		}

		return answer;
	}
}

class CookUnit {

	String name;
	List<CookUnit> ingredient;
	boolean isChecked, creatable;

	CookUnit(String name) {
		this.name = name;
		ingredient = new ArrayList<>();
		isChecked = false;
		creatable = false;
	}

	boolean getCreatable() {

		if (!isChecked) {
			isChecked = true;
			boolean result = true;
			for (CookUnit item : ingredient) {
				result &= item == null ? false : item.getCreatable();
			}
			creatable = result;
		}

		return creatable;
	}

}