#### 一个从小到大排好序的数组，从某一个位置断开分为两个有序的数组，将后面的数组放到前面形成一个新的有了“断层”的数组，现在在新生成的数组中进行查找，能否使用二分查找？？？
- 可以,
要查找的数字:tar_num,
第一部分有序数组:fir_array,
第二部分数组:sen_array,
中间数字:mid_num,
最后一个数字:end_num,
第一个数字:fir_num

- 第一步:比较tar_num和mid_num
- 第二步:根据下标获取中间数字，将mid_num和end_num进行比较，
如果mid_num > end_num,表明fir_array比sen_array数据多，mid_num位于fir_array中，
如果mid_num < end_num,表明 sen_array比fir_array数据多，mid_num位于sen_array中。
如果mid_num == end_num,直接返回该数字(有可能出现连续相同的几个数字，此时需要从该位置往前，往后分别查找)
- 第三步:
当fir_array数量更多时:
如果tar_num比mid_num小，需要将数组从mid_num处分为两部分，分别对这两部分进行查找，其中左边使用常规的二分查找，右边递归(因为fir_array数量更多，从mid_num往后的数据形成了一个同样有断层的新数组)
如果tar_num比mid_num大，直接对右边新生成的数组递归
如果sen_array数量更多时:
and so on...