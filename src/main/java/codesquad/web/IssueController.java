package codesquad.web;

import codesquad.domain.Issue;
import codesquad.domain.IssueRepository;
import codesquad.dto.IssueDto;
import codesquad.service.IssueService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("issue")
public class IssueController {
    private static final Logger log =  LoggerFactory.getLogger(IssueController.class);

    @Resource(name = "issueService")
    IssueService issueService;

    @GetMapping("form")
    public String form() {
        return "/issue/form";
    }

//    @GetMapping("")
//    public String list(Model model) {
//        List<Issue> issues = issueService.findAll();
//        model.addAttribute("issues", issues);
//        return "/index";
//    }

    @PostMapping("")
    public String create(IssueDto issueDto) {
        log.info("create method called");
        issueService.add(issueDto);
        return "redirect:/";
    }

    @GetMapping("{id}")
    public String show(@PathVariable long id, Model model) {
        log.info("issue : {} on show method ", issueService.findById(id));
        model.addAttribute("issue", issueService.findById(id));
        return "/issue/show";
    }

    @PutMapping("{id}")
    public String update(@PathVariable long id, IssueDto target) {
        issueService.update(id, target);
        return "redirect:/";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable long id) {
        issueService.delete(id);
        return "redirect:/";
    }
}
