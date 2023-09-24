# form
> client 측에서 입력을 입력하는 HTML양식을 정의하며, 입력 데이터(ex-login(id, password)..)를 Web Server로 전송하거나, 입격값과 버튼과 같은 이벤트 요소가 필요할 때 사용되는 태그


## 속성
- action
> form을 전송할 서버 쪽의 script 파일을 지정 전송되는 서버 url 또는 html 링크
- method
> 전송 방식 선택 : Get, Post 설정하지 않으면 기본적으로 Get 선택
```html
<form action="server_URL" method="post">
  <데이터 입력 태그들 추가>
</form>
```
- target
> action에서 지정한 script 파일을 현재 창이 아닌 다른 위치에 열도록 지정(_blank(새 탭), _self(기본값 현재 프레임에서 보여줌), _parent, _top)

# input
> 사용자가 정보를 입력하는 부분을 만들어야 할 때 사용

## 속성
- readonly 
> 읽기 전용 필드

- placeholder
> 힌트 표시

- maxLength
> 텍스트 필드에 최대로 입력할 수 있는 문자의 개수 지정

- required
> 필수 입력 필드 지정(입력 값이 없으면 안됨)

- type
> input 태그의 입력 방식 지정

|type 속성|설명|
|--|--|
|text|
 