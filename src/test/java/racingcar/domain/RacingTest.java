package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("RacingTest")
public class RacingTest {

    @Test
    @DisplayName("성공 : 차량이름에 빈 문자열 기입")
    public void 차량이름에_빈_문자열_기입() {
        String input = "";

        final Racing racing = new Racing();

        assertThatThrownBy(() -> racing.getCarList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1~5자로 입력해주세요.");
    }

    @Test
    @DisplayName("성공 : 차량이름에 콤마 연속 삽입")
    public void 차량이름에_콤마_연속_삽입() {
        String input = "1,,2";

        final Racing racing = new Racing();

        assertThatThrownBy(() -> racing.getCarList(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1~5자로 입력해주세요.");
    }

    @Test
    @DisplayName("성공 : 차량이름 정상기입 후 리턴타입 확인")
    public void 차량이름_정상기입_후_리턴타입_확인() {
        String input = "1,3,2,4";

        final Racing racing = new Racing();
        assertThat(racing.getCarList(input)).isInstanceOf(List.class);
    }
}