package hob.spring.service

import hob.spring.model.User

interface InterfaceUserService {
    fun subscribeHob(id: Int): Boolean
    fun cancelHob(id: Int): Boolean
    fun create(user: User): User
}