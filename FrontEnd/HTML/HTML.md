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

#### img
```html
<img src="img_name" alt="이미지 못 불러올 때 대신 표시">
```
#### audio
```html
<aduio src="audio_name" controls="controls"></aduio>
```

#### video
```html
<video controls=controls" width="500px">
    <source src="video_name.mp4" type="video/mp4"
<video>
```

#### select
```html
<form action="test.html">
        <select name="food" id="">
            <option value="kimbab">김밥</option>
            <option value="dduck">떡볶이</option>
            <option value="soon">순대</option>
            <option value="fishcake">어묵</option>
        </select>
        <input type="submit">
    </form><br>
    <form action="food2">

        <select name="" id="" multiple>
            <option value="jjajang">짜장면</option>
            <option value="jjabppong">짬뽕</option>
            <option value="tangsuyuck">탕수육</option>
            <option value="gganponggi">깐풍기</option>
        </select>
        <input type="submit">
    </form><br>

    <select name="" id="">
        <optgroup label="HTML5">
            <option value="">Multimeda Tag</option>
            <option value="">Connectivity</option>
            <option value="">Device Access</option>
        </optgroup>
        <optgroup label="CSS3">
            <option value="">Animation</option>
            <option value="">3D Trasfrom</option>
        </optgroup>
    </select>
```
#### textarea
```html
<textarea name="" id="" cols="30" rows="10"></textarea>
```

### table
```html
<table border="1">
        <tr>
            <th colspan="2">지역별 홍차</th>
        </tr>
        <tr>
            <th rowspan="3">중국</th>
            <td>정산소종</td>
        </tr>
        <tr>
            <td>기문</td>
        </tr>
        <tr>
            <td>윤남</td>
        </tr>
        <tr>
            <th rowspan="4">인도 및 스리랑카</th>
            <td>아삼</td>
        </tr>
        <tr>
            <td>실론</td>
        </tr>
        <tr>
            <td>디질링</td>
        </tr>
        <tr>
            <td>닐기리</td>
        </tr>
    </table>
```

#### p, span
```html
<span>span Tag</span>
<p>p Tag</p>
```

#### div
```html
    <div>div tag</div>
    <div>div tag</div>
    <div>div tag</div>
```

#### radio 
```html
<form action="">
        <table>
            <tr>
                <td><label for="username">이름</label></td>
                <td><input type="text" id="username" name="username"></td>
            </tr>
            <tr>
                <td>성별</td>
                <td>
                    <input type="radio" id="man" value="m" name="gender">
                    <label for="man">남자</label>
                    <input type="radio" id="woman" value="w" name="gender">
                    <label for="woman">여자</label>
                </td>
            </tr>
        </table>
        <input type="submit" value="가입">
    </form>
```
### semantic
검색 엔진은 시맨틱 태그의 내용을 확인
```html
 <!-- 검색 엔진은 시멘틱 태그 내용을 확인 -->
    <header>
        <h1>HTML5</h1>
    </header>
    <nav>
        <ul>
            <li><a href="#">메뉴 -1</a></li>
            <li><a href="#">메뉴 -2</a></li>
            <li><a href="#">메뉴 -3</a></li>
        </ul>
    </nav>
    <section>
        <article>
            <h1>lorem1</h1>
            <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Neque quae sit cupiditate? Eaque facere fugiat distinctio, obcaecati saepe eveniet ipsa repudiandae enim aut, modi minima suscipit nostrum excepturi cum nesciunt.</p>
        </article>
        <article>
            <h1>lorem2</h1>
            <p style="color: red;" title="Lorem">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Neque quae sit cupiditate? Eaque facere fugiat distinctio, obcaecati saepe eveniet ipsa repudiandae enim aut, modi minima suscipit nostrum excepturi cum nesciunt.</p>
        </article>
        <article>
            <h1>lorem2</h1>
            <!-- 들여쓰기 -->
            <blockquote>Lorem ipsum dolor, <q>sit amet consectetur adipisicing elit</q>. Neque quae sit cupiditate? Eaque facere fugiat distinctio, obcaecati saepe eveniet ipsa repudiandae enim aut, modi minima suscipit nostrum excepturi cum nesciunt.</blockquote>
        </article>
    </section>
    <footer><address>서울특별시 금천구 호서대벤처타워</address></footer>
```
