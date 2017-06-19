import React, { Component } from 'react';
import {Grid, Row, Col} from 'react-bootstrap';
import '../css/day.css';
import '../css/home.css';
//import Activity from './activity.jsx';

export default class Day extends Component {
  constructor(props) {
    super(props);
    this.state = {
      h1Style: {
        fontSize: '12px',
        marginTop: '30px'
      }
    };
    this.handleResize = this.handleResize.bind(this);
  }

  componentDidMount() {
    window.addEventListener('resize', this.handleResize);
    this.handleResize();
  }

  componentWillUnmount() {
    window.removeEventListener('resize', this.handleResize, false);
  }

  handleResize(e = null) {
    let h1base = this.props.pageType === 'home' ? 26 : 21;
    let h1marginBase = this.props.pageType === 'home' ? 19 : 16;
    let h1size = Math.round(window.innerWidth / h1base);
    let h1MarginTop = this.props.data.subtitle ? 80 : Math.round(window.innerWidth / h1marginBase) + 10;
    this.setState({
      h1Style: {
        fontSize: h1size + 'px',
        marginTop: h1MarginTop + 'px'
      }
    });
  }

  render() {
    let imageSection = null;
    let parallax = null;
    let subTitle = null;
    if (this.props.data.intro.images.length === 3) {
      imageSection =
        <Row>
          <Col xs={12} sm={6} md={4}>
            <div className="zoom-effect-container">
              <div className="image-card">
                <img src={this.props.data.intro.images[0]} className="img-responsive center-block" />
              </div>
            </div>
          </Col>
          <Col xs={12} sm={6} md={4}>
            <div className="zoom-effect-container">
              <div className="image-card">
                <img src={this.props.data.intro.images[1]} className="img-responsive center-block" />
              </div>
            </div>
          </Col>
          <Col xs={12} sm={6} smOffset={3} md={4} mdOffset={0}>
            <div className="zoom-effect-container">
              <div className="image-card">
                <img src={this.props.data.intro.images[2]} className="img-responsive center-block" />
              </div>
            </div>
          </Col>
        </Row>;
    }

    if (this.props.data.intro.image) {
      parallax =
        <Grid className="bgimg-1" fluid>
          <div className="caption">
            <h2 className="border">{this.props.data.intro.imageText}</h2>
          </div>
        </Grid>;
    }

    if (this.props.data.subtitle) {
      subTitle = <div id="author" className="text-center">by <a href="https://www.daveyx.ga" title="daveyx" target="_blank">daveyx</a></div>;
    }

    return (
        <main ref="content">
          <Grid fluid ref="day" className={this.props.pageType} style={this.props.contentStyle}>
            <Row>
              <Col xs={12}>
                  <h1 className="text-center" style={this.state.h1Style}>
                    {this.props.data.title}
                  </h1>
                  {subTitle}
             </Col>
           </Row>
          </Grid>
          <Grid>
            <Row>
              <Col xs={12}>
                <h2 className="text-center">{this.props.data.intro.title}</h2>
              </Col>
              <Col xs={12}>
                {this.props.data.intro.texts.map(function(data, index){
                  return <p key={index}>{data}</p>;
                })}
              </Col>
            </Row>
            {imageSection}
          </Grid>
          {parallax}
          {this.props.activities}
          <Grid>
            <Row>
              <Col xs={12}>
                <p><br />Stay tuned... The documentation of our trip continues soon...</p>
              </Col>
            </Row>
          </Grid>
        </main>
    );
  }
}
