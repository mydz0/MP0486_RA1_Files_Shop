package dao;

public class TestDao {
	public static void main(String[] args) {
		Dao dao = new DaoImplFile();
		dao.connect();
		System.out.println("RESULT: " + dao.getInventory());
		dao.disconnect();
	}
}