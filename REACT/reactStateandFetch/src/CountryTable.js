import React, { Component } from "react";

class CountryTable extends Component {
  constructor(props){
    super(props);
    this.state = {labels:[], countries:[], newCountries: []};
    this.getMultiColumn = this.getMultiColumn.bind(this);
  }

  componentWillMount(){ 
    this.props.factory.getLabels((data) => {    
      this.setState({ labels: data});
    },)

    this.props.factory.getCountries((data)=>{
      this.setState({countries:data});
    })
  }

  checkIfCountriesUpdated=() =>{
    var oldCountries =this.state.countries;
    this.props.factory.getCountries((data)=>{
     this.setState({newCountries:data});
  });
  var newCountries = this.state.newCountries;
  var objectsAreSame = true;
  for(var propertyName in newCountries) {
    if(newCountries[propertyName] !== oldCountries[propertyName]) {
       objectsAreSame = false;
       break;
    }
 }
 if(!objectsAreSame){
   this.setState({countries:newCountries});
 }
}

   getMultiColumn(data) {
    var columnName = "";
    if(data.length > 1){
      columnName = '+ ' + (data.length-1) + 'more';
    }else{
      columnName = '';
    }
    return columnName;
  }

  render() {
    var update = setInterval(this.checkIfCountriesUpdated, 10000);
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
            
            
            this.state.countries.map(function (names, i) {
              
             var currencies = this.getMultiColumn(names.currencies);
             var topLevelDomain = this.getMultiColumn(names.topLevelDomain);
             var timezone = this.getMultiColumn(names.timezones);
             var borders = this.getMultiColumn(names.borders);
             var languages = this.getMultiColumn(names.languages); 

              return (
                <tr key={i}>
                <td>{names.name}</td>
                <td>{names.capital}</td>
                <td>{names.region}</td>
                <td>{names.population}</td>
                <td>{names.area}</td>
                <td>{names.timezones[0] + " " + timezone}</td>
                <td>{names.borders[0] + " " + borders }</td>
                <td>{names.topLevelDomain[0] + " " + topLevelDomain}</td>
                <td>{names.currencies[0] + " " + currencies}</td>
                <td>{names.languages[0] + " " + languages}</td>
              </tr>
            );
          
        }, this)}
        </tbody>
      </table>
    );
  }
}
export default CountryTable;