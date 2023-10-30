import './App.css';
import {configureStore} from '@reduxjs/toolkit';
import {Provider} from 'react-redux';
import Page1 from './Page1';


// const initState = {
//   data1: "NONE",
//   date2: 0
// }

const reducer = (state, action) =>  {
  if (state === undefined) {
    return {
      data1: "NONE",
      data2: 0
    }
  }
  const newState = {...state};
  switch(action.type) {
    case "STRING" : newState.data1=action.data; break;
    case "INT" : newState.data2=action.data; break;
    default :
  }
  return newState;
} 

const store = configureStore({reducer});

function App() {
  return (
      <Provider store={store}>
        <div className="App">
          <Page1/>
        </div> 
      </Provider>
  );
}

export default App;
