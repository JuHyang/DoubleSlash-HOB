/*
 * DB 삭제 함수 
 */

var User = require('../DB/user');
var Hob = require('../DB/hob');
var HobType = require('../DB/hobType'); 

function user(idx) {
    return new Promise(function (resolve) {
        User.remove({ _id: idx}, function (err, userInfo) {
            if (err) resolve(500);
            if (!userInfo) resolve(404);
            console.log("DELETE USER COMPLETE");
            resolve(1);
        });
    }); 
}

function userHob(idx, classIdx) {
    return new Promise(function (resolve) {
        User.findOne({ _id: idx}, function (err, userInfo) {
            if (err) resolve(500);
            if (!userInfo) resolve(404);
            userInfo.update({$pull: { HOB: { idx: classIdx } } }, function(err){
              if (err) resolve(500);
              console.log("DELETE HOB COMPLETE");
              resolve(1);
            });
        });
    });    
}

function userPickHob(idx, classIdx) {
    return new Promise(function (resolve) {
        User.findOne({ _id: idx}, function (err, userInfo) {
            if (err) resolve(500);
            if (!userInfo) resolve(404);
            userInfo.update({$pull: { pickHOB: { idx: classIdx } } }, function(err){
              if (err) resolve(500);
              console.log("DELETE PICK COMPLETE");
              resolve(1);
            });
        });
    });
}

function userFinHob(idx, classIdx) {
    return new Promise(function (resolve) {
        User.findOne({ _id: idx}, function (err, userInfo) {
            if (err) resolve(500);
            if (!userInfo) resolve(404);
            userInfo.update({$pull: { finHOB: { idx: classIdx } } }, function(err){
              if (err) resolve(500);
              console.log("DELETE FINISH COMPLETE");
              resolve(1);
            });
        });
    });
}

function hob(idx) {
    return new Promise(function (resolve) {
        Hob.remove({ _id: idx}, function (err, hobInfo) {
            if (err) resolve(500);
            if (!hobInfo) resolve(404);
            console.log("DELETE HOB COMPLETE");
            resolve(1);
        });
    }); 
}

function hobType(idx){
    return new Promise(function (resolve) {
        HobType.remove({ _id: idx}, function (err, hobTypeInfo) {
            if (err) resolve(500);
            if (!hobTypeInfo) resolve(404);
            console.log("DELETE HOBTYPE COMPLETE");
            resolve(1);
        });
    }); 
}

module.exports.User = user;
module.exports.UserHob = userHob;
module.exports.UserPickHob = userPickHob;
module.exports.UserFinHob = userFinHob;
module.exports.Hob = hob;
module.exports.HobType = hobType;