# State

> React 공식 문서<br>&nbsp;setState()는 컴포넌트의 state 객체에 대한 업데이트를 실행합니다. state가 변경되면, 컴포넌트는 리렌더링됩니다.



## Function
```javascript
import {useState} from 'react';

function FStateComp() {
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


## Class
```javascript
import React,{Component} from 'react';

class StateComp extends Component {
    // 함수와 클라스의 큰 차이는 this
    constructor(props) {
        super(props);
        this.state = {
            stateString : 'react',
            stateNumber : 501
        }
    }

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