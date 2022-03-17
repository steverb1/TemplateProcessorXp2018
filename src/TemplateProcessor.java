public class TemplateProcessor {

    private static final String CODE = "%CODE%";
    private static final String ALTCODE = "%ALTCODE%";
    private static final int FIRST_INDEX = 5;
    public static final int SECOND_INDEX = 8;

    @Deprecated
    public String process(String template, String reqId, String code) {
        return process(template, reqId);
    }

    public String process(String template, String replacement) {
        template = template.replace(CODE, replacement);
        String hyphenatedReplacement = replacement.substring(0, FIRST_INDEX) + "-" + replacement.substring(FIRST_INDEX, SECOND_INDEX);

        return template.replace(ALTCODE, hyphenatedReplacement);
    }
}
