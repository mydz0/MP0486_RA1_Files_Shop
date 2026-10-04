package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Amount;
import model.Employee;
import model.Product;

public class DaoImplFile implements Dao {

	@Override
	public void connect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee getEmployee(int employeeId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getInventory() {
		List<Product>inventory = new ArrayList<Product>();
		File f = new File(System.getProperty("user.dir") + File.separator + "files/inputInventory.txt");

		try {
			// wrap in proper classes
			FileReader fr;
			fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			// read first line
			String line = br.readLine();

			// process and read next line until end of file
			while (line != null) {
				// split in sections
				String[] sections = line.split(";");

				String name = "";
				double wholesalerPrice = 0.0;
				int stock = 0;

				// read each sections
				for (int i = 0; i < sections.length; i++) {
					// split data in key(0) and value(1)
					String[] data = sections[i].split(":");

					switch (i) {
					case 0:
						// format product name
						name = data[1];
						break;

					case 1:
						// format price
						wholesalerPrice = Double.parseDouble(data[1]);
						break;

					case 2:
						// format stock
						stock = Integer.parseInt(data[1]);
						break;

					default:
						break;
					}
				}
				// add product to inventory
				inventory.add(new Product(name, new Amount(wholesalerPrice), true, stock));

				// read next line
				line = br.readLine();
			}
			fr.close();
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inventory;
	}

}
