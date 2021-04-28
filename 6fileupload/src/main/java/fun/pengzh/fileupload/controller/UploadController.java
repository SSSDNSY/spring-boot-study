package fun.pengzh.fileupload.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author fun.pengzh
 * @class fun.pengzh.fileupload.controller.UploadController
 * @desc
 * @since 2021-04-26
 */
@Controller
public class UploadController {

    @Value("${spring.http.multipart.location}")
    private String PATH;

    @GetMapping("/")
    public String index(Model attributes) {
        attributes.addAttribute("msg", "测试上传");
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, Model attributes) {

        try {
            if (file.isEmpty()) {
                attributes.addAttribute("msg", "文件不能为空！");
                return "upload";
            }
            String originalFilename = file.getOriginalFilename();
            Path dir = Paths.get(PATH);
            if (!Files.exists(dir)) {
                Files.createDirectory(dir);
            }
            Path path = Paths.get(PATH, "\\", originalFilename);
            Files.write(path, file.getBytes());

            attributes.addAttribute("msg", originalFilename + "文件已经上传成功！");

        } catch (IOException e) {
            attributes.addAttribute("msg", e.getMessage());
        }
        return "upload";
    }

}
