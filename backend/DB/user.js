var mongoose = require('mongoose')
var Schema = mongoose.Schema

var userSchema = new Schema({
    name: String,
    sex: String,
    age: Number,
    mail: String,
    desc: String,
    HOBsignup: [{ idx: String, title: String }],
    HOBpick: [{ idx: String, title: String }],
    HOBcomp: [{ idx: String, title: String }]
})

module.exports = mongoose.model('userschema', userSchema)