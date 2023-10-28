import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Routes, Route } from 'react-router-dom';
import Board from './component/Board';
import Header from './component/Header';
import BoardWrite from './component/BoardWrite';
import BoardDetail from './component/BoardDetail';

function App() {
  return (
    <div className="App">
      <Header />
      <Routes>
        <Route exect path="/board" element={<Board />} />
        <Route exect path="/boardwrite" element={<BoardWrite />} />
        <Route exect path="/boarddetail" element={<BoardDetail />} />
      </Routes>
    </div>
  );
}

export default App;
