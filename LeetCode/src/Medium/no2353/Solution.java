package Medium.no2353;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FoodRatings {

	Map<String, FoodVO> foodMap;
	Map<String, PriorityQueue<FoodVO>> cuisineQue;

	public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

		foodMap = new HashMap<>();
		cuisineQue = new HashMap<>();

		for (int i = 0; i < foods.length; i++) {
			FoodVO food = new FoodVO(foods[i], cuisines[i], ratings[i]);
			foodMap.put(food.name, food);
			if (!cuisineQue.containsKey(food.cuisine)) {
				cuisineQue.put(food.cuisine, new PriorityQueue<>());
			}
			cuisineQue.get(food.cuisine).add(food);
		}

	}

	public void changeRating(String food, int newRating) {
		FoodVO item = foodMap.get(food);
		PriorityQueue<FoodVO> que = cuisineQue.get(item.cuisine);
		que.remove(item);
		item.rate = newRating;
		que.add(item);
	}

	public String highestRated(String cuisine) {
		return cuisineQue.get(cuisine).peek().name;
	}
}

class FoodVO implements Comparable<FoodVO> {

	String name;
	String cuisine;
	int rate;

	FoodVO(String name, String cuisine, int rate) {
		this.name = name;
		this.cuisine = cuisine;
		this.rate = rate;
	}

	@Override
	public int compareTo(FoodVO o) {
		return o.rate == this.rate ? this.name.compareTo(o.name) : (o.rate - this.rate);
	}
}