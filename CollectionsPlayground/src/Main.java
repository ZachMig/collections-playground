import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

	public static void main(String[] args) {
		Card.printDeck(Card.getStandardDeck());
		
		//Creates an array of size 13 and fills it with 13 copies of aceOfHearts
		Card[] cardArray = new Card[13];
		Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, "A");
		Arrays.fill(cardArray, aceOfHearts);
		Card.printDeck("Aces of Hearts", Arrays.asList(cardArray), 1);
		
		
		//Creates an ArrayList<Card> of //capacity// 52 but size zero, so
		// Collections.fill() tries to fill a List of size zero, and results in 
		// a List that is still empty.
		List<Card> cards = new ArrayList<>(52);
		Collections.fill(cards, aceOfHearts);
		System.out.println(cards);
		System.out.println("cards.size() = " + cards.size());
		
		
		//Using Collections.nCopies() actually populates the target.
		List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
		Card.printDeck("Aces of Hearts", acesOfHearts, 1);
		
		Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, "K");
		List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
		Card.printDeck("Aces of Hearts", kingsOfClubs, 1);
		
		//Collections.addAll() here fills our previously empty target list properly, this
		// time using an existing array.
		Collections.addAll(cards, cardArray);
		Card.printDeck("Card Collection with Aces using Collections.addAll()", cards, 1);
		
		//Collections.copy() will throw an error here indicating that 
		// source does not fit in destination, as cardsTwo is still
		// technically an empty List, with 52 capacity but zero size.
		//List<Card> cardsTwo = new ArrayList<>(52);
		//Collections.copy(cardsTwo, kingsOfClubs);
		//Card.printDeck("Card Collection with Kings copied", cardsTwo, 1);
		
		
		//Collections.copy() will copy elements from src to dest
		// starting at the beginning of dest, and overwriting elements
		// from there forward.
		List<Card> cardsThree = new ArrayList<>(52);
		Collections.addAll(cardsThree, cardArray);
		Collections.addAll(cardsThree, cardArray);
		Collections.copy(cardsThree, kingsOfClubs);
		Card.printDeck("13 Kings overwriting 26 Aces", cardsThree, 2);
		
		//List.copyOf() returns an unmodifiable copy of the source.
		List<Card> cardsFour = List.copyOf(kingsOfClubs);
		//cardsFour.add(aceOfHearts); // throws exception
		Card.printDeck("Copy of Kings", cardsFour, 1);
	}
	
}	
