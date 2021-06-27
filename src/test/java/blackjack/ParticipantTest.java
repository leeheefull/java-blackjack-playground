package blackjack;

import blackjack.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParticipantTest {
    private Participant participant;

    @BeforeEach
    void setUp() {
        this.participant = new Participant();
    }

    @Test
    @DisplayName("카드 받기")
    void add_card() {
        // given
        participant.addCard(new Card(Denomination.ACE, Suit.CLUB));

        // when, then
        assertThat(participant.getCards().getCards().size()).isEqualTo(1);
    }
}
