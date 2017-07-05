package controller;

import bean.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import service.Counter;

import java.io.UnsupportedEncodingException;

/**
 * Created by qinshuxin on 2017/7/5.
 */
@Controller
public class CharacterController {
    @Autowired
    private Counter counter;

    @RequestMapping(value = "/sendWord")
    public String sendWord(String word, ModelMap model) throws UnsupportedEncodingException {
        word = new String(word.getBytes("iso-8859-1"), "UTF-8");
        System.out.println(word);

        Character character = counter.count(word);

        model.addAttribute("enCount", character.getEnCount());
        model.addAttribute("numCount", character.getNumCount());
        model.addAttribute("chCount", character.getChCount());
        model.addAttribute("puCount", character.getPuCount());
        model.addAttribute("chaMax1", character.getChaMax1());
        model.addAttribute("chaMax2", character.getChaMax2());
        model.addAttribute("chaMax3", character.getChaMax3());
        if(character.getChaMax1Count()==0)
        {
            model.addAttribute("chaMax1Count", "");
        }
        else
        {
            model.addAttribute("chaMax1Count", character.getChaMax1Count());
        }
        if(character.getChaMax2Count()==0)
        {
            model.addAttribute("chaMax2Count", "");
        }
        else
        {
            model.addAttribute("chaMax2Count", character.getChaMax2Count());
        }
        if(character.getChaMax3Count()==0)
        {
            model.addAttribute("chaMax3Count", "");
        }
        else
        {
            model.addAttribute("chaMax3Count", character.getChaMax3Count());
        }

        return "index";
    }

}