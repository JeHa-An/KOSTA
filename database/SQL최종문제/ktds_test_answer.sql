-- 1.
SELECT pr.pdname 제품카테고리, pr.pdsubname 제품명, fa.facname 공장명, se.stoname 판매점명, ifnull(sk.stamount,0) 판매점재고수량
FROM stock sk JOIN product pr USING(pdno)
	JOIN factory fa USING(factno)
	JOIN store se USING(stono)	
WHERE ifnull(sk.stamount,0)=0 AND fa.facloc='SEOUL'
ORDER BY 1;

SELECT p.pdname 제품카테고리,p.pdsubname 제품명, f.facname 공장명, s.stoname 판매점명, sk.stamount 판매점재고수량
FROM (SELECT pdno, stono, ifnull(stamount,0) stamount FROM stock WHERE ifnull(stamount,0)=0) sk 
	JOIN product p USING (pdno)
	JOIN factory f USING(factno)
	JOIN store s USING(stono)
WHERE f.facloc='SEOUL'
ORDER BY 1;	

-- 2.
SELECT pdsubname, pdcost, pdprice
FROM product
WHERE pdcost >ANY (SELECT pdcost from product WHERE pdname='TV')
AND pdcost <ANY (SELECT pdcost from product WHERE pdname='CELLPHONE')
ORDER BY 2;

-- 3.
CREATE TABLE DISCARDED_PRODUCT (
	PDNO INT PRIMARY KEY, -- 제품번호
	PDNAME VARCHAR(10), -- 제품카테고리
	PDSUBNAME VARCHAR(10), -- 제품명
	FACTNO VARCHAR(5) REFERENCES factory(FACTNO), -- 공장번호
	PDDATE DATE,  -- 제품생산일
	PDCOST INT,  -- 제품원가(제품의 생산 원가)
	PDPRICE INT,  -- 제품가격(판매점에 판매되는 가격)
	PDAMOUNT INT,  -- 재고수량(공장 내 재고 수량)
	DISCARDED_DATE DATE  -- 패기날짜
);

-- 4.
INSERT INTO DISCARDED_PRODUCT
SELECT PDNO, PDNAME, PDSUBNAME, FACTNO, PDDATE, PDCOST, PDPRICE, PDAMOUNT, CURDATE()
FROM product
WHERE factno = (SELECT FACTNO FROM factory WHERE facloc='CHANGWON');

-- 5.
DELETE FROM product
WHERE factno = (SELECT FACTNO FROM factory WHERE facloc='CHANGWON');
