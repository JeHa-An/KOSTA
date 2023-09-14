# javascript
> 위로부터 차례대로 읽어 들이는 방식(Top-Down)과, 실행 이전에 에러 체크를 하지 않고 실행하는 인터프리터 언어적 특성을 가지고 있어, 작성 위치에 따라 오작동하기도 한다.
## var, let, const
- var : 예전 JavaScript Version에서 사용하던 것 버전 호환을 위해서 존재하고 있음.
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
  age:30,
  sayHi() {
    console.log(`hi? ${this.name}`);
  }
}
console.log(person); // object 정보 모두 출력
person.sayHi() // hi? 홍길동
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
&nbsp;Date 객체 시간의 한 점을 플랫폼에 종속되지 않는 형태

### 생성자
- Date() : new Date().toString()과 동일하게 현재 날짜와 시간을 문자열로 반환
- new Date() : 새로운 Date 객체를 반환
```javascript
let d = Date();
let nd = new Date();
console.log(typeof(d, nd)); // String, Object
```

### 데이터 비교

## 형변환
### 암시적 형변환
변수 또는 값들끼리 알아서 형변환해 결과를 반환
```javascript
let v1 = 16; // number
let v2 = 'string'; // string
let v3 = true; // boolean
console.log('6' / 3); // 2
console.log('6' + 3); // 63
```

#### equals
- ==
&nbsp;암시적 형변환에 의해 데이터가 같은지 비교
- ===
&nbsp;데이터와 자료형까지 같은지 비교
```javascript
let num = 10;
let str = '10';

console.log(num == str) // true
console.log(num === str) // false
```

### 강제적 형변환
값을 원하는 자료형으로 변환 후 반환
#### Number()
```javascript
let v1 = Number('123');
let v2 = Number(true); // Number(false)
console.log(v1); // 123
console.log(v2); // 1 , 0

let v3 = Number('123z');
console.log(v3) // NaN(Not a Numer)
```

#### Boolean()
```javascript
let b1 = Boolean(-1); // true, 0을 제외한 모든 수는 true
let b2 = Boolean(0); // false

let b3 = Boolean('string'); // ture, null을 제외한 모든 문자열은 true
let b4 = Boolean('') // false

// 비어있어도 ture, 값에 0, false, undefinde, NaN이 들어있어도 true
let b5 = Boolean({}); 
let b6 = Boolean([]);
```

## 배열
&nbsp;index 0 부터 시작하며, 많은 자료형들을 배열로 저장할 수 있다.
```javascript
let arr = [1, 'asd', true, function(x) {return x}, NaN, '', undefined];
```
## function()
- 사용 방법 1
```javascript
function add(x,y) {return x+y;}
add(10,20) // 30
```
- 사용 방법 2
&nbsp;함수를 변수로 저장해 변수명으로 함수 사용
```javascript
let minus = function(x,y) {return x-y};
minus(10,20) // -10
```
- 사용 방법 3
&nbsp;화살표 함수라 하며, 많이 사용됨
```javascript
let multi = (x,y) => x*y;
let multi = (x,y) => { 
  console.log(x,y)
  return x*y
} 
```
