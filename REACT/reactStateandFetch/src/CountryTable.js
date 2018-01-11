import React, { Component } from "react";

class CountryTable extends Component {
  constructor(props){
    super(props);
    this.state = {labels:[], countries:[]};
  }//this.props.lable

  componentWillMount(){ 
    this.props.factory.getLabels((data) => {    
      this.setState({ labels: data});
    },)

    this.props.factory.getCountries((data)=>{
      this.setState({countries:data});
    })
  }
  
 /*
  _getMultiColumn (data){
    var columnName = "";
    if(data.length > 1){
      columnName = '+ ' + (data.length-1) + 'more';
    }else{
      columnName = '';
    }
    console.log(columnName);
    return columnName;
  }
*/
  render() {

    return (
      <table className="table">
        <thead>
          <tr>
            {
              this.state.labels.map(function (labels) {
                return (
                  <th key={labels}>{labels}</th>
                );
              })
            }
          </tr>
        </thead>
        
        <tbody>
          {
            //getMultiColumn([1,2,3,4,5]);
            
            this.state.countries.map(function (names, i) {
             // var currencies = this.getMultiColumn(names.currencies);
              var timezone ="";
              
              if(names.timezones.length > 1){
                timezone = '+ ' + (names.timezones.length-1) + 'more';
              }else{
                timezone = '';
              }
              var borders = '';
              if(names.borders.length > 1){
                borders = '+ ' + (names.borders.length-1) + 'more';
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
                <td>{names.borders[0] + " " + borders }</td>
                <td>{names.topLevelDomain}</td>
                <td>{names.currencies}</td>
                <td>{names.languages[0]}</td>
              </tr>
            );
          
        })}
        </tbody>
      </table>
    );
  }
}
export default CountryTable;