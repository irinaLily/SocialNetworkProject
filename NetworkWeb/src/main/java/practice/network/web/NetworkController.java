package practice.network.web;

import dao.model.PersonDto;
import dao.model.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practice.network.web.model.PostModel;
import practice.network.web.model.ResponseMessage;
import serviceCore.InterestService;
import serviceCore.PersonService;
import serviceCore.PostService;

import java.time.LocalDate;

/**
 * Created by Ирина on 27.05.2016.
 */
@Controller
public class NetworkController {
    @Autowired
    private PersonService personService;
    @Autowired
    private PostService postService;
    @Autowired
    private InterestService interestService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getPub(Model model) {

      model.addAttribute("posts",postService.getAllLPostForPerson(personService.getPersonForId(2L)));
        model.addAttribute("friends",personService.getALLFriends(2L));
        model.addAttribute("person",personService.getPersonForId(2L));
        model.addAttribute("messageForMe",postService.getMessageForUser(2L));
        model.addAttribute("myMessage",postService.getMyMessage(2L));
        model.addAttribute("hobby",interestService.getHobbyForIdPerson(2L));
        model.addAttribute("hobbys",interestService.getAllHobby());
        model.addAttribute("places",interestService.getAllPlaseForPerson(2L));

        return "index";
    }
    @RequestMapping(value = "/friend", method = RequestMethod.GET)
    public String getFriend(Model model, @RequestParam("friendID") String friendNickName) {
        System.out.println(friendNickName);
        PersonDto personDto=personService.getPersonForNik(friendNickName);
        model.addAttribute("posts",postService.getAllLPostForPerson(personDto));
        model.addAttribute("friends",personService.getALLFriends(personDto.getId()));
        model.addAttribute("person",personService.getPersonForNik(friendNickName));
        model.addAttribute("hobby",interestService.getHobbyForIdPerson(personDto.getId()));

        return "friend";
    }


    @ResponseBody
    @RequestMapping(value = "/newPost", method = RequestMethod.PUT)
    public ResponseMessage addPost(@RequestBody PostModel post) {
        System.out.println(post);
        PostDto postDto=new PostDto();
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setPlase_time(LocalDate.now());
        PersonDto personDto=personService.getPersonForId(2L);
        postDto.setPerson(personDto);
        postService.addPost(postDto);
        System.out.println(postService.getAllLPostForPerson(personDto));


        return ResponseMessage.okMessage();
    }


}
