import React from 'react';
import Activity from '../components/activity.js';
import {config} from '../config';
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
    axios.get(config.API_URL + '/days/' + (Number(this.props.day) + 1) + '/activities')
      .then(response => {
        this.setState({
          data: response.data
        });
    }).catch(function (error) {
      console.log('error axios-get activities: ' + error);
    });
  }

  render() {
    const activities = ! this.state.data ? null :
      <div>
        {
          this.state.data._embedded.activities.map((a, i) => {
            return <Activity key={i} activity={a} />;
          })
        }
      </div>;
    return(
      <div>{activities}</div>
    );
  }
}
