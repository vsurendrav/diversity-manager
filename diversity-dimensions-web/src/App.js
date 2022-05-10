import './App.scss';
import SideBarList from "./SideBarList";
import Header from './Header';
import { Routes, Route, Router } from 'react-router-dom';
import Dashboard from './component/DashBoard';

function App() {
  return (
    <div className="d-flex" id="wrapper">
      <SideBarList />
      <div id="page-content-wrapper">
        <Header />
        <div className="container-fluid">
          <h1 className="mt-4">Dash Board</h1>
        </div>
      </div>
    </div>
  );
}

export default App;
