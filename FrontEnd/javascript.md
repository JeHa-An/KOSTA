# javascript

## var, let, const
- let : var 선언에 대한 개선을 반영한 것
- const : 일정한 상수 값을 유지


## type
|Type|'typeof'return value|Object wrapper|
|--|--|--|
|Null|"object"|N/A|
|Undefined|"undefinde"|N/A|
|Boolean|"boolean"|Boolean|
|Number|"number"|Number|
|Bigint|"bigint"|BigInt|
|String|"string"|String|
|Symbol|"symbol"|Symbol|

## Object

### this
```javascript
let person = {
  name:'홍길동',
  
}
```

### for문

#### for in 문
&nbsp;객체와 배열이 올 수 있으며, 객체의 경우 key값이 배열은 index(순서)가 들어온다.
```javascript
let product = {...};
let arr = [...];
for(let i in product) { console.log(product[i]); }
for(let i in arr) { console.log(arr[i]}
```
#### for of 문
&nbsp;배열을 위한 것이며, 앞 변수에는 배열의 값 자체가 순서대로 들어간다.
``` javascript
let arr = [10,20,30,40,50];
for(var i of arr) {
  console.log(i); 
}
```
## Date
&ngsp;Date 객체 시간의 한 점을 플랫폼에 종속되지 않는 형태

### 생성자
- Date() : new Date().toString()과 동일하게 현재 날짜와 시간을 문자열로 반환
- new Date() : 새로운 Date 객체를 반환
```javascript
let d = Date();
let nd = new Date();
console.log(typeof(d, nd)); // String, Object
```

### 데이터 비교

### 형변환
