
'use strict';

import React, { Component } from 'react';
import {Grid, Row, Col} from 'react-bootstrap';
import GMap from './googleMaps';
// import Gallery from './gallery.jsx'
import '../css/activity.css';

export default class Activity extends Component {
  constructor(props) {
    super(props);
  }

  shouldComponentUpdate(nextProps) {
    return this.props.activity != nextProps.activity;
  }

  render() {
    const activityId = Number(this.props.activity.id);
    let pullPushMd = 0;
    let pullPushXs = 0;
    let bgColor = 'bg-light-grey';
    if ((activityId + 1) % 2 > 0) {
      pullPushMd = 6;
      pullPushXs = 12;
      bgColor = 'bg-white';
    }

    let content = ! this.props.activity ? null :
      <Row>
        <Col xs={12} md={6} mdPush={pullPushMd}>
          {this.props.data.activity.position.coordinates.lng > 0 && this.props.data.activity.position.coordinates.lat > 0 ?
          <div>
            <h3>{this.props.data.activity.position.header}</h3>
            <div className="map">
              <GMap initialCenter={this.props.data.activity.position.coordinates} zoom={this.props.data.activity.position.zoom} />
            </div>
          </div>
          : <p>Google Maps not available</p>
          }
        </Col>
        <Col xs={12} md={6} mdPull={pullPushMd}>
          <h3>{this.props.activity.activityHeader2}</h3>
          {this.props.activity.texts.map(function(data, index){
            return <p key={index}>{data}</p>;
          })}
          {this.props.activity.activityLinks.map(function(data, index){
            return <p key={index}>
              {data.linkDescLeft}
              <a href={data.link} target="_blank">
                {data.linkText}
              </a>
              {data.linkDescRight}
             </p>;
         })}
        </Col>
      </Row>;

    return (
      <div className={bgColor}>
        <Grid>
        <Row className="activity-row">
          <Col xs={12}>
            <h2>{this.props.activity.title}</h2>
          </Col>
        </Row>
        {content}
        <Row>
          <Col xs={12}>
            gallery
          </Col>
        </Row>
        </Grid>
      </div>
    );
  }
}
