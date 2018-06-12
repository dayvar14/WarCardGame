import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck
{
    private ArrayList<Card> cards = new ArrayList(0);

    public void generate()
    {
        cards = new ArrayList<>(0);
        for( int i = 0; i < 4; i++)
        {
            for (int j = 2; j < 15; j++)
            {
                Card card = new Card(i, j);
                cards.add(card);
            }
        }
    }

    public void shuffle()
    {
        //Collections.shuffle(cards);
        Random r = new Random();
        for( int k = 0; k < 100; k++)
        {
            for (int i = 0; i < cards.size() - 1; i++) {
                for (int j = i + 1; j < cards.size() - 1; j++) {
                    int rand = r.nextInt(10);
                    if (rand < 6 && i != j) {
                        Collections.swap(cards, i, j);
                    }
                }

            }
        }
    }
    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public void addCard(Card card)
    {
        cards.add(card);
    }

    public Card getCard( int index)
    {
        Card card = cards.get(index);
        return card;
    }

    public Card takeCard()
    {
        if ( cards.size() > 0)
        {
            Card card = cards.get(0);
            cards.remove(0);
            return card;
        }

        return null;
    }


}
