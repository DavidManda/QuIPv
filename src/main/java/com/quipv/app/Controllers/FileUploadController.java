package com.quipv.app.Controllers;

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


@Controller
public class FileUploadController {

    String UPLOADED_FOLDER = System.getProperty("user.dir") + "//";

    @PostMapping("/visualisation/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile[] files,
                                   RedirectAttributes redirectAttributes) {

        for(MultipartFile file:files) {
            System.out.println(file);
            if (file.isEmpty()) {
                System.out.println("Empty");
                redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
                return "redirect:/visualisation";
            }

            try {

                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                System.out.println("Here");
                redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded '" + file.getOriginalFilename() + "'");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/visualisation";
    }

}
