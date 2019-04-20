package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import tw.core.Game;
import tw.views.GameView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Game game = mock(Game.class);
    GameView gameView = mock(GameView.class);
    GameController gameController = new GameController(game, gameView);

    @Before
    public void setup() throws IOException {
        doCallRealMethod().when(gameView).showBegin();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void constructor_test() throws Exception {
        Field field1 = GameController.class.getDeclaredField("game");
        Field field2 = GameController.class.getDeclaredField("gameView");
        field1.setAccessible(true);
        field2.setAccessible(true);
        assertSame(game, field1.get(gameController));
        assertSame(gameView, field2.get(gameController));
    }

    @Test
    public void should_return_game_begin_string() throws Exception {
        gameController.beginGame();
        assertThat(outContent.toString().trim(), equalTo("------Guess Number Game, You have 6 chances to guess!  ------"));
    }

}