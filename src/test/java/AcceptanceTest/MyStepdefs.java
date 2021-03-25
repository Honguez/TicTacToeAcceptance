package AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import MainTicTacToe.Board;
import MainTicTacToe.Main;


public class MyStepdefs {

    Board board = new Board();

    @Given("plateau de jeu avec {string} en case {int}")
    public void plateauDeJeuAvecEnCase(String arg0, int arg1) {

        char arg = arg0.charAt(0);
        board.setBoardPosition(arg1,arg);
    }

    @When("joueur {string} joue")
    public void joueurJoue(String arg0) {

        char arg = arg0.charAt(0);

        int bestMove = Main.findBestMoves(board);
        board.setBoardPosition(bestMove, arg);

        Main.generateBoard(board.board);
    }

    @Then("le joueur joue {string} en case {int}")
    public void leJoueurJoueEnCase(int arg0) {

        Assert.assertEquals('O',board.getBoard()[arg0]);

    }
}
