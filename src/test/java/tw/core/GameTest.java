package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.model.GuessResult;
import tw.views.GameView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    private GameView gameView;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        gameView = new GameView();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void show_guess_result() {
        String str = "1A0B";
        GuessResult guessResult = mock(GuessResult.class);
        when(guessResult.getResult()).thenReturn(str);
        gameView.showGuessResult(guessResult);
        assertThat(outContent.toString().trim(), equalTo("Guess Result: " + str));
    }

    @Test
    public void show_game_status() {
        String str = "World";
        gameView.showGameStatus(str);
        assertThat(outContent.toString().trim(), equalTo("Game Status: " + str));
    }

    @Test
    public void show_game_history() {
        List<GuessResult> guessResults = new ArrayList<>();
        Answer answer = mock(Answer.class);
        guessResults.add(new GuessResult("1 2 3 4", answer));
        gameView.showGuessHistory(guessResults);
        System.out.println(outContent.toString());
    }

    @Test
    public void show_begin() throws Exception {
        gameView.showBegin();
        assertThat(outContent.toString().trim(), equalTo("------Guess Number Game, You have 6 chances to guess!  ------"));
    }
}
