public class TemplateProcessor {

    public String process(String sourceTemplate, String reqId, String code) {

        String template = sourceTemplate;

        // Substitute for %CODE%
        int templateSplitBegin = template.indexOf("%CODE%");
        int templateSplitEnd = templateSplitBegin + 6;
        String templatePartOne = template.substring(0, templateSplitBegin);
        String templatePartTwo = template.substring(templateSplitEnd, template.length());
        code = reqId;
        template = templatePartOne + code + templatePartTwo;

        // Substitute for %ALTCODE%
        templateSplitBegin = template.indexOf("%ALTCODE%");
        templateSplitEnd = templateSplitBegin + 9;
        templatePartOne = template.substring(0, templateSplitBegin);
        templatePartTwo = template.substring(templateSplitEnd, template.length());
        String altcode = code.substring(0, 5) + "-" + code.substring(5, 8);
        return templatePartOne + altcode + templatePartTwo;
    }

}