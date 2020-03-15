import * as React from "react";
import logo from './logo.svg';
import {Link, Route, BrowserRouter as Router} from "react-router-dom";
import {MainPage,SignUpPage} from "./Container";

function App() {
  return (
    <div className="App">
      <Router>
        <Route path="/" exact component={MainPage}/>
        <Route path="/signup" component={SignUpPage}/>
      </Router>
    </div>
  );
}

export default App;
