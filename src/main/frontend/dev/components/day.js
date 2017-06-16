import React, { Component } from 'react';
import {Grid, Row, Col} from 'react-bootstrap';
import '../css/day.css';
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
    let h1size = Math.round(window.innerWidth / 21);
    let h1MarginTop = Math.round(window.innerWidth / 16) + 10;
    this.setState({
      h1Style: {
        fontSize: h1size + 'px',
        marginTop: h1MarginTop + 'px'
      }
    });
  }

  render() {
//    var activityList = this.props.data.activities.map(function(activity, index){
//      return <Activity key={index} data={activity} />;
//    });
    return (
        <main ref="content">
          <Grid fluid ref="day" className="day" style={this.props.contentStyle}>
            <Row>
              <Col xs={12}>
                  <h1 className="text-center" style={this.state.h1Style}>
                    {this.props.data.title}
                  </h1>
             </Col>
           </Row>
          </Grid>
          <div>
            <Grid>
              <Row>
                <Col xs={12}>
                  <h2 className="text-center">{this.props.data.introHeader2}</h2>
                 </Col>
                <Col xs={12}>
                  {this.props.data.intro.texts.map(function(data, index){
                    return <p key={index}>{data}</p>;
                  })}
                </Col>
              </Row>
            </Grid>




            <Grid>
              <Row>
                <Col xs={12}>
                  <p><br />Stay tuned... The documentation of our trip continues soon...</p>
                </Col>
              </Row>
            </Grid>
          </div>
        </main>
    );
  }
}
//            {activityList}
