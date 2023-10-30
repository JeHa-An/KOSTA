import './App.css';
import { useSelector, useDispatch } from 'react-redux';

function App() {
  const dispatch = useDispatch();
  const { value } = useSelector(state => state.value);
  const { count } = useSelector(state => state.count);

  return (
    <div className="App">
      <div>
        value : {value}
      </div>
      <button onClick={() => dispatch({ type: 'INCREMENT' })}>+</button>
      <button onClick={() => dispatch({ type: 'DECREMENT' })}>-</button>
      <button onClick={() => dispatch({ type: 'RESET' })}>RESET</button>
      <div>
        count : {count}
        <button onClick={() => dispatch({ type: 'PUSH' })}>UP</button>
      </div>
    </div>
  );
}

export default App;
