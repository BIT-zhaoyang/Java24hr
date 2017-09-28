package io.zhaoyang.java24hr.lesson20;

public class Beer implements Comparable<Beer> {
    public String name;
    public String country;
    public float price;

    public Beer(String name, String country, float price) {
        super();
        this.name = name;
        this.country = country;
        this.price = price;
    }
    
    public String toString() {
        return "Name: " + name + ", price: " + price;
    }
    
    public int compareTo(Beer otherBeer) {
        if(this.price > otherBeer.price) {
            return 1;
        } else if (this.price < otherBeer.price) {
            return -1;
        } else {
            return 0;
        }
    }
}
