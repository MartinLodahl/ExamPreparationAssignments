
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { Switch, Route, Link, BrowserRouter } from 'react-router-dom'
import {  } from 'react-router-dom';
import image1 from '../logo.svg';
import css from '../index.css';


export default class RouterX extends Component{
    render(){
        return(
            <BrowserRouter>
            <div>
                <App />    
                
            </div>
            </BrowserRouter>
        );
    }
}

class App extends Component{
    render(){
        return(
            <div>
            <Header/>
            <Main/>
            </div>
        );
    }
}
class Header extends Component{
    render(){
        return(
            <div id="header">
            <nav>
                <ul>
                <li><Link to='/articles'>articles</Link></li>                
                <li><Link to='/images'>Images</Link></li>
                <li><Link to='/about us'>About us</Link></li>
                </ul>
            </nav>
        </div>
        );
    }
}
class Main extends Component{
    render(){
        return(
            <div id="main">
            <Switch>
            <Route path='/articles' component={Article}/>            
            <Route exact path='/images' component={Images}/>
            <Route path='/about us' component={About}/>
            </Switch>
        </div>
        );
    }
}

const articles = [
    {number: '101', title: 'Den Halve Sko', writer: 'Van Gogh'}
    ,{number: '102', title: 'Kødbenet', writer: 'Hunden'}
    ,{number: '103', title: 'Den halve kvinde', writer: 'Peter Madsen'}
    ,{number: '104', title: 'Den forsvundne familie', writer: 'Peter Lundin'}
    ,{number: '105', title: 'DA BOOTY', writer: 'BootyLicious'}
];

const Article = () => (
    <Switch>
    <div>
    <div style={{"width" : "50%"}} id="list" class="flexItem">
    <Route exact path='/articles' component={ArticleList}/>
    </div>
    <div style={{"width" : "50%"}} id="details" class="flexItem">
    <Route path='/articles/:number' component={ArticlesDetails}/> 
    </div>
    </div>
    </Switch>
);
const ArticleList = () => (
    <div style={{"width" : "50%"}} id="list" class="flexItem">
        <h2>Our articles: </h2>
        <ul>
            
            <table >
            <thead>
            <tr>
              <th>title</th>
              <th>writer</th> 
              <th>id</th>
            </tr>
            </thead>
            <tbody>
                {articles.map(p => (   
            <tr>
            <td>
                    <li key={p.number}>
                        <Link to={`/articles/${p.number}`}>{p.title}</Link>
                    </li>
                </td>
                <td>{p.writer}</td> 
                <td>{p.number}</td>
                </tr>
                ))                
            }
            </tbody>
            </table>
        </ul>
    </div> 
);

const ArticlesDetails = (props) => {
    const productsFiltered = articles.filter((p)=>p.number === props.match.params.number, 10);
    const article = (productsFiltered.length > 0)?productsFiltered[0]:null;
    if (!article) {
        return <div>Sorry, but the article {props.match.params.number} was not found</div>
    }else {
    return (
        <div class = "flex-container">
        <div style={{"width" : "50%"}} id="list" class="flexItem">
        <h2>Our articles: </h2>
        <ul>
            
            <table >
            <thead>
            <tr>
              <th>title</th>
              <th>writer</th> 
              <th>id</th>
            </tr>
            </thead>
            <tbody>
                {articles.map(p => (   
            <tr>
            <td>
                    <li key={p.number}>
                        <Link to={`/articles/${p.number}`}>{p.title}</Link>
                    </li>
                </td>
                <td>{p.writer}</td> 
                <td>{p.number}</td>
                </tr>
                ))                
            }
            </tbody>
            </table>
        </ul>
    </div> 
        <div>
            <h2>Articles details:</h2>
            <h3>{article.title} (#{article.number})</h3>
            <h3>Writer: {article.writer}</h3>

            <img src={image1}/>
        </div>
        </div>
    );
    }
}
const About = () => (
    <div>
        <h2>We're Interesting NewS Inc.</h2>
        <p>We're having a long story, from the 1400s to 2500s,<br/> in bringing the best news right away, before our competetors</p>
        <form>
        <label>
          Name:
          <input type="text" name="name" />
        </label>
        <br/> 
        Your message por Yo:
        <br/> 
        <textarea name="" id="" cols="30" rows="10"></textarea>
      </form>
    </div>
);
const Images = () => (
    <div class="flex-container">
    <img src={image1} />
    <img src={image1} />
    <img src={image1} />
    </div>
);

