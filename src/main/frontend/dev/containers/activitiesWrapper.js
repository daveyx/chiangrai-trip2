import React from 'react';
import Activity from '../components/activity.js';
import axios from 'axios';

export default class ActivitiesWrapper extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
    };
  }

  render() {
    return(
      <div>activities for day {this.props.day}</div>
    );
  }
}
