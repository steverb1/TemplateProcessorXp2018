import org.junit.Test;

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

}
