package tw.core.generator;

import org.junit.Test;
import tw.core.Answer;

import java.lang.reflect.Field;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {

    @Test
    public void constructor_test() throws Exception {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        Field field = AnswerGenerator.class.getDeclaredField("randomIntGenerator");
        field.setAccessible(true);
        Object obj = field.get(answerGenerator);
        assertTrue(obj instanceof RandomIntGenerator);
        assertSame(randomIntGenerator, obj);
    }

    @Test
    public void return_answer_object() throws Exception {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);
        Object obj = answerGenerator.generate();
        assertTrue("should return an object of type Answer",obj instanceof Answer);
    }
}

