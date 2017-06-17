import React from 'react';

export default class Activity extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return(
      <div>
        fille<br />
        {this.props.val.title}
      </div>
    );
  }
}
