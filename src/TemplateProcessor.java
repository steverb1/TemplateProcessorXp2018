public class TemplateProcessor {

    public static final String CODE = "%CODE%";
    public static final String ALTCODE = "%ALTCODE%";

    public String process(String template, String reqId, String code) {

        // Substitute for %CODE%
        int templateSplitBegin = template.indexOf(CODE);
        int templateSplitEnd = templateSplitBegin + CODE.length();
        String templatePartOne = template.substring(0, templateSplitBegin);
        String templatePartTwo = template.substring(templateSplitEnd, template.length());
        code = reqId;
        template = templatePartOne + code + templatePartTwo;

        // Substitute for %ALTCODE%
        templateSplitBegin = template.indexOf(ALTCODE);
        templateSplitEnd = templateSplitBegin + ALTCODE.length();
        templatePartOne = template.substring(0, templateSplitBegin);
        templatePartTwo = template.substring(templateSplitEnd, template.length());
        String altcode = code.substring(0, 5) + "-" + code.substring(5, 8);
        return templatePartOne + altcode + templatePartTwo;
    }

}