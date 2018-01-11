import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch, NavLink, } from "react-router-dom";
import Home from "./screens/Home";
import Users from "./screens/Users";
import Details from "./screens/Details";


const App = () => (
  <Router>
    <div>
      <NavLink to="/screens/Users">See all users</NavLink>

      <Switch>
        <Route exact path="/" component={Home} />
        <Route exact path={`/screens/Details/:index`} render={props => <Details {...props}/>} />
        <Route exact path="/screens/Users" component={Users} />        
      </Switch>
    </div>
  </Router>
)
export default App
