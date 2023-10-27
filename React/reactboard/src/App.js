import {Routes, Route} from 'react-router-dom';
import './App.css';
import Header from './component/Header';
import BoardList from './component/BoardList';
import BoardWrite from './component/BoardWrite';
import BoardDetail from './component/BoardDetail';

function App() {
  return (
    <div className="App">
      <Header/>
      <Routes>
        <Route exect path="/boardlist" element={<BoardList/>}/>
        <Route exect path="/boarddwrite" element={<BoardWrite/>}/>
        <Route exect path="/boarddetail" element={<BoardDetail/>}/>
      </Routes>
    </div>
  );
}

export default App;
