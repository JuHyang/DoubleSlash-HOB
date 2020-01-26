var express = require('express');
var router = express.Router();

var User = require('../DB/user');
var Hob = require('../DB/hob');

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('class');
});

module.exports = router;
