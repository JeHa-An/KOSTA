# Func vs Class
&nbsp;
1. this 사용 여부
2. 


## 선언
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
      <PropsRequired ReactVersion={501} /><br/>
      {/* 태그 까지 한 행으로 자식(PropsNode)한테 전달할 수 있다.*/}
      <PropsNode> 
        <span>node from App.js</span>
      </PropsNode>
    </div>
  );
}

export default App;
```

### Function
```javascript
function MyComponent({name, age}) {
    // 매개 변수로 받지 않는 다른 방식
    // let {name,age} = props.info;
    return (
        // return 하는 html은 하나의 태그에 있어야함
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
? props


### DataType
&nbsp;값을 받아 올때 데이터 타입에 맞게 저장되지 않는 오류가 발생할 수 있다. 그럴 때는 명시적으로 DataType을 정해줘 해결한다.
```javascript
import datatype from 'prop-types';

function PropsdataType(props) { 
    let {String, Number, Boolean, Array, ObjectJson, Function} = props;
    return (
        <>
            <p>StringProps : {String}</p>
            <p>NumberProps : {Number}</p>
            <p>BooleanProps : {Boolean.toString()}</p>
            <p>ArrayProps : {Array.toString()}</p>
            <p>ObjectJsonProps : {JSON.stringify(ObjectJson)}</p>
            <p>FunctionProps : {Function}</p>
        </>
    )
}

// 각 데이터 타입을 명시적으로 지정
PropsdataType.propTypes = {
    String:datatype.string,
    Number:datatype.number,
    Boolean:datatype.bool,
    Array:datatype.array,
    ObjectJson:datatype.object,
    Function:datatype.func
}

// 생략 시 밖에서 import 불가
export default PropsdataType;
```

### 값을 html 태그로 된 행으로 받기
&nbsp;값이 2개 일대 Json?으로 값이 이어져서 나온다.
```javascript
// App.js
<div className="App">
    <PropsNode> 
        <span>node from App.js</span>
    </PropsNode>
</div>

// PropsNode.js
function PropsNode(props) {
    return(
        <>
            <h1>start</h1>
            {props.children}
            <h1>end</h1>
        </>
    )
}

export default PropsNode;
```

### 값 확인 설정
```javascript
// App.js
<div className="App">
 <PropsRequired ReactVersion={501} /><br/>
</div>

//PropsRequired.js
import datatype from 'prop-types';

let PropsRequired = ({ReactString, ReactVersion})=> {
    return(
        <>
            {ReactString}{ReactVersion}
        </>
    )
}

// 꼭 가져와야할 변수 설정 없으면 에러 표출
PropsRequired.propTypes = {
    ReactString:datatype.string.isRequired,
}

// 값을 가져오지 못할 때 기본값 지정
PropsRequired.defaultProps = {
    ReactString:'리엑트',
    ReactVersion:501
}

export default PropsRequired;
```