/*
 * DB 접근 함수 (전체 검색결과를 제공)
 */

var User = require('../DB/user');
var Hob = require('../DB/hob');


function User(idx) {
    /*
     * 전체 유저검색은 의미가 없을 것 같음 
     */
}

function hob(skip) {
    /*
     * 전체 hob 제공 
     */
    return new Promise(function (resolve) {
        console.log("aaaa");
        console.log(skip);
        resolve(Hob.find().skip(skip).limit(8));
        /*
        Hob.find().skip(skip).limit(8, function (err, hobsInfo) {
            console.log("bbb");
            if (err) resolve(404);
            if (!hobsInfo) resolve(500);
            console.log(err);
            console.log("PASSING THE USER INFO");
            resolve(hobsInfo);
        });
        */
        console.log("SOMETHINGS HAPPEN ERROR");
    });
}

function HobType(idx){
    /*
     * 전체 hob 타입 제공 
     */
}

module.exports.Hob = hob;