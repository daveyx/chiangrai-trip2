import React, { Component } from 'react';

export default class EmptyDay extends Component {
  constructor(props) {
    super();
  }

  render() {
    return (
          <h1 className="text-center">
            {this.props.pathname}  will be available soon, please check back later
          </h1>
    );
  }
}