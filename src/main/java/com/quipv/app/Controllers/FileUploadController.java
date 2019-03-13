package com.quipv.app.Controllers;

import com.quipv.app.Helpers.CsvToEntityConverter;
import com.quipv.app.Models.MaintableEntity;
import com.quipv.app.Repositories.MaintableRepository;
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

    @PostMapping("/visualisation/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile[] files,
                                   RedirectAttributes redirectAttributes) {

        for(MultipartFile file:files) {
            if (file.isEmpty()) {
                redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
                return "redirect:/visualisation";
            }
            else{
                String extension = "";
                String fileName = file.getOriginalFilename();
                int i = fileName.lastIndexOf('.');
                if (i > 0) {
                    extension = fileName.substring(i+1);
                }
                if(!extension.equals("csv")){
                    redirectAttributes.addFlashAttribute("message", "Please select a csv file");
                    return "redirect:/visualisation";
                }
            }

            try {

                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded '" + file.getOriginalFilename() + "'");

                List<MaintableEntity> maintableEntities = CsvToEntityConverter.getMainTableEntities(path);
                maintableRepository.saveAll(maintableEntities);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/visualisation";
    }

}
