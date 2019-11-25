package yincheng.tinytank.algorithm.leetcode._201_300


fun main() {
    val rootNode = ListNode(0)
    val node1 = ListNode(1)
    rootNode.next = node1
    val node2 = ListNode(2)
    node1.next = node2
//    val node3 = ListNode(3)
//    node2.next = node3
//    val node4 = ListNode(4)
//    node3.next = node4
//    val node5 = ListNode(5)
//    node4.next = node5
//    val node6 = ListNode(6)
//    node5.next = node6

//    val rootNode1 = rootNode
//    printNode(reverseLinkedList1(rootNode1))

    val rootNode2 = rootNode
//    printNode(reverseLinkedList2(rootNode2))
    printNode(reverseLinkedList3(rootNode2, null))
}

/**
 * 循环反转链表
 */
fun reverseLinkedList1(rootNode: ListNode?): ListNode? {
    var nowNode = rootNode
    var preNode: ListNode? = null
    while (nowNode != null) {
        val backedUpNode = nowNode.next
        nowNode.next = preNode
        preNode = nowNode
        nowNode = backedUpNode
    }
    return preNode
}

/**
 * 递归反转链表(1个参数)
 */
fun reverseLinkedList2(rootNode: ListNode?): ListNode? {
    if (rootNode == null || rootNode.next == null) return rootNode
    val nowHead = reverseLinkedList2(rootNode?.next)
    rootNode.next?.next = rootNode
    rootNode.next = null
    return nowHead
}

/**
 * 递归反转链表(2个参数)
 */
fun reverseLinkedList3(rootNode: ListNode?, preNode: ListNode?): ListNode? {
    val nextNode = rootNode?.next
    rootNode?.next = preNode
    return if (nextNode == null) rootNode
    else reverseLinkedList3(nextNode, rootNode)
}

class ListNode constructor(val value: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "$value"
    }
}

fun printNode(rootNode: ListNode?) {
    var tempNode = rootNode
    val result = StringBuilder()
    while (tempNode != null) {
        result.append("${tempNode.value} -> ")
        tempNode = tempNode.next
    }
    println(result.substring(0, result.length - 3))
}