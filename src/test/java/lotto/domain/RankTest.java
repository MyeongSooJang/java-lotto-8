package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    void 당첨번호_6개를_일치하면_일등이다() {
        Rank rank = Rank.from(6, false);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    void 당첨번호_5개_일치하고_보너스_번호가_일치하면_이등이다() {
        Rank rank = Rank.from(5, true);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void 당첨번호_5개_일치하고_보너스_번호가_일치하지_않으면_삼등이다() {
        Rank rank = Rank.from(5, false);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    void 당첨번호_4개를_일치하면_사등이다() {
        Rank rank = Rank.from(4, false);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 당첨번호_3개를_일치하면_오등이다() {
        Rank rank = Rank.from(3, false);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 당첨번호_3개미만_일치하면_순위_밖이다() {
        Rank rank = Rank.from(2, false);
        Rank rank2 = Rank.from(1, false);
        Rank rank3 = Rank.from(0, false);

        assertThat(rank).isEqualTo(Rank.NONE);
        assertThat(rank2).isEqualTo(Rank.NONE);
        assertThat(rank3).isEqualTo(Rank.NONE);
    }

    @Test
    void 각_등수의_상금에_당첨된_개수값을_반환한다() {
        Rank rank = Rank.from(6, false);
        Rank rank2 = Rank.from(3, false);
        Rank rank3 = Rank.from(0, false);

        assertThat(rank.calculateTotalPrize(1)).isEqualTo(2_000_000_000);
        assertThat(rank2.calculateTotalPrize(2)).isEqualTo(10_000);
        assertThat(rank3.calculateTotalPrize(2)).isEqualTo(0);

    }
}
