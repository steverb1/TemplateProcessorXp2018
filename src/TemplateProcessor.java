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
        int templateSplitBegin;
        int templateSplitEnd;
        String templatePartOne;
        String templatePartTwo;

        String altcode = reqId.substring(0, 5) + "-" + reqId.substring(5, 8);

        variableName = ALTCODE;
        templateSplitBegin = template.indexOf(variableName);
        templateSplitEnd = templateSplitBegin + variableName.length();
        templatePartOne = template.substring(0, templateSplitBegin);
        templatePartTwo = template.substring(templateSplitEnd, template.length());
        String result = templatePartOne + altcode + templatePartTwo;
        return result;
    }

    private String replace(String template, String reqId, String variableName)
    {
        int templateSplitBegin = template.indexOf(variableName);
        int templateSplitEnd = templateSplitBegin + variableName.length();
        String templatePartOne = template.substring(0, templateSplitBegin);
        String templatePartTwo = template.substring(templateSplitEnd, template.length());
        template = templatePartOne + reqId + templatePartTwo;
        return template;
    }

}