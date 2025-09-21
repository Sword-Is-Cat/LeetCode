package Hard.no1912;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

class MovieRentingSystem {

	HashMap<Integer, HashMap<Integer, Prod>> movieFinder = new HashMap<>();
	HashMap<Integer, TreeSet<Prod>> listOfMovie = new HashMap<>();
	TreeSet<Prod> rented = new TreeSet<>();

	public MovieRentingSystem(int n, int[][] entries) {

		for (int[] prod : entries) {
			Prod v = new Prod(prod[0], prod[1], prod[2]);
			movieFinder.computeIfAbsent(v.shopId, val -> new HashMap<>()).put(v.movieId, v);
			listOfMovie.computeIfAbsent(v.movieId, val -> new TreeSet<>()).add(v);
		}

	}

	public List<Integer> search(int movie) {
		List<Integer> list = new ArrayList<>();
		TreeSet<Prod> set = listOfMovie.get(movie);
		if (set != null) {
			Iterator<Prod> it = set.iterator();
			while (list.size() < 5 && it.hasNext()) {
				list.add(it.next().shopId);
			}
		}
		return list;
	}

	public void rent(int shop, int movie) {
		Prod v = movieFinder.get(shop).get(movie);
		listOfMovie.get(v.movieId).remove(v);
		rented.add(v);
	}

	public void drop(int shop, int movie) {
		Prod v = movieFinder.get(shop).get(movie);
		listOfMovie.get(v.movieId).add(v);
		rented.remove(v);
	}

	public List<List<Integer>> report() {
		Iterator<Prod> it = rented.iterator();
		List<List<Integer>> result = new ArrayList<>();
		while (result.size() < 5 && it.hasNext()) {
			List<Integer> item = new ArrayList<>();
			Prod v = it.next();
			item.add(v.shopId);
			item.add(v.movieId);
			result.add(item);
		}
		return result;
	}

	class Prod implements Comparable<Prod> {

		int shopId, movieId, price;

		Prod(int shopId, int movieId, int price) {
			this.shopId = shopId;
			this.movieId = movieId;
			this.price = price;
		}

		@Override
		public int compareTo(Prod v) {
			int c;
			c = Integer.compare(price, v.price);
			if (c != 0)
				return c;
			c = Integer.compare(shopId, v.shopId);
			if (c != 0)
				return c;
			return Integer.compare(movieId, v.movieId);
		}

	}
}
