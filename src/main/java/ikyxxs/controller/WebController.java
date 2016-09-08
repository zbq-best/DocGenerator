package ikyxxs.controller;

import ikyxxs.utils.FileUtil;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.StringWriter;

@Controller
public class WebController {

    @Autowired
    private VelocityEngine engine;

    @RequestMapping(value = "/generate", method = RequestMethod.GET)
    public String generateDoc() {
        return "generator";
    }

    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    @ResponseBody
    public String generateDoc(String docName, String content) {
        Template template = engine.getTemplate("docTemplate.vm");
        VelocityContext context = new VelocityContext();
        context.put("content", content);
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        FileUtil.write(docName, writer.toString());

        return docName + " generated successfully.";
    }
}