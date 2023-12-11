package seungjun.domain.ladder;

import ladder.LadderLineGenerator;
import seungjun.ladder.RandomLadderLineGenerator;
import seungjun.ladder.SeungjunLadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RandomSeungjunLadderLineGeneratorTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    @DisplayName("[RandomLadderLineGenerator.generate] 컬럼 개수를 지정해서 생성 요청하면 -> 그만큼의 컬럼을 가지는 라인 생성")
    public void lineColumnCountTest(int theNumberOfColumn) {
        LadderLineGenerator generator = new RandomLadderLineGenerator(theNumberOfColumn);

        assertThat(generator.generate().howManyColumns())
                .isEqualTo(theNumberOfColumn);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("[RandomLadderLineGenerator.generate] 컬럼 개수를 0개 이하로 지정하면 -> 예외 던짐")
    public void zeroColumnTest(int theNumberOfColumn) {
        LadderLineGenerator generator = new RandomLadderLineGenerator(theNumberOfColumn);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    generator.generate();
                });
    }
}