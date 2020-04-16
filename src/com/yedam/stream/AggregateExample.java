package com.yedam.stream;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

import com.sun.org.glassfish.external.statistics.AverageRangeStatistic;

import oracle.net.aso.a;

public class AggregateExample {
	public static void main(String[] args) {
		    IntStream intStream = Arrays.stream(new int[] {1,2,3,4,5});
		    long cnt = intStream.filter(n->n%2==0).count();
		    
		    intStream = IntStream.rangeClosed(1, 10);
		    OptionalDouble d = intStream.filter(n->n%2 ==1).average();
		    if(d.isPresent()) {	
		    	System.out.println("결과:" + d.getAsDouble());
		    }else {
		    	System.out.println("처리 결과가 없습니다 ");
		    }
		    
		    intStream = IntStream.range(1, 5);
		    Double od = intStream.filter(n ->n % 5 == 0).average()
		    					.orElse(0.0);
		    System.out.println(od);
	
		    
		    
	}
}
