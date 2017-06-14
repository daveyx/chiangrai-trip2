import React from 'react';
import ReactDOM from 'react-dom';
import { IndexLink } from 'react-router';
import {
  Navbar,
  Nav,
  NavItem,
  Modal,
  Button
} from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';
import '../css/header.css';

export default class Header extends React.Component {
  constructor(props) {
    super();
  }

  render() {
    return  <div>
              <Menu />
            </div>;
  }
}

class Menu extends React.Component {
  constructor(props) {
    super();
    this.state = {
      navHeight: 50,
      showModal: false,
      modalInfo: ''
    };
    this.handleResize1 = this.handleResize1.bind(this);
  }

  handleResize1(e = null) {
    if (this.refs.navbar) {
      this.setState({ navHeight: ReactDOM.findDOMNode(this._navbar).offsetHeight });
    }
  }

  componentDidMount() {
    window.addEventListener('resize', this.handleResize1);
    this.handleResize1();
  }

  close() {
    this.setState({
      showModal: false,
      modalInfo: ""
    });
  }

  openEN() {
    this.setState({
      showModal: true,
      modalInfo: "The english language is displayed already."
    });
  }

  openTH() {
    this.setState({
      showModal: true,
      modalInfo: "The thai language is currently not available."
    });
  }

  openDE() {
    this.setState({
      showModal: true,
      modalInfo: "The german language is currently not available."
    });
  }

  render() {
    return  <div className="App" style={{paddingTop: this.state.navHeight}}>
              <Modal show={this.state.showModal} onHide={this.close.bind(this)}>
                <Modal.Header closeButton>
                  <Modal.Title>Sorry!</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                  <h4>{this.state.modalInfo}</h4>
                  <p>If you want to provide a translation, contact me please!</p>
                </Modal.Body>
                <Modal.Footer>
                  <Button onClick={this.close.bind(this)}>Close</Button>
                </Modal.Footer>
              </Modal>
              <Navbar ref="navbar" fluid collapseOnSelect ref={(e) => this._navbar = e} fixedTop >
                <Navbar.Header>
                  <Navbar.Brand>
                    <IndexLink to="/">Home</IndexLink>
                  </Navbar.Brand>
                  <Navbar.Toggle />
                </Navbar.Header>
                <Navbar.Collapse>
                  <Nav pullRight>
                    <LinkContainer to="/day/1">
                      <NavItem>Day 1</NavItem>
                    </LinkContainer>
                    <LinkContainer to="/day/2">
                      <NavItem>Day 2</NavItem>
                    </LinkContainer>
                    <LinkContainer to="/day/3">
                      <NavItem>Day 3</NavItem>
                    </LinkContainer>
                    <LinkContainer to="/day/4">
                      <NavItem>Day 4</NavItem>
                    </LinkContainer>
                    <LinkContainer to="/day/5">
                      <NavItem>Day 5</NavItem>
                    </LinkContainer>
                    <LinkContainer to="/day/6">
                      <NavItem>Day 6</NavItem>
                    </LinkContainer>
                    <LinkContainer to="/day/7">
                      <NavItem>Day 7</NavItem>
                    </LinkContainer>
                    <LinkContainer to="/contact">
                      <NavItem>Contact</NavItem>
                    </LinkContainer>
                    <NavItem eventKey={'EN'} onClick={this.openEN.bind(this)}>EN</NavItem>
                    <NavItem eventKey={'TH'} onClick={this.openTH.bind(this)}>TH</NavItem>
                    <NavItem eventKey={'DE'} onClick={this.openDE.bind(this)}>DE</NavItem>
                  </Nav>
                </Navbar.Collapse>
              </Navbar>
            </div>;
  }
}