import React from 'react';
import Day from '../components/day.js';
import EmptyDay from '../components/emptyDay.js';
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
    axios.get('http://localhost:8080/api/days/' + day)
      .then(response => {
        this.setState({
          data: response.data
        }, () => this.setBgImage());
    }).catch(function (error) {
      console.log('error axios-get1: ' + error);
    });
  }

  render() {
    let showDay = typeof this.props.params.dayNumber === 'undefined' || this.props.params.dayNumber === '1';
    let content;
    if (showDay && this.state.data !== null) {
      content =
      <Day
        contentStyle={this.props.contentStyle}
        data={this.state.data}
        imgName={this.state.data.image}
        setBgImage={this.props.setBgImage}
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
