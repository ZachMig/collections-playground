import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
		
		//shuffle() and reverse()
		List<Card> deck = Card.getStandardDeck();
		Card.printDeck(deck);
		Collections.shuffle(deck);
		Card.printDeck("Shuffled Deck", deck, 4);
		Collections.reverse(deck);
		Card.printDeck("Reversed Deck", deck, 4);
		
		var sortingAlgorithm = Comparator.comparing(Card::value).thenComparing(Card::suit);
		
		//Collections.sort(deck, sortingAlgorithm);
		deck.sort(sortingAlgorithm);
		Card.printDeck("Sorted Deck", deck, 4);
		
		//
		List<Card> kings = new ArrayList<>(deck.subList(44, 48));
		Card.printDeck("Kings", kings, 1);
		
		List<Card> tens = new ArrayList<>(deck.subList(32, 36));
		Card.printDeck("Tens", tens, 1);	
		
		//Collections.shuffle(deck);
		int subListIndex = Collections.indexOfSubList(deck, tens);
		System.out.println("Index of sublist of tens in deck: " + subListIndex);
		System.out.println("Contains call returns: " + deck.containsAll(tens));
		
		boolean disjoint = Collections.disjoint(deck, tens);
		System.out.println("Disjoint = " + disjoint);
		
		
		
	}
	
}	
