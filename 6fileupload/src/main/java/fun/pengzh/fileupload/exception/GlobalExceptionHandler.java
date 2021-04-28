package fun.pengzh.fileupload.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author fun.pengzh
 * @class fun.pengzh.fileupload.exception.GlobalExceptionHandler
 * @desc
 * @since 2021-04-26
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public String handleError(MultipartException e, RedirectAttributes attr) {
        attr.addAttribute("msg", e.getCause().getMessage());
        attr.addAttribute("errMsg1", e.getMessage());
        return "redirect:/upload";
    }

}
