package tw.core;

import org.junit.Test;
import tw.validator.InputValidator;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {

    private InputValidator inputValidator = new InputValidator();
    Class<InputValidator> inputValidatorClass = InputValidator.class;
    private String numStr = "1 2 3 4";
    private List<String> numList = Arrays.asList("1", "2", "3", "4");

    @Test
    public void validate() {
        assertTrue("should return true", inputValidator.validate(numStr));
        numStr = "1 2 3";
        assertFalse("should return false", inputValidator.validate(numStr));
    }

    @Test
    public void should_return_number_list() throws Exception {
        Method method = inputValidatorClass.getDeclaredMethod("numStrToList", String.class);
        method.setAccessible(true);
        List<String> obj = (List<String>) method.invoke(inputValidator, numStr);
        assertThat(obj, is(numList));
    }

    @Test
    public void validate_single_gigit() throws Exception {
        Method method = inputValidatorClass.getDeclaredMethod("validateSingleGigit", List.class, int.class);
        method.setAccessible(true);
        assertTrue("should return true", (Boolean) method.invoke(inputValidator, numList, 4));
        assertFalse("should return false", (Boolean) method.invoke(inputValidator, numList, 3));
    }

    @Test
    public void validate_digits_count() throws Exception {
        Method method = inputValidatorClass.getDeclaredMethod("validateDigitsCount", List.class, int.class);
        method.setAccessible(true);
        assertTrue("should return true", (Boolean) method.invoke(inputValidator, numList, 4));
        assertFalse("should return false", (Boolean) method.invoke(inputValidator, numList, 3));
    }

}
