var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

////////ROUTERS////////////////////////////////
var indexRouter = require('./routes/index'); // 인덱스
var usersRouter = require('./routes/users'); // 유저관련
var hobRouter = require('./routes/hob'); // 현재 수강 정보 제공
var classRouter = require('./routes/class'); // 수강 관련
var masterRouter = require('./routes/master'); // 마스터 라우터 정보 입력 및 수정 용
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
app.use('/', indexRouter); // 인덱스
app.use('/users', usersRouter); // 유저 관련
app.use('/hob', hobRouter); // 현재 수강 정보 제공
app.use('/class', classRouter); // 수강 관련 
app.use('/master', masterRouter); // 마스터 라우터 정보 입력 및 수정 용
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
