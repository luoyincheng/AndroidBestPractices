package yincheng.tinytank.android_Q_A.javadesignpatterns.absctractfactory;

/**
 * Created by yincheng on 2018/5/15/18:53.
 * github:luoyincheng
 */
public class App {

	private King king;
	private Castle castle;
	private Army army;

	public static void main(String[] args) {
		App app = new App();

		app.createKingdom(FactoryMaker.makeFactory(FactoryMaker.kingdomType.ELF));
		System.out.println(app.getArmy().getDescription());
		System.out.println(app.getCastle().getDescription());
		System.out.println(app.getKing().getDescription());

		app.createKingdom(FactoryMaker.makeFactory(FactoryMaker.kingdomType.ORC));
		System.out.println(app.getKing().getDescription());
		System.out.println(app.getCastle().getDescription());
		System.out.println(app.getKing().getDescription());
	}

	King getKing(final KingdomFactory factory) {
		return factory.createKing();
	}

	public King getKing() {
		return king;
	}

	public void setKing(King king) {
		this.king = king;
	}

	Castle getCastle(final KingdomFactory factory) {
		return factory.createCastle();
	}

	public Castle getCastle() {
		return castle;
	}

	public void setCastle(Castle castle) {
		this.castle = castle;
	}

	Army getArmy(final KingdomFactory factory) {
		return factory.createArmy();
	}

	public Army getArmy() {
		return army;
	}

	public void setArmy(Army army) {
		this.army = army;
	}

	public void createKingdom(final KingdomFactory factory) {
		setKing(factory.createKing());
		setArmy(factory.createArmy());
		setCastle(factory.createCastle());
	}

	public static class FactoryMaker {
		public static KingdomFactory makeFactory(kingdomType type) {
			switch (type) {
				case ORC:
					return new OrcKingdomFactory();
				case ELF:
					return new ElfKingdomFactory();
				default:
					throw new IllegalArgumentException("暂时不支持该类型");
			}
		}

		public enum kingdomType {
			ORC, ELF
		}
	}
}
