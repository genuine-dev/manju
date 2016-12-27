var webpack = require('webpack');
var path = require('path');

module.exports = {
  entry: './src/main/js/index.js',
  output: {
    path: path.join(__dirname, '/build/resources/main/static/js'),
    filename: 'bundle.js',
    publicPath: '/js'
  },
  devtool: 'source-map',
  plugins: [
    new webpack.HotModuleReplacementPlugin(),
    new webpack.DefinePlugin({
      'process.env.NODE_ENV': '"production"',
      DEVELOPMENT: true,
      DEBUG: true,
    }),
    /*
    new webpack.optimize.UglifyJsPlugin({
      compress: {
        warnings: false
      }
    })
    */
  ],
  module: {
    loaders: [{
      test: /\.jsx?$/,
      loader: 'babel',
      query: {
        presets: ['react', 'es2015']
      },
      exclude: /node_modules/,
      include: __dirname
    }]
  },
  devServer: {
    contentBase: './build/resources/main/static',
    port: 3000,
    hot: true,
    inline: true,
    historyApiFallback: true,
    proxy: {
      '/login': {
        target: 'http://localhost:8080'
      },
      '/api/*': {
        target: 'http://localhost:8080'
      },
    }
  }
};
