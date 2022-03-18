import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TemplateProcessorTest {
    TemplateProcessor template = new TemplateProcessor();

    @Test
    public void replaces_CODE_with_first_8_of_reqId() {
        String result = template.process("%CODE% %ALTCODE%", "12345678", "1234567890");
        assertEquals("12345678 12345-678", result);
    }

    @Test
    public void replaces_ALTCODE_with_hyphenated_reqId_5_3() {
        String result = template.process("%CODE% %ALTCODE%", "12345678", "1234567890");
        assertEquals("12345678 12345-678", result);
    }

    @Test
    public void splits_reqId_into_5_and_3_parts() {
        String result = template.process("%ALTCODE% %CODE%", "ABCDEFGHIJK", "");
        assertEquals("ABCDE-FGH ABCDEFGHIJK", result);
    }

    @Test
    public void leaves_everything_else_the_same() {
        String result = template.process("FGH %ALTCODE% 12345 %CODE% XYZ", "ABCDEFGHIJK", "");
        assertEquals("FGH ABCDE-FGH 12345 ABCDEFGHIJK XYZ", result);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void exception_thrown_when_reqId_is_not_at_least_8_length() {
        String result = template.process("FGH %ALTCODE% 12345 %CODE% XYZ", "ABCDEFG", "");
        assertEquals("FGH ABCDE-FG 12345 ABCDEFG XYZ", result);
    }

    @Test(expected = NullPointerException.class)
    public void throws_NullPointerException_when_sourceTemplate_is_null() {
        String result = template.process(null, null, null);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void throws_StringIndexOutOfBoundsException_when_reqId_is_null() {
        String result = template.process("....", "", null);
    }
}
