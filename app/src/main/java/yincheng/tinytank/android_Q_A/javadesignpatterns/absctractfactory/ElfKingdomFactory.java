package yincheng.tinytank.android_Q_A.javadesignpatterns.absctractfactory;

/**
 * Created by yincheng on 2018/5/15/18:49.
 * github:luoyincheng
 */
public class ElfKingdomFactory implements KingdomFactory {
	@Override
	public Castle createCastle() {
		return new ElfCastle();
	}

	@Override
	public Army createArmy() {
		return new ElfArmy();
	}

	@Override
	public King createKing() {
		return new ElfKing();
	}
}
