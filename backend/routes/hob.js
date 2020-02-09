var express = require('express');
var router = express.Router();
var Pager = require('../module/pagination'); // 페이지네이션 전용 모듈
var Search = require('../module/search'); // DB 검색 모듈
var Get = require('../module/get'); // DB 검색 모듈
//var User = require('../DB/user');

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('hob');
});

router.post('/all', function(req, res, next) {
    /*
     * 수강중인 HOB 제공 
     */
    let skip = req.param('skip');
    ( async () => {
        let result = await Get.Hob(parseInt(skip));
        if (result == 500) return res.status(500).json({ error: "err" });
        if (result == 404) return res.status(404).json({ error: "Not found" });
        res.json(result);
        console.log("PASSING THE ALL HOBS");
    })();
});

router.post('/classlist', function(req, res, next) {
    /*
     * 수강중인 HOB 제공 
     */
    let idx = req.param('idx');
    let limit = req.param('limit');
    ( async () => {
        let result = await Search.User(idx);
        if (result == 500) return res.status(500).json({ error: "err" });
        if (result == 404) return res.status(404).json({ error: "Not found" });
        let userClass = Pager.Array(result.HOB, limit);
        res.send(userClass);
        console.log("PASSING THE CLASSLIST");
    })();
});

router.post('/picklist', function(req, res, next) {
    /*
     * 찜한 HOB 제공 
     */
    let idx = req.param('idx');
    let limit = req.param('limit');
    ( async () => {
        let result = await Search.User(idx);
        if (result == 500) return res.status(500).json({ error: "err" });
        if (result == 404) return res.status(404).json({ error: "Not found" });
        let userPick = Pager.Array(result.pickHOB, limit);
        res.send(userPick);
        console.log("PASSING THE PICKLIST");
    })();
});

router.post('/finlist', function(req, res, next) {
    /*
     * 수강 완료 한 HOB 제공 
     */
    let idx = req.param('idx');
    let limit = req.param('limit');
    ( async () => {
        let result = await Search.User(idx);
        if (result == 500) return res.status(500).json({ error: "err" });
        if (result == 404) return res.status(404).json({ error: "Not found" });
        let userFin = Pager.Array(result.finHOB, limit);
        res.send(userFin);
        console.log("PASSING THE FINISHLIST");
    })();
});

module.exports = router;
