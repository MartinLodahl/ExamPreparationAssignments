import React, {Component} from 'react';
import CountryTable from "./CountryTable";
import './App.css';

class App extends Component {
  
  constructor(props){
    super(props);

  }

  render() {
    return (
      <div>
        <div className="App-header">
          <h2>React, State, Fetch and Mobx</h2>
        </div>
        <div className="App-intro">        
          <CountryTable/>

        </div>
      </div>
    );
  }
}

export default App;

/*
  1. Describe the term Single Page Application:
  - flydendne user expericence.
  - håndtere data på frontend.
  - ingen reloading.
  - henter sitet som en js-applikation og kører det.
  - mindre båndbredte bruges.

  2. Explain passing props the right way.
  - props sendes med et klik event. og kan så hentes på this.props.whatever.name
  
  3. Explain map/filter method.
  - map og filter er begge en slaks loops ligesom foreach ovs.
  - tager en callback function som producere hvert element i det nye array.
  
  4. Explain Observer pattern.
  - når state changes, passing props og kalder funktioner.
*/