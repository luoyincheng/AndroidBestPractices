package yincheng.tinytank.tinyframe.alignline

class Permission {
    companion object {
        const val NONE = 0
        const val EDIT = 1.shl(0)
        const val MOVE = 1.shl(1)
        const val DELETE = 1.shl(2)
        const val ROTATE = 1.shl(3)
        const val SCALE = 1.shl(4)
        const val MULTI_CHOOSE = 1.shl(5)
    }

    object PermissionChecker {
        /**
         *        specification: 000010000   <-  SCALE
         * @param compareTarget: 000111010
         *               result: 000010010   <-  support
         * @param compareTarget: 000101011
         *               result: 000000000   <-  not support
         */
        fun hasEditPermission(compareTarget: Int) = (EDIT and compareTarget == EDIT)

        fun hasMovePermission(compareTarget: Int) = (MOVE and compareTarget == MOVE)
        fun hasDeletePermission(compareTarget: Int) = (DELETE and compareTarget == DELETE)
        fun hasRotatePermission(compareTarget: Int) = (ROTATE and compareTarget == ROTATE)
        fun hasScalePermission(compareTarget: Int) = (SCALE and compareTarget == SCALE)
        fun hasMultiChoosePermission(compareTarget: Int) = (MULTI_CHOOSE and compareTarget == MULTI_CHOOSE)
    }
}