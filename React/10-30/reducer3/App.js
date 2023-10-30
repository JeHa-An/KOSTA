import './App.css';
import MyNickname from './MyNickname';
import {initState, reducer} from './MyReducer';
import { useReducer, useState } from 'react';

function App() {
  const [subject, setSubject] = useState('');
  const [grade, setGrade] = useState('');
  const [info, dispatch] = useReducer(reducer, initState);

  return (
    <div className="App">
      <label>{info.id}</label>&nbsp;&nbsp;&nbsp;
      {/* <input type="text" onInput={(e)=>setId(e.target.value)}/> */}
      {/* <button onClick={()=> dispatch({type: 'id', payload: id})}>아이디 변경</button><br/> */}
      <input type="text" onInput={(e)=> dispatch({type:'id', payload: e.target.value})}/>
      <br/>
      <MyNickname info={info} dispatch={dispatch}/>
     
      <label>{info.subject}</label>&nbsp;&nbsp;&nbsp;
      <input type="text" onInput={(e)=>setSubject(e.target.value)}/>
      <button onClick={()=> dispatch({type: 'subject', payload: subject})}>전공 변경</button><br/>

      <label>{info.grade}</label>&nbsp;&nbsp;&nbsp;
      <input type="text" onInput={(e)=>setGrade(e.target.value)}/>
      <button onClick={()=> dispatch({type: 'grade', payload: grade})}>학년 변경</button><br/>
    </div>
  );
}

export default App;
