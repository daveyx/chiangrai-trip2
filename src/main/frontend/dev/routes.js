'use strict';

import React from 'react';
import { Router, Route, IndexRoute, browserHistory } from 'react-router';
import { useBasename } from 'history';
import App from './containers/app.js';

export default class Routes extends React.Component {
  constructor(props) {
    super();
  }

  render() {
    return(
      <Router history={useBasename(() => browserHistory)({ basename: BASENAME })}>
        <Route path="/" component={App}>
          <IndexRoute component={App} />
        </Route>
      </Router>
    )
  }
}