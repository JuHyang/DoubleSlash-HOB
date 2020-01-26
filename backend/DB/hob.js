var mongoose = require('mongoose')
var Schema = mongoose.Schema

var hobSchema = new Schema({
    title: String,
    link: String,
    desc: String,
    desc_detail: String,
    type_idx: Number
})

module.exports = mongoose.model('hobschema', hobSchema)