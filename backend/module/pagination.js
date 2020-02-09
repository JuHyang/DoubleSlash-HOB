/*
 * 페이지 네이션 모듈 
 */

function paginationArray(list, limit) {
    let fixedList;
    if ((list.length - limit) > 8) {
        fixedList = list.slice(limit, limit + 8);
    } else {
        fixedList = list.slice(limit, list.length);
    }
    return fixedList
}

module.exports.Array = paginationArray;