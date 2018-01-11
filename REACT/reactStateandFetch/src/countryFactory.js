class CountryFactory {
 
 constructor(){
  
  this.state = {lable:[], countries:[]}
}
//Kunne ikke få this.setState(sdas:sad) til at virke, når jeg kaldte countryFactory fra andre klasser

getLabels = (cb) =>{
 const url = `http://localhost:3333/labels`;
  fetch(url)
      .then((res) => {
          return res.json();
      }).then((data) => {
          if (cb) {
              cb(data)
          }
      })
}

getCountries = (cb) =>{
  const url = `http://localhost:3333/countries`;
  fetch(url)
  .then((res) => {
      return res.json();
  }).then((data) => {
      if (cb) {
          cb(data)
      }
  })
} 
}

export default new CountryFactory();