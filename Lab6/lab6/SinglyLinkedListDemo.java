package lab6;

public class SinglyLinkedListDemo {

	public static void main(String[] args) {
		SinglyLinkedList<String> airports = new SinglyLinkedList<String>();
		airports.addFirst("BZN");
		airports.addFirst("BOS");
		airports.addFirst("SLC");
		airports.addFirst("LAX");
		airports.addFirst("LAS");
		System.out.println(airports.toString());
		airports.removeFirst();
		airports.addFirst("SFO");
		System.out.println(airports.toString());
		
		SinglyLinkedList<Song> playlist = new SinglyLinkedList<Song>();
		Song song1 = new Song("My House", "Massive Vibes");
		playlist.addFirst(song1);
		song1 = new Song("Breakfast", "Ground Up/G-Eazy");
		playlist.addFirst(song1);
		song1 = new Song("Gold", "Illenium/Excision");
		playlist.addFirst(song1);
		song1 = new Song("Double Up", "PhaseOne/Young Buck");
		playlist.addFirst(song1);
		song1 = new Song("Religion", "BTSM");
		playlist.addFirst(song1);
		System.out.println(playlist.toString());
		playlist.removeFirst();
		song1 = new Song("Turtles All the Way Down", "Sturgill Simpson");
		playlist.addFirst(song1);
		System.out.println(playlist.toString());
		
		System.out.println(airports.get(2));
		System.out.println(airports.get(5));
		System.out.println(playlist.get(3));
		System.out.println(playlist.get(1));
	}
}
