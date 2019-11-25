package yincheng.tinytank.kotlin.by

/**
 * 将Map值映射到类属性
 */
class MappingProperty(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

fun main() {
    val mappingProperty = MappingProperty(mapOf(
            "name" to "音城",
            "age" to 26
    ))

    println("name = ${mappingProperty.name}, age = ${mappingProperty.age}")
}