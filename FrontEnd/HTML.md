# HTML5

## Tag
`<tag>`, `</tag>` 열린태그, 닫힌태그라고 한다. 태그 안에`<h1 id="title">` 있는 것은 속성이라고 한다.
### !DOCTYPE HTML 
이 페이지의 HTML 버전이 무엇인지 웹 브라우저에 알려주는 선언문
``` html
<!DOCTYPE html> 
```
#### lang
페이지의 언어를 설정하며, html 태그에 추가하여 사용. HTML문서는 언어가 설정되어 있으면 검색 엔진에 의해 보다 효과적이며, 시각장애가 있는 자용자에게 유용(같은 숫자라도 언어마다 발음이 다르다.)
```html
<html lang="en"></html>
```

### head
페이지를 열 때 웹 브라우저에 표시되지 않으며, title, css 링크, 파비콘(favicon), 메타데이터를 포함
```html
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./style.css">
    <script src="./script.js"></script>
</head>
```
### body

#### 제목
```html
    <h1>제목 글자 태그1</h1>
    <h2>제목 글자 태그2</h2>
    <h3>제목 글자 태그3</h3>
    <h4>제목 글자 태그4</h4>
    <h5>제목 글자 태그5</h5>
    <h6>제목 글자 태그6</h6>
```
#### form
사용자로부터 입력을 받을 때 사용
```html
<form action="test.html">
    <input type="text" name="id"><br>
    <input type="password" name="password"><br>
    <input type="file" name="file"><br>
    <input type="checkbox" name="hobby" value="독서">독서 <input type="checkbox" name="hobby" value="음악감상">음악감상<br>
    <input type="radio" name="gender" value="male">남<input type="radio" name="gender" value="female">여<br>
    <input type="button" value="버튼"><br>
    <input type="submit" value="로그인"><br>
    <input type="reset" value="다시"><br>
    <input type="image" src="https://placehold.it/100x100"><br>
</form>
```

#### fieldest, legend
폼 엘리먼트들을 그룹화할 때 사용
```html
<fieldest>
    <legend>개인 정보 입력</legend>
    이름 : <input type="text" name="name"><br>
    나이 : <input type="text" name="age"><br>
</fieldest>
```

#### text
```html
<i>Lorem ipsum dolor sit</i><br>
<b>Lorem ipsum dolor sit</b><br>
<small>Lorem ipsum dolor sit</small><br>
<ins>Lorem ipsum dolor sit</ins><br>
<del>Lorem ipsum dolor sit</del><br>
CO<sub>2</sub><br>
10<sup>2</sup><br>
```

#### list
```html
<!-- 순서 없는 -->
<ul>
    <li>사과</li>
    <li>바나나</li>
    <li>오렌지</li>
</ul>
<!-- 순서 있는 -->
<ol>
    <li>사과</li>
    <li>바나나</li>
    <li>오렌지</li>
</ol>
<!-- 중첩 사용 가능 -->
<ul>
    <li>
        <b>과일</b>
        <ol>
            <li>사과</li>
            <li>바나나</li>
            <li>오렌지</li>
        </ol>
    </li>
    <li>
        <b>채소</b>
        <ol>
            <li>상추</li>
            <li>치커리</li>
            <li>양배추</li>
        </ol>
    </li>
</ul>
```

#### link
```html
<a href=http://naver.com>네이버</a>

<!-- 특정 id로 특정 id를 가진 태그로 이동가능 -->
<a href="#lorem1">lorem1</a>&nbsp;&nbsp;
<h1 id="lorem1">Lorem1</h1>
    <p>
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Aliquam dicta dolorquod? Dolor quos officia, tempore perspiciatis, repellat qui aut itaqueexercitationem rerum cumque ipsum, esse neque ex? Iusto, quis.
    </p>
```

### semantic
검색 엔진은 시맨틱 태그 
```html

```