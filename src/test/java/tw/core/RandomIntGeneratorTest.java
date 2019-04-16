package tw.core;


import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.assertThat;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    private RandomIntGenerator generator = new RandomIntGenerator();

    @Test
    public void generate_nums_return_string() {
        String str=generator.generateNums(4, 4);
        assertThat(str,allOf(containsString("0"),containsString("1"),containsString("2"),containsString("3")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void generate_nums_throws_exception() {
        generator.generateNums(3, 4);
    }
}