package yincheng.tinytank

import yincheng.tinytank.tinyframe.alignline.Permission

fun main() {
   val comparingTo = 0b110010
   println(Permission.PermissionChecker.hasEditPermission(comparingTo))
   println(Permission.PermissionChecker.hasMovePermission(comparingTo))
   println(Permission.PermissionChecker.hasDeletePermission(comparingTo))
   println(Permission.PermissionChecker.hasRotatePermission(comparingTo))
   println(Permission.PermissionChecker.hasScalePermission(comparingTo))
   println(Permission.PermissionChecker.hasMultiChoosePermission(comparingTo))
}