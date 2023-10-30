# Props
- 부모가 설정한 값을 자식이 사용하며, 보통 변수에 담아서 사용
- props값은 컴포넌트 함수의 파라미터로 받아 와서 사용할 수 있다

<br>

## props값 지정
```jsx
// App.js
<div className="App">
    <MyComponent ReactVersion={501} /><br/>
</div>

// MyComponent.js
function MyComponent(props) {
    return (
        <>
            Version : {props.ReactVersion} 
        </>
    )
}

// 브라우저
// Version : 501
```
<br><hr>

### props 기본값 설정: defaultProps
&nbsp;큰 프로젝트 진행할 때 해당 컴포넌트에 어떤 props가 필요한지 쉽게 알 수 있다.
```javascript
// App.js
<div className="App">
    <MyComponent ReactVersion={501} />
</div>

//MyComponent.js
let MyComponent = ({ReactString, ReactVersion})=> {
    return(
        <>
            {ReactString}{ReactVersion}
        </>
    )

    // props 값을 지정하지 못했을 때 기본값 지정
    MyComponent.defaultProps = {
        ReactString:'리엑트',
        ReactVersion:501
}

export default MyComponent;

// 브라우저 
// 리엑트501
```
<br><hr>

### 비구조화 할당
&nbsp; props는 값들을 자식에게 객체로 전달한다. 파라미터가 객체라면 그 값을 바로 비구조화해 사용할 수 있다. **부모 컴포넌트의 props의 이름(name)과 자식 컴포넌트의 파라미터의 이름이 일치해야한다 대소문자 까지도...**
```jsx
// App.js
<div className="App">
    <MyComponent name='리엑트' version={501} />
</div>

// MyComponent.js
function MyComponent({name, version}}) {
    return(
        <>
            <h1>{name}{version}</h1>
        </>
    )
}

export default MyComponent;

// 브라우저
// 리엑트501
```
<br><hr>

### children
&nbsp;태그 사이의 내용을 보여주는 props
```javascript
// App.js
<div className="App">
    <MyComponent> 
        <span>node from App.js</span>
    </MyComponent>
</div>

// MyComponent.js
function MyComponent(props) {
    return(
        <>
            <h1>start</h1>
            {props.children}
            <h1>end</h1>
        </>
    )
}

export default MyComponent;

// 브라우저
// start
// node from App.js
// end
```
<br><hr>

### propsTypes를 통한 props 검증
&nbsp;컴포넌트의 필수 props를 지정하거나 props의 타입을 지정할 때 사용하며, 설정한 형태와 일치하지 않으면 브라우저 개발도구에 error 표시
```javascript
// App.js
<div className="App">
    <MyComponent version={501} />
</div>

// MyComponent.js
// propsTypes 사용 시 import 구문 사용
import PropTypes from 'prop-types';

function MyComponent({name, version}) {
    return(
        <>
            {name},{version}
        </>
    )
}
    MyComponent.propTypes = {
        // name 값은 무조건 문자열(string) 형태 그렇지 않은 에러 표출 브라우저에는 값이 보여진다. 
        name:PropTypes.string,
        // 꼭 가져와야할 변수 값이 없으면 에러 표출
        version:PropTypes.string.isRequired
    }

export default MyComponent;
```
<br><hr>

### propsTypes 종류
- array
- bool
- func
- number (숫자)
- object
- node (렌더링할 수 있는 모든 것)
- any (아무 종류)    
.    
.
<br><hr>

### Class 컴포넌트에서 props 사용
```javascript
// App.js
<div className="App">
      <MyComponent name={4} version={501} />
</div>

// MyComponent.js
import {Component} from 'react';
import PropTypes from 'prop-types';

class MyComponent extends Component {
    render() {
        const {name, version} = this.props;
        return (
            <>
            {name}{version}
            </>
        )
    }
}
// 함수 컴포넌트와 사용법 동일
MyComponent.propTypes = {
    name:PropTypes.string,
    Version:PropTypes.string.isRequired
}
```
<br><hr>




