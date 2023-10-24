# Node.js
&nbsp;프로젝트 개발에 필요한 도구들이 Node.js를 사용하기 때문에 설치하는 것이며, 사용하는 개발 도구에는 ECMSAScript 6(javascript 문법)를 호환시켜 주는 **babel**, 코드를 수정할 때마다 웹 브라우저를 리로딩하는 등의 여러 기능을 지닌 **webpack**, 패키지 매니저 도구 **npm**

# React
&nbsp;React는 순수 자바스크립트이며 라이브러리다. 이 자바스크립트를 이용해 컴포넌트를 만들어 나가며, babel을 이용해 순수 자바스크립트로 변환이 된다. 우리가 만든 컴포넌트를 html과 연결하는 작업을 해줘야하는데 이것을 해주는 것이 Virtual DOM이다.

> create-react-app <br>
 리엑트 프로젝트 생성 시 필요한 webpack, babel 설치 및 설정 과정을 생략하고 간편하게 프로젝트 작업 환경을 구축해주는 도구 (npm create-react-app ProjectName) 

 ## Virtual DOM
 &nbsp; DOM을 조작할 때마다 엔진이 웹 피이지를 새로 그려 업데이트가 너무 잦으면 성능이 저하 될 수 있다. 그래서 React에서는 Virtual DOM 방식을 사용하여 DOM 업데이트를 추상화함으로써 DOM 처리 횟수를 최소화하고 효율적으로 진행하였다. 

 ### 업데이트 절차
 1. 데이터 업데이트 시 전체 UI를 Virtual DOM에 리렌더링 
 2. 이전 Virtual DOM에 있던 내용과 현재 내용을 비교
 3. 바뀐 부분만 실제 DOM에 적용

 ## Babel
 &nbsp;

 ## Webpack

 ## npm