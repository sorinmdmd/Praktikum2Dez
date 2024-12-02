package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fabrik.ConcreteCreator;
import fabrik.Creator;
import fabrik.Product;
import ownUtil.Observable;
import ownUtil.Observer;

public class TeppichenModel implements Observable {
	private Teppich teppich;
	List<Teppich> teppichList = new ArrayList<>();

	ArrayList<Observer> oblist = new ArrayList<>();

	private static TeppichenModel tmodel;

	private TeppichenModel() {

	}

	public static TeppichenModel getInstance() {
		if (tmodel == null) {
			tmodel = new TeppichenModel();
		}
		return tmodel;
	}

	public void writeCSV() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("TeppichenAusgabe.csv", true));
		aus.write(teppich.gibTeppichZurueck(';'));
		aus.newLine();
		aus.close();
	}

	public void readCSV() throws IOException {
		Creator creator = new ConcreteCreator();

		Product product = creator.factoryMethod("csv");

		String[] zeile = product.leseausDatei();
		this.teppich = new Teppich(zeile[0], Float.parseFloat(zeile[1]), Float.parseFloat(zeile[2]),
				Float.parseFloat(zeile[3]), zeile[4].split("_"));
		product.schliesseDatei();
		teppichList.add(this.teppich);
		notifyObserver();
	}

	public void readTXT() throws IOException {
		Creator creator = new ConcreteCreator();

		Product product = creator.factoryMethod("txt");

		String[] zeile = product.leseausDatei();
		this.teppich = new Teppich(zeile[0], Float.parseFloat(zeile[1]), Float.parseFloat(zeile[2]),
				Float.parseFloat(zeile[3]), zeile[4].split("_"));
		product.schliesseDatei();
		teppichList.add(this.teppich);
		notifyObserver();
	}

	public String getTeppichen() {
		String gesamtListe = "";

		for (int i = 0; i < teppichList.size(); i++) {
			gesamtListe += teppichList.get(i).toString() + "\n";
		}
		return gesamtListe;
	}

	public Teppich getTeppich() {
		return teppich;
	}

	public void setTeppich(Teppich teppich) {
		this.teppich = teppich;
	}

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		oblist.add(obs);

	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		oblist.remove(obs);

	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (int i = 0; i < oblist.size(); i++) {
			oblist.get(i).update();
		}

	}
}
