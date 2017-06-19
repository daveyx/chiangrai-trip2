import ImageGallery from 'react-image-gallery';
import React from 'react';
import '../css/gallery.css';

export default class Gallery extends React.Component {
  constructor(props) {
    super(props);
  }

  handleImageLoad(event) {
  }

  render() {
    return (
      <ImageGallery
        items={this.props.images}
        slideInterval={2000}
        showIndex={true}
        infinite={false}
        lazyLoad={true}
        onImageLoad={this.handleImageLoad} />
    );
  }
}
