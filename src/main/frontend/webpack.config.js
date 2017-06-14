var webpack = require('webpack');
var path = require('path');

module.exports = {
  entry: './dev/index.js',
  devtool: 'sourcemaps',
  cache: true,
  output: {
    path: __dirname,
    filename: '../resources/static/built/bundle.js'
  },
  plugins: [
    new webpack.LoaderOptionsPlugin({
      debug: true
    }),
    new webpack.DefinePlugin({
      BASENAME: JSON.stringify("/")
    })
    ],
  module: {
    loaders: [
      {
        test: path.join(__dirname, '.'),
        exclude: /(node_modules)/,
        loader: 'babel-loader',
        query: {
          cacheDirectory: true,
          presets: ['es2015', 'react']
        }
      }
    ]
  }
};