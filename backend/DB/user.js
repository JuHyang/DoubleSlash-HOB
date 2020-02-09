var mongoose = require('mongoose')
var Schema = mongoose.Schema

var userSchema = new Schema({
    name: String,
    sex: String,
    age: Number,
    mail: String,
    desc: String,
    HOB: [{ idx: String, title: String }],
    pickHOB: [{ idx: String, title: String }],
    finHOB: [{ idx: String, title: String }]
})

module.exports = mongoose.model('userschema', userSchema)