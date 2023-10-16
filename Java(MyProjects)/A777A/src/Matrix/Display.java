package Matrix;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Display { 

	public static void stampaLista(LinkedList<Matrice> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.println("[" + (i + 1) + "]");
			l.get(i).stampaMatrice();
		}
	}

	public static boolean controllaNome(String s, LinkedList<Matrice> l) {
		int j = 0;
		boolean b = false;
		String temp = "";
		do {
			temp = l.get(j).getNome();
			if (s.equals(temp)) {
				b = true;
			}
			j++;
		} while (j < l.size());
		return b;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Matrice> matrici = new LinkedList<Matrice>();
		int inizio = 0;
		System.out.println("Scegli un'istruzione per iniziare");
		System.out.println("--Per selezionare un'operazione, digita il numero associato e premi invio.--\n");
		System.out.println("1.Inserire delle matrici");
		System.out.println("2.Usare matrici create in modo casuale");
		inizio = Matrice.sceltaMenu(1, 2);
		if (inizio == 1) {
			int nmatrici = 0;
			do {
				System.out.println("Quante matrici vuoi inserire? ");
				nmatrici = Matrice.whileIsInt();
			} while (nmatrici <= 0);
			for (int i = 0; i < nmatrici; i++) {
				System.out.println("Matrice " + "[" + (i + 1) + "]");
				matrici.add(Matrice.creaMatrice());
			}
		} else if (inizio == 2) {
			Random rnd = new Random();
			int cas = rnd.nextInt(3, 6);
			for (int i = 0; i < cas; i++) {
				Matrice casuale = Matrice.creaMatriceCasuale();
				casuale.setNome("casuale " + (i + 1));
				matrici.add(casuale);
			}
		}
		do {
			sc = new Scanner(System.in);
			int scelta = 0;
			int scelta1 = 0;
			int scelta2 = 0;
			System.out.println("\nMATRICI DISPONIBILI\n");
			stampaLista(matrici);
			System.out.println("Lista operazioni disponibili:");
			System.out.println("--Per selezionare un'operazione, \ndigita il numero associato e premi invio.--\n");
			System.out.println("1 -->Prodotto tra Matrici");
			System.out.println("2 -->Somma tra Matrici");
			System.out.println("3 -->Sottrazione tra Matrici");
			System.out.println("4 -->Moltiplica una matrice per un numero");
			System.out.println("5 -->Somma degli elementi di una matrice");
			System.out.println("6 -->Determinante di una matrice");
			System.out.println("7 -->Matrice inversa di una matrice");
			System.out.println("8 -->Matrice di coefficienti di una matrice");
			System.out.println("9 -->Matrice trasposta di una matrice");
			System.out.println("10 -->Creare una matrice enorme");
			System.out.println("11 -->Aggiungere una matrice");
			System.out.println("12 -->Rimuovere una matrice");
			System.out.println("13 -->Creazione matrici particolari");
			scelta = Matrice.sceltaMenu(1, 13);
			switch (scelta) {
			case 1:
				System.out.println("\nPRODOTTO TRA MATRICI:");
				stampaLista(matrici);
				System.out.println("Scegli la prima matrice");
				System.out.println("--Digita il numero all'interno delle parentesi quadre e premi invio--");
				scelta1 = Matrice.sceltaMenu(1, matrici.size()) - 1;
				System.out.println("Scegli la seconda matrice");
				scelta2 = Matrice.sceltaMenu(1, matrici.size()) - 1;
				Matrice AxB = Matrice.prodotto(matrici.get(scelta1), matrici.get(scelta2));
				matrici.add(AxB);
				AxB.stampaMatrice();
				break;
			case 2:
				System.out.println("\nSOMMA TRA MATRICI:");
				stampaLista(matrici);
				System.out.println("Scegli la prima matrice");
				System.out.println("--Digita il numero all'interno delle parentesi quadre e premi invio--");
				scelta1 = Matrice.sceltaMenu(1, matrici.size()) - 1;
				System.out.println("Scegli la seconda matrice");
				scelta2 = Matrice.sceltaMenu(1, matrici.size()) - 1;
				Matrice ApB = Matrice.somma(matrici.get(scelta1), matrici.get(scelta2));
				matrici.add(ApB);
				ApB.stampaMatrice();
				break;
			case 3:
				System.out.println("\nSOTTRAZIONE TRA MATRICI:");
				stampaLista(matrici);
				System.out.println("Scegli la prima matrice");
				System.out.println("--Digita il numero all'interno delle parentesi quadre e premi invio--");
				scelta1 = Matrice.sceltaMenu(1, matrici.size()) - 1;
				System.out.println("Scegli la seconda matrice");
				scelta2 = Matrice.sceltaMenu(1, matrici.size()) - 1;
				Matrice AmB = Matrice.sottrazione(matrici.get(scelta1), matrici.get(scelta2));
				AmB.stampaMatrice();
				break;
			case 4:
				System.out.println("\nMOLTIPLICA UNA MATRICE PER NUMERO:");
				stampaLista(matrici);
				System.out.println("Scegli una matrice");
				System.out.println("--Digita il numero all'interno delle parentesi quadre e premi invio--");
				scelta1 = Matrice.sceltaMenu(1, matrici.size()) - 1;
				System.out.println("inserire un numero");
				Double d = 0.0;
				d = Matrice.whileIsDouble();
				Matrice axd = matrici.get(scelta1).moltiplica(d);
				matrici.add(axd);
				if (d == Math.round(d)) {
					System.out.println("moltiplicando: " + d.intValue());
				} else {
					System.out.println("moltiplicando: " + d);
				}
				axd.stampaMatrice();
				break;
			case 5:
				System.out.println("\nSOMMA DEGLI ELEMENTI DI UNA MATRICE:");
				stampaLista(matrici);
				System.out.println("Scegli una matrice");
				System.out.println("--Digita il numero all'interno delle parentesi quadre e premi invio--");
				scelta1 = Matrice.sceltaMenu(1, matrici.size()) - 1;
				Double dd = matrici.get(scelta1).sommaElementi();
				matrici.get(scelta1).stampaMatrice();
				if (dd == Math.round(dd)) {
					System.out.println("somma dei suoi elementi: " + dd.intValue());
				} else {
					System.out.println("somma dei suoi elementi: " + dd);
				}
				break;
			case 6:
				System.out.println("\nDETERMINANTE DI UNA MATRICE:");
				stampaLista(matrici);
				System.out.println("Scegli una matrice");
				System.out.println("--Digita il numero all'interno delle parentesi quadre e premi invio--");
				scelta1 = Matrice.sceltaMenu(1, matrici.size()) - 1;
				Double de = matrici.get(scelta1).getDeterminante();
				matrici.get(scelta1).stampaMatrice();
				if (matrici.get(scelta1).getRighe() != matrici.get(scelta1).getColonne()) {
					System.out.println("Non esiste il determinante di questa matrice.");
				} else {
					if (de == Math.round(de)) {
						System.out.println("determinante di " + matrici.get(scelta1).getNome() + ": " + de.intValue());
					} else {
						System.out.println("determinante di " + matrici.get(scelta1).getNome() + ": " + de);
					}
				}
				break;
			case 7:
				System.out.println("\nMATRICE INVERSA DI UNA MATRICE:");
				stampaLista(matrici);
				System.out.println("Scegli una matrice");
				System.out.println("--Digita il numero all'interno delle parentesi quadre e premi invio--");
				scelta1 = Matrice.sceltaMenu(1, matrici.size()) - 1;
				Matrice inv = matrici.get(scelta1).getInversa();
				matrici.add(inv);
				matrici.get(scelta1).stampaMatrice();
				inv.stampaMatrice();
				break;
			case 8:
				System.out.println("\nMATRICE DI COEFFICIENTI DI UNA MATRICE:");
				stampaLista(matrici);
				System.out.println("Scegli una matrice");
				System.out.println("--Digita il numero all'interno delle parentesi quadre e premi invio--");
				scelta1 = Matrice.sceltaMenu(1, matrici.size()) - 1;
				Matrice co = matrici.get(scelta1).getMatCoefficienti();
				matrici.add(co);
				co.stampaMatrice();
				break;
			case 9:
				System.out.println("\nMATRICE TRASPOSTA DI UNA MATRICE:");
				stampaLista(matrici);
				System.out.println("Scegli una matrice");
				System.out.println("--Digita il numero all'interno delle parentesi quadre e premi invio--");
				scelta1 = Matrice.sceltaMenu(1, matrici.size()) - 1;
				Matrice trasp = matrici.get(scelta1).getTrasposta();
				matrici.add(trasp);
				trasp.stampaMatrice();
				break;
			case 10:
				System.out.println("\nCREARE UNA MATRICE ENORME:");
				System.out.println("Inserisci nome matrice");
				String nm = "";
				do {
					nm = sc.nextLine();
					if (controllaNome(nm, matrici)) {
						System.out.println("Esiste già una matrice con questo nome.");
					}
				} while (controllaNome(nm, matrici));
				System.out.println("Inserisci l'ordine della matrice " + nm);
				int ordine = 0;
				do {
					ordine = Matrice.whileIsInt();
					if (ordine <= 0) {
						System.out.println("L'ordine deve essere maggiore di 0\nRiprova.");
					}
				} while (ordine <= 0);
				System.out.println("Inserisci un numero da mettere in tutte le posizioni della matrice " + nm);
				Double numero = 0.0;
				numero = Matrice.whileIsDouble();
				Matrice enorme = new Matrice(nm, ordine);
				enorme.cambiaValori(numero);
				enorme.stampaMatrice();
				matrici.add(enorme);
				break;
			case 11:
				System.out.println("\nAGGIUNGERE UNA MATRICE:");
				Matrice agg = new Matrice();
				agg = Matrice.creaMatrice();
				do {
					if (controllaNome(agg.getNome(), matrici)) {
						System.out.println("Esiste già una matrice con questo nome,\nInserire un valore valido.");
						agg.setNome(sc.nextLine());
					}
				} while (controllaNome(agg.getNome(), matrici));
				matrici.add(agg);
				agg.stampaMatrice();
				break;
			case 12:
				System.out.println("\nRIMUOVERE UNA MATRICE:");
				stampaLista(matrici);
				System.out.println("Scegli la matrice da rimuovere");
				System.out.println("--Digita il numero all'interno delle parentesi quadre e premi invio--\n");
				scelta1 = Matrice.sceltaMenu(1, matrici.size()) - 1;
				System.out.println("La matrice seguente è stata rimossa");
				matrici.get(scelta1).stampaMatrice();
				matrici.remove(scelta1);
				break;
			case 13:
				System.out.println("\nCREAZIONE MATRICI PARTICOLARI:");
				System.out.println("Scegli un nome per la matrice\n");
				String nome = "";
				do {
					nome = sc.nextLine();
					if (controllaNome(nome, matrici)) {
						System.out.println("Esiste già una matrice con questo nome.");
					}
				} while (controllaNome(nome, matrici));
				System.out.println("Scegli l'ordine della matrice " + nome + "\n");
				int ord = Matrice.sceltaMenu(2, 5);
				;
				System.out.println("Scegli il determinante della matrice\n");
				Double D = Matrice.whileIsDouble();
				Matrice M = new Matrice();
				do {
					M = Matrice.creaMatriceCasuale(ord, ord);
				} while (M.getDeterminante() != D);
				M.setNome(nome);
				matrici.add(M);
				M.stampaMatrice();
				break;
			}
			System.out.println();
			for (int i = 0; i < matrici.size(); i++) {
				Matrice j = matrici.get(i);
				if (j.isNull()) {
					matrici.remove(i);
				}
			}
		} while (Matrice.yesNo("Vuoi fare altre operazioni?"));
		System.out.println("Programma terminato.");
		sc.close();
	}

}
