import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ClanBaza {

	DataSource dataSource;
	private static ClanBaza instance = null;

	public static ClanBaza getInstance() {
		if (instance == null)
			return instance = new ClanBaza();
		else
			return instance;
	}

	private ClanBaza() {
		try {

			dataSource = (DataSource) new InitialContext().lookup("java:jboss/datasources/baza");

			// ustvariStrukturo();
			// test();
			// test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void test() throws Exception {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			conn.createStatement().execute(
					"insert into clan (ime, priimek, spol, datumRojstva, datumVpisa, sifra, email) values ('gregor','gorjanc','moski',NOW(),NOW(),'lol','mail')");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
			System.out.println("vpis testnega clana");

		}

	}

	public void ustvariStrukturo() throws Exception {
		Connection conn = null;

		try {
			conn = dataSource.getConnection();

			// conn.createStatement().execute("drop table if exists clan");
			// conn.createStatement().execute("drop table if exists meritev");
//			conn.createStatement().execute(
//					"create table if not exists clan (idclan int not null AUTO_INCREMENT, ime varchar, priimek varchar, spol varchar, datumRojstva timestamp, datumVpisa timestamp, sifra varchar, email varchar, primary key (idclan))");
//
//			conn.createStatement().execute(
//					"CREATE TABLE IF NOT EXISTS meritev (idmeritev INT NOT NULL AUTO_INCREMENT, datumMeritve TIMESTAMP , visina DOUBLE, obsegPasu DOUBLE , teza DOUBLE , clan_idclan INT NOT NULL,  PRIMARY KEY (idmeritev), CONSTRAINT fk_meritev_clan FOREIGN KEY (clan_idclan) REFERENCES clan(idclan))");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
			System.out.println("ustvari strukturo");
		}

	}

	public void vpisiClana(Clan c) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"insert into clan (ime, priimek, spol, datumRojstva, datumVpisa, sifra, email, paket) values (?,?,?,?,?,?,?,?)");
			ps.setString(1, c.getIme());
			ps.setString(2, c.getPriimek());
			ps.setString(3, c.getSpol());
			ps.setTimestamp(4, new Timestamp(c.getDatumRojstva().getTimeInMillis()));
			ps.setTimestamp(5, new Timestamp(c.getDatumVpisaVKlub().getTimeInMillis()));
			ps.setString(6, c.getSifra());
			ps.setString(7, c.getEmail());
			ps.setString(8, c.getPaket().toString());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("vpis clana " + c);
			c.getPaket().posljiMail();

		}
	}

	public ArrayList<Clan> getVsiClani() {

		Connection conn = null;

		ArrayList<Clan> seznam = new ArrayList<>();

		try {
			conn = dataSource.getConnection();

			ResultSet resultSet = conn.createStatement().executeQuery("select * from clan");
			while (resultSet.next()) {

				Calendar temp1 = Calendar.getInstance();
				temp1.setTimeInMillis(resultSet.getTimestamp("datumRojstva").getTime());
				Calendar temp2 = Calendar.getInstance();
				temp2.setTimeInMillis(resultSet.getTimestamp("datumVpisa").getTime());

				seznam.add(new Clan(resultSet.getString("ime"), resultSet.getString("priimek"),
						resultSet.getString("spol"), temp1, temp2, resultSet.getString("sifra"),
						resultSet.getString("email"), resultSet.getInt("idclan")));

			}
			resultSet.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println("vse 3");
			// System.out.println("hallo:" + seznam);

		}

		return seznam;

	}

	public ArrayList<Meritev> getSeznamMeritev(int id) {
		Connection conn = null;

		ArrayList<Meritev> seznam = new ArrayList<>();

		try {
			conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("select * from meritev where clan_idclan=?");
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				Calendar temp = Calendar.getInstance();
				temp.setTimeInMillis(resultSet.getTimestamp("datumMeritve").getTime());

				seznam.add(new Meritev(temp, resultSet.getDouble("visina"), resultSet.getDouble("obsegPasu"),
						resultSet.getDouble("teza")));

			}
			resultSet.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//		System.out.println("prodobivanje meritev za: "+id);

		}

		return seznam;

	}
	public ArrayList<Meritev> getSeznamMeritevPoVrsti(int id) {
		Connection conn = null;

		ArrayList<Meritev> seznam = new ArrayList<>();

		try {
			conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("select * from meritev where clan_idclan=? order by datumMeritve asc");
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				Calendar temp = Calendar.getInstance();
				temp.setTimeInMillis(resultSet.getTimestamp("datumMeritve").getTime());

				seznam.add(new Meritev(temp, resultSet.getDouble("visina"), resultSet.getDouble("obsegPasu"),
						resultSet.getDouble("teza")));

			}
			resultSet.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//		System.out.println("prodobivanje meritev za: "+id);

		}

		return seznam;

	}

	public void vpisiMeritev(Calendar c, double teza, double obseg, double visina, int id) {

		Connection conn = null;
		try {
			conn = dataSource.getConnection();

			PreparedStatement ps = conn.prepareStatement(
					"insert into meritev(datumMeritve, teza, obsegPasu, visina, clan_idclan) values(?,?,?,?,?)");
			ps.setTimestamp(1, new Timestamp(c.getTimeInMillis()));
			ps.setDouble(2, teza);
			ps.setDouble(3, obseg);
			ps.setDouble(4, visina);
			ps.setInt(5, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("vpis meritve");

		}

	}

	public void izbrisiClana(int id) {
		Connection conn = null;
		try {
			conn= dataSource.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("delete from clan where idclan=?");
			ps.setInt(1,id);
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
