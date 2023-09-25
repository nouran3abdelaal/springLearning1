package io.javabrains.springbootstarter.Topics;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class topicServie {
    private List<topic> topicList = new ArrayList<>(  Arrays.asList(
            new topic("t1","t1","t1"),
            new topic("t2","t2","t2")

    ));
    public List<topic> getAllTopics(){
        return topicList;
    }
    public topic getTopicByID(String Id){
        return topicList.stream().filter(t->t.getId().equals(Id)).findFirst().get();
    }

    public List<topic> addTopic(topic t) {
        topicList.add(t);
        return topicList;
    }

    public List<topic> updateTopic(String id, topic newTopic) {
        topicList = topicList.stream()
                .map(existingTopic -> {
                    if (existingTopic.getId().equals(id)) {
                        return newTopic;
                    } else {
                        return existingTopic;
                    }
                })
                .collect(Collectors.toList());

        return topicList;
    }

    public List<topic> deleteTopic(String id) {
        topicList.removeIf(t->t.getId().equals(id));
        return topicList;
    }
}
