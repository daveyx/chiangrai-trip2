var webpack = require('webpack');
var path = require('path');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  entry: './dev/index.js',
  devtool: 'inline-source-map',
  cache: true,
  output: {
    path: __dirname + '/../resources/static/built',
    filename: 'bundle.js',
    publicPath: '/'
  },
  plugins: [
    new webpack.LoaderOptionsPlugin({
      debug: true
    }),
    new ExtractTextPlugin('css/styles.css'),
    new webpack.DefinePlugin({
      BASENAME: JSON.stringify('/')
    })
  ],
  module: {
    loaders: [
      {
        test : /\.js?/,
        exclude: /(node_modules|bower_components)/,
        loader : 'babel-loader'
      },
      {
        test: /\.css/,
        loader: ExtractTextPlugin.extract('css-loader')
      }
    ]
  }
};
