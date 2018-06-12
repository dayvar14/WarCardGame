import java.util.ArrayList;
public class Game
{
    private Player player;
    private Player cpu = new Player("CPU");
    private Deck deck = new Deck();
    private Draw draw = new Draw();

    public void createPlayer()
    {
        String name = draw.drawPrompt("Enter player name:");
        this.player = new Player( name );
    }

    public void dealCards()
    {
        deck.generate();
        deck.shuffle();
        //Passes out cards from the deck
        while( deck.getCards().size() > 2 )
        {
            Card card = deck.takeCard();
            cpu.addCard(card);
            card = deck.takeCard();
            player.addCard(card);
        }
    }

    public void playGame()
    {
        draw.drawText("War Card Game\nStarting game...\n");
        createPlayer();
        draw.drawText("Dealing cards to players...\n");
        dealCards();
        Boolean playersHaveCards = true;
        int turnCount = 1;
        Boolean quitting = false;

        while( playersHaveCards && !quitting)
        {
            draw.drawText("Turn " + turnCount + ":\n");
            Card playerCard = (player.getCards().get(0));
            player.removeCard(0);
            Card cpuCard = (cpu.getCards().get(0));
            cpu.removeCard(0);

            String s = "Player's Card: ";
            s += playerCard.getValueName() + " of " + playerCard.getSuitName() +"\n";
            s += "CPU's Card: ";
            s += cpuCard.getValueName() + " of " + cpuCard.getSuitName() + "\n";
            draw.drawText(s);

            if (playerCard.getValue() > cpuCard.getValue())
            {
                draw.drawText(player.getName() + " wins!\n");
                player.addCard(playerCard);
                player.addCard(cpuCard);


            }
            else if (playerCard.getValue() < cpuCard.getValue())
            {
                draw.drawText("CPU wins!\n");
                cpu.addCard(cpuCard);
                cpu.addCard(playerCard);
            }
            else
            {
                draw.drawText("War!\n");
                boolean inWar = true;
                int warCombo = 0;
                ArrayList<Card> warCards = new ArrayList<>(0);
                warCards.add(cpuCard);
                cpu.removeCard(0);
                warCards.add(playerCard);
                player.removeCard(0);
                playersHaveCards = ( player.getCards()!=null ) && ( cpu.getCards()!=null);
                while( inWar && playersHaveCards)
                {
                    s = "";
                    if (player.getCards()!=null)
                    {
                        playerCard = (player.getCards().get(0));
                        warCards.add(playerCard);
                        player.removeCard(0);
                        s = "Player's Card: ";
                        s += playerCard.getValueName() + " of " + playerCard.getSuitName() +"\n";

                    }
                    else
                    {
                        cpu.getCards().addAll(warCards);
                        draw.drawText("CPU wins!");
                        break;
                    }
                    if (cpu.getCards()!=null)
                    {
                        cpuCard = (cpu.getCards().get(0));
                        warCards.add(cpuCard);
                        cpu.removeCard(0);
                        s += "CPU Card: ";
                        s += cpuCard.getValueName() + " of " + cpuCard.getSuitName() +"\n";

                    }
                    else
                    {
                        player.getCards().addAll(warCards);
                        draw.drawText( player.getName() + " wins!\n");
                        break;
                    }

                    draw.drawText(s);

                    if (playerCard.getValue() > cpuCard.getValue())
                    {
                        draw.drawText(player.getName() + " wins!\n");
                        inWar = false;
                    }
                    else if (playerCard.getValue() < cpuCard.getValue())
                    {
                        draw.drawText("CPU wins!\n");
                        inWar = false;
                    }

                    warCombo++;
                    playersHaveCards = ( player.getCards()!=null ) && ( cpu.getCards()!=null);
                }
            }
            /*
            s = draw.drawPrompt("Enter anything to continue or 'q' to quit.");
            if (s.toUpperCase() == "Q")
            {
                quitting = true;
                draw.drawText("Quitting...");
            }
            */
            playersHaveCards = ( player.getCards()!=null ) && ( cpu.getCards()!=null);
            turnCount++;
        }

        if (cpu.getCards() == null)
        {
            draw.drawText( player.getName() + " won the game!\n");
        }
        else
        {
            draw.drawText( "CPU won the game!\n");
        }
    }

    public static void main( String[] args)
    {
        Game game = new Game();
        while(true) {
            game.playGame();
        }
    }



}
