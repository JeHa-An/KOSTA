# DOM (Document Object Model, 이하 DOM)
> &nbsp;문서의 구조화된 표현(structured representation)을 제공하며 프로그래밍 언어가 DOM 구조에 접근할 수 있는 방법을 제공해 문서 구조, 스타일, 내용 등을 변경할 수 있게 돕는 역할을 한다.(+ 문서를 관계형 객체로 만들어 메모리에 올린다.)<br>
`W3C DOM 표준은 대부분의 브라우저에서 DOM를 구현하는 기준`
## 데이터 타입
### document
<details>
<summary>토글 접기/펼치기</summary>
<div markdown="1">

### select
#### querySelector()
> ' '안에 id('#number'), class('.title'), Tag_Name('h1'), 자식('ul>li:first-child'), 자손('h1 p') 등이 들어오며 제일 첫번째 element 선택
```javascript
// 첫 element h1의 style, text 추가
let h = document.querySelector('h1');
h.style.color = 'orange';
h.style.backgroundColor = 'red';
h.innerHTML = 'From JavaSccript';
```
#### querySelectorAll()
> (' ')에 해당하는 element를 모두 가져오며, 배열 형식으로 반환
```javascript
let hs = document.querySelectorAll('h1');
for(let h of hs) {
   h.style.color = 'orange';
   h.style.backgroundColor = 'red';
   h.innerHTML = 'From JavaSccript';
}
```
#### getElementById()
#### getElementByClassName()
#### getElementByTagName()
#### getElementByName()

### event
&nbsp;웹 에서 일어나는 사건(action) 혹은 발생(occurrence)을 어떤한 방식으로 응답할 수 있도록 웹에 말해주는 것<br>
#### 이벤트 타입 예
- 사용자가 키보드에서 키를 선택한다.
- 유저가 브라우저의 창의 크기를 재조정하거나 닫습니다.
- 양식(form)이 제출되었습니다.
- 오류가 발생했습니다.

#### 이벤트 핸들러(event handler)
&nbsp;각 이벤트들은 이벤트 핸들러를 가지고 있으며, 이벤트가 발생되면 실행되는 코드 블럭(우리가 정의한 javascript 함수)이 이벤트에 응답해서 실행되기 위해 정의되었을 때, 우리는 이벤트 핸들러를 등록(register)했다고 하며, 이벤트 리스너(event Listener)라고도 불린다. 즉, **listener는 발생되는 event를 듣고, hanlder는 발생되는 event에 응답해 실행되는 코드입니다.** <br>
> web event는 브라우저의 내장된 API의 일부
 

</div>
</details>

### window
<details>
<summary>토글 접기/펼치기</summary>
<div markdown="1">

### window.onload
&nbsp;javascript는 위에서 차례대로 코드를 읽고 실행하기 때문에 <script> 먼저 실행되면 해당 element들이 없어 코드가 실행되지 않기 때문에 window.onload 함수를 사용해 웹브라우저 내의 모든 요소가 준비된 후 실행되도록 한다.
```javascript
<script>
  window.onload = () => {...}
</script>

<p> 2023-09-14 </p>
```

</div>
</details>

### element
<details>
<summary>토글 접기/펼치기</summary>
<div markdown="1">

안녕

</div>
</details>

### nodeList (아직 배우지 않음)
### attribute
<details>
<summary>토글 접기/펼치기</summary>
<div markdown="1">

안녕

</div>
</details>

### nameNodeMap (아직 배우지 않음)

## HTMLElement

### innerHTML vs textContent
&nbsp;innerHTML은 h1 태그가 적용된 Bye!!가 웹에 보여지고, textContent는 h1태그까지 웹에 보여진다.
```javascript
let div1 = document.getElementById('div1');
div1.innerHTML = `<h1>Bye!!</h1>`; 
let div2 = document.getElementById('div2');
div2.textContent = `<h1>Bye!!</h1>`;

<div id="div1"></div> 
<div id="div2"></div>
```
### setAttribute
&nbsp;element의 속성에 Key:value 추가
```javascript
let div = document.getElementById('div');
div.setAttribute('data','i am d data'); // div tag에 data="i am d data" 추가
console.log(div.getAttribute('data-name')); // web console에 hong 출력

<div id="div" data-name="hong"></div>
```
