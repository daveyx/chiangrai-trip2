var webpack = require('webpack');
var path = require('path');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var HtmlWebpackPlugin = require('html-webpack-plugin');

var BUILD_DIR = path.resolve(__dirname, '../resources/static/built');

module.exports = {
  entry: './dev/index.js',
  devServer: {
    inline: true,
    contentBase: BUILD_DIR,
    port: 3000
  },
  devtool: 'source-map',
  cache: true,
  output: {
    path: BUILD_DIR,
    filename: 'bundle.js',
    publicPath: '/'
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
    new webpack.LoaderOptionsPlugin({
      debug: true
    }),
    new ExtractTextPlugin('css/styles.css'),
    new webpack.DefinePlugin({
      BASENAME: JSON.stringify('/')
    }),
    new HtmlWebpackPlugin({
        template: 'dev/index.html'
    })
  ]
};
