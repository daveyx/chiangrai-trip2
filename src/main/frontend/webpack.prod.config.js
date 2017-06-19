var webpack = require('webpack');
var path = require('path');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var HtmlWebpackPlugin = require('html-webpack-plugin');

var BUILD_DIR = path.resolve(__dirname, '../resources/static/built');

module.exports = {
  entry: './dev/index.js',
  output: {
    path: BUILD_DIR,
    filename: 'bundle.[hash].js',
    publicPath: '/chiangrai-trip'
  },
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
  },
  plugins: [
    new webpack.optimize.OccurrenceOrderPlugin(),
    new ExtractTextPlugin('css/styles.css'),
    new webpack.DefinePlugin({
      BASENAME: JSON.stringify('/chiangrai-trip/'),
    }),
    new webpack.DefinePlugin({ // <-- key to reducing React's size
      'process.env': {
        'NODE_ENV': JSON.stringify('production')
      }
    }),
    new webpack.optimize.UglifyJsPlugin(), //minify everything
    new webpack.optimize.AggressiveMergingPlugin(), //Merge chunks
    new HtmlWebpackPlugin({
        template: 'dev/index.html'
    })
  ]
};
