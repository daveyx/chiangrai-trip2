
'use strict';

import React, { Component } from 'react';
import {Grid, Row, Col} from 'react-bootstrap';
import GMap from './googleMaps';
import Gallery from './gallery.js';
import '../css/activity.css';
import '../css/gmap.css';

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
    let bgColor = 'bg-white';
    if ((activityId + 1) % 2 > 0) {
      pullPushMd = 6;
      pullPushXs = 12;
      bgColor = 'bg-light-grey';
    }

    let settings = {
      initialCenter: {
        lat: Number(this.props.activity.gmap.lat),
        lng: Number(this.props.activity.gmap.lng)
      },
      initialZoom: Number(this.props.activity.gmap.zoom),
      markers: [
        {
          position: {
            lat: Number(this.props.activity.gmap.lat),
            lng: Number(this.props.activity.gmap.lng)
          }
        }
      ],
      snapToUserLocation: false
    };

    const gMap = this.props.activity.gmap.lng > 0 && this.props.activity.gmap.lat > 0 ?
        <Col xs={12} md={6} mdPush={pullPushMd} className="maps-col">
            <h3>{this.props.activity.gmap.title}</h3>
            <GMap config={settings} id={this.props.activity.id} />
        </Col> :
        <Col xs={12} md={6} mdPush={pullPushMd}>
          <p>Google Maps not available</p>
        </Col>;

    let content = ! this.props.activity ? null :
      <Row className="is-table-row">
        {gMap}
        <Col xs={12} md={6} mdPull={pullPushMd}>
          <h3>{this.props.activity.subtitle}</h3>
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
            <h2>{this.props.activity.gallery.title}</h2>
            <p>(click on the bottom right for full screen mode)<br />(click the 'play' button on the bottom left for a image show)</p>
            <Gallery images={this.props.activity.gallery.galleryImages} />
          </Col>
        </Row>
        </Grid>
      </div>
    );
  }
}
