package io.zhaoyang.java24hr.lesson20;

import java.time.LocalDateTime;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfDates {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Supplier<LocalDateTime> myStopWatch = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            return LocalDateTime.now();
        };
        
        Stream<LocalDateTime> timeStream = Stream.generate(myStopWatch).limit(10);
        timeStream.forEach(System.out::println);
    }
    
}
