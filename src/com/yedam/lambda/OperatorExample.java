package com.yedam.lambda;

import java.util.function.IntBinaryOperator;

class IntBinaryClass implements IntBinaryOperator {

	@Override
	public int applyAsInt(int left, int right) {
		if (left >= right) {
			return left;
		} else {
			return right;
		}
	}

}

public class OperatorExample {
	static int[] scores = {92, 95, 87};
	public static int maxOrMin(IntBinaryOperator oper) {// main에서 호출하기위해 static사용
		int result = scores[0];
		for(Integer score : scores) {
			result = oper.applyAsInt(result, score);
		}
		return result;
	}

	public static void main(String[] args) {
		//구현클래스
		IntBinaryClass iclass = new IntBinaryClass();
		int result = maxOrMin(iclass);
		System.out.println("결과는: " + result);
		
		//익명객체
		result = maxOrMin(new IntBinaryOperator() {
			@Override
			public int applyAsInt(int left, int right) {
				if(left>= right) {
					return right;
				} else {
					return left;
				}
			}
		});
		System.out.println("익명 결과는: " + result);
		//람다표현식
		result = maxOrMin((left, right) -> {
			if(left>= right) {
				return right;
			} else {
				return left;
			}
		});
		
		System.out.println("람다 결과는: " + result);
	}

}
