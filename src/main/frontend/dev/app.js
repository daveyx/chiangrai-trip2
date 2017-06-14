
import React from 'react';
import Main from './main.js'
import { IndexLink, Link } from 'react-router';

export default class App extends React.Component {
  
  render() {
    return (
      <div>
        <IndexLink to="/">Home Index Link</IndexLink>
        <br />
        <Link to="/">Home Link</Link>
        <br />
        <IndexLink to="/test">test Index Link</IndexLink>
        <br />
        <Link to="/test">test Link</Link>
        <br />
        <Main />
      </div>
    )
  }
}