var mongoose = require('mongoose')
var Schema = mongoose.Schema

var hobSchema = new Schema({
    title: String,
    link: String,
    desc: String,
    desc_detail: String,
    type: [{ idx: String, title: String }]
})
/* 
 * 이 DB에서 가장 골칫거리는 type 이것에 대해서 논의 해야함
 */

module.exports = mongoose.model('hobschema', hobSchema)