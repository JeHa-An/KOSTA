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

- name
> 해당 폼의 이름을 명시
