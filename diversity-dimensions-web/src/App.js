import './App.scss';
import SideBarList from './component/SideBarList';
import Header from './component/Header';
import { Routes, Route, Router } from 'react-router-dom';
import Dashboard from './component/DashBoard';
import DiversityDimenssions from './component/DiversityDimenssions';
import Chart from 'chart.js/auto';
import SplitPane, { Pane } from 'react-split-pane';
import './AppStyle.css';
import DiversityDimenssionsReport from './component/DiversityDimenssionsReport';
import FileUpload from './component/FileUpload';

function App() {
  return (
    <div className="d-flex" id="wrapper">
      <SideBarList />
      <div id="page-content-wrapper">
        <Header />
        <div className="container-fluid">
          <h6 className="mt-4">Upload File: <FileUpload /> 
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          Download Diversity Dimenssions Report:  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button onClick={() => { }}>
              Export to Excel
            </button>
          </h6>
        </div>
        <div className="container">
          <DiversityDimenssionsReport />
          {/* <PieChartGraph /> */}
        </div>
        <div className="container-fluid Diversity-content">
          <DiversityDimenssions />
        </div>



      </div>
    </div>
  );
}

export default App;
