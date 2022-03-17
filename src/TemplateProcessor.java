public class TemplateProcessor {

    public static final String CODE = "%CODE%";
    public static final String ALTCODE = "%ALTCODE%";

    @Deprecated
    public String process(String template, String reqId, String code) {
        return process(template, reqId);
    }

    public String process(String template, String reqId)
    {
        String variableName = CODE;
        template = replace(template, reqId, variableName);
        String altcode = reqId.substring(0, 5) + "-" + reqId.substring(5, 8);

        variableName = ALTCODE;
        String result = replace(template, altcode, variableName);
        return result;
    }

    private String replace(String template, String reqId, String variableName)
    {
        int templateSplitBegin = template.indexOf(variableName);
        int templateSplitEnd = templateSplitBegin + variableName.length();
        String templatePartOne = template.substring(0, templateSplitBegin);
        String templatePartTwo = template.substring(templateSplitEnd);
        template = templatePartOne + reqId + templatePartTwo;
        return template;
    }
}