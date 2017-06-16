/* global BASENAME */
import React from 'react';
import { Router, Route, IndexRoute, browserHistory } from 'react-router';
import { useBasename } from 'history';
import App from './containers/app.js';
import DayWrapper from './containers/dayWrapper.js';

export default class Routes extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return(
      <Router history={useBasename(() => browserHistory)({ basename: BASENAME })}>
        <Route path="/" component={App}>
          <IndexRoute component={DayWrapper} />
          <Route path="day/:dayNumber" component={DayWrapper} />
        </Route>
      </Router>
    );
  }
}
