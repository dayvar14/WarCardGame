import java.util.ArrayList;

public class Player
{
    private ArrayList<Card> cards = new ArrayList(0);
    private String name;

    public Player( String name )
    {
        this.name = name;
    }


    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public ArrayList<Card> getCards() {
        if( cards.size()>0 )
        {
            return this.cards;
        }
        return null;
    }


    public void setCards( ArrayList<Card> cards )
    {
        this.cards = cards;
        return;
    }

    public void addCard( Object o)
    {
        if( o instanceof Card)
        {
            Card card = (Card)o;
            this.cards.add(card);
        }
        return;
    }

    public void removeCard( int index)
    {
        this.cards.remove(index);
        return;
    }

}
