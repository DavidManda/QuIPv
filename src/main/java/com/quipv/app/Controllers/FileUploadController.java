package com.quipv.app.Controllers;

import com.quipv.app.Helpers.CsvToEntityConverter;
import com.quipv.app.Helpers.GraphHelper;
import com.quipv.app.Helpers.ProjectHelper;
import com.quipv.app.Helpers.UserHelper;
import com.quipv.app.Models.*;
import com.quipv.app.Repositories.EdgeRepository;
import com.quipv.app.Repositories.GraphNodeRepository;
import com.quipv.app.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;


@Controller
public class FileUploadController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    GraphNodeRepository graphNodeRepository;

    @Autowired
    EdgeRepository edgeRepository;

    @PostMapping("/visualisation/upload")
    public String handleFileUpload(@RequestParam("projectName") String projectName, @RequestParam("file") MultipartFile[] files,
                                   RedirectAttributes redirectAttributes) {

        if(files.length != 3){
            redirectAttributes.addFlashAttribute("message", "Please select all three files");
            return "redirect:/visualisation";
        }

        for(MultipartFile file:files) {
            if (file.isEmpty()) {
                redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
                return "redirect:/visualisation";
            } else {
                String extension = "";
                String fileName = file.getOriginalFilename();
                int i = fileName.lastIndexOf('.');
                if (i > 0) {
                    extension = fileName.substring(i + 1);
                }
                if (!extension.equals("csv")) {
                    redirectAttributes.addFlashAttribute("message", "Please select a csv file");
                    return "redirect:/visualisation";
                }
            }
        }

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setName(projectName);
        projectEntity.setUser(UserHelper.getUserName());
        projectEntity = projectRepository.save(projectEntity);

        MultipartFile mainTableFile = files[0];
        MultipartFile sankeyFile = files[1];

        List<MaintableEntity> maintableEntities = CsvToEntityConverter.getMainTableEntities(mainTableFile);

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded '" + mainTableFile.getOriginalFilename() + "'");

        List<SankeyEntity> sankeyEntities = CsvToEntityConverter.getSankeyEntities(sankeyFile);

        Graph graph = GraphHelper.constructGraph(ProjectHelper.populate(maintableEntities,sankeyEntities));
        graph.saveToDb(projectEntity.getId(), graphNodeRepository,edgeRepository );

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded '" + sankeyFile.getOriginalFilename() + "'");

        return "redirect:/visualisation";
    }

}
