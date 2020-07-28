package hob.spring.service

import hob.spring.model.HobType

interface InterfaceHobTypeService {
    fun create(hobType: HobType): HobType
}