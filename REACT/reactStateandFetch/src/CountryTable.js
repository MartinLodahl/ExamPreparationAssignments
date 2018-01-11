import React, { Component } from "react";

class CountryTable extends Component {
  constructor(){
    super();
    this.state = {lable:[], countries:[] }
  }

  componentWillMount(){
    this._getHeadlines();
    this._getData();
  }

  _getHeadlines = () => {
    const url = `http://localhost:3333/labels`;
      fetch(url)
        .then((res) => {
          return res.json();
        })
        .then((json) => {
          this.setState({ lable: json });
        })
        .catch((res) => {
          alert('error');
        })
  }

  _getData = () =>{
    const url = `http://localhost:3333/countries`;
      fetch(url)
        .then((res) => {
          return res.json();
        })
        .then((json) => {
          this.setState({ countries: json });
        })
        .catch((res) => {
          alert('error');
        })
  }

  render() {

    

    return (
      <table className="table">
        <thead>
          <tr>
            {
              this.state.lable.map(function (lables) {
                return (
                  <th key={lables}>{lables}</th>
                );
              })
            }
          </tr>
        </thead>
        
        <tbody>
          {
            this.state.countries.map(function (names, i) {
              var timezone = '';
              if(names.timezones.length > 1){
                timezone = '+ ' + names.timezones.length + 'more';
              }else{
                timezone = '';
              }
              var borders = '';
              if(names.borders.length > 1){
                borders = '+ ' + names.borders.length + 'more';
              }else{
                borders = '';
              }

              return (
                <tr key={i}>
                  <td>{names.name}</td>
                  <td>{names.capital}</td>
                  <td>{names.region}</td>
                  <td>{names.population}</td>
                  <td>{names.area}</td>
                  <td>{names.timezones[0] + " " + timezone}</td>
                  <td>{names.borders[0] + " " + borders + ' more'}</td>
                  <td>{names.topLevelDomain}</td>
                  <td>{names.currencies}</td>
                  <td>{names.languages[0]}</td>
                </tr>
              );
            })
          }
        </tbody>
      </table>
    );
  }
}
export default CountryTable;