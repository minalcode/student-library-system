
package com.example.student_library_system.service;

import com.example.student_library_system.model.Card;
import com.example.student_library_system.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public String saveCard(Card card) {
        cardRepository.save(card);
        return "Card saved successfully";
    }

    public Card getCardById(int id) {
        Optional<Card> cardOptional = cardRepository.findById(id);

        if (cardOptional.isPresent()) {
            return cardOptional.get();
        } else {
            throw new RuntimeException("Card not found with id : " + id);
        }
    }

    public List<Card> getAllCards() {
        List<Card> cardList = cardRepository.findAll();
        return cardList;
    }

    public String updateCard(int id, Card newCard) {
        Card existingCard = getCardById(id);

        existingCard.setCardStatus(newCard.getCardStatus());
        existingCard.setExpiryDate(newCard.getExpiryDate());

        cardRepository.save(existingCard);
        return "Card updated successfully";
    }

    public String deleteCardById(int id) {
        Card card = getCardById(id);
        cardRepository.delete(card);
        return "Card with id " + id + " is deleted successfully!";
    }
}
