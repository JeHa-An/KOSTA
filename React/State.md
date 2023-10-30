# State
&nbsp;컴포넌트 내부에서 바뀔 수 있는 값을 의미하며(UI를 바꿀 수 있다는 의미 인것 같아요), 그 값을 가지고 component함수를 다시 시작해 새로운 return 값을 만들어주는 data입니다!!

## state 종류
1. class 의 state
2. 함수의 useState 함수를 사용하는 state

Virtual DOM에 변수 저장 / setState를 사용해 자식 컴포넌트에서 state 값을 변경할 수 있으며, 부모와 자식 사이 자식이 많을 때 redux를 사용해 해결 단점 무거움

> React 공식 문서<br>&nbsp;setState()는 컴포넌트의 state 객체에 대한 업데이트를 실행합니다. state가 변경되면, 컴포넌트는 리렌더링됩니다.


<br><hr>

### Function

#### 배열 비구조화 할당
&nbsp;객체 비구조화 할당과 비슷하며, 배열 안에 들어 있는 값을 쉽게 추출할 수 있도록 해주는 문법
```javascript
  const array = [1,2];
  const one = array[0];
  const two = array[1];
  // 밑의 코드와 동일
  const array = [1,2];
  const [one, two] = array;
```
<br><hr>

&nbsp;함수 컴포넌트에서 state를 사용하기 위해 Hook(아직은 잘 모르겠음 나중에 설명 추가하겠음)을 사용해야 하며, react에서 제공하는 useState함수다. (react 16.8 version 이상에서 사용 가능)

- state 초깃값의 형태는 자유롭다
- 함수 호출할 때 배열로 반환된다.
```javascript
import {useState} from 'react';

function FState Comp() {
    // state area
    const [stateString, setStateString] = useState('react');
    const [stateNumber, setStateNumber] = useState(501);
    return (
        <>
            <button onClick={() => {setStateString('리엑트')}}> String 변경</button> <br/>
            <button onClick={() => {setStateNumber(502)}}> Number 변경</button> <br/>
            StateString : {stateString} <br/>
            StateNumber : {stateNumber} <br/>
        </>
    )
}

export default FStateComp;
```
<br><hr>

### Class
&nbsp;클래스형 컴포넌트에서 state 설정할 때는 **constructor(생성자 메서드)** 작성하여 설정하며, **super(props)** 를 호출해 주어야 합니다. 이 함수가 호출되면 현재 클래스형 컴포넌트가 상속받고 있는 react의 component클래스가 지닌 생성자 함수를 호출해 줍니다. ***클래스 컴포넌트의 state는 객체 형식이어야 합니다!***
```javascript
import {Component} from 'react';

class StateComp extends Component {
    // 함수와 클라스의 큰 차이는 this
    constructor(props) {
        super(props);
        // state의 초깃값 설정
        this.state = {
            stateString : 'react',
            stateNumber : 501
        }
    }
```

```javascript
    stringChange = (e)=> {
        // this.state.stateString = '리엑트' // 렌더링 되지 않는다.
        this.setState({stateString:'리엑트'});
    }

    numberChange = (e)=> {
        this.setState({stateNumber : 502});
    }

    render() {
        return (
            <>
                <button onClick={(e)=>{this.stringChange(e)}}> String 변경</button> <br/>
                // 호출하는 함수 연결 
                <button onClick={this.numberChange}> Number 변경</button> <br/>
                StateString : {this.state.stateString} <br/>
                StateNumber : {this.state.stateNumber} <br/>
            </>
        )
    }
}

export default StateComp;
```