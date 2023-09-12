package com.kosta;

import com.kosta.order.Order;
import com.kosta.product.Goods;
import com.kosta.shop.Shop;

public class ApplicationMain {

	public static void main(String[] args) {
		//1. Shop 객체 생성 및 변수 초기화
		Shop shop= new Shop();
		
		//2. 상품 추가
		shop.addProduct(new Goods("마우스", 15000, 30, Goods.CATE_COMPUTER)); // 상품코드: P-1
		shop.addProduct(new Goods("자바의 정석", 38000, 50, Goods.CATE_BOOK)); // 상품코드: P-2
		shop.addProduct(new Goods("볼펜", 2900, 100, Goods.CATE_ETC));	    // 상품코드: P-3
		shop.addProduct(new Goods("키보드", 51000, 75, Goods.CATE_COMPUTER)); // 상품코드: P-4
		
		//3. 주문 추가:
		shop.order(new Order("홍길동", "P-1", 2));
		//4. 상품 정보 조회
		Goods p1 = shop.findProductByCode("P-1");
		//5. 상품 정보 출력
		System.out.println(p1);//상품 정보: 코드-P-1, 마우스, 가격-15000원, 재고-28개
		
//		//3. 주문 추가
		shop.order(new Order("홍길동", "P-3", 10));
//		//4. 상품 정보 조회
		Goods p2 = shop.findProductByCode("P-3");
//		//5. 상품 정보 출력
		System.out.println(p2);//상품 정보: 코드-P-3, 볼펜, 가격-2900원, 재고-90개
		
//		//3. 주문 추가
		int orderNo = shop.order(new Order("홍길동", "P-3", 5));//orderNo = 3
//		//4. 상품 정보 조회
		Goods p3 = shop.findProductByCode("P-3");
//		//5. 상품 정보 출력
		System.out.println(p3);//상품 정보: 코드-P-3, 볼펜, 가격-2900원, 재고-85개
//		
		System.out.println("------------전체 상품 정보 출력 시작------------");
//		//6. 전체 상품 정보 출력
		shop.printAllProductInfo();
//		System.out.println("------------전체 상품 정보 출력 종료------------");
//		
		System.out.println("------------전체 주문 정보 출력 시작------------");
//		//7. 전체 주문 정보 출력
		shop.printAllOrderInfo();
		System.out.println("------------전체 주문 정보 출력 종료------------");
//		
		//8-1. 주문 정보 조회
		Order order = shop.findOrderByNo(orderNo);
		//8-2. 주문 정보 출력
		System.out.println(order);//주문 정보: 주문번호-3, 주문고객명-홍길동, 주문상품-P-3, 주문수량-5, 취소여부-정상
//		
		//9. 주문 취소
		Order canceledOrder = shop.cancelOrder(orderNo);
		System.out.println(canceledOrder);//주문 정보: 주문번호-3, 주문고객명-홍길동, 주문상품-P-3, 주문수량-5, 취소여부-취소
//		
		//10. 주문 내역 내역: 고객명(홍길동)과 취소여부(정상) 정보를 이용한 조회
		//홍길동님의 정상주문 건수는: 2건이고,정상주문합계금액은: 59000원 입니다.
		shop.printOrderDetailsByCustomerAndIsCanceled("홍길동", "정상");
		
		//10. 주문 내역 내역: 고객명(홍길동)과 취소여부(취소) 정보를 이용한 조회
//		홍길동님의 취소주문 건수는: 1건이고,취소주문합계금액은: 14500원 입니다.
		shop.printOrderDetailsByCustomerAndIsCanceled("홍길동", "취소");
		
		/*
		 * 주의 사항
		 * 1. 실행결과는 아래와 동일하게 출력되어야 한다.
		 * 2. 제공파일 ApplicationMain.java 파일은 절대 수정하면 안되며, 수정없이 실행하여 아래와 동일하게 출력되어야 한다.
		 * 3. Order.java, Product.java 파일은 생성자 구현과 toString() 메서드만 Overriding 해야 하며, 일체의 수정이나 멤버변수, 멤버메서드 등을 추가하면 안된다.
		 * 4. Shop.java 파일은 ApplicationMain.java실행 시 아래와 동일하게 출력되도록 구현한다.  
		 * 
		 * **** 아래(실행결과) ****
		 	상품 정보: 코드-P-1, 마우스, 가격-15000원, 재고-28개
		 	상품 정보: 코드-P-3, 볼펜, 가격-2900원, 재고-90개
			상품 정보: 코드-P-3, 볼펜, 가격-2900원, 재고-85개
			------------전체 상품 정보 출력 시작------------
			상품 정보: 코드-P-1, 마우스, 가격-15000원, 재고-28개
			상품 정보: 코드-P-2, 자바의 정석, 가격-38000원, 재고-50개
			상품 정보: 코드-P-3, 볼펜, 가격-2900원, 재고-85개
			상품 정보: 코드-P-4, 키보드, 가격-51000원, 재고-75개
			------------전체 상품 정보 출력 종료------------
			------------전체 주문 정보 출력 시작------------
			주문 정보: 주문번호-1, 주문고객명-홍길동, 주문상품-P-1, 주문수량-2, 취소여부-정상
			주문 정보: 주문번호-2, 주문고객명-홍길동, 주문상품-P-3, 주문수량-10, 취소여부-정상
			주문 정보: 주문번호-3, 주문고객명-홍길동, 주문상품-P-3, 주문수량-5, 취소여부-정상
			------------전체 주문 정보 출력 종료------------
			주문 정보: 주문번호-3, 주문고객명-홍길동, 주문상품-P-3, 주문수량-5, 취소여부-정상
			주문 정보: 주문번호-3, 주문고객명-홍길동, 주문상품-P-3, 주문수량-5, 취소여부-취소
			홍길동님의 정상주문 건수는: 2건이고,정상주문합계금액은: 59000원 입니다.
			홍길동님의 취소주문 건수는: 1건이고,취소주문합계금액은: 14500원 입니다.
			
		 */
	}
}
