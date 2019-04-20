package tw.core;

import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {

    @Test
    public void set_num_list() throws Exception {
        List<String> numList = Arrays.asList("1", "2", "3", "4");
        Field field = Answer.class.getDeclaredField("numList");
        field.setAccessible(true);
        Answer answer = new Answer();
        answer.setNumList(numList);
        assertEquals(numList, field.get(answer));
    }

    @Test
    public void create_answer() {
        String str = "1 2 3 4";
        assertTrue("should return true", Answer.createAnswer(str) instanceof Answer);
    }


    @Test(expected = OutOfRangeAnswerException.class)
    public void should_return_exception_when_number_out_of_range() throws Exception {
        String str = "1 12 3 4";
        Answer answer = Answer.createAnswer(str);
        answer.validate();
    }

    @Test
    public void should_return_record_object() {
        Answer answer = Answer.createAnswer("1 2 3 4");
        Answer inputAnswer = Answer.createAnswer("1 2 4 5");
        Object obj = answer.check(inputAnswer);
        assertTrue("should return true", obj instanceof Record);
        assertEquals("2A1B", ((Record) obj).getValue());
    }

    @Test
    public void get_index_of_num() {
        Answer answer = Answer.createAnswer("1 2 3 4");
        assertEquals(2, answer.getIndexOfNum("3"));
    }

    @Test
    public void should_return_answer_string_when_toString_method_called() {
        Answer answer = Answer.createAnswer("1 2 3 4");
        assertEquals("1 2 3 4", answer.toString());
    }
}