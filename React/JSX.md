# JSX
&nbsp;JavaScript 안에 HTML 스타일의 코드를 작성할 수 있게 해주는 것이며, 그 코드를 Babel과 같은 도구를 통해 일반 JavaScript 코드로 변환 후 실행된다. 간단하게 말하면 React 컴포넌트를 편리하게 작성할 수 있게 도와주는 문법.
> JSX 문법은 JavaScript 정식 문법이 아니기 때문에 ES5 형태로 변환해 주어야 한다. 구버전 웹 브라우저의 호환을 위해서이다.

```javascript
function App() {
  return(
    <div className="App">
      <h1>Hello</h1>
    </div>
  )
}
```

## import
&nbsp;리액트로 만든 프로젝트의 자바스크립트 파일에서 다른 파일을 불러와 사용할 수 있다. 이러한 기능을 사용하기 위해 번들러를 사용합니다. 번들은 파일을 묶는다는 뜻이며,
번들러 도구를 사용해 모든 모듈을 하나의 JavaScript 파일로 번들링해 브라우저에 로드합니다.

## 장점
1. 보기 쉽고 익숙하다
1. 높은 활용도 

## 문법

### 감싸인 요소
&nbsp;컴포넌트에 여러 요소가 있다면 반드시 부모 요소 하나로 감싸야 한다.
```javascript
function App() {
  return(
    <>
      <h1>부모 태그에 감싸여</h1>
      <h1>있지 않으면 오류 발생!</h1>
    </>
  )
}
```
감싸야 하는 이유는 Virtual DOM에서 컴포넌트 변화를 감지할 때 효율적으로 비교하기 위해 컴포넌트 내부는 하나의 DOM 트리 구조로 이루어져야 한다는 규칙이 있다.
<hr>

### JavaScript 표현
&nbsp;JSX 안 에서 JavaScript 표현식을 사용할 수 있다. JSX 내부에서 코드를 { }로 감싸면 된다.
```javascript
function App() {
  const name = 'react'
  return(
    <>
      <h1>{name} 공부중</h1>
    </>
  )
}
```
#### if
&nbsp;JSX 내부의 자바스크립트 표현식에서 if문을 사용할 수 없다.
1. JSX 밖에서 if문을 사용하여 사전에 값을 설정
2. { } 안에 조건부 연사자를 사용(삼항 연산자)
```javascript
function App() {
  const name = 'react'
  return(
    <>
      {name === 'react' ? (
        <h1>react</h1>
      ) : null}
      {/* && 연산자 */}
      {name === 'react' && <h1>react입니다.</h1>}
  )
}
```
null을 렌더링하면 아무것도 보여 주지 않는다.<br>
&& 연산자로 조건부 렌더링 할 수 있는 이유는 리엑트에서 false를 렌더링할 때는 null과 마찬가지로 아무것도 나타나지 않기 때문이며, 예외적으로 0은 예외적으로 화면에 나타난다.
<hr>

#### undefined를 렌더링하지 않기
&nbsp;컴포넌트에서 undefined만 반환하여 렌더링하는 상황을 만들면 안 된다. 브라우저에서 에러코드를 발생시킨다. 어떤 값이 undefined일 수 있다면, OR(||) 연산자를 사용해 오류를 방지할 수 있다. 
1. OR(||) 연산자를 사용해 오류를 방지 <>{name || '리엑트'</>
2. JSX 내부에서 undefined를 렌더링하는 것은 괜찮다.
```JSX
function App() {
  const name = undefined;
  return <>{name}</>
}
```



#### 인라인 스타일링
- 스타일을 적용할 때는 객체 형태로 넣어 주어야 한다.
- 스타일 이름 중 margin-top 처럼 - 문자가 포함된 이름의 경우 marginTop과 같이 카멜 표기법으로 작성
```JSX
function App() {
  return (
    <div style={{marginTop : '20px'}}>
      <h1>hello</h1>
    </div>
  )
}
```
<hr>

#### class 대신 className
&nbsp;JSX에서는 class가 아닌 className으로 설정
```JSX
function App() {
  return (
    <div className="App">
      <h1>hello</h1>
    </div>
  )
}
```
#### 닫는 태그
&nbsp;HTML 태그 중 닫는 태그가 없는 태그들이 있지만 JSX에서는 태그를 닫지 않으면 오류가 발생하며, 태그 사이의 별도의 내용이 들어가지 않는 경우 태그를 선언하면서 동시에 닫을 수 있는 태그를 사용합니다. <br>
< input/>

#### 주석
{/* */}를 사용


<details>
<summary>ES6 var, const, let</summary>

### ES6 var, const, let
- const : 상수
- let : 변수 scope 블록
- var : scope 함수

</details>
<hr>

### 