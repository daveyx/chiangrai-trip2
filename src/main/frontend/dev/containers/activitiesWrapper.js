import React from 'react';
import Activity from '../components/activity.js';
import axios from 'axios';

export default class ActivitiesWrapper extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      data: null
    };
  }

  componentDidMount() {
    this.getData();
  }

  componentDidUpdate(prevProps) {
    if(prevProps.day !== this.props.day) {
      this.getData();
    }
  }

  getData() {
    axios.get('http://localhost:8080/api/days/' + (Number(this.props.day) + 1) + '/activities')
      .then(response => {
        this.setState({
          data: response.data
        });
    }).catch(function (error) {
      console.log('error axios-get activities: ' + error);
    });
  }

  render() {
    console.log(this.state.data)
    return(
      <div>
        activities for day {this.props.day}
        <Activity />
      </div>
    );
  }
}
