var mongoose = require('mongoose')
var Schema = mongoose.Schema

var hobTypeSchema = new Schema({
    title: String,
    desc: String
})

module.exports = mongoose.model('hobtypeschema', hobTypeSchema)