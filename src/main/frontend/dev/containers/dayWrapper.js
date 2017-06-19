import React from 'react';
import Day from '../components/day.js';
import EmptyDay from '../components/emptyDay.js';
import ActivitiesWrapper from './activitiesWrapper.js';
import {config} from '../config';
import axios from 'axios';

export default class DayWrapper extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      data: null
    };
  }

  componentDidMount() {
    if (this.props.location.pathname === '/' || this.props.params.dayNumber === '1') {
      this.getData(0);
    }
  }

  componentDidUpdate(prevProps) {
    if (prevProps.location.pathname !== this.props.location.pathname) {
      if (this.props.location.pathname === '/') {
        this.getData(0);
      } else if (this.props.params.dayNumber === '1') {
        this.getData(this.props.params.dayNumber);
      }
    }
  }

  setBgImage() {
    this.props.setBgImage(this.state.data.image);
  }

  getData(dayNumber) {
    let day = Number(dayNumber) + 1;
    axios.get(config.API_URL + '/days/' + day)
      .then(response => {
        this.setState({
          data: response.data
        }, () => this.setBgImage());
    }).catch(function (error) {
      console.log('error axios-get1: ' + error);
    });
  }

  render() {
    let pageType = this.props.location.pathname === '/' ? 'home' : 'day';
    let showDay = typeof this.props.params.dayNumber === 'undefined' || this.props.params.dayNumber === '1';
    let content;
    if (showDay && this.state.data !== null) {
      const dayNumber = this.props.location.pathname === '/' ? 0 : this.props.params.dayNumber;
      const activities = <ActivitiesWrapper day={dayNumber} />;
      content =
      <Day
        pageType={pageType}
        contentStyle={this.props.contentStyle}
        data={this.state.data}
        imgName={this.state.data.image}
        setBgImage={this.props.setBgImage}
        activities={activities}
      />;
    } else {
      content =
        <EmptyDay />;
    }
    return(
      <div>
        {content}
      </div>
    );
  }
}
