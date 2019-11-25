package yincheng.tinytank.algorithm.leetcode._001_100

import java.util.*
import kotlin.collections.ArrayList

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列
 */
fun main() {
    val source = intArrayOf(1, 2, 4, 5)
    val result = permutations(source)
    for (linkedList in result) {
        printLinkedList(linkedList)
    }
}

/**
 * 1. 1，2，4，5
 * 2. 取出1
 * 3. 取出2，将2放到1前面形成一个链表，将2放到1后面形成一个链表，总共生成 1 * 2 个链表。
 *    其中1代表上一步的链表数量，2代表上一步生成的每个链表能生成的新链表的个数。
 * 4. 取出4，将4分别放在上一步形成的两个链表：1 -> 2 和 2 -> 1 的前面、中间、后面，总共生成 2 * 3 个链表。
 * 5. 取出5，将5分别插入到上一步生成的每一个链表的每两个数字之间（包括前面和后面），总共生成 6 * 4 个链表。
 */
fun permutations(intArray: IntArray): ArrayList<LinkedList<Int>> {
    var result = ArrayList<LinkedList<Int>>()
    var tempResult = ArrayList<LinkedList<Int>>()
    var initialMatcher = LinkedList<Int>()
    intArray.forEachIndexed { index, i ->
        if (index == 0) {
            initialMatcher.add(i)
            result.add(initialMatcher)
        } else if (index < intArray.size) {
            /**
             * 使用增强型for循环并且在迭代过程中增加或者删除数据导致concurrentModificationException
             */
            result.addAll(tempResult)
            tempResult.clear()
            for (linkedList in result) { //上一次的执行完成后生成的所有全排列
                val loopSize = linkedList.size
                val clonedLinkedList = linkedList.clone() as LinkedList<Int>
                for (j in 0..loopSize) {
                    when (j) {
                        0 -> linkedList.addFirst(i)
                        loopSize -> {
                            clonedLinkedList.addLast(i)
                            tempResult.add(clonedLinkedList)
                        }
                        else -> {
                            val oneMatcher = clonedLinkedList.clone() as LinkedList<Int>
                            oneMatcher.add(j, i)
                            tempResult.add(oneMatcher)
                        }
                    }
                }
            }
        }
    }
    result.addAll(tempResult)
    return result
}

fun printLinkedList(source: LinkedList<Int>) {
    val builder = StringBuilder()
    source.forEachIndexed { index, i ->
        when (index) {
            0 -> builder.append("[ $i - ")
            source.size - 1 -> builder.append("$i ]")
            else -> builder.append("$i - ")
        }
    }
    println(builder)
}