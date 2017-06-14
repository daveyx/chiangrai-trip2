import React from 'react';
import '../css/app.css';
import Header from '../components/header.js';

export default class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      contentStyle: {},
      imgName: '',
      wrapperStyle: {}
    }
    this.handleResize = this.handleResize.bind(this);
    this.setBgImage = this.setBgImage.bind(this);
  }

  componentDidMount() {
    window.addEventListener('resize', this.handleResize);
  }

  setBgImage(val) {
    this.setState({
      imgName: val
    }, () => this.handleResize());
  }

  handleResize(e = null) {
    if (window.innerWidth >= 992) {
      var minHeight = Math.round(window.innerWidth / 3.5) + 10;
      if (this.state.imgName) {
        this.setState({
          wrapperStyle: {
            backgroundImage: "url(" + this.state.imgName + ")",
            backgroundSize: 'contain',
            backgroundRepeat: 'no-repeat'
          },
          contentStyle: {
            backgroundImage: 'none',
            minHeight: minHeight + 'px'
          }
        });
      } else {
        this.setState({
          wrapperStyle: {
          },
          contentStyle: {
            backgroundImage: 'none',
            minHeight: minHeight + 'px',
            backgroundColor: 'grey'
          }
        });
      }
    } else {
      var minHeight = Math.round(window.innerWidth / 3) + 10;
      if (this.state.imgName) {
        this.setState({
          wrapperStyle: {
            backgroundImage: 'none'
          },
          contentStyle: {
            backgroundImage: "url(" + this.state.imgName + ")",
            backgroundSize: 'contain',
            backgroundRepeat: 'no-repeat',
            minHeight: minHeight + 'px'
          }
        });
      } else {
        this.setState({
          wrapperStyle: {
            backgroundImage: 'none'
          },
          contentStyle: {
            backgroundColor: 'grey',
            minHeight: minHeight + 'px'
          }
        });
      }
    }
  }

  render() {
    const childrenWithProps = React.Children.map(this.props.children,
      (child) => React.cloneElement(child, {
        contentStyle: this.state.contentStyle,
        setBgImage: this.setBgImage
      })
    );
    return  <div>
              <div id="wrapper" style={this.state.wrapperStyle}>
                <Header />
                { childrenWithProps }
              </div>
            </div>;
  }
}
