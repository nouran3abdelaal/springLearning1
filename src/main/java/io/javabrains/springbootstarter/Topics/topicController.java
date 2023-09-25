package io.javabrains.springbootstarter.Topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class topicController {
@Autowired
    private topicServie topicServie;
    @RequestMapping("/Topics")
    public List<topic> getAllTopics(){
        return topicServie.getAllTopics();
    }
    @RequestMapping(method = RequestMethod.POST,value = "/Topics")
    public List<topic> addTopic(@RequestBody topic t){
        return topicServie.addTopic(t);
    }
    @RequestMapping("/Topics/{Id}")
    public topic getTopicByID(@PathVariable String Id){
        return topicServie.getTopicByID(Id);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/Topics/{id}")
    public List<topic> addTopic(@RequestBody topic t,@PathVariable String id){
        return topicServie.updateTopic(id,t);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/Topics/{id}")
    public List<topic> addTopic(@PathVariable String id){
        return topicServie.deleteTopic(id);
    }
}
