package com.quipv.app.Controllers;

import com.quipv.app.Helpers.CsvToEntityConverter;
import com.quipv.app.Models.MaintableEntity;
import com.quipv.app.Models.SankeyEntity;
import com.quipv.app.Repositories.MaintableRepository;
import com.quipv.app.Repositories.SankeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Controller
public class FileUploadController {

    String UPLOADED_FOLDER = System.getProperty("user.dir") + "//";

    @Autowired
    MaintableRepository maintableRepository;

    @Autowired
    SankeyRepository sankeyRepository;

    @PostMapping("/visualisation/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile[] files,
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

        MultipartFile mainTableFile = files[0];
        MultipartFile sankeyFile = files[1];

        try {
            // Get the file and save it somewhere
            byte[] bytes = mainTableFile.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + mainTableFile.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + mainTableFile.getOriginalFilename() + "'");

            List<MaintableEntity> maintableEntities = CsvToEntityConverter.getMainTableEntities(path);
            maintableRepository.saveAll(maintableEntities);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = sankeyFile.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + sankeyFile.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + sankeyFile.getOriginalFilename() + "'");

            List<SankeyEntity> sankeyEntities = CsvToEntityConverter.getSankeyEntities(path);
            sankeyRepository.saveAll(sankeyEntities);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/visualisation";
    }

}
