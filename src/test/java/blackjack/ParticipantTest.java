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
    @DisplayName("hit 잘 되는지")
    void hit() {
        // given
        participant.addCard(new Card(Denomination.ACE, Suit.CLUB));

        // when, then
        assertThat(participant.getCards().getCards().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Ace가 없을 때, 카드 합계 구하기")
    void card_sore_sum() {
        // given
        participant.getCards().hit(() -> new Card(Denomination.JACK, Suit.CLUB));
        participant.getCards().hit(() -> new Card(Denomination.TEN, Suit.DIAMOND));

        // when, when
        assertThat(participant.getCardScoreSum()).isEqualTo(20);
    }

    @Test
    @DisplayName("Ace가 1개일 때, 카드 합계 구하기")
    void card_sore_sum_Ace1() {
        // given
        participant.getCards().hit(() -> new Card(Denomination.ACE, Suit.CLUB));
        participant.getCards().hit(() -> new Card(Denomination.TEN, Suit.DIAMOND));

        // when, when
        assertThat(participant.getCardScoreSum()).isEqualTo(21);
    }

    @Test
    @DisplayName("Ace가 2개일 때, 카드 합계 구하기")
    void card_sore_sum_Ace2() {
        // given
        participant.getCards().hit(() -> new Card(Denomination.ACE, Suit.CLUB));
        participant.getCards().hit(() -> new Card(Denomination.ACE, Suit.DIAMOND));
        participant.getCards().hit(() -> new Card(Denomination.NINE, Suit.DIAMOND));

        // when, when
        assertThat(participant.getCardScoreSum()).isEqualTo(21);
    }

    @Test
    @DisplayName("Ace가 3개일 때, 카드 합계 구하기")
    void card_sore_sum_Ace3() {
        // given
        participant.getCards().hit(() -> new Card(Denomination.ACE, Suit.CLUB));
        participant.getCards().hit(() -> new Card(Denomination.ACE, Suit.DIAMOND));
        participant.getCards().hit(() -> new Card(Denomination.ACE, Suit.SPADE));
        participant.getCards().hit(() -> new Card(Denomination.EIGHT, Suit.DIAMOND));

        // when, when
        assertThat(participant.getCardScoreSum()).isEqualTo(21);
    }

    @Test
    @DisplayName("Ace가 4개일 때, 카드 합계 구하기")
    void card_sore_sum_Ace4() {
        // given
        participant.getCards().hit(() -> new Card(Denomination.ACE, Suit.CLUB));
        participant.getCards().hit(() -> new Card(Denomination.ACE, Suit.DIAMOND));
        participant.getCards().hit(() -> new Card(Denomination.ACE, Suit.SPADE));
        participant.getCards().hit(() -> new Card(Denomination.ACE, Suit.HEART));
        participant.getCards().hit(() -> new Card(Denomination.SEVEN, Suit.DIAMOND));

        // when, when
        assertThat(participant.getCardScoreSum()).isEqualTo(21);
    }

    @Test
    @DisplayName("버스트 여부 구하기")
    void burst() {
        // given
        participant.getCards().hit(() -> new Card(Denomination.JACK, Suit.CLUB));
        participant.getCards().hit(() -> new Card(Denomination.KING, Suit.CLUB));
        participant.getCards().hit(() -> new Card(Denomination.QUEEN, Suit.CLUB));

        // when, when
        assertThat(participant.getCardScoreSum()).isEqualTo(30);
        assertThat(participant.isBurst()).isTrue();
    }
}
