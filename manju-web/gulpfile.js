var gulp = require('gulp');
var webpack = require('webpack-stream');
var webpackConfig = require('./webpack.config.js');
var exec = require('gulp-exec');

gulp.task('build',  function(callback){
  gulp.src('./node_modules/material-design-lite/material.min.css')
    .pipe(gulp.dest('./build/resources/main/static/css/'));
  gulp.src('./node_modules/material-design-lite/material.min.css.map')
    .pipe(gulp.dest('./build/resources/main/static/css/'));
  gulp.src('./node_modules/material-design-lite/material.min.js')
    .pipe(gulp.dest('./build/resources/main/static/js/'));
  gulp.src('./node_modules/material-design-lite/material.min.js.map')
    .pipe(gulp.dest('./build/resources/main/static/js/'));
  webpack(webpackConfig)
    .pipe(gulp.dest('./build/resources/main/static/js/'));
});
