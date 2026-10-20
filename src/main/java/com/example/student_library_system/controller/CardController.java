

package com.example.student_library_system.controller;

import com.example.student_library_system.model.Card;
import com.example.student_library_system.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card/apis")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/save")
    public String saveCard(@RequestBody Card card) {
        return cardService.saveCard(card);
    }

    @GetMapping("/findById/{id}")
    public Card findCardById(@PathVariable int id) {
        return cardService.getCardById(id);
    }

    @GetMapping("/findAll")
    public List<Card> findAllCards() {
        return cardService.getAllCards();
    }

    @PutMapping("/update/{id}")
    public String updateCard(@PathVariable int id, @RequestBody Card card) {
        return cardService.updateCard(id, card);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCardById(@PathVariable int id) {
        return cardService.deleteCardById(id);
    }
}
