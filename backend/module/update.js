/*
 * DB 삽입 함수 
 */

var User = require('../DB/user');
var Hob = require('../DB/hob');
var HobType = require('../DB/hobType'); 


function user(name, sex, age, mail, desc) {
    return new Promise(function (resolve) {
        let user = makeUserJson(name, sex, age, mail, desc);
        user.save(function (err) {
            if (err) resolve(err);
            resolve(1);
        });
    });
}

function makeUserJson (name, sex, age, mail, desc) {
    let user = new User();
    user.name = name;
    user.sex = sex;
    user.age = age;
    user.mail = mail;
    user.desc = desc;
    return user;
}

function userHob(idx, classIdx, title) {
    return new Promise(function (resolve) {
        User.findOne({ _id: idx}, function (err, userInfo) {
            if (err) resolve(500);
            if (!userInfo) resolve(404);
            userInfo.update({$push: { HOB: { idx: classIdx, title: title } } }, function(err){
              if (err) resolve(500);
              console.log("SAVE HOB COMPLETE");
              resolve(1);
            });
        });
    });    
}

function userPickHob(idx, classIdx, title) {
    return new Promise(function (resolve) {
        User.findOne({ _id: idx}, function (err, userInfo) {
            if (err) resolve(500);
            if (!userInfo) resolve(404);
            userInfo.update({$push: { pickHOB: { idx: classIdx, title: title } } }, function(err){
              if (err) resolve(500);
              console.log("SAVE PICK COMPLETE");
              resolve(1);
            });
        });
    });
}

function userFinHob(idx, classIdx, title) {
    return new Promise(function (resolve) {
        User.findOne({ _id: idx}, function (err, userInfo) {
            if (err) resolve(500);
            if (!userInfo) resolve(404);
            userInfo.update({$push: { finHOB: { idx: classIdx, title: title } } }, function(err){
              if (err) resolve(500);
              console.log("SAVE FINISH COMPLETE");
              resolve(1);
            });
        });
    });
}

function hob(title, link, desc, desc_detail, type) {
    return new Promise(function (resolve) {
        let hob = makeHobJson(title, link, desc, desc_detail, type);
        hob.save(function (err) {
            if (err) resolve(err);
            resolve(1);
        });
    });
}

function makeHobJson (title, link, desc, desc_detail, type) {
    let hob = new Hob();
    hob.title = title;
    hob.link = link;
    hob.desc = desc;
    hob.desc_detail = desc_detail;
    //hob.type = type;
    return hob;
}

function hobType(title, desc) {
    return new Promise(function (resolve) {
        let hobType = makeHobTypeJson(title, desc);
        hobType.save(function (err) {
            if (err) resolve(err);
            resolve(1);
        });
    });
}

function makeHobTypeJson (title, desc) {
    let hobType = new HobType();
    hobType.title = title;
    hobType.desc = desc;
    return hobType;
}

module.exports.User = user;
module.exports.UserHob = userHob;
module.exports.UserPickHob = userPickHob;
module.exports.UserFinHob = userFinHob;
module.exports.Hob = hob;
module.exports.HobType = hobType;
