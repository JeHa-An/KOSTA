-- 1
SELECT p.pdname 제품카테고리, p.pdsubname 제품명, f.FACNAME 공장명,st.STONAME 판매점명, ifnull(s.stamount, 0) 판매점재고수량
FROM product p JOIN stock s USING(pdno)
JOIN store st USING(stono)
JOIN factory f USING(factno)
WHERE  f.FACLOC="SEOUL" AND s.stamount=0 OR s.stamount IS NULL;
-- order by 1


-- 2
SELECT PDSUBNAME 제품명, pdcost 제품원가, pdprice 제품가격 FROM product 
WHERE pdname IN ('TV') AND pdprice >ANY (SELECT MIN(pdcost) FROM product WHERE pdname IN ('TV') GROUP BY pdname) OR pdname IN ('CELLPHONE') AND pdprice <ANY (SELECT MAX(pdcost) FROM product WHERE pdname IN ('CELLPHONE') GROUP BY pdname)
ORDER BY 2;


-- 3
CREATE TABLE DISCARDED_PRODUCT(
	pdno INT PRIMARY KEY,
	pdname VARCHAR(10),
	pdsubname VARCHAR(10),
	factno VARCHAR(5) REFERENCES factory(factno),
	pddate DATE,
	pdcost INT,
	pdprice INT,
	pdamount INT,
	discarded_data DATE
);

-- 4
START TRANSACTION;

INSERT INTO discarded_product 
SELECT * , NOW() FROM product WHERE FACTNO=
(SELECT factno FROM factory WHERE FACLOC='CHANGWON');


ROLLBACK;
COMMIT;

SELECT pdno FROM discarded_product;
SELECT pdno FROM product WHERE pdno IN (SELECT pdno from discarded_product);

-- 5
START TRANSACTION;
DELETE FROM product WHERE pdno IN (SELECT pdno from discarded_product);
SELECT * FROM product;
ROLLBACK;
COMMIT;
