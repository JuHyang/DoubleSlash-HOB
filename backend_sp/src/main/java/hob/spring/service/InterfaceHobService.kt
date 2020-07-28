package hob.spring.service

import hob.spring.model.Hob
import hob.spring.model.HobType

interface InterfaceHobService {
    fun searchByName(hobName: String, index: Int): ArrayList<Hob>
    fun searchByHobTypeId(hobTypeId: Int, index: Int): ArrayList<Hob>
    fun create(hob: Hob): Hob
}