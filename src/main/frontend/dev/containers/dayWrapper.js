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
    if (typeof this.props.params.dayNumber === 'undefined' || this.props.params.dayNumber === '1') {
      this.getData();
    }
  }

  componentDidUpdate(nextProps) {
    if (nextProps.params.dayNumber !== this.props.params.dayNumber) {
      if (typeof nextProps.params.dayNumber === 'undefined' || nextProps.params.dayNumber === '1') {
        this.getData();
      }
    }
  }

  setBgImage() {
    this.props.setBgImage(this.state.data.image);
  }

  getData() {
    let day = '1';
    if (typeof this.props.params.dayNumber !== 'undefined') {
      day = Number(this.props.params.dayNumber) + 1;
    }
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
