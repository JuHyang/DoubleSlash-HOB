var express = require('express');
var router = express.Router();

var User = require('../DB/user');
var Hob = require('../DB/hob');
var HobType = require('../DB/hobType');
var Update = require('../module/update'); // DB 삽입 모듈

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('master');
});

router.post('/updateHob', (req, res, next) => { 
    /*
     * 디버깅 용도 -> 강의 저장
     */
    let title = req.param('title');
    let link = req.param('link');
    let desc = req.param('desc');
    let desc_detail = req.param('desc_detail');
    let type = new Object();
    ( async() => {
      let result = await Update.Hob(title, link, desc, desc_detail, type);
      if (result != 1) return res.status(500).json({ error: "err" });
      res.json({ result: 1 });
    })();
    console.log('Debugging');
});

router.post('/updateHobType', (req, res, next) => { 
    /*
     * 디버깅 용도 -> 강의타입 저장
     */
    let title = req.param('title');
    let desc = req.param('desc');
    ( async() => {
      let result = await Update.HobType(title, desc);
      if (result != 1) return res.status(500).json({ error: "err" });
      res.json({ result: 1 });
    })();
    console.log('Debugging');
});
  
module.exports = router;
