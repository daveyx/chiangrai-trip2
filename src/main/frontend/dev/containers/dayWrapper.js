import React from 'react';
import Day from '../components/day.js';
import axios from 'axios';

export default class DayWrapper extends React.Component {
  constructor(props) {
    super();
    this.state = {
      data: null
    };
  }

  componentDidMount() {
    console.log("didmount", this.props.params.dayNumber)
    if (typeof this.props.params.dayNumber === 'undefined' || this.props.params.dayNumber === '1') {
      let data = this.getData();
      this.setState({
        data: data
      }, function() {this.setBgImage()});
    }
  }

  componentDidUpdate(nextProps) {
    if (nextProps.params.dayNumber !== this.props.params.dayNumber) {
      if (typeof nextProps.params.dayNumber === 'undefined' || nextProps.params.dayNumber === '1') {
        let data = this.getData();
        this.setState({
          data: data
        }, function() {this.setBgImage()});
      }
    }
  }

  setBgImage() {
    this.props.setBgImage(this.state.data.imgName);
  }

  getData() {
    axios.get("http://localhost:8080/api/days/1")
      .then(response => {
        console.log(response)
//        this.setState({
//          gallery: response.data.data
//        });
    }).catch(function (error) {
      console.log("error axios-get1: " + error);
    }); 
  }

  render() {
    let pathname = "day" + this.props.params.dayNumber;
    return(
          <div>
          </div>
        );
  }
}
//<Day
//pathname={pathname}
//contentStyle={this.props.contentStyle}
//data={this.state.data.data}
//imgName={this.state.data.imgName}
//setBgImage={this.props.setBgImage}
///>