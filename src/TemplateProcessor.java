public class TemplateProcessor {

    public static final String CODE = "%CODE%";
    public static final String ALTCODE = "%ALTCODE%";

    @Deprecated
    public String process(String template, String reqId, String code) {
        return process(template, reqId);
    }

    public String process(String template, String replacement) {
        template = template.replace(CODE, replacement);
        String hyphenatedReplacement = replacement.substring(0, 5) + "-" + replacement.substring(5, 8);

        return template.replace(ALTCODE, hyphenatedReplacement);
    }
}