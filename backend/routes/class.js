var express = require('express');
var router = express.Router();

var User = require('../DB/user');
var Hob = require('../DB/hob');
var Delete = require('../module/delete'); // DB 삭제 모듈
var Update = require('../module/update'); // DB 삽입 모듈
var Search = require('../module/search'); // DB 검색 모듈

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('class');
});


router.post('/register', function(req, res, next) {
    /*
     * 강좌 수강 
     */
    let idx = req.param('idx');
    let classIdx = req.param('classIdx');
    let title = req.param('title');
    ( async() => {
        let result = await Update.UserHob(idx, classIdx, title);
        if (result == 404) return res.status(404).json({ error: "Not found" });
        if (result == 500) return res.status(500).json({ error: "err" });
        //res.json({ result: 1 });
        res.send("register");
    })();
});

router.post('/pickup', function(req, res, next) {
    /*
     * 강좌 찜하기
     */
    let idx = req.param('idx');
    let classIdx = req.param('classIdx');
    let title = req.param('title');
    ( async() => {
        let result = await Update.UserPickHob(idx, classIdx, title);
        if (result == 404) return res.status(404).json({ error: "Not found" });
        if (result == 500) return res.status(500).json({ error: "err" });
        //res.json({ result: 1 });
        res.send("pickup");
    })();
});

router.post('/fin', function(req, res, next) {
    /*
     * 강좌 수강 완료 
     */
    let idx = req.param('idx');
    let classIdx = req.param('classIdx');
    let title = req.param('title');
    ( async() => {
        let resultFin = await Update.UserFinHob(idx, classIdx, title);
        let resultHob = await Delete.UserHob(idx, classIdx);
        if (resultFin == 404 || resultHob == 404) return res.status(404).json({ error: "Not found" });
        if (resultFin == 500 || resultHob == 500) return res.status(500).json({ error: "err" });
        //res.json({ result: 1 });
        res.send("fin");
    })();
});

router.post('/getdetail', function(req, res, next) {
    /*
     * 강좌 상세정보 제공 
     */
    let classIdx = req.param('classIdx');
    ( async() => {
        let result = await Search.HobIdx(classIdx);
        if (result == 404) return res.status(404).json({ error: "Not found" });
        if (result == 500) return res.status(500).json({ error: "err" });
        //res.json(result);
        res.send("getdetail");
    })();
});

router.post('/search', function(req, res, next) {
    /*
     * 강좌 검색(String) 
     */
    let title = req.param('title');
    ( async() => {
        let result = await Search.HobTitle(title);
        if (result == 404) return res.status(404).json({ error: "Not found" });
        if (result == 500) return res.status(500).json({ error: "err" });
        //res.json(result);
        res.send(result.title);
    })();
});

module.exports = router;
