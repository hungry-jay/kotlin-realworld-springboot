package back.service

import back.model.Tag
import back.repository.TagRepository

class TagService(private val repository: TagRepository) {
    fun getTags(): List<Tag> = repository.findAll().toList()
}