var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

////////ROUTERS////////////////////////////////
var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');
var hobRouter = require('./routes/hob');
var classsRouter = require('./routes/class');
//////////////////////////////////////////////

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

///////////////////CONNECT MONGOOSE////////
var mongoose = require('./mongoose/mongoose'); // 몽고 디비 모듈
mongoose.connectMongoose(); // 몽고디비 연결
//////////////////////////////////////////

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));



////////ROUTER CONNECT///////////////////
app.use('/', indexRouter);
app.use('/users', usersRouter);
app.use('/hob', hobRouter);
app.use('/class', classRouter);
////////////////////////////////////////


// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
