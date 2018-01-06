import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import RoutingDemo from './example.js';
import RouterX from './components/routerX';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<RouterX />, document.getElementById('root'));
registerServiceWorker();
