import React from 'react';
import '../App.css';

export default class Images extends React.Component{
  render(){
    var indents = [];
    for (var i = 0; i < 100; i++) {
      indents.push(i);
    }

    let urlW = "https://api.randomuser.me/portraits/women/";
    let urlM = "https://api.randomuser.me/portraits/men/";
    let end = ".jpg";

return (
   <div>
     {
       indents.map((item, i) => (
         <div className="randomImg">
           <img src={urlW+i+end} alt={i}/>
           <img src={urlM+i+end} alt={i}/>
         </div>
     ))
   }
   </div>
);
  }
}
