/*
 * DB 검색 함수 
 */

var User = require('../DB/user');
var Hob = require('../DB/hob');
var HobType = require('../DB/hobType');

function user(idx) {
    return new Promise(function (resolve) {
        User.findOne({ _id: idx }, function (err, userInfo) {
            if (err) resolve(404);
            if (!userInfo) resolve(500);
            console.log("PASSING THE USER INFO");
            resolve(userInfo);
        });
        console.log("SOMETHINGS HAPPEN ERROR");
    });
}

function hobIdx(idx) {
    return new Promise(function (resolve) {
        Hob.findOne({ _id: idx }, function (err, hobInfo) {
            if (err) resolve(404);
            if (!hobInfo) resolve(500);
            console.log("PASSING THE HOB INFO");
            resolve(hobInfo);
        });
        console.log("SOMETHINGS HAPPEN ERROR");
    });
}

function hobTitle(title) {
    return new Promise(function (resolve) {
        Hob.findOne({ title: title }, function (err, hobInfo) {
            if (err) resolve(404);
            if (!hobInfo) resolve(500);
            console.log("PASSING THE HOB INFO");
            resolve(hobInfo);
        });
        console.log("SOMETHINGS HAPPEN ERROR");
    });
}

function hobType(idx) {
    return new Promise(function (resolve) {
        HobType.findOne({ _id: idx }, function (err, hobTypeInfo) {
            if (err) resolve(404);
            if (!hobTypeInfo) resolve(500);
            console.log("PASSING THE HOBTYPE INFO");
            resolve(hobInfo);
        });
        console.log("SOMETHINGS HAPPEN ERROR");
    });
}

module.exports.User = user;
module.exports.HobIdx = hobIdx;
module.exports.HobTitle = hobTitle;
module.exports.HobType = hobType;