import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemplateProcessorTest
{
    TemplateProcessor templateProcessor = new TemplateProcessor();

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void shouldThrowAnStringIndexOutOfBoundsExceptionWhenNoCodeInTemplate() {
        templateProcessor.process("some stuff", "id", "code");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void shouldThrowAnStringIndexOutOfBoundsExceptionWhenNoAltcodeInTemplate() {
        templateProcessor.process("some stuff%CODE%", "id", "code");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void shouldThrowAnStringIndexOutOfBoundsExceptionWhenReqIdIsShorterThan8() {
        templateProcessor.process("some stuff%CODE%some more stuff%ALTCODE%and some more", "1234567", "code");
    }

    @Test
    public void shouldReplaceCODEWithReqIdAndALTCODEWithReqIdWithADash() {
        String result = templateProcessor.process("some stuff%CODE%some more stuff%ALTCODE%and some more", "12345678", "code");
        assertEquals("some stuff12345678some more stuff12345-678and some more", result);
    }
}
