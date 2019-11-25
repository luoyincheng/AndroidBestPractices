package yincheng.tinytank.algorithm.leetcode._001_100

import yincheng.tinytank.algorithm.AlgorithmUtil.AlgorithmUtil
import yincheng.tinytank.algorithm.ListNode

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node9 = ListNode(8)
    val node10 = ListNode(6)

    val node4 = ListNode(4)
    val node5 = ListNode(5)
    val node6 = ListNode(9)
    val node7 = ListNode(7)
    val node8 = ListNode(8)
    node1.next = node2
    node2.next = node3
    node3.next = node9
    node9.next = node10

    node4.next = node5
    node5.next = node6
    node6.next = node7
    node7.next = node8

    AlgorithmUtil.printListNode(node1)
    AlgorithmUtil.printListNode(node4)

    val result = addTwoNumbers(node1, node4)
    AlgorithmUtil.printListNode(result)
}

fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode? {
    var appendToNext = 0
    var resultNode: ListNode? = null
    var preNode: ListNode? = null
    var firstHeadNode: ListNode? = l1
    var secondHeadNode: ListNode? = l2
    while (firstHeadNode != null || secondHeadNode != null) {
        val firstNum = firstHeadNode?.value ?: 0
        val secondNum = secondHeadNode?.value ?: 0
        val sum = firstNum + secondNum + appendToNext
        appendToNext = sum / 10
        val nowNode = ListNode(sum % 10)
        if (resultNode == null) resultNode = nowNode
        else preNode?.next = nowNode
        preNode = nowNode
        firstHeadNode = firstHeadNode?.next
        secondHeadNode = secondHeadNode?.next
    }
    if (appendToNext == 1) preNode?.next = ListNode(1)
    return resultNode
}