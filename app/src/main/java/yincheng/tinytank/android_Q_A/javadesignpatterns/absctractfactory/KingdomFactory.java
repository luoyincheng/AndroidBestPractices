package yincheng.tinytank.android_Q_A.javadesignpatterns.absctractfactory;

/**
 * Created by yincheng on 2018/5/15/18:45.
 * github:luoyincheng
 */
public interface KingdomFactory {
	Castle createCastle();

	Army createArmy();

	King createKing();
}
