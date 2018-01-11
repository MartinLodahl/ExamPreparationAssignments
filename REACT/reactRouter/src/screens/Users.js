import React from 'react';
import data from "../data/data.json";
import '../App.css';

import { BrowserRouter as Router, Link } from "react-router-dom";

export default class Users extends React.Component{

  constructor(props){
    super(props);
    this.state = {userdata:[],}
  }


  componentWillMount(){
    this.setState({userdata: data.users});
  }


  render(){
    console.log(this.state.userdata);
    return(
      <div className="userContainer">

        {
          this.state.userdata.map(function (users, i) {
            return (
              <div className="userCon" key={i}>
                <div className="userImg">
                  <img src={users.picture.large} alt={users.first}/>
                </div>

                <div className="userTxt">
                  <p>{users.first + " " + users.last}</p>
                </div>

                <div className="details">
                  <Link to={`/screens/Details/${i}`}> Details </Link>
                </div>
              </div>
              );
            })
        }
        <Link to={`/screens/Home`}> Back </Link>
      </div>
    );
  }
}
