import React from 'react';
import data from "../data/data.json";
import { BrowserRouter as Router, Link } from "react-router-dom";

export default class Details extends React.Component{

  constructor(props){
    super(props);
    this.state = {
      index: this.props.match.params.index,
      userdata:[],
    }
  }

  componentWillMount(){
    this.setState({userdata: data.users});
  }

  render(){
    return(
      <div><div className="userProfile">

        <div className="header">
          <h3>Details for {data.users[this.state.index].first + " " + data.users[this.state.index].last}</h3>
        </div>

        <ul className="info">
          <li>
            {data.users[this.state.index].gender}
          </li>
          <li>
            {data.users[this.state.index].street}
          </li>
          <li>
            {data.users[this.state.index].city}
          </li>
          <li>
            {data.users[this.state.index].state}
          </li>
          <li>
            {data.users[this.state.index].zip}
          </li>
          <li>
            {data.users[this.state.index].email}
          </li>
          <li>
            {data.users[this.state.index].dob}
          </li>
          <li>
            {data.users[this.state.index].cell}
          </li>
        </ul>

        <div className="profileImage">
          <img src={data.users[this.state.index].picture.large} alt="image"/>
        </div>

      </div>
      <Link to={`/screens/Users`}> Back </Link>
      </div>
    );
  }
}
