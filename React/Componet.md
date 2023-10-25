# Func vs Class
&nbsp;라이프사이클 기능을 사용할 수 있다는 것과 임의 메서드를 정의할 수 있다는 것.
1. this 사용 여부
2. render() 함수 사용 여부


## 컴포넌트 생성 방식
### App.js
```javascript
import MyComponent from './MyComponent';

function App() {
  return (
    <div className="App">
      {/* 모든 속성은 String or javascript 코드 {} 사용 */}
      // <MyComponent name="jeha" age={24}/>
      // 값을 이름만 줄때 (아무것도 주지 않을 때 error) Boolean Type의 trun로 전달
      <MyComponent info={{name:'gong', age:'40'}}/>
      <PropsdataType 
        String="react"
        Number={501}
        Boolean={1==1}
        Array={[1,2,3]}
        ObjectJson={{react:'리엑트', version:501}}
        Function={console.log("FunctionProps: function!")}
      />
      <PropsBoolean BooleanTrueFalse={false}/>
      <PropsBoolean BooleanTrueFalse/>
    </div>
  );
}

export default App;
```

> import<br>
&nbsp;~~다른 파일들을 불러와 사용할 수 있다. 모듈을 불러와 사용하는 것은 브라우저에는 없는 기능이지만 Node.js에서 지원하는 기능으로 브라우저가 아닌 환경에서 자바~~

### Function
```jsx
function MyComponent({name, age}) {
    return (
        // return 하는 html은 하나의 부모 태그에 있어야함
        <>
            <h1>{name}</h1>
            <h1>{age}</h1>
        </>
    )
}

export default MyComponent;
```
&nbsp;

### Class
```javascript
import React, {Component} from 'react';
class MyComponent extends Component {
    render() {
        let {name,age} = this.props.info;
        return (
            <div>
                {/* <h1>{this.props.info.name}</h1>
                <h1>{this.props.info.age}</h1> */}
                // 사용 할 때 위의 let {name, age} 변수 저장
                <h1>{name}</h1>
                <h1>{age}</h1>
            </div>
        )
    }
}
```

? render 
> 뷰가 어떻게 생겼고 어떻게 작동하는 지에 대한 정보를 지닌 객체를 반환 


