package io.zhaoyang.java24hr.lesson20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class LazyStreamsDemo {
    
    static List<Beer> loadCellar() {
        List<Beer> beerStock = new ArrayList<>();
        
        beerStock.add(new Beer("Stella", "Belgium", 7.75f));
        beerStock.add(new Beer("Sam Adams", "USA", 7.00f));
        beerStock.add(new Beer("Obolon", "Ukraine", 4.00f));
        beerStock.add(new Beer("Bud Light", "USA", 5.00f));
        beerStock.add(new Beer("Yuengling", "USA", 5.50f));
        beerStock.add(new Beer("Leffe Blonde", "Belgium", 8.75f));
        beerStock.add(new Beer("Chimay Blue", "Belgium", 10.00f));
        beerStock.add(new Beer("Brooklyn Lager", "USA", 8.25f));
        
        return beerStock;
    }
    
    public static void main(String[] args) {
        List<Beer> beers = loadCellar();
        
        // First intermediate operation
        Stream<Beer> americanBeers = beers.stream().filter(br -> {
            System.out.println("Inside filter: " + br.country);
            return "USA".equals(br.country);
        });
        
        DoubleStream americanBeerPrices = americanBeers.mapToDouble(br -> {
            System.out.println(
                    "Inside mapToDouble: " + br.name + ": " + br.price);
            return br.price;
        });
        
        System.out.println("The average American beer price is $"
                + americanBeerPrices.average().getAsDouble());
        
//        Collections.sort(beers);
        beers.sort(Comparator.comparing(beer -> beer.price));
        beers.forEach(System.out::println);
    }
}
