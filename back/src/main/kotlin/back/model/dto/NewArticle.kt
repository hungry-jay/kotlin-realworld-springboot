package back.model.dto

class NewArticle (
    val title: String,
    val description: String,
    val body: String,
    val tagList: MutableList<String> = mutableListOf()
        ){
}