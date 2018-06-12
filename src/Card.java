public class Card
{
    private int suit = 0;
    private int value = 0;
    private String[] suits = { "Hearts", "Spades","Diamonds", "Clubs"};
    private String[] values = { "", "", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    public Card( int suit, int value)
    {
        this.suit = suit;
        this.value = value;
    }
    public int getSuit()
    {
        return this.suit;
    }

    public int getValue()
    {
        return this.value;
    }

    public String getSuitName()
    {
        String suitName = this.suits[this.suit];
        return suitName;
    }

    public String getValueName()
    {
        String valueName = this.values[this.value];
        return valueName;
    }

    public int valueCompare(Object o)
    {
        if( o instanceof Card)
        {
            Card card = (Card)o;
            if( card.getValue() > this.value) {
                return 1;
            }
            else if ( card.getValue() == this.value)
            {
                return -1;
            }
        }
        return 0;
    }

}