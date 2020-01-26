var express = require('express');
var router = express.Router();

var User = require('../DB/user');

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('users');
});

router.get('/look', (req, res, next) => { 
  /*
   * 디버깅 용도
   */

  User.find(function(err, data){
    if(err) return res.status(500).json({ error: err });
    res.json(data);
  });
  console.log('Debugging');
});

router.post('/signup', function(req, res, next) { // 디버깅 용
  let user = new User();
  user.name = req.param("name"); 
  user.sex = req.param("sex"); 
  user.age = req.param("age");
  user.mail = req.param("mail"); 
  user.desc = req.param("desc"); 
  /*
   * 추후에 보안 이슈 
   */
 
  user.save(function (err) {
    if (err) {
      console.error(err);
      res.json({ result: 0 });
      return;
    }

    res.json({ result: 1 });
  });
});

router.post('/login', function(req, res, next) {
  let id = req.params('id');
  let pw = req.params('pw');
  
  User.findOne({ id: id, pw: pw }, function (err, user) {
    if (err) return res.status(500).json({ error: err });
    if (!user) return res.status(404).json({ error: "User not found" });
    res.json(user); // 정보 반환
  });
  console.log('sign in user');
});

module.exports = router;
