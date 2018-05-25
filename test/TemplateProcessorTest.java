import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemplateProcessorTest
{
    @Test(expected = StringIndexOutOfBoundsException.class)
    public void shouldThrowAnStringIndexOutOfBoundsExceptionWhenNoCodeInTemplate() {
        TemplateProcessor templateProcessor = new TemplateProcessor();
        String result = templateProcessor.process("some stuff", "id", "code");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void shouldThrowAnStringIndexOutOfBoundsExceptionWhenNoAltcodeInTemplate() {
        TemplateProcessor templateProcessor = new TemplateProcessor();
        String result = templateProcessor.process("some stuff%CODE%", "id", "code");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void shouldThrowAnStringIndexOutOfBoundsExceptionWhenReqIdIsShorterThan8() {
        TemplateProcessor templateProcessor = new TemplateProcessor();
        String result = templateProcessor.process("some stuff%CODE%some more stuff%ALTCODE%and some more", "1234567", "code");
    }
}
