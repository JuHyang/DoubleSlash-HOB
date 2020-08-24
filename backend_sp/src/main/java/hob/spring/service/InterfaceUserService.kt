package hob.spring.service

import hob.spring.model.User

interface InterfaceUserService {
    fun subscribeHob(userId: String, hobId: Int): Boolean
    fun cancelHob(userId: String, hobId: Int): Boolean
    fun create(user: User): User
}