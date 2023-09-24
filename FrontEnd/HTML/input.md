# input
 >form 태그 내부에서 사용되며, 사용자가 정보를 입력하는 부분(입력 필드)을 만들어야 할 때 사용

## 속성
### name
> input 요소의 이름을 명시하며, form이 제출된 후 서버에서 폼 데이터를 참조하기 위해 사용되거나, 자바 스크립트에서 요소를 참조하기 위해 사용

### type
> input 태그의 입력 방식 지정

|속성|설명|
|:--:|:--|
|text|텍스트 입력|
|hidden|화면상에는 표시되지 않지만 서버에 입력 form을 전송시 함께 전송|
|email|이메일 입력|
|file|파일 첨부 버튼|
|password|비밀번호 입력|
|button|버튼 삽입|
|checkbox|체크박스 삽입|
|radio|라디오 버튼 삽입 |
|submit|서버 전송 버튼|

### value
> input 요소의 초깃값(value)을 명시
value 속성은 <input> 요소의 type 속성값에 따라 다른 용도로 사용됩니다.
- “button”, “reset”, “submit” : 버튼 내의 텍스트를 정의함.
- “hidden”, “password”, “text” : 입력 필드의 초깃값을 정의함.
- “checkbox”, “image”, “radio” : 해당 입력 필드를 선택 시 서버로 제출되는 값을 정의함.
또한, input 요소의 type 속성값이 “file”인 경우에는 value 속성을 사용할 수 없습니다.

### readonly 
> 읽기 전용 필드

### placeholder
> 힌트 표시

### maxLength
> 텍스트 필드에 최대로 입력할 수 있는 문자의 개수 지정

### required
> 필수 입력 필드 지정(입력 값이 없으면 안됨)

### width
### src
### size
### max, min
### checked
### autofocus