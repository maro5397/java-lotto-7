package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.create(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.create(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    void testValidateLottoNumbers_InvalidNumber() {
        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> Lotto.create(List.of(24, 13, 23, 12, 52, 3)))
                    .isInstanceOf(IllegalArgumentException.class);
            softly.assertThatThrownBy(() -> Lotto.create(List.of(1, 13, -23, 12, 34, 3)))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
}
