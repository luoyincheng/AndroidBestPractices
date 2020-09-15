package yincheng.tinytank.algorithm.leetcode._101_200

fun main() {
   val source1 = intArrayOf(1, 2, 3, 4, 5, 6)
   rotate1(source1, 2)
   println(source1.contentToString())

   val source2 = intArrayOf(1, 2, 3, 4, 5, 6)
   rotate2(source2, 2)
   println(source2.contentToString())

   val source3 = intArrayOf(1, 2, 3, 4, 5, 6)
   rotate3(source3, 2)
   println(source3.contentToString())
}

fun rotate1(source: IntArray, step: Int) {
   for (i in 1..step) {
      for (j in source.size - 1 downTo 1) {
         val temp = source[j]
         source[j] = source[j - 1]
         source[j - 1] = temp
      }
   }
}

/**
 * 这个耗时200ms　因为判断太多了
 * _189文件夹下面的耗时1ms　内存占用两者差不多
 *
 * 终止条件：交换次数等于size-1次
 *
 * 1,2,3,4,5,6  step为2
 * 选中下标为0的数字，它应该在位置3上 因此替换完成之后数组变成:3,2,1,4,5,6
 * 此时原本下标为3的应该在下标为5的位置上，因此将下标为0和下标为5的替换:5,2,1,4,3,6
 * 此时原本下标为5的应该在下标为0的位置上，而因为本次循环就是将下标为0的作为数据的暂存地址，因此不需要交换，但是交换次数依然要更新
 *
 * 到这里　需要判断交换次数是否达到终止条件，没有达到的话就将选中的下标+1后继续重复以上操作，知道达到退出条件
 *
 */
fun rotate2(source: IntArray, step: Int) {
   var fakeIndex = 0
   var indexShouldBe = (fakeIndex + step) % source.size
   if (fakeIndex == indexShouldBe) return
   var tempData: Int
   var exchangedCount = 0
   for (i in 1 until source.size) {
      if (indexShouldBe == fakeIndex) {
         exchangedCount++
         if (exchangedCount == source.size) break
         else {
            ++fakeIndex
            indexShouldBe = (fakeIndex + step) % source.size
         }
      }

      tempData = source[fakeIndex]
      source[fakeIndex] = source[indexShouldBe]
      source[indexShouldBe] = tempData
      exchangedCount++

      indexShouldBe = (indexShouldBe + step) % source.size
   }
}

fun rotate3(numbers: IntArray, k: Int) {
   var k = k
   k %= numbers.size
   var exchangeCount = 0
   var startIndex = 0
   while (exchangeCount < numbers.size) {
      var nowIndex = startIndex
      var prev = numbers[startIndex]
      do {
         val indexShouldBe = (nowIndex + k) % numbers.size
         val temp = numbers[indexShouldBe]
         numbers[indexShouldBe] = prev
         prev = temp
         exchangeCount++

         nowIndex = indexShouldBe
      } while (startIndex != nowIndex)
      startIndex++
   }
}