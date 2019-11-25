package yincheng.tinytank.sourcecode

import java.util.*

fun main() {
    val linkedList = LinkedList<String>()
    linkedList.add("我的")
    linkedList.add("世界")
    linkedList.addFirst("开始")
    linkedList.addFirst("real")
    linkedList.forEachIndexed { index, s -> println("$index $s") }
}