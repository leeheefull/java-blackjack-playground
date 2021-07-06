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
    @DisplayName("카드 추가")
    void add_card() {
        // given
        this.participant.addDeck(new Card(Denomination.ACE, Suit.CLUB));

        // when, then
        assertThat(this.participant.getDeck().getDeck().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("수익금이 잘 입력 되는지")
    void save_revenue() {
        // given
        this.participant.setRevenue(10000);

        // when, then
        assertThat(this.participant.getRevenue()).isEqualTo(10000);
    }
}
