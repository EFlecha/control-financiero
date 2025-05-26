package com.example.demo.controllers;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DebugTemplatesController {

    @GetMapping("/debug-templates")
    @ResponseBody
    public String listarTemplates() throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:/templates/empleados/*");

        StringBuilder result = new StringBuilder("Archivos encontrados en templates/empleados:<br>");
        if (resources.length == 0) {
            result.append("(no se encontró ningún archivo)");
        } else {
            for (Resource res : resources) {
                result.append("- ").append(res.getFilename()).append("<br>");
            }
        }

        return result.toString();
    }
}